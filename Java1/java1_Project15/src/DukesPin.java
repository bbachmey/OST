import java.awt.Color;

public class DukesPin extends Dukes {
	private boolean showingPin;
	
	public DukesPin(){
		// call the Dukes constructor
		super();
		
	}
	
	public DukesPin(Color nose, boolean love){
		super(nose, love);
		
	}
	
	public boolean isShowingPin(){
		return showingPin;
	}
	
	public void switchShowingPin(){
		showingPin =! showingPin;
		if (showingPin && !isAngry())
		{
			setAngryMessage("I don't get a Pin, I'm not angry");
			//don't let them show Pins since not angry
			showingPin =!showingPin;
		}
	}
	
	public void setMood() {
		//let the parent do the work first, then do what we need in addition
		super.setMood();
		if (isAngry() == false) showingPin = false;
	}

}
