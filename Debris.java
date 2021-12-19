import processing.core.PApplet;
import processing.core.PVector;

public class Debris extends Mover {

  protected float lifetime;
  protected float ttl;

  public Debris(PApplet p, float x, float y) {
    super(p, x, y);
  }

  public Debris(PApplet p, float x, float y, float mass, float size) {
    super(p, x, y, mass, size);
  }

  // Sets time to live
  // lifetime should be given in _seconds_
  public void setLifetime(float lifetime) {
    this.lifetime = lifetime * 60.0f;
    this.ttl = this.lifetime;
  }

  public float getTTL() {
    return this.ttl;
  }

  public void update() {
    this.spd.add(this.acc);
    this.spd.limit(maxSpeed);
    this.pos.add(this.spd);
    this.ttl -= 0.01f;
  }

  public void draw() {
    this.p.noStroke();
    this.p.fill(
        this.p.map(
          this.ttl,
          0.0f,
          this.lifetime * (this.mass / this.size) * 10.0f,
          10,
          255),
        10, 10);
    this.p.circle(this.pos.x, this.pos.y, this.size);
    //System.out.println(this.ttl + " " + this.lifetime);
  }

}
