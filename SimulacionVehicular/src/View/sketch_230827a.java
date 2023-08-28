package View;

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class sketch_230827a extends PApplet {

/**
 * Triangle Strip 
 * by Ira Greenberg. 
 * 
 * Generate a closed ring using the vertex() function and 
 * beginShape(TRIANGLE_STRIP) mode. The outsideRadius and insideRadius 
 * variables control ring's radii respectively.
 */

int x;
int y;
float outsideRadius = 150;
float insideRadius = 100;

public void setup() {
  /* size commented out by preprocessor */;
  background(204);
  x = width/2;
  y = height/2;
}

public void draw() {
  background(204);
  
  int numPoints = PApplet.parseInt(map(mouseX, 0, width, 6, 60));
  float angle = 0;
  float angleStep = 180.0f/numPoints;
    
  beginShape(TRIANGLE_STRIP); 
  for (int i = 0; i <= numPoints; i++) {
    float px = x + cos(radians(angle)) * outsideRadius;
    float py = y + sin(radians(angle)) * outsideRadius;
    angle += angleStep;
    vertex(px, py);
    px = x + cos(radians(angle)) * insideRadius;
    py = y + sin(radians(angle)) * insideRadius;
    vertex(px, py); 
    angle += angleStep;
  }
  endShape();
}


  public void settings() { size(640, 360); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_230827a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}