package ui.panels;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

/**
 * Another Panel added to the MainPanel
 * @author bbachmey
 *
 */
public class ButtonPanel extends Panel {
	private Button btnClear;

	/**
	 * Constructor
	 * @param model
	 */
	public ButtonPanel(final Model model) {
		// declare and instantiate a new Button that says, "Clear"
		btnClear = new Button("Clear");

		/**
		 * Inner Class that implements ActionListener
		 * @author bbachmey
		 *
		 */
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				model.resetComponents();
				model.repaint();
			}
		}

		// add the new listener to the button
		btnClear.addActionListener(new ButtonListener());

		// add the button to the Panel
		add(btnClear);
		
	}
}