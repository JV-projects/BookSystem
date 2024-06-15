#include <SPI.h>
#include <MFRC522.h>
#include <WiFi.h>
#include <WiFiClient.h>
#include <WiFiServer.h>
#include <HTTPClient.h>
#include <ArduinoJson.h>
#include <Arduino_JSON.h>

#define SS_PIN 21
#define RST_PIN 22
#define TOUCH_PIN 2
#define BUZZER_PIN 4

MFRC522 rfid(SS_PIN, RST_PIN);

MFRC522::MIFARE_Key key;

// Acesso Wifi

const char *ssid = "Jackeline";
const char *password = "24050589";

// API

const String URL = "http://192.168.1.7:8080/booksystem/api/tags";

byte uidAuth[4] = {0xA3, 0xA7, 0x3F, 0x25};

byte nuidPICC[4];

char strId[32] = "";

char charId = 'g';
char getId;

bool flag = true;

const long interval = 3000;

char *etiqueta;
char *status;

JsonDocument doctag;

void array_to_string(byte array[], unsigned int len, char buffer[]);
void printHex(byte *buffer, byte bufferSize);
void rfidBegin();
void rfidRead(char startRead);
void rfidAuth();
void rfidWifi();

void setup()
{
  Serial.begin(9600);

  rfidWifi();

  // Desserializando JSON
  HTTPClient httpC;

  httpC.begin(URL);
  int httpCode = httpC.GET();

  if (httpCode > 0)
  {
    String response = httpC.getString();
    Serial.println(response);

    DeserializationError error = deserializeJson(doctag, response);

    if (error)
    {
      Serial.print("deserializeJson() failed: ");
      Serial.println(error.c_str());
      return;
    }

    for (JsonObject item : doctag.as<JsonArray>())
    {

      etiqueta = item["etiqueta"]; // "1A2B", "A3A73F25", "A3A73F25", "A3A73F25", "A3A73F25", ...

    

      status = item["status"]; // "DISPONIVEL", "DISPONIVEL", "DISPONIVEL", "DISPONIVEL", ...
    }
  }
  else
  {
    Serial.println("Não recebeu nada");
  }

  Serial.println("Wifi");
  Serial.println(WiFi.localIP());

  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(BUZZER_PIN, OUTPUT);
}

void loop()
{

  //   digitalWrite(LED_BUILTIN, 1);
  //   delay(500);
  //   digitalWrite(LED_BUILTIN, 0);

  //   delay(2000);

  // digitalWrite(BUILTIN_LED, 1);
  // delay(1000);
  // digitalWrite(BUILTIN_LED, 0);

  // getId = Serial.read();
  // int getTouch = touchRead(15);

  // if (getTouch < 15) {
  //   flag = !flag;
  // }

  // if (flag == true) {
  //   digitalWrite(BUILTIN_LED, 1);
  //   rfidRead(getId);
  // } else {
  //   digitalWrite(BUILTIN_LED, 0);
  //   rfidAuth();
  // }
}

void rfidWifi()
{

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.println(".");
  }

  Serial.print("Conectado ao wifi: ");
  Serial.println(WiFi.localIP());
}

void rfidBegin()
{
  SPI.begin();
  rfid.PCD_Init();

  for (byte i = 0; i < 6; i++)
  {
    key.keyByte[i] = 0xFF;
  }
}

void rfidRead(char startRead)
{
  while (startRead == charId)
  {
    if (rfid.PICC_IsNewCardPresent())
    {
      if (rfid.PICC_ReadCardSerial())
      {
        for (byte i = 0; i < 4; i++)
        {
          nuidPICC[i] = rfid.uid.uidByte[i];
        }
        array_to_string(rfid.uid.uidByte, 4, strId);
        Serial.print(strId);
        Serial.println();
        startRead = 'a';
      }
    }
  }

  rfid.PICC_HaltA();
  rfid.PCD_StopCrypto1();
}

void rfidAuth()
{
  if (rfid.PICC_IsNewCardPresent())
  {
    if (rfid.PICC_ReadCardSerial())
    {
      if (rfid.uid.uidByte[0] == uidAuth[0] &&
          rfid.uid.uidByte[1] == uidAuth[1] &&
          rfid.uid.uidByte[2] == uidAuth[2] &&
          rfid.uid.uidByte[3] == uidAuth[3])
      {
        Serial.println("Acesso autorizado");
      }
      else
      {
        Serial.println("Acesso nao autorizado");
        digitalWrite(BUZZER_PIN, 1);
        digitalWrite(BUZZER_PIN, 0);
      }
      for (byte i = 0; i < 4; i++)
      {
        nuidPICC[i] = rfid.uid.uidByte[i];
      }
    }
  }
}

void printHex(byte *buffer, byte bufferSize)
{
  for (byte i = 0; i < bufferSize; i++)
  {
    Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    Serial.print(buffer[i], HEX);
  }
}

void array_to_string(byte array[], unsigned int len, char buffer[])
{
  for (unsigned int i = 0; i < len; i++)
  {
    byte nib1 = (array[i] >> 4) & 0x0F;
    byte nib2 = (array[i] >> 0) & 0x0F;
    buffer[i * 2 + 0] = nib1 < 0xA ? '0' + nib1 : 'A' + nib1 - 0xA;
    buffer[i * 2 + 1] = nib2 < 0xA ? '0' + nib2 : 'A' + nib2 - 0xA;
  }
  buffer[len * 2] = '\0';
}
