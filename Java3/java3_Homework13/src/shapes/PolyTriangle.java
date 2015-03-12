package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * PolyTriangle extends Shape with additional shape properties
 * @author bbachmey
 *
 */
public class PolyTriangle extends Shape {
	private Color fillColor;
	private int width;
	private int height;
	private boolean fill;
	private Point A;
	private Point B;
	private Point C;
	private int sides = 3;
	private Polygon p;

	/**
	 * Constructor
	 * @param lineColor
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param fillColor
	 * @param fill
	 */
	public PolyTriangle(Color lineColor, int x, int y, int w, int h,
			Color fillColor, boolean fill) {

		// Super constructor
		super(lineColor, x, y);

		A = new Point(lineColor, x, y);
		B = new Point(lineColor, x, y);
		C = new Point(lineColor, x, y);

		this.width = w;
		this.height = h;

		this.fillColor = fillColor;
		this.fill = fill;

	}

	/* (non-Javadoc)
	 * @see shapes.Shape#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {

		// Be nice. Save the state of the object before changing it.
		Color oldColor = g.getColor();

		int[] polyx = new int[3];
		int[] polyy = new int[3];

		A.setX(super.getX());
		A.setY(super.getY());

		B.setX(super.getX() + width);
		B.setY(super.getY());

		C.setX(B.getX() - (width / 2));
		C.setY(A.getY() - height);

		polyx[0] = A.getX();
		polyx[1] = B.getX();
		polyx[2] = C.getX();

		polyy[0] = A.getY();
		polyy[1] = B.getY();
		polyy[2] = C.getY();

		p = new Polygon(polyx, polyy, sides);

		if (isFill()) { // TODO: Add Fill property to PolyTri
			g.setColor(getFillColor());
			g.fillPolygon(p);
		}
		g.setColor(getLineColor());

		g.drawPolygon(p);
		// Set the state back when done.
		g.setColor(oldColor);

	}

	// Override abstract method containsLocation in the Shape class.
	/* (non-Javadoc)
	 * @see shapes.Shape#containsLocation(int, int)
	 */
	@Override
	public boolean containsLocation(int x, int y) {
		if (p.contains(x, y)) {
			return true;
		}
		return false;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PolyTri: " + "\n\tA = ( " + A.getX() + "," + A.getY() + " )"
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
