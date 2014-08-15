
import java.util.Scanner;

public class GuessMyNumber{

  Scanner scan;
	
 /**
 * 
 * Create a new project named java2_Project5 in your Java2_Homework working set. 
 * Download the code for this project by clicking here. 
 * The code is an application (GuessMyNumber.java) which prompts the user to enter a number. 
 * There are a couple of errors in the program which you should be able to fix easily.
 * First, fix these errors and run the program to see how it works. 
 * (Basically it just prompts the user for a number.)
 * Then, edit it to solve the following problem: Write a program to determine how many calories a person needs in a day to maintain their current weight. (A simple formula is that a person needs about 14 calories for each pound of weight.)
 * Allow the user to enter their weight in pounds. 
 * Provide the user understandable output of how many calories a day they need to sustain their current weight. 
 * Tell them how much they would weigh in grams (1 pound = 453.59237 grams). 
 * Format the number output so it is readable. 
 * When finished, submit the working code in the java2_Project5 folder.
 * 
 */
public GuessMyNumber(){
      scan = new Scanner(System.in);
  }

  public void testMe(){
      getInput();
      // calls to methods you make
  }

  public void getInput(){
       // prompt the user for input
         System.out.println("Click in the Console");
         System.out.print("Type a number and hit enter: ");
        theGuess = scan.nextDouble();
  }

  public static void main(String[] args){
      GuessMyNumber myGame = new GuessMyNumber();
      myGame.testMe();
  }
  
}