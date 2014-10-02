package ui.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class GUIDemo extends Applet implements ItemListener {
    private final String DRAW = "Draw";
    Checkbox draw;
	
    public void init(){
        draw = new Checkbox(DRAW);
        add(draw);
        draw.addItemListener(this);
    }
	
    public void itemStateChanged(ItemEvent e){
        System.out.println("I see you now!");
        if (e.getSource() == draw)
            System.out.println("I know you clicked " + e.getItem().toString());
    }
}