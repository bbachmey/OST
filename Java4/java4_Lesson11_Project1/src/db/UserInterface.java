package db;

import java.sql.*;
import java.util.*;

public class UserInterface {

    private DatabaseManager database;                                      // the reference to the DatabaseManager object, 
                                                                          // handles all requests to access the database

    public UserInterface(DatabaseManager theDatabaseManager) {
	    database = theDatabaseManager;
    }

    public void start() {
        Scanner in = new Scanner (System.in);
        while (true) {                                   // Continue until the user quits
            System.out.println ("Click in the Console,"
             + "\n then enter a command:");

            String command = in.nextLine();

            if(command.isEmpty()){
            	System.out.println ("Please enter a command before hitting Enter.");
            	System.out.println ("\n");
            }
            else if ( command.charAt(0) == 'A' ){
                System.out.println ("Enter name: ");
                String name = in.nextLine();
                System.out.println ("Enter phone number (format ###-#######): ");
                String phoneNumber = in.nextLine();
                if(goodPhoneNumber(phoneNumber)){
                    database.addEntry (name, phoneNumber);  // Add this entry to the database.                	
                }
                else {
                	System.out.println("Please enter a valid phone number.");
                }
            }
            else if ( command.charAt(0) == 'C' ){
                System.out.println ("Closing...");
                
                // Drop the table PhoneBook
                database.dropTable("PhoneBook");
                // Confirm drop table
                System.out.println ("Table dropped: PhoneBook");
                
                // Close the statement instance
                database.closeDbConnection();
                System.out.println ("Connection closed");
                
                // Exit the program
                System.exit(0);
                
            }
            else {
            	System.out.println("I'm sorry, Dave. I can't do that.");
            }
        }   
    }
    /*
     Source: 
     */
    private static boolean goodPhoneNumber(String phone) {

    	String regex = "\\d{3}-\\d{7}";
        if (phone.matches(regex)){
        	return true;
        }
        else {
        	 return false;
        }
        
    }
    
}