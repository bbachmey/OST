package ui.panels;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class ButtonPanel extends Panel {
    private Button btnClear;

    public ButtonPanel(final Model model) {
    	//declare and instantiate a new Button that says, "Clear"
        btnClear = new Button("Clear");
        
        /*Homework 8
        Modify the ButtonPanel's Clear button so that it no longer uses an 
        anonymous inner class, but rather, a local inner class. 
        Its functionality should not change.
        */
        
//        btnClear.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                model.resetComponents();
//                model.repaint();
//            }
//        });        
        
        //declare an inner class that implements ActionListener
        class ButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent arg0) {
                model.resetComponents();
                model.repaint();
            }            
        }
        
        //add the new listener to the button
        btnClear.addActionListener( new ButtonListener() );
        
        //add the button to the Panel
        add(btnClear);
    }
}