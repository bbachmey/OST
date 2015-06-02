Make a new Eclipse project for this objective named java4_Objective1. Put a copy of our current SalesApp class in this new project. So that it has no errors, comment out the lines about the SalesInterface:
// SalesInterface myInterface; 
// public void setInterface(SalesInterface myGUI){
 //  myInterface = myGUI;
 // }
Save this--there should be no errors now in this current version.
Edit the file by adding a main() method so that you can test it. In the main() method you will need to

instantiate the SalesApp class:
declare, create, and populate an array of int of size 4 with values {4,6,7,8}
use the methods available in SalesApp to
set the sales array to this array defined in the main
find and print the average sale (formatted to two decimal places)
find and print the minimum sale. Print both the id of the salesperson with the min sale and the amount of the sale, e.g., "Salesperson 3 had the lowest sale with $4500."
do the same for the max sale.
set a goal of 6.
find all salespeople over the goal--print both their index and the amount sold.
since our GUI is not quite complete, you can print these to the Console
You should be able to do all of these through the main() method without adding any new methods. However, if you have good reason to add a method and explain why it is necessary, it might be acceptable. Submit the edited running class in your java4_Objective1 project.