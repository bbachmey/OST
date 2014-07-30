import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DukesAppletGUI extends Applet implements ActionListener{

	// Instance Variable giving the instance name "myDuke"
	Dukes myDuke;
	// Instance Variable telling what action is being done
	String action;
	
	// init method 
	public void init()
	{
		// makes a list to choose from
		List actionList = new List(3);
		// give the list 3 choices
		actionList.add("wave");
		actionList.add("think");
		actionList.add("write");
		
		// tell Java to listen for user input
		actionList.addActionListener(this);
		// add the list to the Applet
		add(actionList);
		
		// make an instance of Duke
		myDuke = new Dukes();
		// see what Duke's current action is
		action = myDuke.getActionImage();
		
	}
	
	// paint method 
	public void paint(Graphics g)
	{
		Image myAction = getImage(getDocumentBase(), action);
		g.drawString(myDuke.getAction(), 10, 165);
		g.drawString(myDuke.getMessage(), 10, 180);
		g.drawImage(myAction,  20,  50,  Color.WHITE,  this);
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		String userChoice = evt.getActionCommand();
		if (userChoice == "write") action = myDuke.write();
		else if (userChoice == "think") action = myDuke.think();
		else if (userChoice == "wave") action = myDuke.wave();
		
		// if a different choice has been made, call our paint through repaint()
		repaint();
		
	}
	

}
