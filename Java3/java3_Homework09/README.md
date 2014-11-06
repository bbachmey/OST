Create a new project named java3_Homework09 in your Java3_Homework working set. Copy everything from java3_Homework08 into the new project.

In the model of your java3_Homework09 project, add an array of type Shape of size 2 as an instance variable. (in the Model class)
Allow the user to draw two Shapes, which when instantiated, get put into the array.(store the shapes in the createShape() method.
The Applet's paint() will need to get this array from the model and draw both Shapes, of the proper type, size, and location as where they were when first drawn by the user. Your Model class will need to provide a method that returns the array of shapes.
Add a method to your model called compareShapes(), which will return either 0, 1, or 2--1 if the area of the first Shape is bigger than the second, 2 if it is smaller, and 0 if the two Shapes are the same size.
Create an interface named ComparableShape for the shape objects, that will specify that objects that implement the interface can be compared. The interface should require implementing classes to have a method getArea() capable of returning the area of the object. Obviously, only closed shapes can do this. How do you get the area of a line? The instanceof operator will be handy here.
Then if two figures have been drawn and the two objects drawn can be compared,
have the objects compared using the model's compareShapes() method.
The applet output should show the two drawings and also specify which one is larger than the other, or if they are the same area.
If two figures have been drawn but the two objects are not comparable, then tell the user something like "Cannot compare Rectangles to Lines."
When a third figure is drawn, reset the array and allow the process to repeat.

When everything works as expected, submit java3_Homework09.