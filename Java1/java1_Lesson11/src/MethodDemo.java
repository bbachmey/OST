
import java.applet.Applet;
import java.awt.*;


/**
 * @author bbachmey
 * This class is an applet with a method 
 * that draws two triangles
 */
public class MethodDemo extends Applet {

	public void paint(Graphics g){
		int rightX = 42;
        g.drawString("rightX before the method call is " + rightX, 5,170); 
        drawTriangle(g, 80, 120, 100, 110);
        drawTriangle(g, 125, 140, 60, 70);
        g.drawString("rightX after the method call is " + rightX, 5,200);
	}
	
	private void drawTriangle(Graphics g, int bottomX, int bottomY, int base, int height){
		int rightX = bottomX + base;
		g.drawString("rightX in the method is " + rightX, 5,185);
		int topX = bottomX + base/2;
		int topY = bottomY - height;
		
		//
		g.drawLine(bottomX, bottomY, rightX, bottomY);
		g.drawLine(rightX, bottomY, topX, topY);
		g.drawLine(topX, topY, bottomX, bottomY);
		
	}

}
