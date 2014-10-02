package view;

import java.applet.Applet;
import java.awt.Graphics;
import model.Model;


public class ChoiceApplet extends Applet{
    Model model;
    ChoicePanel choicePanel;
    
    public void init() {
        model = new Model(this);
        choicePanel = new ChoicePanel(model);
        this.add(choicePanel);
    }
    
    public void paint(Graphics g) {
        g.drawString(model.getMessage(), 20,100);
    }
}