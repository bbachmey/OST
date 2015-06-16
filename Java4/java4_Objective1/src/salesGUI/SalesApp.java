package salesGUI;


public class SalesApp {

    //array to hold sales of each salesperson
    private int[] sales;
    //variable for sales goal (to be established by user)
    private int salesBar; 
    //sales of all sales people together
    private int totalSales;
    //why not average = totalSales/sales.length; here?
    private double average; 
    private int minIndex = 0;
    private int maxIndex = 0;
    
//    SalesUserInterface myUserInterface;
//    
//    public void setMyUserInterface(SalesUserInterface myGUI){
//        myUserInterface = myGUI;
//    }
    
    public static void main(String[] args){
    	
    	//System.out.println("asdf");
    	
    	// instantiate the SalesApp class
    	SalesApp me = new SalesApp();
    	
		// declare, create, and populate an array of int of size 4 with values {4,6,7,8}
    	int [] values = new int[4];
    	values[0]=4;
    	values[1]=5;
    	values[2]=6;
    	values[3]=7;
    	
    	// use the methods available in SalesApp to
    	// set the sales array to this array defined in the main
    	me.setSales(values);
    	
    	// find and print the average sale (formatted to two decimal places)
    	double avg = me.getAverage();
    	System.out.println("The average sale is: " + avg);
    	
    	// find and print the minimum sale. 
    	me.calculateMinMax();
    	int min = me.getMinIndex();
    	System.out.println("The minimum sale is: " + me.sales[min]);
    	System.out.println("");
    	
    	// Print both the id of the salesperson with the min sale and the amount of the sale, e.g., "Salesperson 3 had the lowest sale with $4500."
    	System.out.println("Min Sales");
    	System.out.println("Salesperson ID: " + (me.minIndex+1) );
    	System.out.println("Sales amount: " + me.getSales()[me.minIndex] );
    	System.out.println("");
    	
    	// do the same for the max sale.
    	System.out.println("Max Sales");
    	System.out.println("Salesperson ID: " + (me.maxIndex+1) );
    	System.out.println("Sales amount: " + me.getSales()[me.maxIndex] );
    	System.out.println("");
    	
//      System.out.println("Maximum value is at index " + maxIndex
//          + " (Salesperson " + (maxIndex + 1) + ") with value " + maximum);
//      System.out.println("Minimum value is at index " + minIndex
//          + " (Salesperson " + (minIndex + 1) + ") with value " + minimum);
    	
    	// set a goal of 6.
    	me.setSalesBar(6);
		System.out.println("The sales goal is " + me.getSalesBar() );
    	
    	// find all salespeople over the goal--print both their index and the amount sold.
    	for(int i=0; i<me.sales.length; i++){
    		if(me.sales[i] > me.getSalesBar()){
    			System.out.println("Salesperson " + (i+1) + " is over the goal." );
    		}
    	}
    	
    	// since our GUI is not quite complete, you can print these to the Console
    	
    }
    
    public void setSales(int[] sales) {
        this.sales = sales;
        for (int i = 0; i < sales.length; i++)
            // checking to see if it's working
            //System.out.println(sales[i]); 
        // data consistency
        calculateTotalSales(); 
    }

    public void calculateTotalSales() {
        totalSales = 0;
        
        for (int x = 0; x < sales.length; x++){
            totalSales += sales[x];
        }
        
        calculateAverage(); // data consistency
    }
    
    public void calculateAverage() {
        if (sales.length != 0){
            average = (double) (totalSales / sales.length);
        }
        
//        System.out.println("totalSales is " + totalSales + " and sales.length is "
//            + sales.length + " making average "
//            + ((double) totalSales / sales.length));
        
    }
    
    public void setSalesBar(int goal){
        salesBar = goal;
    }

    
    public int[] getSales() {
        return sales;
    }
    
    public double getAverage() {
        if (sales.length != 0)
            // cast so does not truncate int division
            return ((double) totalSales / sales.length); 
        else
            return average;
    }
    
    public int getSalesBar() {
        return salesBar;
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
//        System.out.println("Maximum value is at index " + maxIndex
//            + " (Salesperson " + (maxIndex + 1) + ") with value " + maximum);
//        System.out.println("Minimum value is at index " + minIndex
//            + " (Salesperson " + (minIndex + 1) + ") with value " + minimum);
        calculateAverage();
    }

    
    //method returns performance array to indicate success at reaching goal
    public int[] getTopSalesPeople() {                      
        // System.out prints to console to be sure we got here--debugging tool
        System.out.println("I'm here and salesBar is " + salesBar);
    
        // an array with values of -1, 0, 1 to indicate success at reaching goal
        int[] performance = new int[sales.length]; 

        // Loop through the sales array and see who sold more than the sales bar
        for (int x = 0; x < sales.length; x++)
        {
            if (sales[x] > salesBar) {
                performance[x] = 1;
            }
            else if (sales[x] == salesBar) {
                performance[x] = 0;
            }
            else {
                performance[x] = -1;
            }
        }
        return performance;
    }
}
