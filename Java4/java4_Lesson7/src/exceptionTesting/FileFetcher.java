package exceptionTesting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileFetcher {
    FileReader myFile;
    BufferedReader in;
    String aLine =""; 

    public void getHomework() throws FileNotFoundException, IOException {

        // try {
            myFile = new FileReader("homework2.txt");
            System.out.println("I did get here");
            in = new BufferedReader(myFile); 
        // } 
        // catch (FileNotFoundException e){
        //     System.out.println("Can't find the file, but keep going anyway - allows for future problems");
        // }
        while (aLine != null){
            // try {
                aLine = in.readLine();
            // } 
            // catch(IOException e){
                // System.out.println("Now we have some other I/O problem");
            // }
            if (aLine !=null) System.out.println(aLine);             // we had another readLine after the check for null 
        } 
    }

//    public static void main(String [] args){
//        FileFetcher testMe = new FileFetcher();
//        testMe.getHomework();
//    }
}  