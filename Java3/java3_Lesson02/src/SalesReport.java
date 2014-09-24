import java.util.Scanner;
                
public class SalesReport {
    int salespeople;
    int sum;
    double avg;
    int sales[];
    Scanner scan = new Scanner(System.in);

    public SalesReport(){
        System.out.print("Enter the number of salespersons: ");
        this.salespeople = scan.nextInt(); //REMOVE the 3!!!
        this.sales = new int[salespeople];
    }
  
    public SalesReport(int howMany) {
		// TODO Auto-generated constructor stub
    	this.salespeople = howMany;
    	this.sales = new int[salespeople];
	}

	public void testMe(){
        getSalesInput();
        provideSalesOutput();
        findMax();
    }
                
    private void findMax() {
    	int max = sales[0];
    	int who = 0;
    	for (int i=0; i < sales.length; i++)
    	{
    		if (max < sales[i]){
    			max=sales[i];
    			who = i;
    		}
    	}
    	System.out.println("\nSalesperson " + (who+1) + " had the highest sales with $" + max);
		
	}

	public void getSalesInput(){
//        Scanner scan = new Scanner(System.in);
               
        for (int i=0; i<sales.length; i++){
            System.out.print("Enter sales for salesperson " + (i+1) + ": ");
            sales[i] = scan.nextInt();
        }
    }
                
    public void provideSalesOutput(){
        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i<sales.length; i++){
            System.out.println("     " + (i+1) + "         " + sales[i]);
            sum = sum + sales[i];
        }
        System.out.println("\nTotal sales: " + sum);
        //Homework 01
        System.out.println("\nAverage sales: " + computeAverage(sum,salespeople));
    }
    
    public int computeAverage(int s, int p){
    	avg = s/p;
    	
		return (int)avg;
    }
} 