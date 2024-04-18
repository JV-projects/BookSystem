#include <SPI.h>
#include <MFRC522.h>


#define SS_PIN 21
#define RST_PIN 22

MFRC522 rfid(SS_PIN, RST_PIN);

MFRC522::MIFARE_Key key;

byte nuidPICC[4];

byte uidAuth[4] = {0xA3, 0xA7, 0x3F, 0x25};

char strId[32] = "";

char charId = 'g';
char getId;

void setup() {
  Serial.begin(9600);
  SPI.begin();
  rfid.PCD_Init();

  for (byte i = 0; i < 6; i++) {
    key.keyByte[i] = 0xFF;
  }

  pinMode(2, OUTPUT);

}

void loop() {
  getId = Serial.read();

  if (rfid.PICC_IsNewCardPresent()) {
    if (rfid.PICC_ReadCardSerial()) {
      if (rfid.uid.uidByte[0] == uidAuth[0] &&
          rfid.uid.uidByte[1] == uidAuth[1] &&
          rfid.uid.uidByte[2] == uidAuth[2] &&
          rfid.uid.uidByte[3] == uidAuth[3] ) {
        Serial.println("Acesso autorizado");
      } else {
        Serial.println("Acesso nao autorizado");
        for (byte j = 0; j < 4; j++) {
          digitalWrite(2, 1);
          delay(1000);
          digitalWrite(2, 0);
        }
      }
      for (byte i = 0; i < 4; i++) {
        nuidPICC[i] = rfid.uid.uidByte[i];
      }
    }
  }
  rfid.PICC_HaltA();
  rfid.PCD_StopCrypto1();
}

void printHex(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++ ) {
    Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    Serial.print(buffer[i], HEX);
  }
}

void array_to_string(byte array[], unsigned int len, char buffer[]) {
  for (unsigned int i = 0; i < len; i++)
  {
    byte nib1 = (array[i] >> 4) & 0x0F;
    byte nib2 = (array[i] >> 0) & 0x0F;
    buffer[i * 2 + 0] = nib1  < 0xA ? '0' + nib1  : 'A' + nib1  - 0xA;
    buffer[i * 2 + 1] = nib2  < 0xA ? '0' + nib2  : 'A' + nib2  - 0xA;
  }
  buffer[len * 2] = '\0';
}
