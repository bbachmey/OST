package greenDB;
                
import javax.swing.JFrame;
                
/**
 This is the main class in this project. Execution begins here.
 */
public class SimplePhoneBook {
	// Instantiate the phone book frame window and display it.
    public static void main(String args[]) {   
        PhoneBookFrame pbFrame = new PhoneBookFrame();
        pbFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pbFrame.setVisible(true);
    }
}  