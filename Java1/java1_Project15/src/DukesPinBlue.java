import java.awt.Color;

public class DukesPinBlue extends Dukes {
	private boolean showingPin;
	
	public DukesPinBlue(){
		// call the Dukes constructor
		super();
		
	}
	
	public DukesPinBlue(Color nose, boolean love){
		super(nose, love);
		
	}
	
	public boolean isShowingPin(){
		return showingPin;
	}
	
	public void switchShowingPin(){
		showingPin =! showingPin;
		if (showingPin && !isAngry())
		{
			setAngryMessage("I get a pin whether or not I'm not angry");
			//don't let them show Pins since not angry
			//showingPin =!showingPin;
		}
	}
	
	public void setMood() {
		//let the parent do the work first, then do what we need in addition
		super.setMood();
		if (isAngry() == false) showingPin = false;
	}

}
