import processing.core.*;
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
    for(int a = 0; a <= particleCount; a++) {
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

      // Add random force to particles
      particles.get(i).force(new PVector(rand.nextFloat(-maxForce, maxForce) * particles.get(i).mass, 
                                         rand.nextFloat(-maxForce, maxForce) * particles.get(i).mass));
      
      // Update particle acceleration, speed and position
      particles.get(i).update();
      clipParticle(particles.get(i));

      // Draw particles
      noStroke();
      fill(map(particles.get(i).size, minSize, 1.0f, 0, 255),
           map(particles.get(i).size, minSize, 1.0f, 0, 192),
           map(particles.get(i).size, minSize, 1.0f, 0, 192));
      ellipse(particles.get(i).pos.x,
              particles.get(i).pos.y,
              particles.get(i).size * maxSize,
              particles.get(i).size * maxSize);
    }
  }

}
