package exceptionTesting;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Mom {

	public void getToDoHomework() throws IOException {

		FileFetcher fileFetcher = new FileFetcher();

		try{
			fileFetcher.getHomework(); 
		}
		catch(FileNotFoundException e){
			System.out.println("Mom caught the File Not Found Exception.");   


			JFileChooser chooser = new JFileChooser();
			//          FileNameExtensionFilter filter = new FileNameExtensionFilter(
			//              "JPG & GIF Images", "jpg", "gif");
			//          chooser.setFileFilter(filter);
			// Note: The parent parameter can be null for non-GUI applications. For GUI applications, it should be a reference to the JFrame of the application.
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " +
						chooser.getSelectedFile().getName());
			}
		}
	}

//	public static void main(String [] args) throws FileNotFoundException {     
//		Mom mom = new Mom();
//		mom.getToDoHomework();
//	}
} 