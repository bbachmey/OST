package db;

import java.sql.*;

public class DatabaseManager {

	private Connection connection;  // The database connection object.
	private Statement statement;    // the database statement object, used to execute SQL commands.

	public DatabaseManager (String username, String password ) {          // the constructor for the database manager
		String url = "jdbc:mysql://sql.useractive.com:3306/" + username;  // where username is your O'Reilly login username
		try {
			Class.forName ("com.mysql.jdbc.Driver");
		}
		catch (Exception e) {
			System.out.println("Failed to load JDBC/ODBC driver.");
			return;
		}

		try {                                                                       // Establish the database connection, create a statement for execution of SQL commands.
			connection = DriverManager.getConnection (url, username, password );     // username and password are passed into this Constructor
			statement  = connection.createStatement();
			if(doesTableExist("PhoneBook")){
				this.dropTable("PhoneBook");				
			}
			statement.execute("create table PhoneBook (Name varchar (32), PhoneNumber varchar (18));"); // create a table in the database                                       
		}
		catch (SQLException exception ) {
			System.out.println ("\n*** SQLException caught ***\n");
			while (exception != null) 
			{                                                                         // tell us the problem
				System.out.println ("SQLState:    " + exception.getSQLState()  );
				System.out.println ("Message:     " + exception.getMessage()   );
				System.out.println ("Error code:  " + exception.getErrorCode() );
				exception = exception.getNextException ();

				System.out.println ( "" );
			}
		}
		catch ( java.lang.Exception exception ) {
			exception.printStackTrace();
		}
	}

	public void addEntry (String name, String phoneNumber ){                       // adds an entry to the Phone Book
		try
		{
			statement.execute ( "insert into PhoneBook values ('" + name + "', '" + phoneNumber + "');" );
		}
		catch ( SQLException exception ) 
		{
			System.out.println ("\n*** SQLException caught ***\n");

			while ( exception != null) 
			{
				System.out.println ("SQLState:    " + exception.getSQLState()  );
				System.out.println ("Message:     " + exception.getMessage()   );
				System.out.println ("Error code:  " + exception.getErrorCode() );
				exception = exception.getNextException ();   
				System.out.println ( "" );
			}
		}
		catch(java.lang.Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	/*
     Drops the table name given
	 */
	public void dropTable (String tableName ){                     
		try
		{
			statement.execute ( "DROP TABLE " + tableName );
		}
		catch ( SQLException exception ) 
		{
			System.out.println ("\n*** SQLException caught ***\n");

			while ( exception != null) 
			{
				System.out.println ("SQLState:    " + exception.getSQLState()  );
				System.out.println ("Message:     " + exception.getMessage()   );
				System.out.println ("Error code:  " + exception.getErrorCode() );
				exception = exception.getNextException ();   
				System.out.println ( "" );
			}
		}
		catch(java.lang.Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	/*
		Closes the connections
	 */
	public void closeDbConnection(){                     
		try
		{
			statement.close();
			connection.close();
		}
		catch ( SQLException exception ) 
		{
			System.out.println ("\n*** SQLException caught ***\n");

			while ( exception != null) 
			{
				System.out.println ("SQLState:    " + exception.getSQLState()  );
				System.out.println ("Message:     " + exception.getMessage()   );
				System.out.println ("Error code:  " + exception.getErrorCode() );
				exception = exception.getNextException ();   
				System.out.println ( "" );
			}
		}
		catch(java.lang.Exception exception ) 
		{
			exception.printStackTrace();
		}
	}

	public boolean doesTableExist(String tableName){
		
		boolean does = false;

		DatabaseMetaData meta;
		
		try {
			meta = connection.getMetaData();
			
			ResultSet res = meta.getTables(null, null, tableName, new String[] {"TABLE"});
			
			while (res.next()) {
				
				does = true;
				
				// Source: http://stackoverflow.com/questions/2942788/check-if-table-exists
				System.out.println(
						"   "+res.getString("TABLE_CAT") 
						+ ", "+res.getString("TABLE_SCHEM")
						+ ", "+res.getString("TABLE_NAME")
						+ ", "+res.getString("TABLE_TYPE")
						+ ", "+res.getString("REMARKS")); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return does;
	}
}