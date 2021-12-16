import processing.core.*;

public class Main {
  public static void main(String[] args) {
    String[] processingArgs = { "Bubbles" };
    Bubbles bubbles = new Bubbles(20);
    PApplet.runSketch(processingArgs, bubbles);
  }
}
