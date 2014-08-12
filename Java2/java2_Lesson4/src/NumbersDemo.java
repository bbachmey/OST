import java.applet.Applet;
import java.awt.*;


public class NumbersDemo extends Applet {
	
	public void paint(Graphics g){
		double area;
		double radius = 12;

		g.drawString("Area of a circle = (radius)^2*Pi", 10, 20);
		g.drawString("If radius = " + radius, 10, 40);
		g.drawString("The circle's area = " + Math.pow(radius, 2)*Math.PI, 10, 60);
		
	}


}
