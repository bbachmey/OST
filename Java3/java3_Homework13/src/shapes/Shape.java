package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Base class for all shapes in this application
 * @author bbachmey
 * 
 */
public abstract class Shape {
	// All Shapes have x and y positions and a line Color
	protected int x, y;
	private Color lineColor;

	/**
	 * The constructor requires three basic Shape properties
	 * @param x
	 * @param y
	 * @param lineColor
	 * 
	 */
	public Shape(Color lineColor, int x, int y) {
		this.lineColor = lineColor;
		this.x = x;
		this.y = y;
	}

	/**
	 * Abstract method must be implemented by subclasses
	 * @param g
	 */
	public abstract void draw(Graphics g);

	/**
	 * Abstract method must be implemented by subclasses
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract boolean containsLocation(int x, int y);

	// getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
}