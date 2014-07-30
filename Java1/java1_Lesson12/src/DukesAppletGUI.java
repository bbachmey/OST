import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DukesAppletGUI extends Applet implements ActionListener{

	Dukes myDuke;
	String action;
	
	public void init()
	{
		List actionList = new List(3);
		actionList.add("wave");
		actionList.add("think");
		actionList.add("write");
		
		actionList.addActionListener(this);
		add(actionList);
		
		myDuke = new Dukes();
		action = myDuke.getActionImage();
		
	}
	
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
		
		repaint();
		
	}
	

}
