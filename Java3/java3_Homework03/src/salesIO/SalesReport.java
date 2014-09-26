package salesIO;
import java.util.Scanner;

import utilities.*;

public class SalesReport {
	private Scanner scanner = new Scanner(System.in);
	private SalesComputations computer;

	private int salespeople;
	private int sales[][];//[rows][columns]
	private int sum;
	private double avg;
	private int max;
	private int min;
	private int more[];
	private int guess;
	private int rows;

	public static final int COLUMNS = 3;
	public static final int ID_COLUMN = 0;
	public static final int NUMBER_COLUMN = 1;
	public static final int TOTAL_COLUMN = 2;	

	public SalesReport(){
		//empty constructor
	}

	public void init(){
		input();
		calculate();
		output();

		inputAgain();
		calculateAgain();
		outputAgain();

	}



	private void input() {
		//ask for a number
		System.out.print("Enter the number of salespersons: ");
		//store the number given
		salespeople = scanner.nextInt();
		//set the number of rows equal to the number of salespeople
		rows = salespeople;
		//instantiate a 2d array 
		//[rows][columns]
		sales = new int[rows][COLUMNS];
		//loop through the sales array and ask for sales amounts
		for (int i=0; i<sales.length; i++){
			int number = i+1;
			System.out.print("Enter sales for salesperson number " + number + ": ");
			//wait for the user response
			int amount = scanner.nextInt();
			//populate each column in the row
			sales[i][0] = i;
			sales[i][1] = number;
			sales[i][2] = amount;
		}

	}

	private void calculate() {
		computer = new SalesComputations();
		sum = computer.findSum(sales);
		avg = computer.findAvg(salespeople,sum);
		max = computer.findMax(sales);
		min = computer.findMin(sales);

	}

	public void output(){
		//List all sales
		System.out.println("Salesperson   Sales");
		System.out.println("--------------------");
		for (int i=0; i<sales.length; i++){
			System.out.println("     " + (sales[i][NUMBER_COLUMN]) + "         " + sales[i][TOTAL_COLUMN]);
		}
		//New line
		System.out.println("\n");
		//Total
		System.out.println("Total sales: " + sum);
		//Average
		System.out.println("Average sales: " + avg);
		//Highest
		System.out.println("Salesperson " + (sales[max][NUMBER_COLUMN]) + " had the highest sales with $" + sales[max][TOTAL_COLUMN]);
		//Lowest
		System.out.println("Salesperson " + (sales[min][NUMBER_COLUMN]) + " had the lowest sales with $" + sales[min][TOTAL_COLUMN]);

	}

	private void inputAgain() {
		System.out.print("\nEnter a $ amount: ");
		guess = scanner.nextInt();

	}

	private void calculateAgain() {
		//get an array of IDs 
		more = computer.findMore(sales, guess);

	}

	private void outputAgain() {

		if (more.length==0){
			System.out.println("No salespeople sold more than $" + guess );
		}
		else{

			for (int i=0; i<more.length; i++){
				int id = more[i];
				System.out.println("Salesperson number " + sales[id][NUMBER_COLUMN] + " sold more than $" + guess + " with sales of $" + sales[id][TOTAL_COLUMN] );
			}
			
			System.out.println("The total number of salespeople whose sales exceeded the $ amount entered is: " + more.length ); 
		}
	}
} 