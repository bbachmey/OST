package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	private Color fillColor;
	private int width; 
	private int height;
	private boolean fill;
	private Line line1;
	private Line line2;
	private Line line3;

	public Triangle(int x, int y, Color lineColor) {
		super(x, y, lineColor);
		
//		line1 = new Line(x,y,x+30,y+30, lineColor);
//		line2 = new Line(
//				line1.getX1()+line1.getX2(),
//				(int)((line1.getX2()-line1.getX1())/2),
//				line1.getY1()+30, 
//				y, 
//				lineColor);
//		line3 = new Line(10,20,30,40, lineColor);
		
	}

	@Override
	public void draw(Graphics g) {
		line1.draw(g);
		line2.draw(g);
		line3.draw(g);

	}

	// Override abstract method containsLocation in the Shape class.
	@Override
	public boolean containsLocation(int x, int y) {
		if (
				getX() <= x 
				&& getY() <= y 
				&& getX() + getWidth() >= x 
				&& getY() + getHeight() >= y
				){
			return true;
		}
		return false;
	}

	//getters and setters
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

}
