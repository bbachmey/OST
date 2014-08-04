import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class DukesPinApplet extends Applet implements ItemListener {
	
	DukesPin myDuke;
	String action;
	Checkbox showLovePin;
	Checkbox showBluePin;
	Graphics g;
	
	private void clearBluePin() {
		// TODO Auto-generated method stub
		
	}
	
	private void clearLovePin() {
		// change the pen color
		g.setColor(Color.white);
		// fill an oval the same shape as the pin
		g.fillOval(120, 50, 80, 80);
		
	}

	public void init(){
		Choice actionList = new Choice();
		actionList.add("wave");
		actionList.add("think");
		actionList.add("write");
		
		//add the applet, itself, as an item listener to the Choice actionList
		actionList.addItemListener(this);
		//add the Choice to the applet, so that it is displayed on the UI
		add(actionList);
		
		//make a new DukesPin, which is-a Dukes by extension of the Dukes class
		myDuke=new DukesPin();
		//get the String actionImage from the new Duke and assign it to the action attribute of this applet
		action = myDuke.getActionImage();
		
		//make a new checkbox, set it to the return value of the Dukes object angry attribute
		Checkbox changeMood = new Checkbox("Angry", myDuke.isAngry());
		//add the checkbox to the applet
		add(changeMood);
		//add this applet as an item listener to the Checkbox object
		changeMood.addItemListener(this);

		//make another Checkbox
		showBluePin = new Checkbox("ShowBluePin");
		//add the checkbox to the applet
		add(showBluePin);
		//add the applet to the Checkbox as a listener
		showBluePin.addItemListener(this);
		
		//make another Checkbox
		showLovePin = new Checkbox("ShowLovePin");
		//add the checkbox to the applet
		add(showLovePin);
		//add the applet to the Checkbox as a listener
		showLovePin.addItemListener(this);
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	public void itemStateChanged(ItemEvent evt){
		//this method will get called by any of the objects to which this applet has been added as a listener
		//use a series of ifs and an else to decide which object sent the event and then decide what to do
		if (evt.getItem().toString() == "Angry")
		{
			//if the Checkbox object sending the event was called "Angry" when it was created 
			//call the setMood method of the Duke
			myDuke.setMood();
			//if the Duke isn't angry, set the state of the Checkbox object to false
			if (!myDuke.isAngry()) showLovePin.setState(false);		
		}
		else if (evt.getItem().toString() == "ShowPin")
		{
			myDuke.switchShowingLovePin();
			if(showLovePin.getState() && !myDuke.isAngry()) showLovePin.setState(false);
		}
		else
		{
			//if neither the Angry Choice object nor the ShowPin Choice object sent the event
			//then it was the Choice list
			//cast the selectable item from the event into a Choice, and get the selected index of the choice
			int which = ((Choice)evt.getItemSelectable()).getSelectedIndex();
			switch (which){
			case 0: action= myDuke.wave(); break;
			case 1: action= myDuke.think(); break;
			case 2: action= myDuke.write(); break;
			}
			
		}
		//repaint the applet
		repaint();
	}

	private void makeBluePin() {
		// TODO Auto-generated method stub
		
	}
	
	private void makeLovePin() {
		//
		PinImages images = new PinImages();
		//make pin
		g.setColor(Color.red);
		g.fillOval(120, 50, 80, 80);
		//put something in Pin
		g.setColor(Color.white);
		g.drawString("I", 155, 70);
		images.drawHeart(g, Color.pink, 145, 75, 25);
		g.setColor(Color.white);
		g.drawString("Duke!", 145, 120);
		
		
	}

	public void paint(Graphics g){
		//make the Graphics object given to the paint method an attribute of the applet
		this.g = g;
		//make an image
		Image actionChoice = getImage(getDocumentBase(), action);
		//draw an image
		g.drawImage(actionChoice, 20, 50, Color.white, this);
		//draw three strings on the graphics object
		g.drawString(myDuke.getAction(),10,165);
		g.drawString(myDuke.getMessage(),10, 180);		
		g.drawString(myDuke.getAngryMessage(),  110,  140);

		//call the makeBluePin() method if the showingPin attribute of the Duke is true
		if (myDuke.isShowingBluePin()) makeBluePin();
		else clearBluePin();
		
		//call the makeLovePin() method if the showingPin attribute of the Duke is true
		if (myDuke.isShowingLovePin()) makeLovePin();
		else clearLovePin();
		
	}

}
