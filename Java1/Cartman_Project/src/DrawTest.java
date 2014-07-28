import java.applet.Applet;
import java.awt.*;

public class DrawTest extends Applet 
{
	public void init()
	{
		//set the applet background color
		setBackground(Color.WHITE);
		

		// resize the applet window
		resize(300,300);
		
	}
	
	public void paint(Graphics g)
	{
		//Create a Cartman object and pass to it the Graphics object given to this applet
		Cartman myCartman = new Cartman();
		 
		//call the method on the Cartman object that draws the Cartman using the Graphics object
		myCartman.drawAllOfMe(g);
		
	}
}
