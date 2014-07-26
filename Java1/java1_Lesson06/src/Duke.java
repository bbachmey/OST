import java.applet.Applet;
import java.awt.*;

public class Duke extends Applet {
	//declare an Image object
	Image action;
	//declare a Color object
	Color noseColor = Color.red;
	
	public void paint(Graphics g){
		//random picker
		int rint = (int)(Math.random() * 2); // Makes either 1 or 0
		if (rint == 0) {
			noseColor = Color.red;
		}
		else{
			noseColor = Color.blue;	
		}
		//Randomly let this duke do something			
		switch ((int)(Math.random() * 3)) //gives a number between 0 and 2 
		{
			case 0: action= this.write(g); break;
			case 1: action= this.think(g); break;
			case 2: action= this.wave(g); break;
		}
		
		// resize the applet window
		resize(300,300); 
		//draw the image on this Duke applet
		g.drawImage(action,  10, 10, Color.white, this);

	}
	
	public Image write(Graphics graph) {
		graph.drawString("I am a writing Duke", 10, 130);
		if  (noseColor == Color.red) {
			action = getImage(getDocumentBase(),"../../images/duke/penduke.gif");
		}
		else{
			action = getImage(getDocumentBase(),"../../images/duke/penduke2.gif");
		}
		return action;
	}
	
	public Image think(Graphics graph) {
		graph.drawString("I am a thinking Duke", 10, 130);
		if  (noseColor == Color.red) {
			action = getImage(getDocumentBase(),"../../images/duke/thinking.gif");
		}
		else{
			action = getImage(getDocumentBase(),"../../images/duke/thinking2.gif");
		}
		return action;
	}
	
	public Image wave(Graphics graph) {
		graph.drawString("I am a waving Duke", 10, 130);
		if  (noseColor == Color.red) {
			action = getImage(getDocumentBase(),"../../images/duke/dukeWave.gif");
		}
		else{
			action = getImage(getDocumentBase(),"../../images/duke/dukeWave2.gif");
		}
		return action;
		
	}
}
