package salesGUI;

import java.awt.Panel;
import javax.swing.*;
import java.text.DecimalFormat;

public class OutputPanel extends JPanel {
  
    JLabel jlSalesOutput;
    Panel leftPanel, rightPanel;
    JLabel jlSalesBar;
    JTextField jtfSalesBar;
    JButton done;
    SalesApp app;      
    int salesBar;
    int [] sales; 
    DecimalFormat decimalFormat =  new DecimalFormat("####.##");  

    public OutputPanel(SalesApp container) {
        app = container;
        sales = app.getSales();
        leftPanel = new Panel();
        rightPanel = new Panel();
        add("East", rightPanel);
        add("West", leftPanel);
        jlSalesOutput = new JLabel();
        rightPanel.add(jlSalesOutput);
        refreshOutput();
    }

    public void refreshOutput(){
        jlSalesOutput.setText("");
    }

    protected void writeResults(){  
        app.calculateMinMax();
//        DecimalFormat df1 =  new DecimalFormat("####.##");  
        // Build the output string like an HTML doc 
        String txtOutput = 
           "<html>Sales Figures<br>__________________________<br>";
        for (int x = 0; x < sales.length; x++)
        {
            txtOutput += "Sales Person " + (x + 1) + ": $" + sales[x] + "<br>";
        }

        txtOutput += "<br>The lowest sales belongs to sales person " + 
            (app.getMin() + 1) + " with $" + decimalFormat.format(sales[app.getMin()]) + "<br>";
        txtOutput += "The highest sales belongs to sales person " + 
            (app.getMax() + 1) + " with $" + decimalFormat.format(sales[app.getMax()]) + "<br>";
        txtOutput += "<br>The total sales were: $" + decimalFormat.format(app.getTotalSales()) + "<br>";
        txtOutput += "The average sales was: $" + decimalFormat.format(app.getAverage()) + "<br><br>";
        txtOutput += createSalesBarInfo();
        txtOutput += "</html>";

        jlSalesOutput.setText(txtOutput);
        validate();
        repaint();
    }

    protected void writeMinMax(){  
        app.calculateMinMax();
//        DecimalFormat df1 =  new DecimalFormat("####.##");  
        // Build the output string like an HTML doc 
        String txtOutput = 
           "<html>Min Max<br>__________________________<br>";
        for (int x = 0; x < sales.length; x++)
        {
            txtOutput += "Sales Person " + (x + 1) + ": $" + sales[x] + "<br>";
        }

        txtOutput +="Maximum value is at index " + app.getMaxIndex();
        txtOutput +=" (Sales Person " + (app.getMaxIndex() + 1) + ") with value $" + decimalFormat.format(app.getMax()) + "<br />";
        txtOutput +="Minimum value is at index " + app.getMinIndex();
        txtOutput +=" (Sales Person " + (app.getMinIndex() + 1) + ") with value $" + decimalFormat.format(app.getMin());
        
        txtOutput += "</html>";

        jlSalesOutput.setText(txtOutput);
        validate();
        repaint();
    }


    protected String createSalesBarInfo(){                                               
        String salesBarOutput = "";
        int overSalesBar = 0;
        int [] performance = app.determineTopSalesPeople();
        int [] sales = app.getSales();

        // Loop through the number of sales people
        for (int x = 0; x < sales.length; x++)
        {
        	// If this sales person exceeded the goal
            if (performance[x] ==1) {
                overSalesBar++;
                salesBarOutput += "Sales person " + (x + 1) + 
                    " sold more than the sales goal with sales of $"+ decimalFormat.format(sales[x])+ "<br>" ;
            } // If this sales person met the goal
            else if (performance[x] ==0) {
               salesBarOutput += "Sales person " + (x + 1) + 
                   " exactly reached the sales goal with sales of $"+ decimalFormat.format(sales[x])+ "<br>" ;
            } // If this sales person did not meet the goal
            else {
                salesBarOutput += "Sales person " + (x + 1) + 
                    " did not reach the sales goal with sales of $"+ decimalFormat.format(sales[x])+ "<br>" ;
            }
        }
        if (overSalesBar ==1)
            salesBarOutput += "Only " + overSalesBar + 
                " sales person sold more than the sales goal of " + decimalFormat.format(app.getBar()) + "<br><br>";
        else
            salesBarOutput += overSalesBar + 
                " sales people sold more than the sales goal of " + decimalFormat.format(app.getBar()) + "<br><br>";
        return salesBarOutput;     
    } 

}