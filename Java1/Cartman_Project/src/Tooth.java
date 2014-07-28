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
	private int [] xPoints;
	private int [] yPoints;
	
	/**
	 * Tooth is a polygon and x and y points to build a shape
	 * @param c
	 * @param x
	 * @param y
	 */
	public Tooth(Color c, int x, int y, int [] xArr, int [] yArr){
		// super constructor
		super(c);
		// instance variables
		this.setxPos(x);
		this.setyPos(y);
		this.setxPoints(xArr);
		this.setyPoints(yArr);
	}

	/**
	 * @param g
	 */
	@Override
	public void draw(Graphics g) {
		//reposition the x coordinates of the shape by adding xPos
		 for(int i=0; i < xPoints.length; i++)
		  {
			 xPoints[i]=xPoints[i]+xPos;
		  }
		//reposition the y coordinates of the shape by adding yPos
		 for(int i=0; i < yPoints.length; i++)
		  {
			 yPoints[i]=yPoints[i]+yPos;
		  }
		//make a polygon
		Polygon p = new Polygon(xPoints, yPoints, xPoints.length);
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

	public int[] getxPoints() {
		return xPoints;
	}

	public void setxPoints(int[] xPoints) {
		this.xPoints = xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	public void setyPoints(int[] yPoints) {
		this.yPoints = yPoints;
	}


}
