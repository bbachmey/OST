package view;

import java.applet.Applet;
import java.awt.Graphics;

public class ChoiceApplet extends Applet{
  
    public void init() {
        ChoicePanel choicePanel = new ChoicePanel();
        this.add(choicePanel);
    }
    public void paint(Graphics g) {
        g.drawString("Message will go here.", 20,100);
    }
}