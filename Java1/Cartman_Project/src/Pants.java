import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Pants extends Part {
	private int xPos;
	private int yPos;
	private int [] xPoints;
	private int [] yPoints;

	/**
	 * @param c
	 * @param x
	 * @param y
	 * @param xArr
	 * @param yArr
	 */
	public Pants(Color c, int x, int y, int [] xArr, int [] yArr) {
		//super constructor
		super(c);
		//instance variables
		this.setxPos(x);
		this.setyPos(y);
		this.setxPoints(xArr);
		this.setyPoints(yArr);
	}

	/* (non-Javadoc)
	 * @see Part#draw(java.awt.Graphics)
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
	
	/**
	 * @return int
	 * This is an instance method which returns the width of the pants
	 * based on the known positions of the shape of the pants
	 */
	public int getBottomWidth(){
		int width;
		//xPoints[2] is the bottom right corner of the pants polygon
		//xPoints[3] is the bottom left corner of the pants polygon
		width = xPoints[2]-xPoints[3];
		return width;
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
