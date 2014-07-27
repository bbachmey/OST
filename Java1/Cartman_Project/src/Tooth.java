import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


/**
 * @author bbachmey
 *
 */
public class Tooth extends Part {
	private int xPos;
	private int yPos;
	
	/**
	 * Tooth is a polygon and x and y points to build a shape
	 * @param c
	 * @param x
	 * @param y
	 */
	public Tooth(Color c, int x, int y){
		// call super constructor
		super(c);
		// set instance variables
		this.setxPos(x);
		this.setyPos(y);
			
	}

	@Override
	public void draw(Graphics g) {
		//make int arrays
		//this is where the shape of the tooth is defined
		//setting the shape values here makes every tooth the same size
		//TODO: make an override constructor for Tooth that accepts different values for the shape of the tooth
		int x = this.getxPos();
		int y = this.getyPos();
		int [] xValues = (new int [] {x, x+5, x+5, x}); 
		int [] yValues = (new int [] {y, y, y+5, y+5});
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);

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


}
