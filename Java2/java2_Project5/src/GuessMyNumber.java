
import java.util.Scanner;

public class GuessMyNumber{

	Scanner scan;
	double pounds;
	double grams;
	double calories;
	static double RATIO = 453.59237;

	/**
	 * 
	 * Create a new project named java2_Project5 in your Java2_Homework working set. 
	 * Download the code for this project by clicking here. 
	 * The code is an application (GuessMyNumber.java) which prompts the user to enter a number. 
	 * There are a couple of errors in the program which you should be able to fix easily.
	 * First, fix these errors and run the program to see how it works. 
	 * (Basically it just prompts the user for a number.)
	 * Then, edit it to solve the following problem: 
	 *   Write a program to determine how many calories a person needs in a day to maintain their current weight. 
	 *   (A simple formula is that a person needs about 14 calories for each pound of weight.)
	 * Allow the user to enter their weight in pounds. 
	 * Provide the user understandable output of how many calories a day they need to sustain their current weight. 
	 * Tell them how much they would weigh in grams (1 pound = 453.59237 grams). 
	 * Format the number output so it is readable. 
	 * When finished, submit the working code in the java2_Project5 folder.
	 * 
	 */
	public GuessMyNumber(){
		//create a Scanner, but don't use it yet
		scan = new Scanner(System.in);
	}

	public void start(){
		// 
		getInput();
		calculate();
		sentOutput();
	}

	private void sentOutput() {

		System.out.println("You will need to injest " + calories + " calories today to maintain your current body weight.");
		System.out.println("If you stepped on a metric scale, your weight would read: " + grams + " grams.");
		
	}

	private void calculate() {
		calories = 14 * pounds;
		grams = pounds * RATIO;
	}

	public void getInput(){
		// prompt the user for input
		System.out.println("Click in the Console");
		System.out.print("Enter your weight in pounds: ");
		//save the return value to the double variable
		pounds = scan.nextDouble();
	}

	public static void main(String[] args){
		GuessMyNumber iama = new GuessMyNumber();
		iama.start();
	}

}