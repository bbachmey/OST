import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class Mouth extends Part {
	private int xPos;
	private int yPos;

	public Mouth(Color c, int x, int y) {
		super(c);
		this.setxPos(x);
		this.setyPos(y);
		
	}

	@Override
	public void draw(Graphics g) {
		//set color
		g.setColor(Color.black);
		int x = this.getxPos();
		int y = this.getyPos();
		//define shape
		int [] xValues = (new int [] {x, x+22, x+44}); 
		int [] yValues = (new int [] {y, y+16, y});
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
