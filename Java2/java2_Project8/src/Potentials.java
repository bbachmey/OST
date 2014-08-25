import java.util.Calendar;
import java.util.Scanner;


/**
 * @author bbachmey
 * @instructions Write either an application or an applet that allows 
 * the user to give their year of birth.
 * 
 * Given their year of birth, calculate their age.
 * 
 * So that you do not have to worry about issues like Y2K, use the class java.util.Calendar.
 * 
 * Try these calls to instantiate and get the current year (of course you will need to import the package too):
 *   Calendar rightNow = Calendar.getInstance();
 *   System.out.println(rightNow.get(Calendar.YEAR));
 *    
 * Provide a nested if (or case statement) of 10 different statements of what the person can do 
 * depending on their age. Ranges of capabilities are from 0-9, 10-19, 20-29, ... 90-99. 
 * 
 * Given their age, provide output of how many decades they have been alive and then 
 * give them some words of wisdom about what they can or should do during this time of their life. 
 * If you use a case statement, you have the option of letting them know what they have to 
 * look forward to as well. Have fun! 
 *
 */
public class Potentials {

	Scanner scan;
	int birth;
	int now;
	int age;

	/**
	 * constructor
	 */
	public Potentials(){
		//when the class is constructed,
		//create a Scanner, but don't use it yet
		scan = new Scanner(System.in);
	}

	/**
	 * @param args
	 * This is a console application
	 */
	public static void main(String[] args) {
		//declare and instantiate and instance of itself
		Potentials pots = new Potentials();
		//call the start method
		pots.start();

	}

	/**
	 * call the three methods
	 */
	public void start(){
		// 
		getInput();
		calculate();
		sentOutput();
	}

	/**
	 * 
	 */
	public void getInput(){
		// prompt the user for input
		System.out.println("Click in the Console");
		System.out.print("Enter the year of your birth: ");
		//call the nextInt() method on the scanner
		birth = scan.nextInt();
	}

	/**
	 * 
	 */
	private void calculate() {
		//make a Calendar object
		Calendar rightNow = Calendar.getInstance();
		//get this year
		now = rightNow.get(Calendar.YEAR);
		//calculate age
		age = now - birth;

	}

	/**
	 * 
	 */
	private void sentOutput() {
		//confirm the input
		System.out.println("You entered: " + birth); 
		//confirm this year
		System.out.println("This year is: " + now); 
		//confirm this year
		System.out.println("Your age is: " + age); 
		//how many decades
		System.out.println("You have been alive for "+ age/10 + " decades.");

		if (age < 0) 
			System.out.println("You haven't been born yet.");
		else if (age < 10) 
			System.out.println("You can breathe");
		else if (age < 20) 
			System.out.println("You can walk and talk.");
		else if (age < 30) 
			System.out.println("You can vote.");
		else if (age < 40) 
			System.out.println("You can be president.");
		else if (age < 50) 
			System.out.println("You can tell people that " + age + " is the new 2" + age%10 + ".");
		else if (age < 60) 
			System.out.println("You can tell people how much a stamp used to cost.");
		else if (age < 70) 
			System.out.println("You can get senior discounts.");
		else if (age < 80) 
			System.out.println("You have " + age + " rings on your trunk.");
		else if (age < 90) 
			System.out.println("You can remember all kinds of wonderful things.");
		else if (age < 10) 
			System.out.println("You can be happy.");
		else if (age >= 100) 
			System.out.println("You are the oldest person in the world.");



		

	}

}
