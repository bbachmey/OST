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
	 * Tooth is a polygon and has int arrays for x and y points
	 * @param c
	 * @param xVals
	 * @param yVals
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
		int [] xValues = (new int [] {this.getxPos(),this.getxPos()+5, this.getxPos()+5, this.getxPos()}); 
		int [] yValues = (new int [] {this.getxPos(),this.getxPos(), this.getxPos()+5, this.getxPos()+5}) ;
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
