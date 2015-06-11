package exceptionTesting;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Mom {
	
    public void getToDoHomework() throws IOException {
        FileFetcher testMe = new FileFetcher();
        try{
            testMe.getHomework();	
        }
        catch(FileNotFoundException e){
            System.out.println("Mom caught the File Not Found Exception.");
        }
    }

    public static void main(String [] args) throws IOException {   
        // Note: This is VERY BAD programming. Do not throw exceptions in main methods.
        Mom parent1 = new Mom();
        parent1.getToDoHomework();
    }
} 