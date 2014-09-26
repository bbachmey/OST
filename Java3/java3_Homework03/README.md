Create a new project named java3_Homework03 in your Java3_Homework working set. Copy your final Lesson 2 classes (saved in Java3_Homework02) into this project (don't use the SalesReport from Lesson 3), but break the SalesReport.java class into separate classes as follows:

One class should do all of the input and output, and another should perform the calculations of average, min, max, who exceeds, etc.
The two classes should be in separate packages so we can test our skill with packages.
Keep the SalesReport as the input/output class and put it in a package named salesIO.
Make another class named SalesComputations and put it in a package named utilities. No input or output statements should be in this class.
The content of the Main class can stay as it is, but put it in the salesIO package.
Submit the java3_Homework03 project when done.

Notes on the SalesComputations class:

No I/O in this class. Each method should return a value and be used by the SalesReport class like this:

System.out.println ("Average Sales: " + salesComputations.computeAverage(sales));
or if the computeAverage method is static:

System.out.println ("Average Sales: " + SalesComputations.computeAverage(sales));
SalesComputations methods should not store data in instance variables (they can, but these are utility methods and should not rely on the order in which methods are called.)

For example, assuming a getTotalSales() method in SalesComputations that returns the total sales for an integer array passed as a parameter:

public static int getTotalSales(int[] sales) { // returns the total sales.}
You could create the following for a computeAverage() method:

public static double computeAverage(int[] sales) {

  int sum = getTotalSales(sales); //store in local variable.

  if(sales.length != 0) { //check for a divide by zero problem.
 
    return (double) sum / sales.length; //force non integer division.
 
  }
 
  return Double.MIN_VALUE; 
 //A flag to show divide by zero. Impossible number to normally get unless
 
 //all elements of the array = Double.MIN_VALUE.

}
Notice how it relies on nothing other than the parameter passed and other methods inside its own class?

These are utility methods and since they neither access nor store instance data, they can be static.