package db;

public class PhoneBook {

    public PhoneBook(){
        String [] info = PasswordDialog.login(this);                              // static login so can call from class
        DatabaseManager databaseManager = new DatabaseManager(info[0], info[1]);  // Create the database manager and pass login info.
        UserInterface userInterface = new UserInterface(databaseManager );        // Create access for user input
        userInterface.start();
    }
   
    public static void main ( String[] args ) {                                         // instantiate to start                                                                                       // args[1] must be the password to connect to the mysql database
        PhoneBook myApp = new PhoneBook();     
    }
}

