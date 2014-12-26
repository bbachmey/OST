Create a new project named java3_Homework11 in your Java3_Homework working set, and copy your latest GUIDemo applet and all associated files into java3_Homework11. 

We want to be able to click on an instance drawn and determine which object it is so that we can move it, resize it, or delete it. We have seen how to use the mouse to identify x and y locations, but we still need to determine which of our drawn objects might have surface area surrounding the point where we have clicked.

In your model, write a method that returns an instance of a Shape, given a set of x and y coordinates. You will need to search your Vector or Array list. If no object contains those coordinates, return null.

Then, in your mouse handler, implement the actions Move, Resize, Change, and Remove to behave as expected. You can ask the model which object has been clicked by passing the mouse x and y locations to your new method in the model.

Actions when a box is checked:
•Draw: The mouse performs the Draw action.
•Move: When the mouse is clicked, select and move the object under the mouse. If two objects overlap, move the last object drawn under the mouse coordinates.
•Remove: When the mouse is clicked, select and remove the object under the mouse.
•Change: The object clicked takes on the attributes (lineColor, fillColor, filled) currently stored in the model. If two objects overlap, change the last object drawn under the mouse .
•Resize: The next object clicked will be resized. This is very similar to the Draw action.

If no object is clicked, then do nothing.
