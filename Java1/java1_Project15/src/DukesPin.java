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
		super();
		
	}
	
	/**
	 * overloaded constructor
	 * @param nose
	 * @param love
	 */
	public DukesPin(Color nose, boolean love){
		//accept a Color and a boolean and send them to the super constructor
		super(nose, love);
		
	}
	
	public boolean isShowingLovePin(){
		return showingLovePin;
	}
	
	/**
	 * This switch only works if the Duke is angry. 
	 * If Duke isn't angry, this method sets the Angry message and
	 * sets the showingLovePin Checkbox back to false 
	 */
	public void switchShowingPin(){
		showingLovePin =! showingLovePin;
		if (showingLovePin && !isAngry())
		{
			setAngryMessage("I don't get a Pin, I'm not angry");
			//don't let them show Pins since not angry
			showingLovePin =!showingLovePin;
		}
	}
	
	/* (non-Javadoc)
	 * @see Dukes#setMood()
	 */
	 @Override
	public void setMood() {
		//let the parent do the work first, then do what we need in addition
		super.setMood();
		if (isAngry() == false) showingLovePin = false;
	}

	public boolean isShowingBluePin() {
		return showingBluePin;
	}

	public void setShowingBluePin(boolean showingBluePin) {
		this.showingBluePin = showingBluePin;
	}

}
