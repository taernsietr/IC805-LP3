import processing.core.*;

public class Debris extends Mover {

  protected static float maxSpeed;
  protected static float maxAccel;
  protected PVector pos;
  protected PVector spd = new PVector (0.0f, 0.0f);
  protected PVector acc = new PVector (0.0f, 0.0f);
  protected float mass;
  protected float size;

  private int TTL;

  // Constructor
  public Debris(float x, float y, float mass, float size) {
    this.pos = new PVector(x, y);
    this.mass = mass;
    this.size = size;
  }

  public void update() {
    this.spd.add(this.acc);
    this.spd.limit(maxSpeed);
    this.pos.add(this.spd);
    this.TTL -= 1;
  }

  
}
