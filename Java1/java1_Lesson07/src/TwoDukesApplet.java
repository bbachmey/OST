import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class TwoDukesApplet extends Applet {
	
	Dukes myDuke, yourDuke;
	String myAction, yourAction;
	
	public void init() {
		
		myDuke = new Dukes();
		myAction = myDuke.getActionImage();
		
		yourDuke = new Dukes();
		yourAction = yourDuke.think();
		
		resize(400,200);
	}
	
	public void paint(Graphics g) {
		Image myChoice = getImage(getDocumentBase(), myAction);
		g.drawString(myDuke.getAction(), 10, 165);
		g.drawString(myDuke.getMessage(), 10, 180);
		g.drawImage(myChoice, 20, 50, Color.white, this);
		
		Image yourChoice = getImage(getDocumentBase(), yourAction);
		g.drawString(yourDuke.getAction(), 200, 165);
		g.drawString(yourDuke.getMessage(), 200, 180);
		g.drawImage(yourChoice, 200, 50, Color.white, this);
		
	}

}
