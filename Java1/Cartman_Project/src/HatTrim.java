import java.awt.Color;
import java.awt.Graphics;


public class HatTrim extends Part {
	//subclass attributes
	private int startAngle;
	private int arcAngle;
	private int xPos;
	private int yPos;
	private int height;
	private int width;

public HatTrim(Color c, int x, int y, int w, int h, int sa, int aa){
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

	@Override
	public void draw(Graphics g) {
		//draw the arc
		g.drawArc(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight(), this.getStartAngle(), this.getArcAngle());
		//test the shape of the rectangle within which the arc is drawn
		//g.drawRect(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
	}

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
