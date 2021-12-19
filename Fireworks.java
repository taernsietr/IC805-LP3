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
  private PVector gravity = new PVector(0.00f, 0.005f);

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
      this.debris.add(e);
    }
  }
/*
    Debris d = new Debris(this, mouseX, mouseY, 1.0f, 10.0f);
    d.setMaxAccel(maxAccel);
    d.setMaxSpeed(maxSpeed);
    d.setLifetime(2.0f);
    this.debris.add(d);

  public Fireworks() {
  }
*/
  public void draw() {
    System.out.println(debris.size());
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
