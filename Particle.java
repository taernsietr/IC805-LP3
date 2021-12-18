import processing.core.*;

public class Particle {

  protected static float spdLimit;
  protected PVector pos;
  protected PVector spd;
  protected PVector acc;
  protected float mass;
  protected float size;

  // Constructor
  public Particle(PVector pos, PVector spd, PVector acc, float mass, float size) {
    this.pos = pos;
    this.spd = spd;
    this.acc = acc;
    this.mass = mass;
    this.size = size;
  }

  // Attribute changing methods
  public static void setSpeedLimit(float limit) {
    spdLimit = limit;
  }

  // Movement functions
  public void force(PVector force) {
    this.acc.add(force);
  }

  public void update() {
    this.spd.add(this.acc);
    this.spd.limit(spdLimit);
    this.pos.add(this.spd);
  }

}
