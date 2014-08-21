
import java.util.Scanner;

public class Testing {

   public static void main(String[] args)  { 

       int score;
       String grade;
       Scanner scan = new Scanner(System.in);
       
       System.out.print("Enter a grade to test: ");
       score = scan.nextInt();		
       
       if (score >= 90) 
           grade = "A";
       else if (score >= 80) 
           grade = "B";
       else if (score >= 70) 
           grade = "C";   
       else if (score >= 60)
           grade = "D"; 
       else
           grade = "F";
       System.out.println("For a score of " + score + ", the grade is " + grade);
    }
}