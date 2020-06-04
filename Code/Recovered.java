public class Recovered extends State{
  
  public Recovered(Person p){
    super(p);
  }
  public Recovered(State source) {
    super(source);
  }
  public int changeHealth(){
    return 100;
  }public void toInfected(){
  }
  public void transitionState() {
    //System.out.println("** Invalid State Transition Exception **");
  }
}