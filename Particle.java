import processing.core.PVector;

public class Particle {
  public PVector pos;
  public PVector spd;
  public PVector acc;
  public float mass;
  public float size;

  public Particle(PVector pos, PVector spd, PVector acc, float mass, float size) {
    this.pos = pos;
    this.spd = spd;
    this.acc = acc;
    this.mass = mass;
    this.size = size;
  }

  public void force(PVector force) {
    this.acc.add(force);
  }

  public void update() {
    this.spd.add(this.acc);
    this.pos.add(this.spd);
  }

  public void display() {

  }
}
