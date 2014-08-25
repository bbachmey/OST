public class Testing {

    public static void main(String[] args)  { 
    
        int score = 85;
        String grade = "?";		
        
        if (score < 80)  
            { if (score < 70) 
                grade = "C"; } 
        else
            grade = "B";

        System.out.println("For a score of " + score + ", the grade is " + grade);
    }
}