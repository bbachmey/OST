import java.applet.Applet;
import java.awt.*;


/**
 * @author bbachmey
 * @instructions
 * Make a new project: java1_Project10.
 * In it, write an Applet class named Construction.java. 
 * It should build 3 houses (rectangles with triangle roofs on top) 
 * but its paint method should be only 3 calls to a method named drawHouse. 
 * In Construction.java, you should (at least) define methods named: 
 * 		paint (which invokes drawHouse), 
 * 		drawHouse (which invokes drawTriangle and probably methods from the Graphics class), 
 * 		and drawTriangle. 
 */
public class Construction extends Applet {
	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		this.drawHouse(g, 10, 100, 30, 15);
		this.drawHouse(g, 50, 100, 40, 30);
		this.drawHouse(g, 100, 100, 50, 50);
	}
	/**
	 * @param g
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	private void drawHouse(Graphics g, int x, int y, int w, int h){
		this.drawTriangle(g, x, y, w, h);
	    this.drawSquare(g, x, y, w, h);		
	}
	/**
	 * @param g
	 * @param bottomX
	 * @param bottomY
	 * @param base
	 * @param height
	 */
	private void drawTriangle(Graphics g, int xPos, int yPos, int width, int height){
		//baseline: left corner to right corner
		g.drawLine(
				xPos, //start x 
				yPos, //start y
				xPos+width, //end x 
				yPos); //end y
		//slope up: right corner to peak
		g.drawLine(
				xPos+width, 
				yPos, 
				xPos+width/2, 
				yPos-height
				);
		//slope down: peak to left corner
		g.drawLine(
				xPos+width/2, 
				yPos-height, 
				xPos, 
				yPos
				);
	}
	/**
	 * @param g
	 * @param xPos
	 * @param yPos
	 * @param width
	 * @param height
	 */
	private void drawSquare(Graphics g, int xPos, int yPos, int width, int height){
		g.drawRect(
				xPos, 
				yPos, 
				width, 
				height
				);
	}
	
}
