import java.applet.Applet;
import java.awt.*;

public class DrawTest extends Applet 
{
	public void init()
	{
		//set the applet background color
		//setBackground(Color.cyan);
	}
	
	public void paint(Graphics g)
	{
		//Create a Cartman object and pass to it the Graphics object given to this applet
		Cartman myCartman = new Cartman(g);
		//call the drawMe method on the Cartman object
		myCartman.drawAllOfMe();
		
	}
}
