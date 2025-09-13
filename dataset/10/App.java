package main;

import java.util.Random;

public class App {
  private static Random rand = new Random();

  public static int generateRand(){
    return rand.nextInt(13);
  }

  public static int check(int number, int guess){
    return (number == guess ? 1 : 0);
  }

  public static void hint(int number, int guess){
    if(guess > number){
      System.out.println("Too high! Try again.");
    } else if(guess < number){
      System.out.println("Too low! Try again.");
    } else {
      System.out.println("You got it!");
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("Guess a number between 1 and 13!");
  }
}