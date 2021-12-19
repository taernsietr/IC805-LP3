import processing.core.PApplet;
import processing.core.PVector;

public class Debris extends Mover {

  protected int ttl;

  public Debris(PApplet p, float x, float y) {
    super(p, x, y);
  }

  public Debris(PApplet p, float x, float y, float mass, float size) {
    super(p, x, y, mass, size);
  }

  public void setTTL(int ttl) {
    this.ttl = ttl;
  }

  public void draw() {
    this.p.noStroke();
    this.p.fill(this.p.map(mass, 0.0f, 1.0f, 0, 255), 30, 30);
    this.p.circle(this.pos.x, this.pos.y, this.size);
  }

}
