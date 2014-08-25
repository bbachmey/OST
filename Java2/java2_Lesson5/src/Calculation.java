import java.applet.Applet;
import java.awt.*;


public class Calculation extends Applet {
	
	//make room for display
	public void start(){
		resize(300,200);
		
	}

	public void paint(Graphics g){
		int radius;
		double area;
		
		radius =50;
		area = Math.PI * Math.pow(radius, 2);
		
		g.drawOval(10, 10, radius,  radius);
		g.drawString("My circle's area is " + area,  10,  100);
		


	}
	
}
