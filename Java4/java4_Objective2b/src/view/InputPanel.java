package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import calc.SalesApp;



public class InputPanel extends JPanel implements ActionListener  {

	String TAG = InputPanel.class.getName();

	JPanel topPanel, middlePanel, bottomPanel, leftPanel, rightPanel;
	SalesApp calc;
	JLabel prompt, doneLabel, jlSalesBar;
	JLabel[] jlSales;
	JButton done;
	JTextField[] jtfSales;
	JTextField jtfSalesBar;
	int numPeople;
	int [] sales;
	int goal;
	int gridX;

	public InputPanel(SalesApp app, int numPeople, int gridX) {

		// Make a reference to the app to which this input panel is being added
		this.calc = app;
		// How many sales people 
		this.numPeople = numPeople;
		// How many columns are in the grid
		this.gridX = gridX;
		// Make an array of integers to store the sales values
		sales = new int[numPeople];
		// Assemble the UI components
		buildView();

	}

	private void buildView(){

		// Choose a layout for this JPanel
		this.setLayout(new BorderLayout());

		// Top
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		// Middle
		middlePanel = new JPanel(new GridLayout(numPeople, gridX));
		// Bottom
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		// Left
		leftPanel = new JPanel();
		// Right
		rightPanel = new JPanel();

		// Add
		add("North",topPanel);
		add("Center",middlePanel);
		add("South",bottomPanel);
		add("East",rightPanel);
		add("West",leftPanel);

		// Label
		jlSales = new JLabel[numPeople];
		// Text field
		jtfSales = new JTextField[numPeople];
		// Prompt
		prompt = new JLabel("Give values for each salesperson:");
		// Add prompt to top panel
		topPanel.add(prompt);

		jlSalesBar = new JLabel("Enter a value for the sales goal");
		bottomPanel.add(jlSalesBar);

		jtfSalesBar = new JTextField("0",8);
		bottomPanel.add(jtfSalesBar);

		doneLabel = new JLabel("Click when all are entered");
		bottomPanel.add(doneLabel);

		done = new JButton("All Set");
		bottomPanel.add(done);

		done.addActionListener(this);

		// Add labels and text fields for every sales person
		makeSalesBoxes();

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) {

		// If the source of the event was a button
		if(event.getSource() instanceof JButton) {
			// If the source of the button was this button
			if ((JButton)event.getSource() == done) {
				// Loop through the number of people and add values from the text boxes to the sales array
				for (int x = 0; x < numPeople; x++) {
					sales[x] = Integer.parseInt(jtfSales[x].getText());
				}
				// Call the setSales() method of the app
				calc.setSales(sales);
				// Set the goal value of this panel
				goal = Integer.parseInt(jtfSalesBar.getText());
				// Set the goal value of the app
				calc.setSalesBar(goal);
				
				calc.myUserInterface.clickAllSet(event);
				
			}
		}
	}

	private void makeSalesBoxes(){
		//System.out.println("makeSalesBoxes()");

		// Loop through number of people and add labels and text fields to middle panel		
		for(int x = 0; x < sales.length; x++){

			// Make the label
			jlSales[x] = new JLabel("Sales Person " + (x+1));
			// Make the text field
			jtfSales[x] = new JTextField(Integer.toString(sales[x]),8);

			// Add a document listener to the text field
			jtfSales[x].getDocument().addDocumentListener(new DocumentListener() {


				@Override
				public void changedUpdate(DocumentEvent e) {

					System.out.println("Changed");
					handleTfEvent(e);

				}
				@Override
				public void removeUpdate(DocumentEvent e) {

					// System.out.println("Remove");	
					// System.out.println(e.toString());	
					handleTfEvent(e);

				}
				@Override
				public void insertUpdate(DocumentEvent e) {

					System.out.println("Insert");	
					handleTfEvent(e);

				}

			});


			// Add the label to the panel
			middlePanel.add(jlSales[x]);
			// Add the text field to the panel
			middlePanel.add(jtfSales[x]);

		}


	}

	private void handleTfEvent(DocumentEvent e){
		System.out.println("handleTfEvent()");

		Document doc = e.getDocument();

		for (int i = 0; i<sales.length; i++){

			if (doc == jtfSales[i].getDocument()){
				System.out.println("event caused by " + doc.toString() );
				System.out.println("Text field number: " + i);

				String text = jtfSales[i].getText();

				if(text.length()>0){

					sales[i] = Integer.parseInt(text);
				}
				else {

					sales[i] = 0;
				}


			}

		}	
		
	}

	public String getNumSalesPeople() {

		return Integer.toString(sales.length);
		
	}

}
