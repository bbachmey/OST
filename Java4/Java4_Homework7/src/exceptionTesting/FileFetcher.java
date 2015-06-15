package exceptionTesting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import javax.swing.JFileChooser;

public class FileFetcher {

	FileReader myFile;
	BufferedReader in;
	String aLine =""; 
	String fileName = "homework2.txt";
	int counter = 0;

	public static void main(String [] args)  {

		FileFetcher me = new FileFetcher();
		me.go();

	}

	private void go(){
		
		try {
			
			this.openFile(fileName);
			
		}
		catch(FileNotFoundException e){
			System.out.println("FileFetcher caught the File Not Found Exception.");   


			JFileChooser chooser = new JFileChooser();
			//          FileNameExtensionFilter filter = new FileNameExtensionFilter(
			//              "JPG & GIF Images", "jpg", "gif");
			//          chooser.setFileFilter(filter);
			// Note: The parent parameter can be null for non-GUI applications. For GUI applications, it should be a reference to the JFrame of the application.
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " +
						chooser.getSelectedFile().getName());
				fileName = chooser.getSelectedFile().getAbsolutePath();
				counter++;
				if (counter < 3){
					go();
				}
			}
		}
		catch(IOException e){
			System.out.println("FileFetcher caught the I/O Exception.");    
		} 

	}

	public void openFile(String fileName) throws FileNotFoundException, IOException {
		System.out.println("openFile()");
		
		if (fileName != null && fileName.length() > 0){
			
			myFile = new FileReader(fileName);
			System.out.println("Created new FileReader in openFile()");
			in = new BufferedReader(myFile);
			readFile(in);
			
		}


	}	
	
	public void readFile(BufferedReader bufferedReader) throws FileNotFoundException, IOException {
		System.out.println("readFile()");

		while (aLine != null){

			aLine = bufferedReader.readLine();

			if (aLine !=null) System.out.println(aLine); 

		} 
	}	
}  