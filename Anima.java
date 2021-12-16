import processing.core.*;
import java.util.ArrayList;
import java.util.Random;

public class Anima extends PApplet {
  private final int canvasWidth = 800;
  private final int canvasHeight = 600;
  private final float maxSpd = 2.0f;
  
  private ArrayList<Particle> particles = new ArrayList<Particle>();
  private Random rand = new Random();

  public Anima(int particleCount) {
    for(int a = 0; a <= particleCount; a++) {
      this.particles.add(
          new Particle(
            new PVector(
              rand.nextInt(0, canvasWidth),
              rand.nextInt(0, canvasHeight)
            ),
            new PVector(
              rand.nextFloat(-maxSpd, maxSpd),
              rand.nextFloat(-maxSpd, maxSpd)
            ),
            new PVector(0, 0), 
            rand.nextFloat(0.01f, 1.0f),
            rand.nextFloat(0.33f, 1.0f)
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

  public void setup() {
    noStroke();
  }

  public void draw() {
    background(0, 0, 0);
    for(int i = 0; i < particles.size(); i++) {
      particles.get(i).force(
                        new PVector(
                                    rand.nextFloat(-0.01f, 0.01f) * particles.get(i).size, 
                                    rand.nextFloat(-0.01f, 0.01f) * particles.get(i).size 
                                   )
                            );
      
      particles.get(i).update();
      clipParticle(particles.get(i));

      fill(
          map(particles.get(i).size, 0.01f, 1.0f, 0, 63),
          map(particles.get(i).size, 0.01f, 1.0f, 0, 63),
          map(particles.get(i).size, 0.01f, 1.0f, 0, 255)
      );

      ellipse(
          particles.get(i).pos.x,
          particles.get(i).pos.y,
          particles.get(i).size * 30,
          particles.get(i).size * 30
      );
    }
  }

}
