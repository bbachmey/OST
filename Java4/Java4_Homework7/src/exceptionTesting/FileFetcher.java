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

		myFile = new FileReader("homework2.txt");
		System.out.println("I did get here");
		in = new BufferedReader(myFile);

		while (aLine != null){

			aLine = in.readLine();

			if (aLine !=null) System.out.println(aLine); 

		} 
	}
}  