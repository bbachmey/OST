import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends Applet {
	private final int START_X = 20;
	private final int START_Y = 40;
	private final int ROWS = 3;
	private final int COLS = 3; 
	private final int BOX_WIDTH = 50;
	private final int BOX_HEIGHT = 50;
	private MaskableBox boxes[][];
	private Color boxColors[][];
	private Button resetButton;
	//this is used to keep track of boxes that have been matched.
	private boolean matchedBoxes[][];
	//this is used to keep track of two boxes that have been clicked.
	private MaskableBox chosenBoxes[];

	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	@Override
	public void init() {
		boxes = new MaskableBox[ROWS][COLS];
		boxColors = new Color[ROWS][COLS];
		resetButton = new Button("Reset Colors");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomizeColors();
				buildBoxes();
				repaint();
			}
		});
		add(resetButton);
		//separate building colors so we can add a button later
		//to re-randomize them.
		randomizeColors();
		buildBoxes();
	}

	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		//loop through the rows of the 2D array of MaskableBoxes
		// for the purpose of figuring out which box was clicked  
		for (int row = 0; row < boxes.length; row++) {
			// loop through columns of the 2D array of MaskableBoxes
			for (int col = 0; col < boxes[row].length; col++) {
				//each MaskableBox has a clicked property from the parent class ClickableBox
				if (boxes[row][col].isClicked()) {
					// un click it
					boxes[row][col].setClicked(false);
					//check the boolean value in the matchedBoxes array at the 
					//same [row][col] position to see if this 
					//MaskableBox has been matched.
					//Call the doGameLogic() method if the box in this position has not already been matched
					if (!matchedBoxes[row][col]) {
						doGameLogic(boxes[row][col]);
					}
				}
			}
		}
		//loop through the array of all MaskableBoxes and draw them
		for (int row = 0; row < boxes.length; row++) {
			for (int col = 0; col < boxes[row].length; col++) {
				//the draw() method of MaskableBox overrides the draw() method inherited from ClickableBox
				boxes[row][col].draw(g);
			}
		}
	}

	/**
	 * 
	 */
	private void randomizeColors() {
		//make an int array
		int[] chosenColors = {0, 0, 0, 0, 0, 0, 0, 0 };
		//make an array of Color objects
		Color[] availableColors = { 
				Color.red, 
				Color.blue, 
				Color.green,
				Color.yellow, 
				Color.cyan, 
				Color.LIGHT_GRAY, 
				Color.pink, 
				Color.orange 
		};
		//loop through the array of rows of boxes
		//the array of rows is as long as there are ROWS in the declaration MaskableBox[ROWS][COLS]
		for(int row = 0; row < boxes.length; row++) {
			//loop through the array of boxes in each row
			//the array of boxes is as long as there are COLS in the declaration MaskableBox[ROWS][COLS]
			for(int col = 0; col < boxes[row].length; col++) {
				//infinite loop, runs until break;
				for(;;) {
					//get a random number
					int rnd = (int)(Math.random() * 8);
					//look at the int value in the chosenColors array at the position of the random number
					//if the int value in the array at the random position is less than 2
					//then this color has not yet been used twice
					if(chosenColors[rnd] < 2) {
						//increment the int value in the array at the random position  
						chosenColors[rnd]++;
						//grab the Color from the availableColors array at the random position and 
						//assign the color to the boxColors array
						boxColors[row][col] = availableColors[rnd];
						//quit the infinite loop
						break;
					}
				}
			}
		}
	}

	/**
	 * 
	 */
	private void buildBoxes() {
		// need to clear any chosen boxes when building new array.
		chosenBoxes = new MaskableBox[2];
		// create a new matchedBoxes array
		matchedBoxes = new boolean [ROWS][COLS];

		//mouse listeners have to be removed from the applet
		this.removeMouseListeners();

		for(int row = 0; row < boxes.length; row++) {
			for(int col = 0; col < boxes[row].length; col++) {
				//create a new MaskableBox and add it to the array of boxes
				boxes[row][col] = 
						new MaskableBox(START_X + col * BOX_WIDTH,
								START_Y + row * BOX_HEIGHT,
								BOX_WIDTH,
								BOX_HEIGHT,
								Color.gray,
								boxColors[row][col],
								true,
								this);
				//set the MASK to TRUE when the box is first built
				boxes[row][col].setMask(true);
				boxes[row][col].setMaskColor(Color.WHITE);
				//add the MaskableBox as a MouseListener to the applet
				this.addMouseListener(boxes[row][col]);
			}
		}
	}

	/**
	 * 
	 */
	private void removeMouseListeners() {
		for(int row = 0; row < boxes.length; row ++) {
			for(int col = 0; col < boxes[row].length; col++) {
				//this is a method of the Component class
				this.removeMouseListener(boxes[row][col]);
			}
		}
	}

	/**
	 * @param box
	 * 
		pseudocode:

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

	 */
	public void doGameLogic(MaskableBox box){

		if(chosenBoxes[0] == null){
			//we have no boxes already chosen.
			//set the first chosenBoxes element equal to the parameter of the method.
			chosenBoxes[0] = box;
			//set its mask value to false
			chosenBoxes[0].setMask(false);
		}
		else if (chosenBoxes[1] == null) {
			//this is the second box chosen
			//set the second chosenBoxes element equal to the parameter of the method.
			chosenBoxes[1] = box;	
			//set its mask value to false
			chosenBoxes[1].setMask(false);

			//Check to see if the Colors of the MaskableBox objects match
			if ( chosenBoxes[0].getBackColor() == chosenBoxes[1].getBackColor() ){
				//we need to set each of their corresponding matchedBoxes elements
				//to true so game logic won't be called if those boxes are clicked
				//again.
				for (int i=0;i<chosenBoxes.length;i++) {
					for(int j=0;j<boxes.length;j++){
						for (int k=0;k<boxes[j].length;k++){
							if (chosenBoxes[i] == boxes[j][k] ){
								matchedBoxes[j][k] = true;
								boxes[j][k].setMatched(true);
								break;
							}
						}
					}
				}
			}
		}
		else {
			//this is the third box chosen

			//check to see if the previous two were matches
			if (!chosenBoxes[0].isMatched()){
				//set both the chosenBoxes mask value to true
				chosenBoxes[0].setMask(true);
				chosenBoxes[1].setMask(true);
			}

			//Clear the chosen boxes to allow another pair of guesses
			chosenBoxes = new MaskableBox[2];

			//set the first chosenBoxes element equal to the parameter of the method.
			chosenBoxes[0] = box;

			//set the mask on the third box chosen to false
			chosenBoxes[0].setMask(false);

		}
	} //end doGameLogic


}
