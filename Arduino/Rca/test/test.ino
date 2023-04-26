#include "TVout.h"
TVout TV;
int d=1000;
void setup() {
  TV.begin(_NTSC);
  TV.clear_screen();
  TV.fill(1);
}
void loop() {
  delay(d);
  for (int x=1;x<100;x++){
    TV.set_pixel(x,1,2);
    delay(d);
  }
}
