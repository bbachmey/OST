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
	private TickableBox boxes[][];
	private Button resetButton;
	private char turn;
	private String winner;
	private int turnCounter;

	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	@Override
	public void init() {
		//x goes first
		turn = 'x';
		//declare an array of TickableBoxes
		boxes = new TickableBox[ROWS][COLS];
		//declare a button
		resetButton = new Button("New Game");
		//add an action listener to the button
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				winner = null;
				turnCounter=0;
				//removeMouseListeners();
				buildBoxes();
				repaint();
			}
		});
		//add the button to the applet
		add(resetButton);
		//
		buildBoxes();
		//resize the window
		this.resize(BOX_WIDTH*4, BOX_HEIGHT*5);
	}

	/**
	 * 
	 */
	private void buildBoxes() {
		//paint hasn't been called yet
		//loop through the declared array of boxes and create a box in each position
		for(int row = 0; row < boxes.length; row++) {
			for(int col = 0; col < boxes[row].length; col++) {
				//create a new TickableBox and add it to the array of boxes
				boxes[row][col] = 
						new TickableBox(
								START_X + col * BOX_WIDTH, //x
								START_Y + row * BOX_HEIGHT, //y
								BOX_WIDTH,	//width
								BOX_HEIGHT,	//height
								Color.BLACK, //borderColor
								Color.WHITE, //backColor
								true, //drawBorder
								this //container
								);
				//add the TickableBox as a MouseListener to the applet
				this.addMouseListener(boxes[row][col]);
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		//loop through the array of all TickableBoxes and draw them
		for (int row = 0; row < boxes.length; row++) {
			for (int col = 0; col < boxes[row].length; col++) {
				if (boxes[row][col].isClicked()){
					this.doGameLogic(boxes[row][col]);
				}
				//the draw() method of TickableBox overrides the draw() method inherited from ClickableBox
				boxes[row][col].draw(g);
			}
		}

		//remove the outer border of the set of boxes
		g.setColor(Color.WHITE);
		g.drawRect(
				START_X, 
				START_Y, 
				ROWS * BOX_WIDTH, 
				COLS * BOX_HEIGHT
				);
		if (winner != null){
			g.setColor(Color.BLACK);
			g.drawString(
					winner, 
					START_X-8,
					(COLS * BOX_HEIGHT)+ (START_Y*2)+5
					);
		}
		else {
			g.setColor(Color.BLACK);
			g.drawString(
					" go: " + turn, 
					START_X-5,
					(COLS * BOX_HEIGHT)+ (START_Y*2)+5
					);
		}
	}

	/**
	 * @param box
	 * 
	 */
	public void doGameLogic(TickableBox box){
		//see if there is already a winner
		if (winner == null){
			//see if the box already has a mark
			//don't count the turn if the box has a mark
			if (box.getBoxMark()[0]==0){
				//set the box mark, according to whose turn it is
				box.changeBoxMark(turn);	
				//increment the turn counter
				turnCounter++;
				//switch turns
				if (turn=='x'){
					turn='o';
				}
				else{
					turn='x';
				}
			}

			//unset the clicked boolean
			box.setClicked(false);		

			//decide if we have a winner
			//no point in checking for a winner before turn 5
			if (turnCounter > 4){
				int [] checksum;
				checksum = new int[8];
				//row 1
				checksum[0] = (int)boxes[0][0].getBoxMark()[0] + (int)boxes[0][1].getBoxMark()[0] + (int)boxes[0][2].getBoxMark()[0];
				//row 2
				checksum[1] = (int)boxes[1][0].getBoxMark()[0] + (int)boxes[1][1].getBoxMark()[0] + (int)boxes[1][2].getBoxMark()[0];
				//row 3
				checksum[2] = (int)boxes[2][0].getBoxMark()[0] + (int)boxes[2][1].getBoxMark()[0] + (int)boxes[2][2].getBoxMark()[0];
				//col 1
				checksum[3] = (int)boxes[0][0].getBoxMark()[0] + (int)boxes[1][0].getBoxMark()[0] + (int)boxes[2][0].getBoxMark()[0];
				//col 2
				checksum[4] = (int)boxes[0][1].getBoxMark()[0] + (int)boxes[1][1].getBoxMark()[0] + (int)boxes[2][1].getBoxMark()[0];
				//col 3
				checksum[5] = (int)boxes[0][2].getBoxMark()[0] + (int)boxes[1][2].getBoxMark()[0] + (int)boxes[2][2].getBoxMark()[0];
				//diagonal down
				checksum[6] = (int)boxes[0][0].getBoxMark()[0] + (int)boxes[1][1].getBoxMark()[0] + (int)boxes[2][2].getBoxMark()[0];
				//diagonal up
				checksum[7] = (int)boxes[2][0].getBoxMark()[0] + (int)boxes[1][1].getBoxMark()[0] + (int)boxes[0][2].getBoxMark()[0];
				//333 o wins
				//360 x wins
				for (int i=0;i<8;i++){
					if (checksum[i]==333){
						winner = "o wins!";
						break;
					}
					if (checksum[i]==360){
						winner = "x wins!";
						break;
					}
				}

				//if we don't have a winner after 9 turns, it's a draw
				if (turnCounter == 9){
					if (winner == null){
						winner = "draw";
					}
				}
			}
		}
	} //end doGameLogic
}
