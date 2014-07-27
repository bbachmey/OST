import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;


/**
 * @author bbachmey
 *
 */
public class Head extends Part {

	private int xPos;
	private int yPos;
	private int height;
	private int width;
	private Shape clipShape;

	/**
	 * Head is an oval
	 * @param c
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Head(Color c, int x, int y, int w, int h, Shape clip) {
		//super constructor 
		super(c);
		//set instance variables
		this.setHeight(h);
		this.setWidth(w);
		this.setxPos(x);
		this.setyPos(y);
		this.setClipShape(clip);
		
	}

	/* (non-Javadoc)
	 * @see Part#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		//set clip
		//g.setClip(100, 100, 100, 100);
		g.setClip(clipShape);
		//draw the oval
		g.fillOval(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
		//set the clip back to null
		g.setClip(null);

	}

	//getters and setters
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Shape getClipShape() {
		return clipShape;
	}

	public void setClipShape(Shape clip) {
		this.clipShape = clip;
	}
	
}
