import java.applet.Applet;
import java.awt.*;


public class ReturnDemo extends Applet {
	
	public void paint(Graphics g){
		int answer = areaRectangle(30,40);
		g.drawString("area of rectangle is " + answer, 20, 20);
		
	}
	
	private int areaRectangle(int side1, int side2){
		int area = side1 * side2;
		
		return area;
	}



}
