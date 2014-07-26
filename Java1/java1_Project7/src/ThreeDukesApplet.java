import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class ThreeDukesApplet extends Applet {
	//declare some Dukes
	Dukes dukeOne, dukeTwo, dukeThree;
	//declare some Duke positions
	int dukeOneX, dukeTwoX, dukeThreeX;
		
	public void init() {
		// Resize the applet window
		resize(600,200);
				
		// this Duke is the first Duke
		dukeOne = new Dukes(0);
		
		// this Duke is the second Duke
		dukeTwo = new Dukes(1);

		// this Duke is the third Duke
		dukeThree = new Dukes(2);
		
		//randomize the position of the Dukes
		this.randomizeDukesX();
		
	}
	
	public void randomizeDukesX() {
		//make a random number
		int rint = (int)(Math.random() * 3);
		//give the first Duke the random number
		dukeOneX = spaceDukeX(rint);
		//flip for a 1 or 0
		int flip = (int)(Math.random() * 2);
		//convert the int to a boolean
		boolean b = (flip == 1);
		//randomize the position of the second and third dukes 
		switch (rint) 
		{			
			case 0: 
				//use the ternary operator to if/then against the boolean b
				dukeTwoX = spaceDukeX(b ? 2 : 1);
				dukeThreeX = spaceDukeX(b ? 1 : 2);
				break;
			case 1: 
				dukeTwoX = spaceDukeX(b ? 2 : 0);
				dukeThreeX = spaceDukeX(b ? 0 : 2);
				break;
			case 2: 
				dukeTwoX = spaceDukeX(b ? 0 : 1);
				dukeThreeX = spaceDukeX(b ? 1 : 0);
				break;
		}
	}
	
	private int spaceDukeX(int dukeX){
		//given an integer, return an integer for the horizontal placement of the graphics elements
		switch (dukeX) 
		{
			case 0: 
				dukeX = 10;
				break;
			case 1: 
				dukeX = 200;
				break;
			case 2: 
				dukeX = 400;
				break;
		}
		return dukeX;
	}
	
	public void paint(Graphics g) {
		//declare and instantiate the image object
		Image dukeOneImage = getImage(getDocumentBase(), dukeOne.getActionImageAddress());
		//draw the image 
		g.drawImage(dukeOneImage, dukeOneX, 50, Color.white, this);
		//draw the what doing string
		g.drawString(dukeOne.getWhatDoing(), dukeOneX, 20);
		//draw the message string
		g.drawString(dukeOne.getMessage(), dukeOneX, 180);
		
		Image dukeTwoImage = getImage(getDocumentBase(), dukeTwo.getActionImageAddress());
		g.drawImage(dukeTwoImage, dukeTwoX, 50, Color.white, this);
		g.drawString(dukeTwo.getWhatDoing(), dukeTwoX, 20);
		g.drawString(dukeTwo.getMessage(), dukeTwoX, 180);
		
		Image dukeThreeImage = getImage(getDocumentBase(), dukeThree.getActionImageAddress());
		g.drawImage(dukeThreeImage, dukeThreeX, 50, Color.white, this);
		g.drawString(dukeThree.getWhatDoing(), dukeThreeX, 20);
		g.drawString(dukeThree.getMessage(), dukeThreeX, 180);
	}
}
