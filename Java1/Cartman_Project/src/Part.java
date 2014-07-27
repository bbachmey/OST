import java.awt.Color;
import java.awt.Graphics;


/**
 * @author bbachmey
 * 
 * a Part is an object which composes a Cartman
 * the actual parts of a Cartman extend this Part
 * Extending Part allows the individual parts to be stuffed into the same array
 * That's polymorphisim
 *
 */
public abstract class Part {

	private Color color;
	
	public Part(Color c){
		//this is the class constructor
		this.setColor(c);
	}

	/**
	 * @param g
	 * every object which extends Part must have a draw() method which accepts a Graphics object and returns void
	 */
	public abstract void draw(Graphics g);

	//getter and setters
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}


