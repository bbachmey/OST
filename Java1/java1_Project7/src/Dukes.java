import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.applet.Applet;


/** (JavaDoc)
 * @author bbachmey
 * this is the Dukes class
 */
public class Dukes {
	//declare a set of Duke attributes
	private Color noseColor;
	private String actionImageAddress;
	private String whatDoing;
	private String message;
	
	public Dukes(){
		//default constructor
	}
	public Dukes(int dukeNum){
		//randomize nose color
		int rint = (int)(Math.random() * 2); // Makes either 1 or 0
		if (rint == 0) {
			noseColor = Color.red;
		}
		else{
			noseColor = Color.blue;	
		}
		//get an action using the dukeNum
		switch (dukeNum) 
		{
			case 0: this.write(); 
				break;
			case 1: this.think(); 
				break;
			case 2: this.wave(); 
				break;
		}
		
	}

	public void write()
	{
		this.whatDoing = "I am a writing Duke";
		if (this.noseColor == Color.red){
			this.actionImageAddress = "../../images/duke/penduke.gif";
			this.message = "";
		}
		else
		{
			this.actionImageAddress = "../../images/duke/penduke2.gif";
			this.message = "My nose feels funny";
		}
	}
	public void think()
	{
		this.whatDoing = "I am a thinking Duke";
		if (this.noseColor == Color.red){
			this.actionImageAddress = "../../images/duke/thinking.gif";
			this.message = "";
		}
		else
		{
			this.actionImageAddress = "../../images/duke/thinking2.gif";
			this.message = "My nose feels funny";
		}
	}
	public void wave()
	{
		this.whatDoing = "I am a waving Duke";
		if (this.noseColor == Color.red){
			this.actionImageAddress = "../../images/duke/dukeWave.gif";
			this.message = "";
		}
		else
		{
			this.actionImageAddress = "../../images/duke/dukeWave2.gif";
			this.message = "My nose feels funny";
		}
	}
	    
	//getters and setters
	public Color getNoseColor() {
		return noseColor;
	}

	public void setNoseColor(Color noseColor) {
		this.noseColor = noseColor;
	}

	public String getWhatDoing() {
		return whatDoing;
	}

	public void setWhatDoing(String whatDoing) {
		this.whatDoing = whatDoing;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getActionImageAddress() {
		return actionImageAddress;
	}
	
	public void setActionImageAddress(String actionImageAddress) {
		this.actionImageAddress = actionImageAddress;
	}

}
