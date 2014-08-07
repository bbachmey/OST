import java.awt.Color;
import java.awt.Graphics;


public class MathLine extends MathShape {
	MathPoint pointA;
	MathPoint pointB;
	MathPoint center;
	double length;
	int thickness;

	MathLine(MathPoint pA, MathPoint pB){
		super(Color.BLACK);
		this.pointA = pA;
		this.pointB = pB;
		this.color = null;
		this.calculateCenter();
		this.calculateLength();
	}

	MathLine(MathPoint pA, MathPoint pB, Color col){
		super(Color.BLACK);
		this.pointA = pA;
		this.pointB = pB;
		this.color = col;
		this.calculateCenter();
		this.calculateLength();
	}

	private void calculateCenter(){
		this.center = new MathPoint(
				//absolute value of half of the product of x-coordinate of point A minus the x-coordinate of point B;
				(int)Math.abs( ((pointA.getX()-pointB.getX())/2) ), 
				//absolute value of half of the product of the y-coordinate of point A minus the y-coordinate of point B;
				(int)Math.abs( ((pointA.getY()-pointB.getY())/2) ) 
				);
	}

	private void calculateLength(){
		//use the distance formula
		//a squared plus b squared equals c squared
		
		int a = Math.abs((int)(pointA.getX()-pointB.getX())); //absolute value of the x-coordinate of point A minus the x-coordinate of point B;
		int b = Math.abs((int)(pointA.getY()-pointB.getY())); //absolute value of the x-coordinate of point A minus the x-coordinate of point B;
		double c = Math.sqrt( (a*a) + (b*b) );
		this.length = c; 
	}
	
	public void draw(Graphics g){
		Color jot = g.getColor();
		if (this.color != null){
			g.setColor(this.color);			
		}

		g.drawLine(
				(int)pointA.getX(), 
				(int)pointA.getY(), 
				(int)pointB.getX(), 
				(int)pointB.getY()
				);
		
		g.setColor(jot);
		
	}

	public MathPoint getPointA() {
		return pointA;
	}

	public void setPointA(MathPoint pointA) {
		this.pointA = pointA;
	}

	public MathPoint getPointB() {
		return pointB;
	}

	public void setPointB(MathPoint pointB) {
		this.pointB = pointB;
	}

	public MathPoint getCenter() {
		return center;
	}

	public void setCenter(MathPoint center) {
		this.center = center;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
}
