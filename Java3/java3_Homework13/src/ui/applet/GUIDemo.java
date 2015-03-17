package ui.applet;

import interfaces.Resettable;

import java.applet.Applet;
import java.awt.Graphics;

import model.Model;
import shapes.Oval;
import shapes.PolyOctagon;
import shapes.PolyTriangle;
import shapes.Rectangle;
import shapes.Shape;
import ui.panels.MainPanel;
import event.ShapeMouseHandler;

/**
 * This is the Applet
 * @author bbachmey
 *
 */
public class GUIDemo extends Applet implements Resettable {
	MainPanel mainPanel;
	Model model;

	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init() {
		
		// set the applet window size
		resize(600, 400);

		// make a Model object and send it this Applet
		model = new Model(this);

		// make a MainPanel object
		mainPanel = new MainPanel(model);

		// add the MainPanel to this Applet
		this.add(mainPanel);

		// make a ShapeMouseHandler
		ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);

		// add the ShapeMouseHandler to this applet as a MouseListener
		this.addMouseListener(mouseHandler);

		// add the ShapeMouseHandler to this applet as a MouseMotionListener
		this.addMouseMotionListener(mouseHandler);

	}

	/* (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		// declare an index counter
		int i = -1;
		// Loop through instantiation of Shapes from the Model
		for (Shape shape : model.shapes) {
			// increment the counter
			i++;
			// If the Model provided a Shape, then draw() it
			if (shape != null) {
				// The logic for how the Shape is drawn is in the draw() method
				// of the Shape.
				shape.draw(g);
			}

			// Log the Model and Shape to the console
			System.out.println(model);
			System.out.println(shape);

			// each time a new figure is added
			// to the list, provide output in the console of all of the elements
			// in the Vector (or ArrayList) at that time.
			if (shape instanceof Rectangle) {
				System.out.println("Element " + i + " is a rectangle");
			}
			if (shape instanceof Oval) {
				System.out.println("Element " + i + " is a oval");
			}
			if (shape instanceof PolyTriangle) {
				System.out.println("Element " + i + " is a triangle");
			}
			if (shape instanceof PolyOctagon) {
				System.out.println("Element " + i + " is an octagon");
			}

		}
	}

	/* (non-Javadoc)
	 * @see interfaces.Resettable#resetComponents()
	 */
	public void resetComponents() {
		// call the resetComponents() method of the MainPanel object
		if (mainPanel != null) {
			mainPanel.resetComponents();
		}
	}
}