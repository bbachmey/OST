import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author bbachmey
 * Simple if-statement applet
 * compares color objects
 * 
 */
public class IfStatement extends Applet {
	
	//Declare the colors
	private Color instructorColor; 
	private Color myColor;
	//set the position of the first line
	int x=35;
	int y=25;
	//set the line multiplier
	int ln=15;
	 
	public void init(){
		//set the colors
		setInstructorColor(Color.BLUE);
		setMyColor(Color.RED);
		//set the size of the applet window
		setSize(647/2, 400/2);		
	}

	public void paint(Graphics g) {
		//call the drawRect method on the Graphics object
		// to draw a rectangle on the screen
		g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
		
		//State the color values
		g.drawString("The .toString value of my color is:", x, y+ln*1 );
		g.drawString(myColor.toString(), x, y+ln*2);
		g.drawString("The .toString value of instructor color is:", x, y+ln*4 );
		g.drawString(instructorColor.toString(), x, y+ln*5);
		
		//test whether the two Color objects are the same
		if (instructorColor == myColor)
		{	
			//call the drawString method on the Graphics object
			g.drawString("Favorite colors match", x, y+ln*7);
			
		}
		else{
			//call the drawString method on the Graphics object
			g.drawString("Favorite colors do not match", x, y+ln*7);
		}
	}
		
	//getters and setters
	public Color getInstructorColor() {
		return instructorColor;
	}
	public void setInstructorColor(Color instructorColor) {
		this.instructorColor = instructorColor;
	}
	public Color getMyColor() {
		return myColor;
	}
	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}	 
	 
}
