+ This is the final project of the course. So, as you can imagine, we aren't going to be holding your hand much. We will, however, give you some helpful suggestions.

+ This project is going to be a Tic-Tac-Toe game. If you haven't played Tic-Tac-Toe, you can find info on it through google. The basic object of the game is a 3x3 grid. Players, alternately, starting with X, will place either an X or an O in a box. The first player to get three X's or O's in a row, horizontally, vertically, or diagonally, wins.

+ In your game, you will need to keep track of two players, the current player, and of course which boxes have X's or O's in them. You can use and extend anything you have created or learned in this course to complete the game.

+ We recommend extending your ClickableBox class to create a TicTacToeBox class. Modify it like you modified the MaskableBox class to do the drawing of X's and O's instead of just masking with a color. You can have each player with a different color drawing. Also, it might be helpful to have a variable in the class to keep track of what character it is to draw. Create an Applet for the game iself. We recommend a gameLogic() method so you can keep game logic separate from the painting process.

+ Remember, your TicTacToeBox class should only know things about itself, other than a Container object that it tells to repaint() when the mouse is clicked on it. No game logic can exist in the TicTacToeBox class. It only knows its own state and its methods to modify that state, a Container to send a repaint() message to, and a method to draw itself on a Graphics object.

+ The minimum requirements of the game are that it be playable, it uses two dimensional arrays, loops, and that it shows who the current player is. Also it will need a "New Game" button that resets everything to it's initial state.

+ We would love it if you put some bells and whistles in it, like showing which player won. This would be a very cool use of loops. Perhaps highlighting the boxes of the winning player? There are 8 winning patterns for each player in tic-tac-toe. If you want to go all out, try to make the game a single player version with your game logic playing the X or O player. Can you make the computer player learn? Remember, there are 8 winning patterns for each player in tic-tac-toe.

Helpful beginning steps:
+ Create a new project named java2_Project14 in your Java2_Homework working set.
+ Copy any classes from other lessons or projects you might think you need, into this new project.
+ Go out on the web and play a few games of tic-tac-toe to visualize the logic you might need.
+ Get out a piece of paper and doodle the game logic. This is called pseudo-code. It will help you think out the problem without trying to code it right away.
+ Once you have a good design on paper or in your head, start coding it
+ Don't be afraid to throw away a bad design.
+ Don't hesitate to use the Ask A Question link.
+ Debug, run, debug, as needed.
+ And, most importantly, HAVE FUN!!!!

Submit your java2_Project14 when you are done.
