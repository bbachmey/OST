package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import ui.panels.MainPanel;
import model.Model;
import java.awt.Graphics;

public class GUIDemo extends Applet implements Resettable{
    MainPanel mainPanel;
    Model model;
  
    public void init() {
        //resize the applet window
    	resize(600,400);
        //make a model object and send this Applet as a parameter
    	model = new Model(this);
    	//make a MainPanel object and send the Model object as a parameter
        mainPanel = new MainPanel(model);
        //add the MainPanel object to this Applet
        this.add(mainPanel);
    }
    
    public void paint(Graphics g){
    	//Nothing happening here, yet. See the console for output.
        System.out.println(model);
    }
    
    public void resetComponents() {
    	//call the resetComponents() method on the MainPanel object
        mainPanel.resetComponents();
    }
}