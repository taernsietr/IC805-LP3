import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import java.util.Random;

public class Fireworks extends PApplet {
  private Random rand = new Random();
  private ArrayList<Ephemeral> debris = new ArrayList<Ephemeral>();
  private ArrayList<Payload> payloads = new ArrayList<Payload>();

  // Animation parameters
  private int canvasWidth = 800;
  private int canvasHeight = 800;
  private float maxSpeed = 3.0f;
  private float maxAccel = 0.35f;
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
    Payload p = new Payload(this, mouseX, mouseY, 20.0f, 1.0f, 2.0f);
    p.force(rand.nextFloat(-0.05f, 0.05f), -2.0f);
    this.payloads.add(p);
  }

  public void draw() {
    background(0, 0, 0);
    for(int i = 0; i < payloads.size(); i++) {
      Payload p = payloads.get(i);
      p.force(gravity);
      p.update();
      p.draw();
      if (p.getSpd().y >= 0) {
        for(int j = 0; j < p.getMass(); j++) {
          Ephemeral e = new Ephemeral(this,
                                      p.getPos().x,
                                      p.getPos().y, 
                                      1.0f, 5.0f, 5.0f); // mass, size, lifetime
          e.force(rand.nextFloat(-0.5f, 0.5f), rand.nextFloat(-0.5f, 0.0f));
          debris.add(e);
        }
        payloads.remove(p);
      }
    }
    for(int k = 0; k < debris.size(); k++) {
      System.out.println(debris.size());
      Ephemeral d = debris.get(k);
      d.force(gravity);
      d.update();
      d.draw();
      if (d.getTTL() <= 0)
        debris.remove(k);
    }
  }
}
