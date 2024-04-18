

void setup() {
  Serial.begin(115200, SERIAL_7E2);
}

void loop() {
  if (Serial.available() > 0) {
    String message = Serial.readString();
    Serial.println(message);
  }
}
