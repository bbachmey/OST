package view;

import io.FileEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import controller.SalesApp;


public class SalesUserInterface extends JFrame{

	SalesApp app;
	JMenuBar mb;
	JMenu menuFile, m1, menuData;
	JMenuItem miFileExit,r,s,t,miDataReset,miDataRetrieve,miDataReturn;
	InputPanel inputPanel;
	JLabel peopleLabel;
	JTextField peopleField;
	JButton jbNumPeople, done;
	int numPeople;
	boolean processed = false;
	int [] currentValues;
	int [] recentValues;

	public SalesUserInterface(){

		resetCalcApp();

		setLayout(new BorderLayout());

		setPreferredSize(new Dimension(600,600));

		// Save sales when closing the JFrame
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent winEvt) {
				saveSales();
				System.exit(0);
			}


		});
		
		// Initialize the current values array
		currentValues = new int[0];

		// Make the menu bar
		mb = new JMenuBar();
		setJMenuBar(mb);

		// Make the file menu
		menuFile = new JMenu("File");
		mb.add(menuFile);
		menuFile.add(miFileExit = new JMenuItem("Exit"));
		miFileExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});

		// Make the Data menu
		menuData = new JMenu("Data");
		mb.add(menuData);
		menuData.add(miDataReset = new JMenuItem("Reset"));
		menuData.add(miDataRetrieve = new JMenuItem("Retrieve"));
		menuData.add(miDataReturn = new JMenuItem("Return"));
		miDataReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clickReset(e);
			}
		});
		miDataRetrieve.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clickRetrieve(e);
			}
		});
		miDataReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clickReturn(e);
			}
		});

		// Make the Init Panel
		InitPanel specifyNumber = new InitPanel();
		add("North", specifyNumber);	
		//		InputPanel inputPanel = new InputPanel(app);
		//		add("Center",inputPanel);

		// Pack it up and show it
		pack();
		setVisible(true);

	}

	private void resetCalcApp() {
		
		app = new SalesApp();
		app.setMyUserInterface(this);
		
	}

	private void saveSales() {

		// Get sales values from the input panel
		if (inputPanel != null){
			int [] sales = inputPanel.getSales();

			String [] lines = new String[sales.length];

			for(int i=0;i<sales.length;i++){
				lines[i]= Integer.toString(sales[i]);
			}

			// New file editor
			FileEditor ed = new FileEditor();
			ed.eraseFile("sales.txt");
			ed.saveFile("sales.txt",lines);
		}



	}

	private void clickReset(ActionEvent e){

		// Clear the value in the text field
		peopleField.setText("");

		// Check for null and remove the input panel
		if (inputPanel != null){
			remove(inputPanel);
			resetCalcApp();

		}

		// Revalidate and repaint
		SalesUserInterface.this.revalidate();
		SalesUserInterface.this.repaint();
	}

	private void clickRetrieve(ActionEvent e){


		resetCalcApp();
		
		// Remove the input panel
		if (inputPanel != null){
			remove(inputPanel);
		}
		
		// Try to load previous values
		FileEditor ed = new FileEditor();
		recentValues = ed.readFile("sales.txt");

		if(recentValues == null){
			// TODO: handle no previous values found 
		}
		else {

			String size = Integer.toString(recentValues.length);

			// Set the value in the text field
			peopleField.setText(size);

			numPeople = recentValues.length;
			inputPanel = new InputPanel(app, recentValues, 2);
			add("Center", inputPanel);

			// Revalidate and repaint
			SalesUserInterface.this.revalidate();
			SalesUserInterface.this.repaint();

		}

	}

	private void clickReturn(ActionEvent e){

		resetCalcApp();
		
		String size = Integer.toString(currentValues.length);

		// Set the value in the text field
		peopleField.setText(size);

		numPeople = currentValues.length;
		
		if (inputPanel != null){
			remove(inputPanel);
		}
		
		if (numPeople > 0){
			inputPanel = new InputPanel(app, currentValues, 2);
			add("Center", inputPanel);
		}

		// Revalidate and repaint
		SalesUserInterface.this.revalidate();
		SalesUserInterface.this.repaint();

	}


	/*
	 Inner class
	 */
	private class InitPanel extends JPanel{
		public InitPanel(){
			peopleLabel = new JLabel("Enter the number of sales people");
			add(peopleLabel);
			peopleField = new JTextField(5);
			add(peopleField);
			jbNumPeople = new JButton("Submit");
			add(jbNumPeople);
			jbNumPeople.addActionListener(new NumSalesPeopleListener());

		}
	}

	/*
	 Inner class
	 */
	private class NumSalesPeopleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			// Remove the input panel
			if (inputPanel != null){
				remove(inputPanel);
			}

			numPeople = Integer.parseInt(peopleField.getText());
			currentValues = new int[numPeople];
			inputPanel = new InputPanel(app, currentValues, 2);
			add("Center", inputPanel);
			SalesUserInterface.this.validate();


		}

	}

}
