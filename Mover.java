import processing.core.PApplet;
import processing.core.PVector;

public class Mover implements Moving, Physical {

  protected PApplet p;
  protected static float maxSpeed = 10.0f;
  protected static float maxAccel = 0.05f;
  protected PVector pos;
  protected PVector spd = new PVector (0.0f, 0.0f);
  protected PVector acc = new PVector (0.0f, 0.0f);
  protected float mass;
  protected float size;

  // Constructor
  public Mover(PApplet p, float x, float y) {
    this.p = p;
    this.pos = new PVector(x, y);
  }

  public Mover(PApplet p, float x, float y, float mass, float size) {
    this.p = p;
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

  public PVector getPos() {
    return this.pos;
  }
  
  public float getMass() {
    return this.mass;
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

  public void draw() {
    this.p.noStroke();
    this.p.fill(255, 255, 255);
    this.p.circle(this.pos.x, this.pos.y, this.size);
  }
  
}
