import java.applet.Applet;
import java.awt.*;


public class Calculation extends Applet {

	public void paint(Graphics g){
		int length;
		int width;
		int area;
		
		length = 20;
		width = 10;
		area = length * width;
		g.drawString("Area is " + area,  100,  100);
		//display the answer
	}
	
}
