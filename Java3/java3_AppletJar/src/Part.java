import java.awt.Color;
import java.awt.Graphics;


/**
 * @author bbachmey
 * 
 * A Part is an object which composes a Cartman.
 * The actual parts of a Cartman extend this Part.
 * Extending Part allows the individual parts to be stuffed into the same array.
 * That's polymorphism!!!
 *
 */
public abstract class Part {
	//every Part has a color
	private Color color;
	
	/**
	 * @param c
	 */
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


