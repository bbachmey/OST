
import java.util.Scanner;

public class GuessMyNumber{

  Scanner scan;
	
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