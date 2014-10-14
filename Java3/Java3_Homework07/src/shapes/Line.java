package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	int x2;
	int y2;

	public Line(int x, int y, Color lineColor) {
		super(x, y, lineColor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
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
