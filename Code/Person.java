public class Person{
  private int x;
  private int y;
  private int healthVal;
  private int infectedLgt;
  private int direction;
  private State personState;
  
  //Constructors
  public Person(){
    int x = 0;
    int y = 0;
    direction = 5;
    healthVal = 100;
    personState = State.InitialState(this);
  }
  public Person(int xVal, int yVal){
    x = xVal;
    y = yVal;
    direction = 5;
    healthVal = 100;
    personState = State.InitialState(this);
  }
  public Person(int xVal, int yVal, int hVal){
    x = xVal;
    y = yVal;
    direction = 5;
    healthVal = hVal;
    personState = State.InitialState(this);
  }
  
  //Getters
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public int getInfectedLgt(){
    return infectedLgt;
  }
  public int getHealthVal(){
    return healthVal;
  }
  public State getState() {
    return personState;
  }
  public int getDirection(){
    return direction;
  }
  
  //Setters
  public void setX(int xVal){
    x = xVal;
  }
  public void setY(int yVal){
    y = yVal;
  }
  public void setState(State newState) {
    personState = newState;
  }
  public void setHealthVal(int h){
    healthVal = h;
  }
  public void setInfectedLgt(int l){
    infectedLgt = l;
  }
  public void increaseLgt(){
    infectedLgt++;
  }
  public void setDirection(int d){
    direction = d;
  }
  
  //Other Functions
  public void changeHealth(){
    healthVal = personState.changeHealth();
  }
  public boolean equals(Person p){
    if(x == p.x && y == p.y)
      return true;
    else return false;
  }
}