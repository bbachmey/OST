import java.util.Scanner;
                
public class SalesReport {
    int salespeople;
    int sum;
    int sales[];

    public SalesReport(){
        this.salespeople = 3;
        this.sales = new int[salespeople];
    }
  
    public void testMe(){
        getSalesInput();
        provideSalesOutput();
    }
                
    public void getSalesInput(){
        Scanner scan = new Scanner(System.in);
               
        for (int i=0; i<sales.length; i++){
            System.out.print("Enter sales for salesperson " + i + ": ");
            sales[i] = scan.nextInt();
        }
    }
                
    public void provideSalesOutput(){
        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i<sales.length; i++){
            System.out.println("     " + i + "         " + sales[i]);
            sum = sum + sales[i];
        }
        System.out.println("\nTotal sales: " + sum);
    }
} 