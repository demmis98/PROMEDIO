int x=255;
int d=1000;
void setup() {
  pinMode(13,OUTPUT);
}
void loop() {
  analogWrite(13,x);
  delay(d);
}
