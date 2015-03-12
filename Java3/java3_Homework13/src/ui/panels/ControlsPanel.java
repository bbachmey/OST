package ui.panels;

import interfaces.Resettable;

import java.awt.Panel;

import model.Model;

/**
 * Another Panel added to the MainPanel
 * @author bbachmey
 *
 */
public class ControlsPanel extends Panel implements Resettable {
	private ButtonPanel btnPanel;

	/**
	 * Constructor
	 * @param model
	 */
	public ControlsPanel(Model model) {
		btnPanel = new ButtonPanel(model);
		add(btnPanel);
	}

	/* (non-Javadoc)
	 * @see interfaces.Resettable#resetComponents()
	 */
	public void resetComponents() {
	}
}