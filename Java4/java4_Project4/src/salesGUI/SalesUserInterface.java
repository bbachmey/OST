package salesGUI;

import java.awt.BorderLayout;
import java.awt.Dimension; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SalesUserInterface extends JFrame {
    SalesApp app;
    JMenuBar jMenuBar;
    JMenu menuFile, menuOptions;
    JMenuItem miFileExit;
    //JMenuItem r;
    //JMenuItem s;
    JMenuItem miOptionsResults;
    JMenuItem miOptionsMinMax;
    InputPanel inputPanel;
    JLabel peopleLabel;
    JTextField peopleField;
    JButton jbNumPeople, done;
    int numPeople;
    OutputPanel outputPanel;  
    boolean processed = false;
    
    public SalesUserInterface(SalesApp myApp) {
        
    	// Calculator
    	app = myApp;
        app.setMyUserInterface(this);
        
        // Layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 600));
        
        // Menu bar
        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        
        // File menu
        menuFile = new JMenu("File");
        jMenuBar.add(menuFile);
        menuFile.add(miFileExit = new JMenuItem("Exit"));
        miFileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Options menu
        menuOptions = new JMenu ("Options"); 
        jMenuBar.add(menuOptions);   
        // Results
        menuOptions.add(miOptionsResults= new JMenuItem("Results")); 
        miOptionsResults.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if (processed) 
                { 
                    remove(outputPanel); 
                } 
                outputPanel = new OutputPanel(app); 
                add("South", outputPanel); 
                processed = true; 
                outputPanel.writeResults();}
        }); 
        // MinMax
        menuOptions.add(miOptionsMinMax= new JMenuItem("MinMax")); 
        miOptionsMinMax.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                if (processed) 
                { 
                    remove(outputPanel); 
                } 
                outputPanel = new OutputPanel(app); 
                add("South", outputPanel); 
                processed = true; 
                outputPanel.writeMinMax();}
        }); 

        // North panel
        InitPanel initPanel = new InitPanel();
        add("North", initPanel);
        
        //InputPanel inputPanel = new InputPanel(app, numPeople, 2);
        //add("Center", inputPanel);
        
        // Pack and display
        pack();
        setVisible(true);
        
    }
    
    /*
     Inner class
     */
    private class InitPanel extends JPanel {
        public InitPanel() {
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
        public void actionPerformed(ActionEvent event) {
            if (inputPanel != null)
            {
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