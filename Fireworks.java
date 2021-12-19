import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import java.util.Random;

public class Fireworks extends PApplet {
  private Random rand = new Random();
  private ArrayList<Mover> movers = new ArrayList<Mover>();
  private ArrayList<Debris> debris = new ArrayList<Debris>();

  // Animation parameters
  private int canvasWidth = 800;
  private int canvasHeight = 800;
  private float maxSpeed = 3.0f;
  private float maxAccel = 0.5f;
  private PVector gravity = new PVector(0.00f, 0.05f);

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
    for(int j = 0; j < 30; j++) {
      Debris e = new Debris(this,
      rand.nextFloat(0.0f, canvasWidth-30.0f),
      rand.nextFloat(0.0f, 30.0f), 
      rand.nextFloat(2.0f, 50.0f),
      rand.nextFloat(2.0f, 20.0f));
      e.setLifetime(2.0f);
      e.setMaxSpeed(2.0f);
      this.debris.add(e);
    }
  }

  public void draw() {
    background(0, 0, 0);
    for(int i = 0; i < debris.size(); i++) {
      Debris d = debris.get(i);
      d.force(gravity);
      d.update();
      d.draw();
      if (d.getTTL() <= 0)
        debris.remove(i);
    }
  }
}
