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
	//Chin has two additional attributes, after extending Part
	private int startAngle;
	private int arcAngle;
	
	/**
	 *   the chin is an arc  
	 *  an arc is drawn with the drawArc method of the Graphics object
	 *  
	 *  drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
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
		super(c, x, y, w, h);
		//set the additional attributes of the subclass
		this.setArcAngle(aa);
		this.setStartAngle(sa);
		
	}

	// override required abstract method
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		//draw the arc
		g.drawArc(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight(), this.getStartAngle(), this.getArcAngle());
		//test the shape of the rectangle within which the arc is drawn
		g.drawRect(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
		
		
	}
	
	//subclass getters and setters
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

}
