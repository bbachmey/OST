import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class DukesAppletGUI extends Applet implements ItemListener{

	// Instance Variable giving the instance name "myDuke"
	Dukes myDuke;
	// Instance Variable telling what action is being done
	String action;
	
	// init method 
	public void init()
	{
		// makes a list to choose from
		Choice actionList = new Choice();
		// give the list 3 choices
		actionList.add("wave");
		actionList.add("think");
		actionList.add("write");
		
		// tell Java to listen for user input
		actionList.addItemListener(this);
		// add the list to the Applet
		add(actionList);
		
		// make an instance of Duke
		myDuke = new Dukes();
		// see what Duke's current action is
		action = myDuke.getActionImage();
		
		//new checkbox
		Checkbox isAngry = new Checkbox("angry", myDuke.isAngry());
		//add this checkbox to the applet
		add(isAngry);
		//add an item listener to the checkbox
	    isAngry.addItemListener(this);
		
	}
	
	// paint method 
	public void paint(Graphics g)
	{
		Image myAction = getImage(getDocumentBase(), action);
		g.drawString(myDuke.getAction(), 10, 165);
		g.drawString(myDuke.getMessage(), 10, 180);
		g.drawImage(myAction,  20,  50,  Color.WHITE,  this);
		g.drawString(myDuke.getAngryMessage(), 110,110);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent evt)
	{
		if (evt.getItem().toString() == "angry"){
			myDuke.setMood();
		}
	    else
	    {
			int whichOne = ((Choice)evt.getItemSelectable()).getSelectedIndex();
			switch (whichOne)
			{
				case 0: action = myDuke.wave();
					break;
				case 1: action = myDuke.think();
					break;
				case 2: action = myDuke.write();
					break;
			}
			
			// if a different choice has been made, call our paint through repaint()
			repaint();
	    }
		
	}


	

}
