package ui.panels;

import interfaces.Resettable;

import java.awt.Panel;

import model.Model;

public class ControlsPanel extends Panel implements Resettable {
	private ButtonPanel btnPanel;

	public ControlsPanel(Model model) {
		btnPanel = new ButtonPanel(model);
		add(btnPanel);
	}

	public void resetComponents() {
	}
}