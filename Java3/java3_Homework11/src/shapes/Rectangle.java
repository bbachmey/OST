package shapes;

import interfaces.ComparableShape;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape implements ComparableShape {
	private Color fillColor;
	private int width; 
	private int height;
	private boolean fill;
	private int area;

	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param lineColor
	 * @param fillColor
	 * @param fill
	 */
	public Rectangle(
			Color lineColor,
			int x, 
			int y, 
			int w, 
			int h,  
			Color fillColor, 
			boolean fill
			){
		super(lineColor, x, y);
		this.width = w;
		this.height = h;
		this.fillColor = fillColor;
		this.fill = fill;
	}

	public void draw(Graphics g) {
		// Be nice. Save the state of the object before changing it.
		Color jot = g.getColor();
		if (isFill()) {
			g.setColor(getFillColor());
			g.fillRect(getX(), getY(), getWidth(), getHeight());
		}
		//draw the outline after drawing the shape
		g.setColor(getLineColor());
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		// Set the state back when done.
		g.setColor(jot);
	}

	// Override abstract method containsLocation in the Shape class.
	@Override
	public boolean containsLocation(int paramX, int paramY) {
		if (
				getX() <= paramX
				&& getY() <= paramY 
				&& getX() + getWidth() >= paramX 
				&& getY() + getHeight() >= paramY
			) {
				return true;
		}
		return false;
	}

	/**
	 * Returns a String representing this object.
	 * Overrides toString() in java.lang.Object
	 */
	@Override
	public String toString() {
		return "Rectangle: \n\tx = " + getX() + "\n\ty = " + getY() + 
				"\n\tw = " + getWidth() + "\n\th = " + getHeight();
	}

	// Getters and setters.
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

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public boolean isFill() {
		return fill;
	}

	@Override
	public int getArea() {
		return area;
		
	}

	@Override
	public void setArea() {
		area = (this.getWidth()) * (this.getHeight());
		
	}

}