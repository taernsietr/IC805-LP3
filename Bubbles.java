import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import java.util.Random;

public class Bubbles extends PApplet {
  private ArrayList<Particle> particles = new ArrayList<Particle>();
  private Random rand = new Random();

  // Animation parameters
  private int canvasWidth = 1024;
  private int canvasHeight = 768;
  private float maxSpeed = 3.0f;
  private float maxForce = 0.5f;
  private float minMass = 0.001f;
  private float minSize = 0.1f;
  private float maxSize = 40.f;
  private static int particleNumber = 75;

  public static void main(String[] args) {
    String[] processingArgs = { "Bubbles" };
    Bubbles bubbles = new Bubbles(particleNumber);
    PApplet.runSketch(processingArgs, bubbles);
  }

  public void settings() {
    size(canvasWidth, canvasHeight);
  }

  public Bubbles(int particleCount) {
    Particle.setSpeedLimit(maxSpeed);
    for(int a = 0; a <= particleCount-1; a++) {
      this.particles.add(
          new Particle(
            new PVector(rand.nextInt(0, canvasWidth),         // initial position
                        rand.nextInt(0, canvasHeight)),
            new PVector(rand.nextFloat(-maxSpeed, maxSpeed),  // initial speed
                        rand.nextFloat(-maxSpeed, maxSpeed)),
            new PVector(0, 0),                                // initial acceleration
            rand.nextFloat(minMass, 1.0f),                    // mass
            rand.nextFloat(minSize, 1.0f))                    // size
      );
    }
  }

  // Allows particles to move to the opposite side when moving out of bounds
  public void clipParticle(Particle p) {
    float offset = p.size * maxSize;

    if(p.pos.x <= 0 - offset)
      p.pos.set(canvasWidth, p.pos.y);
    else if(p.pos.x >= canvasWidth + offset)
      p.pos.set(0, p.pos.y);
    if(p.pos.y <= 0 - offset)
      p.pos.set(p.pos.x, canvasHeight);
    else if(p.pos.y >= canvasHeight + offset)
      p.pos.set(p.pos.x, 0);
  }

  public void draw() {
    background(40, 40, 40);
    for(int i = 0; i < particles.size(); i++) {

      Particle cur = particles.get(i);

      // Add random force to particles
      cur.force(new PVector(rand.nextFloat(-maxForce, maxForce) * cur.mass, 
                                         rand.nextFloat(-maxForce, maxForce) * cur.mass));
      
      // Update particle acceleration, speed and position
      cur.update();
      clipParticle(cur);

      // Draw particles
      noStroke();
      fill(map(cur.size, minSize, 1.0f, 0, 255),
           map(cur.size, minSize, 1.0f, 0, 192),
           map(cur.size, minSize, 1.0f, 0, 192));
      ellipse(cur.pos.x,
              cur.pos.y,
              cur.size * maxSize,
              cur.size * maxSize);
    }
  }

}
