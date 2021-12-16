import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

public class Bubbles extends PApplet {
  private int canvasWidth = 800;
  private int canvasHeight = 600;
  private float maxSpd = 2.0f;
  private static int particleNumber = 20;
  private ArrayList<Particle> particles = new ArrayList<Particle>();
  private Random rand = new Random();

  public static void main(String[] args) {
    String[] processingArgs = { "Bubbles" };
    Bubbles bubbles = new Bubbles(particleNumber);
    PApplet.runSketch(processingArgs, bubbles);
  }

  public Bubbles(int particleCount) {
    Particle.setSpeedLimit(maxSpd);
    for(int a = 0; a <= particleCount; a++) {
      this.particles.add(
          new Particle(
            new PVector(
              rand.nextInt(0, canvasWidth),        // initial position
              rand.nextInt(0, canvasHeight)
            ),
            new PVector(
              rand.nextFloat(-maxSpd, maxSpd),     // initial speed
              rand.nextFloat(-maxSpd, maxSpd)
            ),
            new PVector(0, 0),                     // initial acceleration
            rand.nextFloat(0.01f, 1.0f),           // mass
            rand.nextFloat(0.33f, 1.0f)            // size
          )
      );
    }
  }

  public void clipParticle(Particle p) {
    if(p.pos.x <= 0)
      p.pos.set(canvasWidth, p.pos.y);
    else if(p.pos.x >= canvasWidth)
      p.pos.set(0, p.pos.y);
    if(p.pos.y <= 0)
      p.pos.set(p.pos.x, canvasHeight);
    else if(p.pos.y >= canvasHeight)
      p.pos.set(p.pos.x, 0);
  }

  public void settings() {
    size(canvasWidth, canvasHeight);
  }

  public void draw() {
    background(30, 30, 60);
    for(int i = 0; i < particles.size(); i++) {
      particles.get(i).force(new PVector(rand.nextFloat(-0.1f, 0.1f) * particles.get(i).mass, 
                                         rand.nextFloat(-0.1f, 0.1f) * particles.get(i).mass));
      
      particles.get(i).update();
      clipParticle(particles.get(i));

      noStroke();
      fill(map(particles.get(i).size, 0.01f, 1.0f, 0, 191),
           map(particles.get(i).size, 0.01f, 1.0f, 0, 63),
           map(particles.get(i).size, 0.01f, 1.0f, 0, 191));
      ellipse(particles.get(i).pos.x,
              particles.get(i).pos.y,
              particles.get(i).size * 30,
              particles.get(i).size * 30);
    }
  }

}
