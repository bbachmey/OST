import java.awt.Color;
import java.awt.Graphics;


public class XLine extends MathShape {
	MathPoint center;
	int length;
	
	XLine(MathPoint cen, int len){
		super(Color.BLACK);
		this.center = cen;
		this.length = len;
	}
	
	public void draw(Graphics g){
		Color jot = g.getColor();
		g.setColor(Color.GREEN);
		g.drawLine(
				(int)center.getX()-(length/2), 
				(int)center.getY(), 
				(int)center.getX()+(length/2), 
				(int)center.getY()
				);
		g.setColor(jot);
	}

	public MathPoint getCenter() {
		return center;
	}

	public void setCenter(MathPoint center) {
		this.center = center;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
