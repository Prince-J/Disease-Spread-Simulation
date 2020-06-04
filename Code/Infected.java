import java.util.*;

public class Infected extends State{
  private int infectedPeriod = 10;
  
  public Infected(Person p){
    super(p);
  }
  public Infected(State source) {
    super(source);
  }
  public int changeHealth(){
    Random rand = new Random();
    int healthVal = getContext().getHealthVal();
    if(healthVal < 0){
      return 0;
    }else{
      healthVal -= (rand.nextInt(20) + 1);
      getContext().increaseLgt();
      return healthVal;
    }
  }
  public void toInfected(){
  }
  public void transitionState() {  
    int healthVal = getContext().getHealthVal();
    if(getContext().getInfectedLgt() == infectedPeriod)
      getContext().setState(new Recovered(this));
    else if(healthVal <= 0)
      getContext().setState(new Dead(this));
    //  transitions to either a Recovered or Dead state    
  }
}