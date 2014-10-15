Using your latest version of the Shape drawing applet we've been working on, create a new project named Java3_Homework07 and place it in your Java3_Homework working set. Copy the src folder from your Java3_Lesson07 project into this new project. Make sure the changes incorporated from your Java2_Homework06 project are included.

Give your Model.createShape() the ability to make whatever shape the Model.currentShapeType variable (created in the last project) indicates.

Add mouse and mouse motion listeners (either by implementing listeners or by using adapters), as in Lesson 7.

Make the applet functional in that if the user selects a Shape and then selects Draw, then the user can draw that Shape on the applet.

Update all of the toString() methods so that the reflect any state changes in the class they are in.

At this time, you do not have to save multiple figures. Once a user draws one shape on the Applet, the Applet should show it and you should output to the console that a figure of that type was drawn. Then the next time something is chosen to be drawn, the Applet can have only that one drawing and in the console give its identification.

Finally, the implementation of how a given type should be "drawn" should be in that type's class. It can be invoked from the Applet, but its code should be in the Shape's specific class type.