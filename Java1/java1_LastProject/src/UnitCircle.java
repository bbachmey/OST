import java.awt.Color;
import java.awt.Graphics;


public class UnitCircle extends MathShape {
	MathPoint centerPoint;
	int radius;

	UnitCircle(MathPoint gcp, int u){
		super(Color.BLACK); //no-constructor color for the unit circle is black 
		this.centerPoint = gcp;
		this.radius = u;
		
	}

	UnitCircle(MathPoint gcp, int u, Color c){
		super(c);
		this.centerPoint = gcp;
		this.radius = u;
		
	}
	
	@Override
	public void draw(Graphics g) {

		g.drawOval(
				//the x-coordinate of the point used to draw the oval for the unit circle
				//  is the same as the x-coordinate of the center point of the graph
				//  minus the spacing unit of the graph
				(int)centerPoint.getX()-radius,
				//
				(int)centerPoint.getX()-radius,
				//the height of the oval is twice the size of the spacing unit
				radius*2,
				//the width of the oval is twice the size of the spacing unit
				radius*2
				);
		
	}

	public void erase(Graphics g) {
		Color jot = g.getColor();
		g.setColor(Color.WHITE);			

		g.fillOval(
				//the x-coordinate of the point used to draw the oval for the unit circle
				//  is the same as the x-coordinate of the center point of the graph
				//  minus the spacing unit of the graph
				(int)centerPoint.getX()-radius,
				//
				(int)centerPoint.getX()-radius,
				//the height of the oval is twice the size of the spacing unit
				radius*2,
				//the width of the oval is twice the size of the spacing unit
				radius*2
				);
		g.setColor(jot);
	}

}
