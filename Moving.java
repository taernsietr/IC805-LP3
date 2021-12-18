import processing.core.PVector;

public interface Moving {

  public void setMaxSpeed(float speed);
  public void setMaxAccel(float speed);
  public void force(PVector force);
  public void update();

}
