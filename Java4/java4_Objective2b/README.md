
Make a new Eclipse project for this objective named java4_Objective2. Copy all of the classes from our current version in the java4_Lesson1 salesGUI package. We want to keep that version the same for everyone since we will use it again in the next lessons.
In this version in java4_Objective2:

Add a new menu (named Data) to the JMenuBar for SalesInterface.
The menu should have three menu items:
Reset
Retrieve Previous
Return
Reset should allow the user to Reset All Inputs. This should reset the GUI to its original state.
Retrieve is completely new. We want to have our application remember at least the most recent application's information previous to the one currently being viewed. Specifically, what were the values of the salespeople for the application run prior to the current one?
So, if in the middle of a new set of data, the user wants to go back, they can look at the last session. You only need to remember two "cases" at any given time (the current and the most recent past).
The Return menu item will allow the user to go back to the current application information (and hence to be able to toggle back and forth.)
This will take some serious tracing of the current code to see how and why things were done.
Submit the edited running class in your java4_Objective2 project.