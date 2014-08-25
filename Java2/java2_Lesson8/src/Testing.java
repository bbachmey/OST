public class Testing {

    public static void main(String[] args)  { 
    
//        int score = 85;
//        String grade = "?";		
//        
//        if (score < 80)  
//            { if (score < 70) 
//                grade = "C"; } 
//        else
//            grade = "B";
//
//        System.out.println("For a score of " + score + ", the grade is " + grade);
    	


	    String stringLiteral = "are they the same";
    	String stringObject = new String ("are they the same"); 
    	System.out.println("stringLiteral == stringObject? " + (stringLiteral == stringObject));
    	System.out.println("The sequence of characters is the same is " + stringLiteral.equals(stringObject));
    	
    }
}