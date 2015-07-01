package db;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PhoneBook {

	public PhoneBook(){
		DatabaseManager databaseManager = null;
		boolean connected = false;

		// Try to login three times
		for(int i=0;i<3;i++){
			String [] info = PasswordDialog.login(this);                              // static login so can call from class
			// Create the database manager and pass login info.
			databaseManager = new DatabaseManager(info[0], info[1]);  

			if(databaseManager.isConnected()){
				connected = true;
				break;
			}

		}
		if(connected){
			UserInterface userInterface = new UserInterface(databaseManager);        // Create access for user input
			userInterface.start();    		
		}
		else {
			// opens a dialog box which tells the user to contact the sysadmin for help
			JOptionPane.showMessageDialog(null,"Please contact your system administrator","Invalid login", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	public static void main ( String[] args ) {                                         // instantiate to start                                                                                       // args[1] must be the password to connect to the mysql database
		PhoneBook myApp = new PhoneBook();     
	}
}

