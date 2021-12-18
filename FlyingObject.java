import processing.core.*;

public class FlyingObject implements Mover, Object {

  protected static float maxSpeed;
  protected static float maxAccel;
  protected PVector pos;
  protected PVector spd = new PVector (0.0f, 0.0f);
  protected PVector acc = new PVector (0.0f, 0.0f);

  protected float mass;
  protected float size;

  // Constructor
  public FlyingObject(float x, float y) {
    this.pos = new PVector(x, y);
  }

  public FlyingObject(float x, float y, float mass, float size) {
    this.pos = new PVector(x, y);
    this.mass = mass;
    this.size = size;
  }

  // Attribute changing methods
  public void setMaxSpeed(float max) {
    maxSpeed = max;
  }

  public void setMaxAccel(float max) {
    maxAccel = max;
  }

  public void setMass(float mass) {
    this.mass = mass;
  }
  
  public void setSize(float size) {
    this.size = size;
  }

  public void changeMass(float mass) {
    this.mass += mass;
    if (this.mass < 0)
      this.mass = 0;
  }

  public void changeSize(float size) {
    this.size += size;
    if (this.size < 0)
      this.size = 0;
  }

  // Movement functions
  public void force(float x, float y) {
    PVector force = new PVector(x, y);
    this.acc.add(force);
  }

  public void force(PVector force) {
    this.acc.add(force);
  }

  public void update() {
    this.spd.add(this.acc);
    this.spd.limit(maxSpeed);
    this.pos.add(this.spd);
  }
  
}
