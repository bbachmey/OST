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
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	public Part(Color c, int x, int y, int w, int h){
		//this is the class constructor
		this.setColor(c);
		this.setHeight(h);
		this.setWidth(w);
		this.setxPos(x);
		this.setyPos(y);
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

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}


