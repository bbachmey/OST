package ui.panels;

import interfaces.Resettable;

import java.awt.Choice;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Model;

/**
 * @author bbachmey
 * Homework 6
 * Add a ChoicePanel that contains a Choice component for the types of Shapes you 
 * will allow (as shown in lesson 6), including at least one Shape in addition 
 * to the Rectangle and Oval (perhaps a Triangle). 
 * This ChoicePanel also needs to implement Resettable.
 */
public class ChoicePanel extends Panel implements Resettable{

	Model model;
	Choice choice;

	public ChoicePanel(Model mdl) {
		model = mdl;
		choice = new Choice();
		

        for(String msg : mdl.choices) {
            choice.add(msg);
        }
        
        
        

		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Nothing here
			}
		});
		this.add(choice);
	}

	public void resetComponents() {
		choice.select(0);


	}
}