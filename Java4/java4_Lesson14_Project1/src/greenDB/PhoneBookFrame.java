package greenDB;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 This is the UI class for the project. This class extends JFrame and implements WindowListener.
 */
class PhoneBookFrame extends JFrame implements WindowListener {
	/*** The initial user interface width, in pixels */
	private static final int WIDTH  = 577;
	/*** The initial user interface height, in pixels */
	private static final int HEIGHT = 466;
	/*** Provides methods for displaying a SQL result set in a JTable */
	private ListingsTableModel tblModel;
	/*** Used to display the SQL result set in a cell format */
	private JTable table;
	/*** A scrollable view for the SQL result set */
	private JScrollPane scrollPane;
	/*** A text field for entering the phone listing's last name */
	private JTextField lNameField    = new JTextField(10);
	/*** A text field for entering the phone listing's first name */
	private JTextField fNameField    = new JTextField(10);
	/*** A text field for entering the phone listing's area code */
	private JTextField areaCodeField = new JTextField(2);
	/*** A text field for entering the phone listing's prefix */
	private JTextField prefixField   = new JTextField(2);
	/*** A text field for entering the phone listing's extension */
	private JTextField suffixField   = new JTextField(3);
	/*** Database Operations */
	private DatabaseManager myDB;

	/**
     Constructor
	 */
	public PhoneBookFrame() {

		addWindowListener(this);

		String [] info = PasswordDialog.login(this);  // static login so can call from class
		// create and initialize the listings table
		myDB = new DatabaseManager(info[0], info[1]);
		// Should have access so make GUI   

		JButton getButton = new JButton("Get");  // get the listing
		JButton add       = new JButton("+");    // add a listing
		JButton rem       = new JButton("-");    // remove a listing
		JButton ext       = new JButton("Exit");    // remove a listing
		JLabel  space     = new JLabel(" ");
		// set the window size and title
		setTitle("Simple Phone Book");
		setSize(WIDTH, HEIGHT);
		// if user presses Enter, get button pressed
		getRootPane().setDefaultButton(getButton);
		// create the panel for looking up listing
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.LEFT));

		south.add(new JLabel("Last:"));
		south.add(lNameField);
		south.add(new JLabel(" First:"));
		south.add(fNameField);
		south.add(new JLabel("  Phone:  ("));
		south.add(areaCodeField);
		south.add(new JLabel(") "));
		south.add(prefixField);
		south.add(new JLabel("-"));
		south.add(suffixField);
		south.add(new JLabel("   "));
		south.add(getButton);

		// create the panel for adding and deleting listings
		JPanel  east           = new JPanel();
		GridBagLayout gb       = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		east.setLayout(gb);
		add.setFont(new Font("SansSerif", Font.BOLD, 12));
		rem.setFont(new Font("SansSerif", Font.BOLD, 12));

		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gb.setConstraints(add, gbc);
		gb.setConstraints(space, gbc);
		gb.setConstraints(rem, gbc);
		east.setLayout(gb);
		east.add(add);
		east.add(space);
		east.add(rem);
		east.add(ext);

		// add the panels
		Container contentPane = getContentPane();
		contentPane.add(south, BorderLayout.SOUTH);
		contentPane.add(east, BorderLayout.EAST);

		// Add listeners
		// When the application closes, drop the Listings table and close the connection to MySQL
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent wEvent) {      
						myDB.close(false);
					}
				});

		areaCodeField.addFocusListener(new PhoneFocusListener());
		areaCodeField.getDocument().addDocumentListener(new PhoneDocumentListener(areaCodeField, 3));

		prefixField.addFocusListener(new PhoneFocusListener());
		prefixField.getDocument().addDocumentListener(new PhoneDocumentListener(prefixField, 3));

		suffixField.addFocusListener(new PhoneFocusListener());
		suffixField.getDocument().addDocumentListener(new PhoneDocumentListener(suffixField, 4));

		add.addActionListener(new AddListingListener(this));  // add (+) listener--define in own class

		// remove (-) listener--delete the highlighted listing from the result set and database
		rem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent aEvent) {
						try {
							int selected = table.getSelectedRow();
							ResultSet rset  = myDB.getResultSet();
							if(selected != -1 && selected < tblModel.getRowCount()) {
								rset.absolute(table.getSelectedRow() + 1);
								rset.deleteRow();
								table.repaint();
								table.clearSelection();
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});

		ext.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent aEvent) {
						windowClosing(null);
						System.exit(0);
					}
				});

		getButton.addActionListener(new GetListener());  // Add the listener for the getButton (GetListener inner class defined below)
		// when the ui first displays do an empty lookup so the center panel doesn't look funny
		getButton.doClick();
		lNameField.requestFocus();    // set focus to last name field (most common lookup)
	}

	/**
     The PhoneBookFrame requires a handle to the DatabaseManager
	 */
	public DatabaseManager getDBManager(){
		return myDB;
	}

	/** 
     Gets the entries from the text fields
	 */
	class GetListener implements ActionListener {  

		/**
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent aEvent) {
			// Get whatever the user entered, trim any white space and change to upper case
			String last  = lNameField.getText().trim().toUpperCase();
			String first = fNameField.getText().trim().toUpperCase();
			String ac    = areaCodeField.getText().trim().toUpperCase();
			String pre   = prefixField.getText().trim().toUpperCase();
			String sfx   = suffixField.getText().trim().toUpperCase();

			// Replace any single quote chars w/ space char or SQL will think the ' is the end of the string
			last  = last.replace('\'', ' ');
			first = first.replace('\'', ' ');
			ac    = ac.replace('\'', ' ');
			pre   = pre.replace('\'', ' ');
			sfx   = sfx.replace('\'', ' ');
			// Get rid of the last result displayed if there is one
			if(scrollPane != null)
				getContentPane().remove(scrollPane);
			// Only execute the query if one or more fields have data, else just display an empty table
			if(last.length()  > 0 ||
					first.length() > 0 ||
					ac.length()    > 0 ||
					pre.length()   > 0 ||
					sfx.length()   > 0) {
				// build the query and execute it. Provide the results to the table model
				myDB.doGetQuery(buildQuery(last, first, ac, pre ,sfx));
				ResultSet rset = myDB.getResultSet();
				tblModel = new ListingsTableModel(rset);
				table = new JTable(tblModel);
			} else {
				table = new JTable();
			}
			// Allows the user to only delete one record at a time
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// Add the table with the results to the contentPane and display it.
			scrollPane = new JScrollPane(table);
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			pack();
			doLayout();
		}

		/**
        Creates SQL for select query 
		 */
		public String buildQuery(String last, String first, String ac, String pre, String sfx) {
			String whereClause = " where";
			// Build the where clause
			if(last.length() > 0)
				whereClause += (" LAST_NAME = '" + last + "'");

			if(first.length() > 0) {
				if(whereClause.length() > 6)
					whereClause += " AND";
				whereClause += (" FIRST_NAME = '" + first + "'");
			}

			if(ac.length() > 0) {
				if(whereClause.length() > 6)
					whereClause += " AND";
				whereClause += (" AREA_CODE = '" + ac + "'");
			}

			if(pre.length() > 0) {
				if(whereClause.length() > 6)
					whereClause += " AND";
				whereClause += (" PREFIX = '" + pre + "'");
			}

			if(sfx.length() > 0) {
				if(whereClause.length() > 6)
					whereClause += " AND";
				whereClause += (" SUFFIX = '" + sfx + "'");
			}

			if(last.contains("*") || first.contains("*") || ac.contains("*") || pre.contains("*") || sfx.contains("*") ){
				return "select * from Listings" ;            	            	
			}
			else {
				return "select LAST_NAME, FIRST_NAME, AREA_CODE, PREFIX, SUFFIX, LISTING_ID from Listings" + whereClause;            	
			}
		}
	} // End GetListener inner class

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("PhoneBookFrame.windowClosed()");
	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("PhoneBookFrame.windowClosing()");

		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to keep the data?","Hello",dialogButton);
		if(dialogResult == JOptionPane.NO_OPTION){
			myDB.dropTable();
		}
	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}   