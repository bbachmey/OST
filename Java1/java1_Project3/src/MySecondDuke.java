import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class MySecondDuke extends Applet {

	public void paint(Graphics graph) {
		
		Image action = getImage(getDocumentBase(),"../../images/duke/dukeWave.gif");
		
		graph.drawImage(action,  10, 50, Color.white, this);
		
		graph.drawString("Hi. I am Duke... Down below!", 10, 25);
		
	}
}
