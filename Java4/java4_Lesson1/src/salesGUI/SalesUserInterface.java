package salesGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalesUserInterface extends JFrame{
	
	SalesApp app;
	JMenuBar mb;
	JMenu m, m1;
	JMenuItem q,r,s,t;
	InputPanel inputPanel;
	JLabel peopleLabel;
	JTextField peopleField;
	JButton jbNumPeople, done;
	int numPeople;
	boolean processed = false;
	
	public SalesUserInterface(SalesApp myApp){
		app = myApp;
		app.setMyUserInterface(this);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600,600));
		mb = new JMenuBar();
		setJMenuBar(mb);
		m = new JMenu("File");
		mb.add(m);
		m.add(q = new JMenuItem("Exit"));
		q.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		InitPanel specifyNumber = new InitPanel();
		add("North", specifyNumber);	
//		InputPanel inputPanel = new InputPanel(app);
//		add("Center",inputPanel);
		pack();
		setVisible(true);
		
	}
	
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
	
	private class NumSalesPeopleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (inputPanel != null){
				remove(inputPanel);
				app = new SalesApp();
				
			}
			
			numPeople = Integer.parseInt(peopleField.getText());
			inputPanel = new InputPanel(app, numPeople, 2);
			add("Center", inputPanel);
			SalesUserInterface.this.validate();
			
			
		}
		
	}
	
}
