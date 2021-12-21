import processing.core.PApplet;
import java.util.Random;

public class Payload extends Ephemeral {
  protected Random rand = new Random();
  protected int r = rand.nextInt(63, 255);
  protected int g = rand.nextInt(63, 255);
  protected int b = rand.nextInt(63, 255);

  public Payload(PApplet p, float x, float y, float mass, float size) {
    super(p, x, y, mass, size);
  }

  public Payload(PApplet p, float x, float y, float mass, float size, float lifetime) {
    super(p, x, y, mass, size);
    this.lifetime = lifetime * 60.0f;
    this.ttl = this.lifetime;
  }

  // Color methods
  public void setRGB(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public int r() {
    return this.r;
  }

  public int g() {
    return this.g;
  }

  public int b() {
    return this.b;
  }

  public void draw() {
    this.p.fill(r, g, b);
    this.p.circle(this.pos.x, this.pos.y, 10.0f);
  }

}
