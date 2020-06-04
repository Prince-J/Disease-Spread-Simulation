public abstract class State {
  
  private Person context;
  
  public State(Person person) {
    context = person;
  }
  
  public State(State source) {
    setContext(source.getContext());
  }
  
  public static State InitialState(Person person) {
    return new Healthy(person);
  }
  
  public Person getContext() {
    return context;
  }
  
  public void setContext(Person person) {
    context = person;
  }
  
  /*public void roll_person(){
    transitionState();
  }*/
  
  public abstract void transitionState();
  public abstract int changeHealth();
  public abstract void toInfected();
  
}