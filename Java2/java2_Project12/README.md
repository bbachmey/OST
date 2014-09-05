Here are your instructions:
In this project, you will create a guessing game. To get started, create a new project named java2_Project12 in your Java2_Homework working set.

Copy all of the files in the src directory of your java2_Lesson12 project into your new project. We are going to build on that lesson's example.

In this project, you will create a guessing game. The concept of this game is simple. The user will select a square on the applet grid. The square will reveal its color. The user selects another square on the gird and that square will reveal its color. If the two squares are the same color, they will remain visible. If they are not the same color, on the next mouse click, they will mask their color again and the next square will reveal its color. The game continues until all squares have been revealed and remain visible.

The pseudo code below assumes the user will be perfect in their play. For instance it assumes they will not select the same square twice in a row, etc (i.e. chosenBoxes[0] and [1] are assumed to be different objects). Can you make it so it will catch those errors? That is not required for this lab but would be a good exercise for you.

Modify the MaskableBox class' constructor to take a mask boolean so that you can set the box's mask variable to true when the box is created. This game will begin with all of the boxes masked.
Note in the MaskableBox class' draw() method that the super.draw(g) method is called first. Make it so that it is only called if the MaskableBox class' mask variable is false.
Right-click on the TwoDArrayApplet in your java2_Project12 project. Select Refactor|Rename, and change the name of the file to GuessingGame.
Open the GuessingGame class. Refactoring the class should have changed its name in the code.
Add the following instance variables to the class.
 //this is used to keep track of boxes that have been matched.
 private boolean matchedBoxes[][];
 //this is used to keep track of two boxes that have been clicked.
 private MaskableBox chosenBoxes[];
Modify the paint() method to be the following:
 public void paint(Graphics g) {
 // loop through the boxes rows
 for (int row = 0; row < boxes.length; row++) {
  // loop through each rows columns.
  for (int col = 0; col < boxes[row].length; col++) {
  // if we are at a clicked box.
  if (boxes[row][col].isClicked()) {
   // un click it
   boxes[row][col].setClicked(false);
   //only do game logic on boxes that haven't been matched.
   if (!matchedBoxes[row][col]) {
   gameLogic(boxes[row][col]);
   }
  }
  }
 }
 //loop through the boxes and draw them.
 for (int row = 0; row < boxes.length; row++) {
  for (int col = 0; col < boxes[row].length; col++) {
  boxes[row][col].draw(g);
  }
 }
 }
Add the following line to the beginning of the buildBoxes() method:
 // need to clear any chosen boxes when building new array.
 chosenBoxes = new MaskableBox[2];
 // create a new matchedBoxes array
 matchedBoxes = new boolean [ROWS][COLS];
When building the array of boxes, set each box's masked value to true so that the boxes will be blacked out on initial display.
Create a new method with the following signature:
 public void gameLogic(MaskableBox box)
The gameLogic() method is your project. We will give you the basic logic of the game and you need to take that and convert it into Java code.
Game Logic:

If both chosenBoxes array at index 0 and 1 are not null 
 //we need to check to see if their colors match.
 if the background color of both chosenBoxes are equal to each other
  //we need to set each of their corresponding matchedBoxes elements
  //to true so game logic won't be called if those boxes are clicked
  //again.
  for each of the chosenBoxes at index i
   for each of the boxes array at index row
    for for each of the boxes[row] array at index col
     if the boxes array at the intersection of indexes
       row and col is equal to the 
       chosenBoxes array at index i
      Set the matchedBoxes array at row and col equal to true
      break out of the inner loop.// break; is the Java statement.
     end_if
    end_for
   end_for
  end_for
 end_if
 else 
  //the background colors do not match
  set both chosenBoxes mask value to true.
 end_else
 //we need to reset the chosenBoxes array elements to null.
 Set the chosenBoxes array to equal a new array of size 2.
end_if

if the first index chosenBoxes is null
 //we have no boxes already chosen.
 set the first chosenBoxes equal to the parameter of the method.
 set its mask value to false and return out of the method.
end_if
else 
 if the second index chosenBoxes is null
  //we have one box already chosen.
  set the second chosenBoxes equal to the parameter of the method.
  set its mask value to false

 end_if
end_else
Debug, run, etc., as needed.

Submit your java2_Project12 when done.