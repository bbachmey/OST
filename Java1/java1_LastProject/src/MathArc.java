import java.awt.Color;
import java.awt.Graphics;


public class MathArc extends MathShape {

	MathPoint center;
	int radius;
	int angle;
	
	public MathArc(MathPoint gcp, int uni, int ang) {
		//no-color constructor color is black
		super(Color.BLACK);
		this.center = gcp;
		this.radius = uni;
		this.angle = ang;
		
		
	}

	public MathArc(MathPoint gcp, int uni, int ang, Color c) {
		super(c);
		this.center = gcp;
		this.radius = uni;
		this.angle = ang;
	}

	@Override
	public void draw(Graphics g) {
		//make a jot of the current color
		Color jot = g.getColor();
		//use the color of this object
		g.setColor(this.color);			

		g.fillArc(
				(int)center.getX()-radius, //x
				(int)center.getY()-radius, //y
				radius*2, //w
				radius*2, //h
				0, //start angle
				angle); //arc angle
		
		
		//reset the color
		g.setColor(jot);

	}

	public MathPoint getCenter() {
		return center;
	}

	public void setCenter(MathPoint center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

}
