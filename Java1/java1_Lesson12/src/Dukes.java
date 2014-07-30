import java.awt.Color;


/** (JavaDoc)
 * @author bbachmey
 * this is the Dukes class
 */
public class Dukes {
	//default Dukes have reds noses
	private Color noseColor = Color.red;
	//default Dukes are friendly
	private String action = "../../images/duke/dukeWave.gif";
	private String whatDoing = "Give me something to do";
	private String message = "";
	
	public Dukes(){
		//generate a random number
		int rint = (int)(Math.random() * 3);
		if (rint == 0)
		{
			//more often red
			noseColor = Color.blue;
			action = "../../images/duke/dukeWave2.gif";
			message = "What's up with the blue nose?";
		}
	}

	public String write()
	{
		whatDoing = "I am a writing Duke";
		if (noseColor == Color.red){
			action = "../../images/duke/penduke.gif";
			message = "";
		}
		else
		{
			action = "../../images/duke/penduke2.gif";
			message = "My nose feels funny";
		}
		return action;
	}
	public String think()
	{
		whatDoing = "I am a thinking Duke";
		if (noseColor == Color.red){
			action = "../../images/duke/thinking.gif";
			message = "";
		}
		else
		{
			action = "../../images/duke/thinking2.gif";
			message = "My nose feels funny";
		}
		return action;
	}
	public String wave()
	{
		whatDoing = "I am a waving Duke";
		if (noseColor == Color.red){
			action = "../../images/duke/dukeWave.gif";
			message = "";
		}
		else
		{
			action = "../../images/duke/dukeWave2.gif";
			message = "My nose feels funny";
		}
		return action;
	}
	
    public String getActionImage()
    {
        return action;
    }
    
	//getters and setters
	public Color getNoseColor() {
		return noseColor;
	}

	public void setNoseColor(Color noseColor) {
		this.noseColor = noseColor;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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

}
