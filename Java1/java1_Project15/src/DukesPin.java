import java.awt.Color;

public class DukesPin extends Dukes {
	private boolean showingLovePin;
	private boolean showingBluePin;
	
	public DukesPin(){
		// call the Dukes constructor
		super();
		
	}
	
	public DukesPin(Color nose, boolean love){
		super(nose, love);
		
	}
	
	public boolean isShowingPin(){
		return showingLovePin;
	}
	
	public void switchShowingPin(){
		showingLovePin =! showingLovePin;
		if (showingLovePin && !isAngry())
		{
			setAngryMessage("I don't get a Pin, I'm not angry");
			//don't let them show Pins since not angry
			showingLovePin =!showingLovePin;
		}
	}
	
	public void setMood() {
		//let the parent do the work first, then do what we need in addition
		super.setMood();
		if (isAngry() == false) showingLovePin = false;
	}

}
