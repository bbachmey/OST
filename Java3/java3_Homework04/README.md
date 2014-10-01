Create a new project named java3_Homework04 in your Java3_Homework working set.

Look at the example drawing project for this course. Make the following packages in the java3_Homework04 project:

event
interfaces
model
shapes
ui.appletui.panels
For this assignment, in the shapes package, make classes named Shape, Rectangle, Oval, and Line. The class Shape should be at the top of the class hierarchy and the only class that extends Object. You can have additional classes in the hierarchy (e.g. ImageShape, Polygon, ClosedShape, Triangle, etc.), if you want--be sure to give each the proper superclass and/or subclasses.

Once again, look at the example project shown above, play with it to see the behavior that is expected and write variables and methods to start your design. The methods should have meaningful names to specify actions we can expect, but at this time the methods can be empty (no-ops with just { } for code). Remember that each figure will be drawn on an Applet and each will have to be individually identified. Thus, the objects will have to have locations and have an identifiable "space" to assist identification. Give it some thought, as we will be adjusting this project in the next few lessons and guiding your design.

Consider what methods should be specified by the superclass Shape to "define" what makes something a Shape, and which variables/methods will need to be explicit for each subclass. They should provide an initial valid design. In figuring out what to put where, Ask the question, "Is this common to ALL current and future shapes?" if so, it belongs in the Shape class. If not, then it does not belong there.

Give thought to what constructors will be needed to build the objects of each shape. Also, give some thought to inheritance. (Hint: What differentiates an Oval from a Rectangle in the way Java displays the two?)

When you feel good about your design, submit java3_Homework04.

Note

When considering the contents of the Shape class, take into consideration that classes other than those required here might be added. Shape should be the most generic of these classes. Think about other shapes that could descend from it, like a Triangle, Polygon, etc. Only include things in the Shape class that are common to ALL shapes, not just Rectangle, Oval, and Line.

We will be developing this applet further, step by step, through the rest of the course.