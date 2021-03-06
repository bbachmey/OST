import java.awt.Color;

/**
 * @author bbachmey
 * DukesPin extends Dukes. DukesPin is-a Dukes.
 *
 */
public class DukesPin extends Dukes {
	private boolean showingLovePin;
	private boolean showingBluePin;
	
	/**
	 * empty constructor
	 */
	public DukesPin(){
		// call the Dukes constructor
		// remember that the empty Dukes constructor randomly generates a mood and nose color
		super();
		
	}
	
	/**
	 * overloaded constructor
	 * @param nose
	 * @param mad
	 */
	public DukesPin(Color nose, boolean mad){
		//accept a Color and a boolean and send them to the super constructor
		//
		super(nose, mad);
		
	}
	
	public boolean isShowingBluePin() {
		return showingBluePin;
	}
	
	public boolean isShowingLovePin(){
		return showingLovePin;
	}
	
	/* (non-Javadoc)
	 * @see Dukes#setMood()
	 */
	 @Override
	public void setMood() {
		//let the parent do the work first, then do what we need in addition
		super.setMood();
		//if Dukes.isAngry() returns true, set the showingLovePin to false
		if (isAngry() == false) showingLovePin = false;
	}

	public void setShowingBluePin(boolean showingBluePin) {
		this.showingBluePin = showingBluePin;
	}

	public void setShowingLovePin(boolean showingLovePin) {
		this.showingLovePin = showingLovePin;
	}

	/**
	 * This switch works whether or not the Duke is angry.  
	 */
	public void switchShowingBluePin(){
		showingBluePin =! showingBluePin;

	}
	/**
	 * This switch only works if the Duke is angry. 
	 * If Duke isn't angry, this method sets the Angry message and
	 * sets the showingLovePin Checkbox back to false 
	 */
	public void switchShowingLovePin(){
		showingLovePin =! showingLovePin;
		if (showingLovePin && !isAngry())
		{
			setAngryMessage("I don't get a Pin, I'm not angry");
			//don't let them show Pins since not angry
			showingLovePin =!showingLovePin;
		}
	}

}
