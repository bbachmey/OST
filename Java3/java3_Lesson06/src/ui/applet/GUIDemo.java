package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
//import ui.panels.ActionPanel;
import ui.panels.MainPanel;

public class GUIDemo extends Applet implements Resettable{
    //ActionPanel actionPanel;
    MainPanel mainPanel;
  
    public void init() {
        resize(600,400);
        //actionPanel = new ActionPanel();
        //add(actionPanel);
        mainPanel = new MainPanel();
        add(mainPanel);
    }
    
    public void resetComponents(){
        mainPanel.resetComponents();
    }
}