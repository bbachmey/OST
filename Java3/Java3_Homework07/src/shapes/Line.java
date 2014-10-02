package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private int x1, y1, x2, y2;

	public Line(int x1, int y1, int x2, int y2, Color lineColor) {
		//the Shape constructor takes x1 and y1 as x and y
		super(x1, y1, lineColor);

		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;

	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(x1, y1, x2, y2);

	}


	// Override abstract method containsLocation in the Shape class.
	@Override
	public boolean containsLocation(int x, int y) {
		if (
				getX1() <= x 
				&& getX2() >= x
				&& getY1() <= y  
				&& getY2() >= y
				) 
		{
			return true;
		} else {
			return false;
		}
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
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
