public class Environment{
  private int x;
  private int y;
  
  public Environment(){
    x = 5;
    y = 5;
  }
  public Environment(int xVal, int yVal){
    x = xVal;
    y = yVal;
  }
  
  public int getX(){
    return x;
  }
  
  public int getY(){
    return y;
  }
}