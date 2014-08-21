
import java.util.Scanner;

public class Testing {

   public static void main(String[] args)  { 

       int score;
       String grade;
       Scanner scan = new Scanner(System.in);
       
//       System.out.print("Enter a grade to test: ");
//       score = scan.nextInt();		
       
//       if (score >= 90) 
//           grade = "A";
//       else if (score >= 80) 
//           grade = "B";
//       else if (score >= 70) 
//           grade = "C";   
//       else if (score >= 60)
//           grade = "D"; 
//       else
//           grade = "F";
       

	   	 
//       if (score < 60)  grade = "F"; else grade = "unknown";     
//       if (score >= 60 && score < 70) grade = "D";
//       if (score >= 70 && score < 80) grade = "C";
//       if (score >= 80 && score < 90) grade = "B";
//       if (score >= 90)  grade = "A";
//       
//       System.out.println("For a score of " + score + ", the grade is " + grade);
       
       
       //Logic Statements Versus If Statements
       int year;
       boolean leap;


       System.out.print("Enter a year to test: ");
       year = scan.nextInt();		
	   	 
       //leap = (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
       

       if (year % 4 == 0)
           if (year % 100 == 0)   // if divisible by 100 must be divisible by 400
               leap = (year % 400 == 0);  // i.e., if year is divisible by 400 then this is true
           else
               leap = true;
       else
           leap = false;

       System.out.println("It is " + leap + " that " + year + " is a leap year.");       
       
       
       
    }
}