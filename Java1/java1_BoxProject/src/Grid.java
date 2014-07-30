import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author bbachmey
 *
 */
public class Grid extends Applet implements ActionListener {
	//int primitives for Box height and width
	private int boxH;
	private int boxW;
	//int for the number of boxes
	private int numBoxes;
	//Color object for the applet background
	private Color background;
	//Color object for the box background
	private Color boxColor;
	//ArrayList object to hold the boxes
	ArrayList<Box> boxes;	
	
	/** This method is called every time the Applet is started
	 * @see java.applet.Applet#init()
	 */
	public void init(){
		//set the original height and width of the first box
		boxH = 60;
		boxW = 60;
		
		//set the number of boxes
		numBoxes = 16; 
		/** 
		 * 
		 * adjust the value of numBoxes to get a different size grid
		 * 
		 **/

		//resize the window to fit
		//resize((int)((Math.sqrt(numBoxes)*boxW)+(boxW*Math.PI)),(int)((Math.sqrt(numBoxes)*boxH)+(boxH*Math.PI)));
		resize(380,380);
		//set the background color
		this.setBackground(Color.LIGHT_GRAY.darker());
		//initialize the boxes ArrayList
		boxes = new ArrayList<Box>();
				
		//make a button
		//give the button a label by sending a string to the Button constructor
		Button button = new Button("Click Me!");
		//add this class (Grid.java) to the button object as an ActionListener
		//the Grid class is-a-ActionListener because it implements the ActionListener interface
		button.addActionListener(this);
		//add the button to the Applet
		this.add(button);
		
	}
	
	public void paint(Graphics g){
		//call the method to make the boxes
		this.makeBoxes();
		//call the method to paint the boxes
		this.paintBoxes(g);
	}
	

	public void actionPerformed(ActionEvent evt)
	{
		//when the button is clicked, repaint this applet
		this.repaint();
		
	}
	
	private void makeBoxes(){
		//loop rows by the square of numBoxes 
		for(int i=0; i < Math.sqrt(numBoxes); i++ ){
			//set the row position
			int r = (i+1)* boxH;
			//loop columns by the square of numBoxes
			for(int j=0; j < Math.sqrt(numBoxes); j++ ){
				//set the column position
				int c = (j+1)* boxW;
				//create a Box
				Box box = new Box(c, r, boxH, boxW, randomColor());
				//put the box in the ArrayList
				boxes.add(box);									
			}
		}
	}

	private void paintBoxes(Graphics g){
		for (Box b : boxes){
			//pass the Graphics object to the Box object
			//by calling the display method
			//the Box object then calls the fillRect method on the Graphics object
			b.display(g);	
		}
	}
	
	private Color randomColor(){
		//declare Color object
		Color c;
		
		//make a random number
		Random rand = new Random();
		
		// Java 'Color' class takes 3 floats, from 0 to 1.
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		
		//instantiate Color object
		c = new Color(r, g, b);
		
		//return Color object
		return c;
	}
	
	//getters and setters
	public int getBoxH() {
		return boxH;
	}

	public void setBoxH(int boxH) {
		this.boxH = boxH;
	}

	public int getBoxW() {
		return boxW;
	}

	public void setBoxW(int boxW) {
		this.boxW = boxW;
	}

	public int getNumBoxes() {
		return numBoxes;
	}

	public void setNumBoxes(int numBoxes) {
		this.numBoxes = numBoxes;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public Color getBoxColor() {
		return boxColor;
	}

	public void setBoxColor(Color boxColor) {
		this.boxColor = boxColor;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}

	
	
	

}
