import processing.core.*;

public class Main {
  public static void main(String[] args) {
    String[] processingArgs = { "Anima" };
    Anima anima = new Anima(20);
    PApplet.runSketch(processingArgs, anima);
  }
}
