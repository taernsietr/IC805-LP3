import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

public class Fireworks extends PApplet {
  private static boolean debug = false;
  private ArrayList<Mover> objs = new ArrayList<Mover>();

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
    this.objs.add(new Mover(mouseX, mouseY, 1.0f, 10.0f));
    // Debug
    if (debug)
      System.out.println("New Mover created at " + mouseX + ", " + mouseY);
  }

  public Fireworks() {
    this.objs.add(new Mover(canvasWidth/2, canvasHeight/2, 1.0f, 10.0f));
  }

  public void draw() {
    background(0, 0, 0);
    noStroke();
    fill(200, 200, 200);
    for(int i = 0; i < objs.size(); i++) {
      Mover current = objs.get(i);
      current.setMaxAccel(0.0f);
      current.setMaxSpeed(0.0f);
      current.force(0.00f, 0.00f);
      current.update();
      ellipse(current.pos.x,
              current.pos.y,
              current.size,
              current.size);
      if (debug)
        System.out.println("Obj 1: " + current.pos.x + ", " + current.pos.y + ", " + current.spd + ", " + current.acc);
    }
  }
}
