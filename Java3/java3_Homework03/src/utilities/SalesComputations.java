package utilities;

import java.util.Scanner;

import salesIO.SalesReport;

public class SalesComputations {


	public int findMax(int sales[][]) {
		int max = sales[0][SalesReport.TOTAL_COLUMN];
		int who = sales[0][SalesReport.ID_COLUMN];
		for (int i=0; i < sales.length; i++)
		{
			if (max < sales[i][SalesReport.TOTAL_COLUMN]){
				who=sales[i][SalesReport.ID_COLUMN]; //ID
			}
		}
		return who; 

	}

	public int findMin(int sales[][]) {
		int min = sales[0][SalesReport.TOTAL_COLUMN];
		int who = sales[0][SalesReport.ID_COLUMN];
		for (int i=0; i < sales.length; i++)
		{
			if (sales[i][SalesReport.TOTAL_COLUMN] < min){
				who=sales[i][SalesReport.ID_COLUMN];
			}
		}
		return who;

	}

	public int[] findMore(int sales[][], int guess) {
		int more[];
		int many = 0;
		int counter = 0;
		for (int i=0; i < sales.length; i++)
		{
			if (sales[i][SalesReport.TOTAL_COLUMN] > guess){
				many++;
			}
		}
		more = new int[many];
		for (int i=0; i < sales.length; i++)
		{
			if (sales[i][SalesReport.TOTAL_COLUMN] > guess){
				more[counter]=sales[i][SalesReport.ID_COLUMN];
				counter++;
			}
		}
		return more;
		
	}

	public int findSum(int sales[][]) {
		int sum = 0;
		for (int i=0; i<sales.length; i++){
			sum = sum + sales[i][SalesReport.TOTAL_COLUMN];
		}
		return sum;
	}

	public int findAvg(int people, int sum) {
		double average = sum/people;
		return (int)average;
	}

}
