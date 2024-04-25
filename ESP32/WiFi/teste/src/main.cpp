#include <Arduino.h>
#include <WiFi.h>
#include <WiFiClient.h>
#include <WiFiServer.h>
#include <HTTPClient.h>

const char *ssid = "Jacke";
const char *password = "jackjack2354@";

const String URL = "https://www.freetogame.com/api/game?id=452";

void setup()
{
  pinMode(LED_BUILTIN, OUTPUT);

  Serial.begin(115200);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.println(".");
  }

  Serial.print("Conectado ao wifi: ");
  Serial.println(WiFi.localIP());
}

void loop()
{
  HTTPClient httpC;

  httpC.begin(URL);
  int httpCode = httpC.GET();

  if (httpCode > 0) {
    String response = httpC.getString();
    Serial.println(response);
  }else{
    Serial.println("Não recebeu nada");
  }

  Serial.println("Wifi");
  Serial.println(WiFi.localIP());

  digitalWrite(LED_BUILTIN, 1);
  delay(500);
  digitalWrite(LED_BUILTIN, 0);

  delay(1000);
}
