package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class MainPanel extends Panel implements Resettable {
    ActionPanel actionPanel;
    ChoicePanel choicePanel;
  
    public MainPanel(Model model) {
    	//set the layout of this MainPanel
    	this.setLayout(new GridLayout(2,1));
    	
    	//add the action panel to the main panel
        actionPanel = new ActionPanel(model);        
        add(actionPanel);
        
    	//add the choice panel to the main panel
        choicePanel = new ChoicePanel(model);
        add(choicePanel);
    }
  
    public void resetComponents() {
        actionPanel.resetComponents();
    }
}