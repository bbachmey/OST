import java.applet.Applet;
import java.awt.Graphics;


public class Calculation extends Applet {

	//make room for display
	public void start(){
		resize(300,200);

	}

	public void paint(Graphics g){

		double diameter = 50;
		double radius = 1/2.0 * diameter;
		double area;

		area = Math.PI * Math.pow(radius,2); 

		g.drawOval(10,10,(int)radius,(int)radius);
		g.drawString("My circle's area is " + area, 10, 100);


		g.drawString("Answer is " + 1 + 2, 100, 120);

		g.drawString("Answer is " +(1+2), 100, 130);

	}

}
