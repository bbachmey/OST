package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import ui.panels.MainPanel;
import model.Model;

public class GUIDemo extends Applet implements Resettable{
    MainPanel mainPanel;
    Model model;
  
    public void init() {
        resize(600,400);
        model = new Model(this);
        mainPanel = new MainPanel(model);
        add(mainPanel);
    }
  
    public void resetComponents() {
        mainPanel.resetComponents();
    }
}