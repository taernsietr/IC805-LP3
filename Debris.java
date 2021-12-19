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
    this.lifetime = (lifetime + this.mass - 1) * 60.0f;
    this.ttl = lifetime;
  }

  public float getTTL() {
    return this.ttl;
  }

  public void update() {
    this.spd.add(this.acc);
    this.spd.limit(maxSpeed);
    this.pos.add(this.spd);
    this.ttl -= 0.015f;
  }

  public void draw() {
    this.p.noStroke();
    this.p.fill(this.p.map(this.ttl, 0.0f, this.lifetime * 0.03f, 40, 255), 40, 20);
    this.p.circle(this.pos.x, this.pos.y, this.size);
    System.out.println(this.ttl + " " + this.lifetime);
  }

}
