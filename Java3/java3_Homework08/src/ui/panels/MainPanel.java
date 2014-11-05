package ui.panels;

import interfaces.Resettable;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Model;

public class MainPanel extends Panel implements Resettable {
	ActionPanel actionPanel;
	ChoicePanel choicePanel;
	ControlsPanel controlsPanel;
	ColorPanel colorPanel;

	public MainPanel(Model model) {
		//set the layout of this MainPanel
		this.setLayout(new GridLayout(3,1));

		//add the action panel to the main panel
		actionPanel = new ActionPanel(model);        
		add(actionPanel);

		//add the choice panel to the main panel
		choicePanel = new ChoicePanel(model);
		add(choicePanel);

		//add the controls panel to the main panel
		controlsPanel = new ControlsPanel(model);
		add(controlsPanel);

		//Homework 8
		//add the color panel to the main panel
		colorPanel = new ColorPanel(model);
		add(colorPanel);

	}

	public void resetComponents() {
		//reset all the Panels defined in the MainPanel
		actionPanel.resetComponents();
		controlsPanel.resetComponents();
		choicePanel.resetComponents();
	}

	/* Homework 8
	 * Add a static nested class ColorPanel which creates a panel (and listeners) 
	 * for two Color choice boxes, one for the line color and one for the fill color. 
	 * Provide at least 8 colors. Use the same techniques you learned in previous lessons. 
	 * These Choice boxes should work; if a user chooses a line color of Blue, 
	 * the model should be updated so that the next figure drawn will have a Blue line color, etc. 
	 * The choice boxes should be properly labeled. A good place for this nested class is 
	 * in the ControlsPanel or MainPanel. The idea is to put the class close to where it 
	 * is used to make maintenance easier.
	 */

	static class ColorPanel extends Panel implements Resettable {
		ChoicePanel colorChoicePanel;
		Choice fillColorChoice;
		Model model;
		Choice lineColorChoice;

		public ColorPanel(Model mdl){

			//Set the Model property of the ColorPanel object to the Model defined in the formal parameter
			//of the constructor
			model = mdl;
			//make a new blank Choice
			lineColorChoice = new Choice();

			//loop through the selections in the Model and add each one to the Choice object
			for(Color col : Model.colors) {
				lineColorChoice.add(col.toString());
			}

			//add an anonymous inner class ItemListener to the Choice object
			lineColorChoice.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {

					lineColorChoice.getSelectedItem().
					
					model.setCurrentLineColor();

					model.repaint();

				}
			});
			//add the Choice to this ChoicePanel
			this.add(lineColorChoice);
			
			

			//make a new blank Choice
			fillColorChoice = new Choice();

			//loop through the selections in the Model and add each one to the Choice object
			for(Color col : Model.colors) {
				fillColorChoice.add(col.toString());
			}

			//add an anonymous inner class ItemListener to the Choice object
			fillColorChoice.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {

					String s = fillColorChoice.getSelectedItem();
					Color c = s;
					model.setCurrentLineColor();

					model.repaint();

				}
			});
			//add the Choice to this ChoicePanel
			this.add(lineColorChoice);
			
			

		}

		@Override
		public void resetComponents() {
			// TODO Auto-generated method stub

		}



	}

}