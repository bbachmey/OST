package ui.panels;

import interfaces.Resettable;

import java.awt.Panel;

import model.Model;

/**
 * @author bbachmey
 *
 */
public class ControlsPanel extends Panel implements Resettable {
	private ButtonPanel btnPanel;

	/**
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