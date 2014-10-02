package ui.applet;

import java.applet.Applet;
import ui.panels.ActionPanel;

    public class GUIDemo extends Applet{
        
        
        ActionPanel actionPanel;
    
        public void init(){
            resize(600,400);
            actionPanel = new ActionPanel();
            add(actionPanel); 
        }
         
}