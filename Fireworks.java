import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import java.util.Random;

public class Fireworks extends PApplet {
  private static boolean debug = false;
  private ArrayList<Mover> objs = new ArrayList<Mover>();

  // Animation parameters
  private int canvasWidth = 800;
  private int canvasHeight = 800;
  private float maxSpeed = 3.0f;
  private float maxAccel = 0.5f;
  private PVector gravity = new PVector(0.00f, 0.001f);

  // Main method
  public static void main(String[] args) {
    String[] processingArgs = { "Fireworks" };
    PApplet.main(processingArgs);
  }

  // Processing methods
  public void settings() {
    size(canvasWidth, canvasHeight);
  }

  public void mousePressed() {
    this.objs.add(new Debris(this, mouseX, mouseY, 1.0f, 10.0f));
  }

  public Fireworks() {
  }

  public void draw() {
    background(0, 0, 0);
    for(int i = 0; i < objs.size(); i++) {
      Mover current = objs.get(i);
      current.setMaxAccel(maxAccel);
      current.setMaxSpeed(maxSpeed);
      current.force(gravity);
      current.update();
      current.draw();
    }
  }
}
