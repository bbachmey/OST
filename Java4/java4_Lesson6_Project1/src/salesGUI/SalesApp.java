package salesGUI;

public class SalesApp {

    //array to hold sales of each salesperson
    private int[] sales;
    //variable for sales goal (to be established by user)
    private int salesGoal; 
    //sales of all sales people together
    private int totalSales;
    private double average; 
    private int minIndex = 0;
    private int maxIndex = 0;
    // View
    SalesUserInterface myUserInterface;
    
    /*
     This class has no explicit constructor
     */
    
    /*
     * CALCULATIONS
     */
    
    public void calculateMinMax() {
        int minimum = sales[0];
        int maximum = sales[0];
        // loop through the sales array to see each sales amount
        for (int x = 0; x < sales.length; x++) {
            //Check for max sale
            if (sales[x] > maximum) {
                maximum = sales[x];
                maxIndex = x;
            }
            else if (sales[x] < minimum) //Check for min sale
            {
                minimum = sales[x];
                minIndex = x;
            }
        }
        System.out.println("Maximum value is at index " + maxIndex
            + " (Salesperson " + (maxIndex + 1) + ") with value " + maximum);
        System.out.println("Minimum value is at index " + minIndex
            + " (Salesperson " + (minIndex + 1) + ") with value " + minimum);
        calcAverage();
    }

    
    //method returns performance array to indicate success at reaching goal
    public int[] calculateTopSalesPeople() {                      
        // System.out prints to console to be sure we got here--debugging tool
        System.out.println("I'm here and salesBar is " + salesGoal);
    
        // an array with values of -1, 0, 1 to indicate success at reaching goal
        int[] performance = new int[sales.length]; 

        // Loop through the sales array and see who sold more than the sales bar
        for (int x = 0; x < sales.length; x++)
        {
            if (sales[x] > salesGoal) {
                performance[x] = 1;
            }
            else if (sales[x] == salesGoal) {
                performance[x] = 0;
            }
            else {
                performance[x] = -1;
            }
        }
        return performance;
    }
    
    public void calcTotalSales() {
        totalSales = 0;
        for (int x = 0; x < sales.length; x++)
            totalSales += sales[x];
        calcAverage(); // data consistency
    }
    
    public void calcAverage() {
        if (sales.length != 0)
            average = (double) (totalSales / sales.length);
        System.out.println("totalSales is " + totalSales + " and sales.length is "
            + sales.length + " making average "
            + ((double) totalSales / sales.length));
    }

    
    /*
     * GET and SET
     */
    
    public void setMyUserInterface(SalesUserInterface myGUI){
        myUserInterface = myGUI;
    }
    
    public double getAverage() {
        if (sales.length != 0)
            // cast so does not truncate int division
            return ((double) totalSales / sales.length); 
        else
            return average;
    }
    
    public void setSales(int[] sales) {
        this.sales = sales;
        for (int i = 0; i < sales.length; i++)
            // checking to see if it's working
            System.out.println(sales[i]); 
        // data consistency
        calcTotalSales(); 
    }
    
    public int[] getSales() {
        return sales;
    }
    
    public int getSalesGoal() {
        return salesGoal;
    }
        
    public void setSalesGoal(int goal){
        salesGoal = goal;
    }
    
    public int getTotalSales() {
        return totalSales;
    }
    
    public int getMinIndex() {
        return minIndex;
    }
    
    public int getMaxIndex() {
        return maxIndex;
    }

}
