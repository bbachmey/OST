package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	int x2;
	int y2;

	public Line(
			Color lineColor,
			int x1, 
			int y1,
			int x2, 
			int y2
			){
		super(lineColor, x1, y1);
	}
	
	@Override
	public void draw(Graphics g) {


        // Jot down the Color of the Graphics object
        Color jot = g.getColor();
        g.setColor(getLineColor());
        g.drawLine(super.getX(), super.getY(), this.x2, this.y2);

        // Re-jot the Color
        g.setColor(jot);
		
	}

	@Override
	public boolean containsLocation(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}



	
}
