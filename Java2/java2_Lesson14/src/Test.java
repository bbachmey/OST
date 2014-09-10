class Test {  
	
public static Test student; 

    public static void main(String[] args){
    	student = new Test();
    	student.check();
    }

    public void check(){
        int s;
        int[] sales = {3400, 2233, 3433, 754, 5664, 42};       // instantiate and populate the array sales             
        int winner = student.highest(sales);                    // call the method highest and pass the array sales;

        s=0;                                                    // while loop to find the highest person
        while (sales[s] ==0)
        	s++;
        	
        System.out.println("The highest sale was salesperson " + (s+1));   // salespeople do not like to be named 0 so add one to indices

        for (s=0; s < sales.length; s++) 
            System.out.println("Salesperson " + (s+1) + " sold "+ sales[s]);
    }

    public int highest(int [] passedSales) {
        int currentHigh = passedSales[0];       // instantiate the high sale to be the first salesperson's sales initially
        int highGuy = 0;                        // instantiate the high person                                        
        for (int s=0; s < passedSales.length; s++)      
            if (passedSales[s] > currentHigh)                // get highest value
                {currentHigh=passedSales[s];                   // remember current high
                passedSales[highGuy] = 0;                     // this one isn't highest anymore, set to 0
                highGuy = s;                                  // new highGuy
            }
            else passedSales[s]=0;                         // only keep value at highest so can retrieve
                           
        return currentHigh;
    }
}