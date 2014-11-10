Create a new project named java3_Homework10 in your Java3_Homework working set. Copy your latest version of the GUIDemo applet and its associated files into the java3_Homework10 project.

So far, we can only draw and remember two Shapes. For java3_Homework10, use Vector or ArrayList to add components drawn to a list for multiple figure storage. Add this Vector (or ArrayList) to the model and allow users to draw as many figures as they want (that is, it should not erase each time but draw everything that the user has thus far drawn). Basically you will need to replace your array of Shapes with this collection and modify any methods that utilized that array. Your Vector or ArrayList should only allow objects of type Shape

Each time something is drawn, it should stay until it is removed (no need to implement the Remove action yet). Since objects are stored in vectors as Objects, you will need to cast them back to Shape to have access to the correct draw methods. So that we can see how they are stored, each time a new figure is added to the list, provide output in the console of all of the elements in the Vector (or ArrayList) at that time. For example:

Element 1 is a rectangle 
Element 2 is a oval 
Element 3 is a rectangle 
Element 4 is a line

instanceof will be handy here.

Remember, the model should be keeping track of everything and the applet should be asking the model for information. Keep logic out of the applet as much as possible.

Note: compareShapes() is only relevant to the previous objective.  Now that multiple figures can be drawn, compareShapes() won't work as previously designed.  You are free to update compareShapes() to compare multiple shapes or comment this method out.

When finished, submit java3_Homework10.