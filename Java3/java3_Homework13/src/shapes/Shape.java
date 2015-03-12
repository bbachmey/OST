package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author bbachmey
 * 
 */
public abstract class Shape {
	// All Shapes have x and y positions and a line Color
	protected int x, y;
	private Color lineColor;

	/**
	 * @param x
	 * @param y
	 * @param lineColor
	 * 
	 *            The constructor requires all three Shape properties
	 */
	public Shape(Color lineColor, int x, int y) {
		this.lineColor = lineColor;
		this.x = x;
		this.y = y;
	}

	// Abstract methods must be implemented by subclasses
	/**
	 * @param g
	 */
	public abstract void draw(Graphics g);

	/**
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