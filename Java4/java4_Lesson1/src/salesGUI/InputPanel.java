package salesGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel implements ActionListener  {
	JPanel topPanel, middlePanel, bottomPanel, leftPanel, rightPanel;
	SalesApp app;
	JLabel prompt, doneLabel, jlSalesBar;
	JLabel[] jlSales;
	JButton done;
	JTextField[] jtfSales;
	JTextField jtfSalesBar;
	int numPeople;
	int [] sales;
	int goal;

	public InputPanel(SalesApp container, int numPeople, int gridX) {
		this.app = container;
		this.numPeople = numPeople;
		sales = new int[numPeople];
		this.setLayout(new BorderLayout());
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		middlePanel = new JPanel(new GridLayout(numPeople, gridX));
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		add("North",topPanel);
		add("Center",middlePanel);
		add("South",bottomPanel);
		add("East",rightPanel);
		add("West",leftPanel);
		jlSales = new JLabel[numPeople];
		jtfSales = new JTextField[numPeople];
		prompt = new JLabel("Give values for each salesperson:");
		topPanel.add(prompt);

		for(int x = 0; x < numPeople; x++){
			jlSales[x] = new JLabel("Sales Person " + (x+1));
			jtfSales[x] = new JTextField("0",8);
			middlePanel.add(jlSales[x]);
			middlePanel.add(jtfSales[x]);
		}

		jlSalesBar = new JLabel("Enter a value for the sales goal");
		bottomPanel.add(jlSalesBar);
		jtfSalesBar = new JTextField("0",8);
		bottomPanel.add(jtfSalesBar);
		doneLabel = new JLabel("Click when all are entered");
		bottomPanel.add(doneLabel);
		done = new JButton("All Set");
		bottomPanel.add(done);
		done.addActionListener(this);

	}

    public void actionPerformed(ActionEvent event){
        if (event.getSource() instanceof JButton)
        {
            if ((JButton)event.getSource() == done) 
            {
                for (int x = 0; x < numPeople; x++)
                {
                    try 
                    {
                        sales[x] = Integer.parseInt(jtfSales[x].getText());  // throws NumberFormatException
                    } 
                    catch(NumberFormatException e)
                    {   

                        String temp = JOptionPane.showInputDialog("Decimal values are not allowed.\n Please give a whole number for Sales Person " + (x+1) + ": ");
                        sales[x] = Integer.parseInt(temp);
                        jtfSales[x].setText(Integer.toString(sales[x]));      
                    }
                }

                app.setSales(sales);
                goal = Integer.parseInt(jtfSalesBar.getText());  // so don't have to be sure they hit enter
                app.setSalesBar(goal);
            }
        }
    }
}