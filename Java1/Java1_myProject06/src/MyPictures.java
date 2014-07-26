import java.applet.Applet;
import java.awt.*;

public class MyPictures extends Applet {
	//declare an Image object
	Image picture;
	//Declare a String for the message
	String message;
	
	public void init(){
		// resize the applet window
		resize(300,300); 
		//randomly generate 0 or 1 or 2
		int rint = (int)(Math.random() * 3); 
		//set the ball attributes using the random number
		setBallAttributes(rint); 
		
	}
	public void start(){
		//test - see init() instead
		//setBallAttributes(1); 
	}
	public void paint(Graphics g){
		//draw the message
		g.drawString(message, 20, 20);
		//draw the image
		g.drawImage(picture,  20, 40, Color.white, this);
	}
	
	public void setBallAttributes(int number) {
		//set the attributes of the ball, given an integer from 0 to 2
		switch (number) 
		{
			case 0: 
				setPicture(getImage(getDocumentBase(),"images/beach.jpg")); 
				setMessage("This is a beach ball"); 
				break;
			case 1: 
				setPicture(getImage(getDocumentBase(),"images/golf.jpg"));
				setMessage("This is a golf ball");
				break;
			case 2: 
				setPicture(getImage(getDocumentBase(),"images/soccer.jpg"));
				setMessage("This is a soccer ball");
				break;
		}

	}

	//getters and setters
	public Image getPicture() {
		return picture;
	}

	public void setPicture(Image pic) {
		this.picture = pic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}
	
}
