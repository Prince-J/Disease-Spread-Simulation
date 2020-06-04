public class Dead extends State{
  public Dead(Person person){
    super(person);
  }
  public Dead(State source) {
    super(source);
  }
  public int changeHealth(){
    return 0;
  }
  public void toInfected(){
  }
  public void transitionState() {
    //System.out.println("** Invalid State Transition Exception **");
  }
}