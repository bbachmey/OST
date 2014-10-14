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
		//Set the Model property of the ChoicePanel object to the Model defined in the formal parameter
		//of the constructor
		model = mdl;
		//make a new blank Choice
		choice = new Choice();
		
		//loop through the selections in the Model and add each one to the Choice object
	    for(String msg : Model.choices) {
	        choice.add(msg);
	    }
	    
		//add an anonymous inner class ItemListener to the Choice object
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setCurrentShapeType(choice.getSelectedItem());
				 model.repaint();

			}
		});
		//add the Choice to this ChoicePanel
		this.add(choice);
	}

	public void resetComponents() {
		choice.select(0);
        model.setCurrentShapeType(choice.getSelectedItem());

	}
}