import java.applet.Applet;
import java.awt.*;


public class TriangleClassDemo extends Applet {

	public void paint(Graphics g){
		this.drawTriangle(g, 80, 120, 100, 110);
	     drawTriangle(g, 125, 140, 60, 70);
	     // demonstrating we don't really NEED "this" 
	}
	
	private void drawTriangle(Graphics g, int bottomX, int bottomY, int base, int height){
		g.drawLine(bottomX, bottomY, bottomX+base, bottomY);
		g.drawLine(bottomX+base, bottomY, bottomX+base/2, bottomY-height);
		g.drawLine(bottomX+base/2, bottomY-height, bottomX, bottomY);
	}
	public TriangleClassDemo() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

}
