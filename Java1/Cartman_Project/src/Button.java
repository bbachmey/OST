import java.awt.Color;
import java.awt.Graphics;


/**
 * @author bbachmey
 *
 */
public class Button extends Part {

	private int xPos;
	private int yPos;
	private int height;
	private int width;

	/**
	 * Head is an oval
	 * @param c
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public Button(Color c, int x, int y, int w, int h) {
		//super constructor 
		super(c);
		//set instance variables
		this.setHeight(h);
		this.setWidth(w);
		this.setxPos(x);
		this.setyPos(y);
		
	}

	/**
	 * @param Graphics g
	 */
	@Override
	public void draw(Graphics g) {
		//draw the oval
		g.fillOval(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());

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
	
}
