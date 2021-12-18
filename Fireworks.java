import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

public class Fireworks extends PApplet {
  private static boolean debug = true;
  private ArrayList<FlyingObject> flyingObjects = new ArrayList<FlyingObject>();

  // Animation parameters
  private int canvasWidth = 800;
  private int canvasHeight = 800;

  public static void main(String[] args) {
    String[] processingArgs = { "Fireworks" };
    Fireworks fireworks = new Fireworks();
    PApplet.runSketch(processingArgs, fireworks);
  }

  public void settings() {
    size(canvasWidth, canvasHeight);
  }

  public void mousePressed() {
    this.flyingObjects.add(new FlyingObject(mouseX, mouseY));
    // Debug
    if (debug)
      System.out.println("New FlyingObject created at " + mouseX + ", " + mouseY);
  }

  public Fireworks() {
    this.flyingObjects.add(new FlyingObject(canvasWidth/2, canvasHeight/2));
  }

  public void draw() {
    background(0, 0, 0);
    noStroke();
    fill(200, 200, 200);
    for(int i = 0; i < flyingObjects.size(); i++) {
      FlyingObject current = flyingObjects.get(i);
      current.force(0.01f, 0.00f);
      current.update();
      ellipse(current.pos.x,
              current.pos.y,
              current.size,
              current.size);
    }
  }
}
