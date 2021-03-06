import java.awt.Color;


/** (JavaDoc)
 * @author bbachmey
 * this is the Dukes class
 */
public class Dukes {
	//default Dukes have reds noses
	private Color noseColor = Color.red;
	
	// default Dukes aren't disgruntled
	private boolean angry = false;  
	//public boolean angry = false;
	
	//default Dukes are friendly
	private String action = "../../images/duke/dukeWave.gif";
	private String whatDoing = "Give me something to do";
	private String message = "";
	private String angryMessage= "";
	
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
		
		// randomly decide if Duke is angry
		        rint = (int)(Math.random() * 3);
		if (rint == 1)
			{
			angry = true;
			angryMessage = "I QUIT!!";
		Dukes myDuke = new Dukes(noseColor, true); 
		}

	}
	
	//new constructor
    public Dukes(Color nose, boolean isMad) {
		// give Duke instance specified values for traits 
    	//that are passed from the class that instantiated

		this.noseColor = nose;
		this.angry = isMad;
	}
    

    public String getAngryMessage()
    {
        return angryMessage;
    }

    public void setAngryMessage(String newMessage)
    {
        angryMessage = newMessage;
    }

    public boolean isAngry()
    {
        return angry;
    }

    public void setMood()  
    {   // toggle the boolean value.  
    	//If it was true it becomes false; if false it becomes true
        angry = !angry;
        if (angry == true)
            angryMessage= "I QUIT!!";
        else 
            angryMessage= "";
    }

	public String getAction() 
	{
		return whatDoing;
	}
    public String getActionImage()
    {
        return action;
    }
   	public Color getNoseColor() 
   	{
   		return noseColor;
   	}
	public String getMessage() 
	{
		return message;
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
	
}
