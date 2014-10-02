package ui.panels;

import interfaces.Resettable;
import java.awt.GridLayout;
import java.awt.Panel;

public class MainPanel extends Panel implements Resettable {
    ActionPanel actionPanel;
  
    public MainPanel() {
        actionPanel = new ActionPanel();
        setLayout(new GridLayout(2,1));
        add(actionPanel);
    }
  
    public void resetComponents() {
        actionPanel.resetComponents();
    }
}