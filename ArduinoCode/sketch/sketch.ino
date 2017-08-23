

// Define Pins
#define BLUE 9
#define GREEN 10
#define RED 11

char c;

void setup() {
  pinMode(RED, OUTPUT);
  pinMode(GREEN, OUTPUT);
  pinMode(BLUE, OUTPUT);
  digitalWrite(RED, LOW);
  digitalWrite(GREEN, LOW);
  digitalWrite(BLUE, LOW);
  
  Serial.begin(9600);
  Serial.println("OK then, you first, say something.....");
  Serial.println("Go on, type something in the space above");
  Serial.println(" and hit Send or Enter,");
  Serial.println("then I will repeat it!");
  Serial.println("");
}

int redValue = 0;
int greenValue = 0;
int blueValue = 0;

void loop() {
  if (Serial.available()) {
    c = Serial.read();
    Serial.println(c);
    if (c == '1') {
      redValue = 255; 
      greenValue = 0;
      blueValue = 0;
      Serial.println("red");
    }
    if (c == '2') {
      redValue = 0; 
      greenValue = 255;
      blueValue = 0;
      Serial.println("green");
    }
    if (c == '3') {
      redValue = 0; 
      greenValue = 0;
      blueValue = 255;
      Serial.println("blue");
    }
  }

  analogWrite(RED, redValue);
  analogWrite(GREEN, greenValue);
  analogWrite(BLUE, blueValue);
}
