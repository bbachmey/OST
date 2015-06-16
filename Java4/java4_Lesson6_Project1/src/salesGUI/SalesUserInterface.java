package salesGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SalesUserInterface extends JFrame {
	SalesApp salesApp;
	JMenuBar mb;
	JMenu m, m1;
	JMenuItem q, r, s, t;
	InputPanel inputPanel;
	JLabel jlPeople;
	JTextField jtfPeople;
	JButton jbNumPeople, done;
	int numPeople;
	OutputPanel outputPanel;  
	boolean processed = false;

	public SalesUserInterface(SalesApp myApp) {
		salesApp = myApp;
		salesApp.setMyUserInterface(this);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 600));
		mb = new JMenuBar();
		setJMenuBar(mb);
		m = new JMenu("File");
		m1 = new JMenu ("Options"); 
		mb.add(m);
		mb.add(m1); 
		m.add(q = new JMenuItem("Exit"));
		q.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		m1.add(t= new JMenuItem("Results")); 
		t.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				if(inputPanel==null){
					// Nothing to do
				}
				else {
					inputPanel.setAllInputs();  // added method call to make sure all is set
					if (processed) { 
						remove(outputPanel); 
					} 
					outputPanel = new OutputPanel(salesApp); 
					add("South", outputPanel); 
					processed = true; 
					outputPanel.writeOutput();
				}
			}
		}); 

		InitPanel initPanel = new InitPanel();
		add("North", initPanel);
		//InputPanel inputPanel = new InputPanel(app, numPeople, 2);
		//add("Center", inputPanel);
		pack();
		setVisible(true);
	}

	private class InitPanel extends JPanel {
		public InitPanel() {
			jlPeople = new JLabel("Enter the number of sales people");
			add(jlPeople);
			jtfPeople = new JTextField(5);
			add(jtfPeople);
			jbNumPeople = new JButton("Submit");
			add(jbNumPeople);
			jbNumPeople.addActionListener(new NumSalesPeopleListener());
		}
	}

	private class NumSalesPeopleListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (inputPanel != null) {
				remove(inputPanel);
				// Reset the model and controller when the number of sales people changes
				salesApp = new SalesApp();
			}
			if(validateNumPeople(jtfPeople.getText())){
				numPeople = Integer.parseInt(jtfPeople.getText());
				// Make a new input panel
				inputPanel = new InputPanel(salesApp, numPeople, 2);
				add("Center", inputPanel);
			}

			SalesUserInterface.this.validate();
		}
	}

	private boolean validateNumPeople(String input){
		boolean ok = false;
		int condition = 0;
		String message = "BLANK MESSAGE";

		// nothing there (empty Strings)
		if(input.length() == 0  ){
			condition = 2;
		}

		// characters/Strings (typing a character like e rather than a number)
		else if( input.matches("^*[a-zA-Z]*$") ){
			condition = 1;
		}

		// use of commas, dollar signs, decimals , etc.
		else if( !input.matches("^[0-9]+$") ){
			condition = 3;
		}

		if (condition == 0){
			ok = true;
			return ok;
		}
		else {
			switch (condition){
			// characters/Strings (typing a character like e rather than a number)
			case 1:
				message = "The value you entered for number of Sales People includes a letter.\n Please enter numbers, no letters.\n ";

				JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

				return ok;

				// nothing there (empty Strings)
			case 2:
				message = "The value you entered for number of Sales People is blank.\n Please enter a number.\n ";

				JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

				return ok;

				// use of commas, dollar signs, decimals , etc.
			case 3:
				message = "The value you entered for number of Sales People includes a special character.\n Please enter numbers only. No commas, dollar signs, decimals, etc.\n ";

				JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

				return ok;

			default:
				return ok;     		
			}
		}
	}
}