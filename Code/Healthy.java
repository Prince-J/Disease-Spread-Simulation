import java.util.*;

public class Healthy extends State{
  public Healthy(Person p){
    super(p);
  }
  public Healthy(State source) {
    super(source);
  }
  public int changeHealth(){
    Random rand = new Random();
    int healthVal = getContext().getHealthVal();
    if(healthVal < 0){
      return 0;
    }else{
      healthVal += (rand.nextInt(10) - 5);
      return healthVal;
    }
  }
  public void toInfected(){
    getContext().setState(new Infected(this));
  }
  public void transitionState() {  
    int healthVal = getContext().getHealthVal();
    if(healthVal <= 0)
      getContext().setState(new Dead(this));
    //  transitions Infected State  
  }
}