package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	private Color fillColor;
	private int width;
	private int height;
	private boolean fill;
	private Point A;
	private Point B;
	private Point C;

	public Triangle(Color lineColor, int x, int y) {
		super(lineColor, x, y);
		A = new Point(lineColor, 0, 0);
		B = new Point(lineColor, 0, 0);
		C = new Point(lineColor, 0, 0);
	}

	@Override
	public void draw(Graphics g) {

		Line ab = new Line(fillColor, 0, 0, 0, 0);
		Line bc = new Line(fillColor, 0, 0, 0, 0);
		Line ca = new Line(fillColor, 0, 0, 0, 0);

		A.setX(super.getX());
		A.setY(super.getY());

		B.setX(super.getX() + width);
		B.setY(super.getY());

		C.setX(B.getX() - (width / 2));
		C.setY(A.getY() - height);

		ab.setX(A.getX());
		ab.setX2(B.getX());
		ab.setY(A.getY());
		ab.setY2(B.getY());

		bc.setX(B.getX());
		bc.setX2(C.getX());
		bc.setY(B.getY());
		bc.setY2(C.getY());

		ca.setX(C.getX());
		ca.setX2(A.getX());
		ca.setY(C.getY());
		ca.setY2(A.getY());

		ab.draw(g);
		bc.draw(g);
		ca.draw(g);

	}

	// Override abstract method containsLocation in the Shape class.
	@Override
	public boolean containsLocation(int x, int y) {
		if (getX() <= x && getY() <= y && getX() + getWidth() >= x
				&& getY() + getHeight() >= y) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a String representing this object. Overrides toString() in
	 * java.lang.Object
	 */
	@Override
	public String toString() {
		return "Triangle: " + "\n\tA = ( " + A.getX() + "," + A.getY() + " )"
				+ "\n\tB = ( " + B.getX() + "," + B.getY() + " )"
				+ "\n\tC = ( " + C.getX() + "," + C.getY() + " )";
	}

	// getters and setters
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

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public Point getC() {
		return C;
	}

	public void setC(Point c) {
		C = c;
	}

}
