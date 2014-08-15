import java.applet.Applet;
import java.awt.*;


public class Calculation extends Applet {
	
	//make room for display
	public void start(){
		resize(300,200);
		
	}

	public void paint(Graphics g){

	     int diameter = 50;
	        // int radius = 1/2 * diameter;
	        double area;

	        area = Math.PI * Math.pow(diameter/2,2); 
			        
		    g.drawOval(10,10,diameter/2, diameter/2);
	        g.drawString("My circle's area is " + area, 10, 100);

	}
	
}
