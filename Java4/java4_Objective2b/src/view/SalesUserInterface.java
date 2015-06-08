package view;

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

import calc.SalesApp;



public class SalesUserInterface extends JFrame{

	SalesApp app;
	JMenuBar mb;
	JMenu menuFile, m1, menuData;
	JMenuItem miFileExit,r,s,t,miDataReset,miDataRetrieve,miDataReturn;
	InputPanel currentPanel;
	InputPanel recentPanel;
	JLabel jlNumSalesPeople;
	JTextField jtfNumSalesPeople;
	JButton jbSubmit, done;
	int numPeople;
	boolean processed = false;

	public SalesUserInterface(){

		resetCalcApp();

		setLayout(new BorderLayout());

		setPreferredSize(new Dimension(600,600));

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


	private void clickReset(ActionEvent e){

		// Clear the value in the text field
		jtfNumSalesPeople.setText("");

		// Check for null and remove the input panel
		if (currentPanel != null){
			remove(currentPanel);
			resetCalcApp();
		}

		// Revalidate and repaint
		SalesUserInterface.this.revalidate();
		SalesUserInterface.this.repaint();
	}
	
	public void clickAllSet(ActionEvent e){

		// Clear the value in the text field
		jtfNumSalesPeople.setText("");

		resetCalcApp();
		
		// Check for null and remove the input panel
		if (currentPanel != null){
			recentPanel = currentPanel;
			remove(currentPanel);
		}

		// Revalidate and repaint
		SalesUserInterface.this.revalidate();
		SalesUserInterface.this.repaint();
	}

	private void clickRetrieve(ActionEvent e){

		resetCalcApp();

		// Remove the input panel
		if (recentPanel != null){
			remove(currentPanel);
			
			jtfNumSalesPeople.setText(recentPanel.getNumSalesPeople());

			add("Center", recentPanel);

			// Revalidate and repaint
			SalesUserInterface.this.revalidate();
			SalesUserInterface.this.repaint();
		}

	}

	private void clickReturn(ActionEvent e){
		
		resetCalcApp();

		// Remove the input panel
		if (recentPanel != null){
			remove(recentPanel);

			jtfNumSalesPeople.setText(currentPanel.getNumSalesPeople());
			
			add("Center", currentPanel);

			// Revalidate and repaint
			SalesUserInterface.this.revalidate();
			SalesUserInterface.this.repaint();
			
		}

	}


	/*
	 Inner class
	 */
	private class InitPanel extends JPanel{
		public InitPanel(){
			jlNumSalesPeople = new JLabel("Enter the number of sales people");
			add(jlNumSalesPeople);
			jtfNumSalesPeople = new JTextField(5);
			add(jtfNumSalesPeople);
			jbSubmit = new JButton("Submit");
			add(jbSubmit);
			jbSubmit.addActionListener(new NumSalesPeopleListener());

		}
	}

	/*
	 Inner class
	 */
	private class NumSalesPeopleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// Remove the input panel
			if (currentPanel != null){
				remove(currentPanel);
			}

			numPeople = Integer.parseInt(jtfNumSalesPeople.getText());

			recentPanel = currentPanel;
			currentPanel = new InputPanel(app, numPeople, 2);
			add("Center", currentPanel);
			SalesUserInterface.this.validate();


		}

	}

}
