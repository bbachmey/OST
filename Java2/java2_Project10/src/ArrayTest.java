import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


/**
 * @author bbachmey 
 * @instructions Create a new java2_Project10 in your Java2_Homework working set.
 * Locate your ArrayTest class in your java2_Project9 project and copy it to your java2_Project10 src folder.
 * Add the following four fields to the ArrayTest class.
 * final int START_X = 10;
 * final int START_Y = 10;
 * final int BOX_WIDTH = 30;
 * final int BOX_HEIGHT = 30;
 * Modify the paint(Graphics g) method to use a for loop to fill the rectangles on the applet.
 * Change the number of rectangles to be filled so that it is an odd number. 
 * Then use the above constants to determine the location and size of the rectangles. 
 * In order to position the rectangles next to each other horizontally you could use: 
 * x = START_X + i * BOX_WIDTH (if i is your looping variable). 
 * Likewise, to position the boxes next to each other vertically you can use: 
 * y = START_Y + i * BOX_HEIGHT.
 * The goal is to position the rectangles diagonally from left to right 
 * so that the upper left corner of a box touches the lower right corner 
 * of the rectangle above and to its left.
 * Extra Credit: See if you can also draw another set of 
 * rectangles in the opposite diagonal direction starting from the upper right to 
 * form a big X of filled rectangles on the screen (try to use a decrementing loop).
 * 
 */
public class ArrayTest extends Applet {
	Color[] colorArray;

	final int START_X = 10;
	final int START_Y = 10;
	final int BOX_WIDTH = 30;
	final int BOX_HEIGHT = 30;
	final double GOLDEN = ((1+Math.sqrt(5))/2);

	public void generateColors(){
		//instantiate the array
		colorArray = new Color[9];
		//fill the array
		colorArray[0]=Color.BLUE;
		colorArray[1]=Color.RED;
		colorArray[2]=Color.GREEN;
		colorArray[3]=Color.ORANGE;
		colorArray[4]=Color.PINK;
		colorArray[5]=Color.CYAN;
		colorArray[6]=Color.MAGENTA;
		colorArray[7]=Color.YELLOW;
		//odd number
		colorArray[8]=Color.GRAY;

	}

	@Override
	public void init(){
		int side = 300;
		//setSize((int)(side*GOLDEN),side);
		setSize(side,side);
		generateColors();

	}

	@Override
	public void paint(Graphics g) {
		//super.paint(g);

		int i=0;
		for (Color c : colorArray){
			int xpos = START_X;
			int ypos = START_Y;
			int width = BOX_WIDTH;
			int height = BOX_HEIGHT;

			g.setColor(c);
			g.fillRect(xpos+(i*width),ypos+(i*height),width,height); 

			i++;
		}

	}


}
