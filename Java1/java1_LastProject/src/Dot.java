import java.awt.Color;
import java.awt.Graphics;


public class Dot extends MathShape {
	private MathPoint center;
	private double diameter;
	private double radius;

	Dot(MathPoint p, double d){
		super(Color.BLACK);
		this.center = p;
		this.diameter = d;
		this.radius = d/2;
	}
	
	Dot(MathPoint p, double d, Color c){
		super(c);
		this.center = p;
		this.diameter = d;
		this.radius = d/2;
	}

	public void draw(Graphics g){
		//jot the current color of the Graphics object
		Color jot = g.getColor();
		//set the color of the Graphics object to the parameter value
		g.setColor(super.color);
		//down cast the double values to int
		int x = (int)(center.getX() - diameter/2); // the x-coordinate of the upper-left corner of the rectangle which encloses the oval is half the diameter of the oval less than the x-coordinate of the center of the oval  
		int y = (int)(center.getY() - diameter/2); // the y-coordinate of the upper-left corner of the rectangle which encloses the oval is half the diameter of the oval less than the y-coordinate of the center of the oval
		int w = (int)(diameter);
		int h = (int)(diameter);
		//
		g.fillOval(x, y, w, h);
		//reset the color of the Graphics object
		g.setColor(jot);
	}

	public MathPoint getCenter() {
		return center;
	}

	public void setCenter(MathPoint center) {
		this.center = center;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}
