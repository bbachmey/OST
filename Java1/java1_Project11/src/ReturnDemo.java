import java.applet.Applet;
import java.awt.*;


public class ReturnDemo extends Applet {
	//instance variables
	int height = 60;
	int width = 42;
	
	public void paint(Graphics g){
		// always gives original upper left corner of (25,25)
		g.drawRect( 25, 25, width, height); 

		g.drawString("area of rectangle is " + areaRectangle(), 20, 100);
		g.drawString("perimeter of rectangle is " + perimeterRectangle(), 20, 120);
		g.drawString("rectangle center is (" + centerX() + "," + centerY() +")", 20, 140);
	}


	//the area of a rectangle:
	private int areaRectangle(){
		int area = height * width;
		
		return area;
	}
	
	//the perimeter of the rectangle: 
	private int perimeterRectangle(){
		int p;
		
		p = (height + height) + (width + width);
		return p;
	}
	
	//the X value of the center of the rectangle: 
	private int centerX(){
		int x;
		
		x = (width / 2) + 25;
		
		return x;
		
	}
	//the Y value of the center of the rectangle: 
	private int centerY(){
		int y;
		
		y = (height/2) + 25;
		
		return y;
	}



}
