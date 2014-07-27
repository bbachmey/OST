import java.awt.Color;
import java.awt.Graphics;


public class Hat extends Part {
	int xPos;
	int yPos;
	int height;
	int width;
	int startAngle;
	int arcAngle;

	public Hat(Color c, int x, int y, int w, int h, int sa, int aa) {
		//super constructor
		super(c);
		// instance variables
		this.setxPos(x);
		this.setyPos(y);
		this.setHeight(h);
		this.setWidth(w);
		this.setStartAngle(sa);
		this.setArcAngle(aa);
		
	}

	@Override
	public void draw(Graphics g) {
		//draw the arc
		g.fillArc(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight(), this.getStartAngle(), this.getArcAngle());
		//test the shape of the rectangle within which the arc is drawn
		//g.drawRect(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());
		
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
