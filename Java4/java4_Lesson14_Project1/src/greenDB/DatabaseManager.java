package greenDB;
                
import java.sql.*;
                
/**
 This class manages connection, read, and write to the database
 */
public class DatabaseManager {
    private Connection conn;  
    private Statement stmt;
    private ResultSet rset;
                    
    public DatabaseManager (String username, String password) {  // the constructor for the database manager
        // Connect to database and execute the SQL commands for creating and initializing the Listings table.
        try {
            Class.forName ("com.mysql.jdbc.Driver");  // Load the MySQL JDBC driver
        }
        catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC/ODBC driver.");
            e.printStackTrace();
            return;
        }
                    
        try {                   
            // Connect to the database.
            // Give the whole URL as a parameter rather than using a variable
            conn = DriverManager.getConnection("jdbc:mysql://sql.useractive.com:3306/" + username, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);   // Create a Statement
            // Execute the creation and initialization of table query 
            DatabaseMetaData aboutDB = conn.getMetaData(); 
            String [] tableType = {"TABLE"};
            ResultSet rs = aboutDB.getTables(null, null, "Listings",  tableType);   
            if (!inspectForTable (rs, "Listings")) {     // Find out if the table is already there
                // there is no table--make it from the initialization listing
                String [] SQL = initListingsTable();     // code for this method is below
                for (int i=0; i < SQL.length; i++) 
                {
                	System.out.println(SQL[i]);
                    stmt.execute(SQL[i]);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
                    
    /**
     Populate db with records
     */
    private String [] initListingsTable() {
        // Executable SQL commands for creating Listings table 
        // inserting initial names and phone numbers.
        String[]  SQL = {
            "create table Listings (" +

			"LISTING_ID int NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            "LAST_NAME  varchar (16)," +
            "FIRST_NAME varchar (16)," +
            "AREA_CODE  varchar(3)," +
            "PREFIX     varchar(3)," +
            "SUFFIX     varchar(4))"
            ,
            "INSERT INTO Listings (LAST_NAME, FIRST_NAME, AREA_CODE, PREFIX, SUFFIX) " +
            "VALUES ('ANDERSON', 'JOHN',  '314', '825', '1695')"
			,
            "INSERT INTO Listings (LAST_NAME, FIRST_NAME, AREA_CODE, PREFIX, SUFFIX) " +
            "values ('CABLES',   'WALLY', '212', '434', '9685')"
            ,
            "INSERT INTO Listings (LAST_NAME, FIRST_NAME, AREA_CODE, PREFIX, SUFFIX) " +
            "values ('FRY',      'EDGAR', '415', '542', '5885')"
            ,
            "INSERT INTO Listings (LAST_NAME, FIRST_NAME, AREA_CODE, PREFIX, SUFFIX) " +
            "values ('MARTIN',   'EDGAR', '665', '662', '9001')"
            ,
            "INSERT INTO Listings (LAST_NAME, FIRST_NAME, AREA_CODE, PREFIX, SUFFIX) " +
            "values ('TUCKER',   'JOHN',  '707', '696', '8541')"
            
        };
        return SQL;
    }
                    
    /**
     Get metadata about database
     */
    private boolean inspectForTable (ResultSet rs, String tableName)  throws SQLException {  // exception will be caught when method is used
        int i;
        ResultSetMetaData rsmd = rs.getMetaData ();  // Get the ResultSetMetaData to use for the column headings
        int numCols = rsmd.getColumnCount ();        // Get the number of columns in the result set
                    
        boolean more = rs.next ();
        while (more) {                               // Get each row, fetching until end of the result set
            for (i=1; i<=numCols; i++) { 
                if (rsmd.getColumnLabel(i) == "TABLE_NAME")   // Loop through each row, getting the column data looking for Tables
                    if  (rs.getString(i).equals(tableName))   // If the column is the TABLE_NAME, is it the one we are looking for?
                    {
                        System.out.println("Found one that equals " + rs.getString(i));
                        return true;
                    }
            }
            System.out.println("");
            more = rs.next ();              // Fetch the next result set row
        }
        return false;
    }
                    
    /**
     Perform get query
     */
    public void doGetQuery(String query) {  // rather than the "getEntries" of the previous example
        try {
        	
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                    
    /**
     Perform insert query
     */
    public void doInsertQuery(String query) {   // rather than the hard-coded "addEntry" of the previous example
        try {  
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                    
    /**
     Encapsulate access to result set
     */
    public ResultSet getResultSet() {  // a new method that will let the GUI get the resultSet to manipulate it
        return rset;
    } 
                    
    /**
     Close db connection 
     */
    public void close(boolean remove){  // closes all open connections                                             
        try {
            if (remove) 
                stmt.execute ("drop table Listings;");                                 
            stmt.close();
            conn.close();
        }
        catch ( SQLException e ) {
            System.out.println ("\n*** SQLException caught ***\n");
            e.printStackTrace();
        }
    }
    
    /**
     Drop db table
     */
    public void dropTable(){

        try {
			stmt.execute("DROP TABLE Listings");
			System.out.println("Table dropped");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}