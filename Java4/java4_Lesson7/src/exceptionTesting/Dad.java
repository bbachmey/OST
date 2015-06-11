package exceptionTesting;

import java.io.IOException;

public class Dad {
	
    public void parentalCollaboration() {
        Mom spouse = new Mom();
        try{
            spouse.getToDoHomework();
        }
        catch(IOException e){
            System.out.println("Dad caught the I/O Exception.");
        } 
    }
	
    public static void main(String [] args)  {
        Dad parent2 = new Dad();
        parent2.parentalCollaboration();
    }
}