import java.awt.Color;
import java.awt.Graphics;


/**
 * @author bbachmey
 * @description Chin extends Part
 * 
 * 
 *
 */
public class Chin extends Part {
	//subclass attributes
	private int startAngle;
	private int arcAngle;
	private int xPos;
	private int yPos;
	private int height;
	private int width;
	
	/**
	 *  The chin is an arc.  
	 * 
	 *  The center of the arc is the center of the rectangle whose origin is (x, y) and whose size is specified by the width and height arguments.
	 *  
	 *  Angles are interpreted such that 0 degrees is at the 3 o'clock position. 
	 *  A positive value indicates a counter-clockwise rotation while a negative value indicates a clockwise rotation.
	 *  
	 *  @see http://docs.oracle.com/javase/1.5.0/docs/api/java/awt/Graphics.html#drawArc(int, int, int, int, int, int)
	 *  
	 * @param c: color
	 * @param x: x-position
	 * @param y: y-position
	 * @param w: width
	 * @param h: height
	 * @param sa: start angle
	 * @param aa: arc angle
	 */
	public Chin(Color c, int x, int y, int w, int h, int sa, int aa){
		//call the constructor of the super class: Part
		//all Parts have Color, xPos, yPos, height, and width
		super(c);
		//set the additional attributes of the subclass
		this.setxPos(x);
		this.setyPos(y);
		this.setHeight(h);
		this.setWidth(w);
		this.setArcAngle(aa);
		this.setStartAngle(sa);
		
	}

	// override abstract method
	@Override
	public void draw(Graphics g) {
		//draw the arc
		g.drawArc(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight(), this.getStartAngle(), this.getArcAngle());
		//test the shape of the rectangle within which the arc is drawn
		//g.drawRect(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
		
		
	}
	
	//getters and setters
	public int getStartAngle() {
		return startAngle;
	}


	public void setStartAngle(int startAngle) {
		this.startAngle = startAngle;
	}


	public int getArcAngle() {
		return arcAngle;
	}


	public void setArcAngle(int arcAngle) {
		this.arcAngle = arcAngle;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

}
