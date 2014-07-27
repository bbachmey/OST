import java.applet.Applet;
import java.awt.*;

public class DrawTest extends Applet 
{
	public void init()
	{
		//set the applet background color
		//setBackground(Color.cyan);
		

		// resize the applet window
//		resize(
//				myCartman.body.getWidth(),
//				myCartman.body.getyPos()
//				); 
		resize(300,300);
		
	}
	
	public void paint(Graphics g)
	{
		//Create a Cartman object and pass to it the Graphics object given to this applet
		Cartman myCartman = new Cartman();

		//call the method on the Cartman object that draws the Cartman using the Graphics object
		myCartman.drawAllOfMe(g);
		
		//TEST
//	    g.drawArc(10, 40, 70, 70, 0, 75);
//	    g.fillArc(100, 40, 70, 70, 0, 75);
//	    g.drawArc(10, 100, 70, 80, 0, 175);
//	    g.fillArc(100, 100, 70, 90, 0, 270);
//	    g.drawArc(200, 80, 80, 80, 0, 180);
		
	}
}
