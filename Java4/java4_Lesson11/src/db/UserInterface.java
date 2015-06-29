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
             + "\n then enter a command:"
             + "\n A (then Enter) to Add a phone book entry, \n"
             + "Click red square to quit (terminate) for now.");

            String command = in.nextLine();

            if ( command.charAt(0) == 'A' )
            {
                System.out.println ("Enter name: ");
                String name = in.nextLine();
                System.out.println ("Enter phone number: ");
                String phoneNumber = in.nextLine();
                database.addEntry (name, phoneNumber);  // Add this entry to the database.
            }
        }   
    }
}