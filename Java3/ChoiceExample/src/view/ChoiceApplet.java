package view;

import java.applet.Applet;
import java.awt.Graphics;
import model.Model;
import interfaces.Resettable;

public class ChoiceApplet extends Applet implements Resettable{
    Model model;
    ChoicePanel choicePanel;
    ButtonPanel buttonPanel;
    
    public void init() {
        model = new Model(this);
        choicePanel = new ChoicePanel(model);
        buttonPanel = new ButtonPanel(model);
        this.add(choicePanel);
        this.add(buttonPanel);
    }
    
    public void paint(Graphics g) {
        g.drawString(model.getMessage(), 20,100);
    }
    
    public void resetComponents() {
        choicePanel.resetComponents();
    }
}