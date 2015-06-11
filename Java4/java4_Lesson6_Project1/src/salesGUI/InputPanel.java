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
	SalesApp salesApp;
	JLabel prompt, jlAllSet, jlSalesBar;
	JLabel[] jlSales;
	JButton jbAllSet;
	JTextField[] jtfSales;
	JTextField jtfSalesBar;
	int numPeople;
	int [] sales;
	int goal;

	public InputPanel(SalesApp container, int numPeople, int gridX) {
		
		this.salesApp = container;
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
		
		jlAllSet = new JLabel("Click when all are entered");
		bottomPanel.add(jlAllSet);
		
		jbAllSet = new JButton("All Set");
		bottomPanel.add(jbAllSet);
		jbAllSet.addActionListener(this);

	}

	// The InputPanel is-a event ActionListener and actionPerformed() is the event handler
    public void actionPerformed(ActionEvent event) {
        // If the source of the event was a JButton
    	if (event.getSource() instanceof JButton){
        	// If the JButton is jbAllSet
            if ((JButton)event.getSource() == jbAllSet){
                setAllInputs();    
            }
        }
    }
    
    public void setAllInputs(){
    	int condition = 0;
    	String message;
    	
        for (int x = 0; x < numPeople; x++){
        	message = "Hello World!"; //should not be displayed

        	// nothing there (empty Strings)
        	if(jtfSales[x].getText().length() == 0  ){
        		condition = 2;
        	}

        	// characters/Strings (typing a character like e rather than a number)
        	else if( jtfSales[x].getText().matches("^*[a-zA-Z]*$") ){
        		condition = 1;
        	}
        	
        	// use of commas, dollar signs, decimals , etc.
        	else if( !jtfSales[x].getText().matches("^[0-9]+$") ){
        		condition = 3;
        	}
        	
        	if (condition == 0){
                try {
            		sales[x] = Integer.parseInt(jtfSales[x].getText());                    
                } 
                catch(NumberFormatException e){   
                    String messageLine1 = "Input must be whole numbers.\n ";
                    String messageLine2 = "Your decimal value " + jtfSales[x].getText() + " for Sales Person " + (x+1) +" will be truncated.\n ";
                    String messageLine3 = "You may enter a different integer and click AllSet if truncation is unacceptable.";

                    JOptionPane.showMessageDialog(this, messageLine1+messageLine2+messageLine3,"Input Error", JOptionPane.ERROR_MESSAGE);

                    sales[x]= (int)Double.parseDouble(jtfSales[x].getText());
                    jtfSales[x].setText(Integer.toString(sales[x]));          
                }
                
        	}
        	else {
        		switch (condition){
            	// characters/Strings (typing a character like e rather than a number)
        		case 1:

                    message = "The value you entered for Sales Person " + (x+1) +" includes a letter.\n Please enter numbers, no letters.\n ";
                  
                    JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

        			return;
        		// nothing there (empty Strings)
        		case 2:

                    message = "The value you entered for Sales Person " + (x+1) +" is blank.\n Please enter a number.\n ";
                    
                    JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

                    return;
                // use of commas, dollar signs, decimals , etc.
        		case 3:

                    message = "The value you entered for Sales Person " + (x+1) +" includes a special character.\n Please enter numbers only. No commas, dollar signs, decimals, etc.\n ";
                    
                    JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

                    return;
        		default:
        			break;        		
        		}
        	}

        }

        
        // Set the sales goal in the sales app
        if(validateSalesGoal(jtfSalesBar.getText())){
            this.goal = Integer.parseInt(jtfSalesBar.getText());  // so don't have to be sure they hit enter
            salesApp.setSalesGoal(this.goal);
        } else {
        	return;
        }

        // Set the array of sales in the sales app
        salesApp.setSales(sales);
        
    }
    
	private boolean validateSalesGoal(String input){
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
				message = "The value you entered for the Sales Goal includes a letter.\n Please enter numbers, no letters.\n ";

				JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

				return ok;
				
			// nothing there (empty Strings)
			case 2:
				message = "The value you entered for the Sales Goal is blank.\n Please enter a number.\n ";

				JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

				return ok;
				
			// use of commas, dollar signs, decimals , etc.
			case 3:
				message = "The value you entered for the Sales Goal includes a special character.\n Please enter numbers only. No commas, dollar signs, decimals, etc.\n ";

				JOptionPane.showMessageDialog(this, message,"Input Error", JOptionPane.ERROR_MESSAGE);

				return ok;
				
			default:
				return ok;     		
			}
		}
	}	
}