import java.util.*;

public class Simulation{
  public static void main(String[]args){
    Random rand = new Random();
    int[] info = new int[1000];
    int citySize = 150;//rand.nextInt(150) + 5; // Creating Environment
    Environment city = new Environment(citySize,citySize);
    int popSize = 170;//Population Size
    int sickAmt = 25;//rand.nextInt(popSize/2) + 2;//initial Sick
    for(int k = 0; k < info.length; k++){
      ArrayList<Person> population = new ArrayList<Person>(); //Creating population
      
      
      for(int i=0;i<popSize; i++){ //populating Environment with population
        int xVal = rand.nextInt(city.getX() + 1);
        int yVal = rand.nextInt(city.getY() + 1);
        population.add(new Person(xVal,yVal));
      }
      //Getting the random directions of individuals
      for(int i = 0; i < population.size(); i++){
        int d = rand.nextInt(9) + 1;
        while(d == 5){
          d = rand.nextInt(9) + 1;
        }
        population.get(i).setDirection(d);
      }
      //Setting a random amount to be sick
      for(int i = 0; i < sickAmt; i++){
        int d = rand.nextInt(population.size());
        while(population.get(d).getState() instanceof Infected){
          d = rand.nextInt(population.size());
        }
        population.get(d).getState().toInfected();
      }
      //daily Simulation of movement
      for(int j = 0; j< 10; j++){ // total Days
        //System.out.println("DAY " + (j+1));
        for(int i = 0; i < 5; i++){ //movements per day
          move(population, city);
          changeHealth(population);
          comparePeople(population);
          stateChange(population);
        }
      }
      //Get Data
      int heal = 0;
      int inf = 0;
      int rec = 0;
      int ded = 0;
      
      for(int i = 0; i < population.size(); i++){
        if(population.get(i).getState() instanceof Infected){
          inf++;
        }else if(population.get(i).getState() instanceof Healthy){
          heal++;
        }else if(population.get(i).getState() instanceof Recovered){
          rec++;
        }else if(population.get(i).getState() instanceof Dead){
          ded++;
        }
      }
      info[k] = rec + ded + inf - sickAmt;
    }
    double avg = 0;
    for(int i = 0; i < info.length; i++){
      avg += info[i];
      //System.out.println("Trial " + (i+1) + ": " + info[i]);
    }
    avg = avg/info.length;
    System.out.println("\n\nStats:");
    System.out.println("City Size:" + citySize);
    System.out.println("Population Size:" + popSize);
    System.out.println("Initial Sick:" + sickAmt);
    System.out.println("Repitition Amount:" + info.length);
    System.out.println("\nAvg new infected: " + avg);
    /*
     System.out.println("Stats:");
     System.out.println("City Size:" + citySize);
     System.out.println("Population Size:" + popSize);
     System.out.println("Initial Sick:" + sickAmt);
     System.out.println("\n\nHealthy: " + heal);
     System.out.println("Recovered: " + rec);
     System.out.println("Dead: " + ded);
     System.out.println("Infected: " + inf);*/
  }
  //movement Function
  public static void move(ArrayList<Person> population, Environment city){
    for(int i = 0; i < population.size();i++){
      switch(population.get(i).getDirection()){
        case 1: //Down Left
          if(population.get(i).getX() == 0 && population.get(i).getY() == 0){
          population.get(i).setDirection(9);
        }else if(population.get(i).getX() == 0){
          population.get(i).setDirection(3);
        }else if(population.get(i).getY() == 0){
          population.get(i).setDirection(7);
        }else{
          population.get(i).setX(population.get(i).getX() - 1);
          population.get(i).setY(population.get(i).getY() - 1);
        }
        break;
        case 2: //Down
          if(population.get(i).getY() == 0){
          population.get(i).setDirection(8);
        }else{
          population.get(i).setY(population.get(i).getY() - 1);
        }
        break;
        case 3: //Down Right
          if(population.get(i).getX() == city.getX() && population.get(i).getY() == 0){
          population.get(i).setDirection(7);
        }else if(population.get(i).getX() == city.getX()){
          population.get(i).setDirection(1);
        }else if(population.get(i).getY() == 0){
          population.get(i).setDirection(9);
        }else{
          population.get(i).setX(population.get(i).getX() + 1);
          population.get(i).setY(population.get(i).getY() - 1);
        }
        break;
        case 4://Left
          if(population.get(i).getX() == 0){
          population.get(i).setDirection(6);
        }else{
          population.get(i).setX(population.get(i).getX() - 1);
        }
        break;
        case 6://Right
          if(population.get(i).getY() == city.getX()){
          population.get(i).setDirection(4);
        }else{
          population.get(i).setX(population.get(i).getX() + 1);
        }
        break;
        case 7://Up Left
          if(population.get(i).getX() == 0 && population.get(i).getY() == city.getY()){
          population.get(i).setDirection(3);
        }else if(population.get(i).getX() == 0){
          population.get(i).setDirection(9);
        }else if(population.get(i).getY() == city.getY()){
          population.get(i).setDirection(1);
        }else{
          population.get(i).setX(population.get(i).getX() - 1);
          population.get(i).setY(population.get(i).getY() + 1);
        }
        break;
        case 8://Up
          if(population.get(i).getY() == city.getY()){
          population.get(i).setDirection(2);
        }else{
          population.get(i).setY(population.get(i).getY() + 1);
        }
        break;
        case 9://Up Right
          if(population.get(i).getX() == city.getX() && population.get(i).getY() == city.getY()){
          population.get(i).setDirection(1);
        }else if(population.get(i).getX() == city.getX()){
          population.get(i).setDirection(7);
        }else if(population.get(i).getY() == city.getY()){
          population.get(i).setDirection(3);
        }else{
          population.get(i).setX(population.get(i).getX() + 1);
          population.get(i).setY(population.get(i).getY() + 1);
        }
        break;
        default://Up Right
          Random rand = new Random();
          int d = rand.nextInt(9) + 1;
          while(d == 5){
            d = rand.nextInt(9) + 1;
          }
          population.get(i).setDirection(d);
      }
    }
  }
  //Changing Health
  public static void changeHealth(ArrayList<Person> population){
    for(int i = 0; i < population.size(); i++){
      population.get(i).changeHealth();
    }
  }
  //Comparing interacting individuals
  public static void comparePeople(ArrayList<Person> population){
    for(int i = 0; i < population.size(); i++){
      for(int j = 0; j < population.size(); j++){
        if(i==j){
          continue;
        }else if(population.get(i).getX() == population.get(j).getX() && population.get(i).getY() == population.get(j).getY()){
          //population.get(i).transitionState();
          if(population.get(i).getState() instanceof Infected && population.get(j).getState() instanceof Healthy)
            population.get(j).getState().toInfected();
        }
      }
    }
  }
  //Switching state
  public static void stateChange(ArrayList<Person> population){
    for(int i = 0; i < population.size(); i++){
      population.get(i).getState().transitionState();
    }
  }
}