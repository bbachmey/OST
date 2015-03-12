package event;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import enums.ShapeAction;
import model.Model;
import shapes.PolyOctagon;
import shapes.PolyTri;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

public class ShapeMouseHandler extends MouseAdapter {
	// Integers to mark the x,y position of a mouse click
	private int startX;
	private int startY;
	private int offsetX;
	private int offsetY;
	// Shape object
	private Shape shape;
	// Shape action
	private ShapeAction action;
	// The Model
	private Model model;

	int diffX;
	int diffY;

	/**
	 * Constructor. Sets the model for this Listener.
	 * 
	 * @param model
	 */
	public ShapeMouseHandler(Model model) {
		// Instantiate a local reference to the Model
		this.model = model;
	}

	private void changeShape() {

		// Set the line color of the shape
		shape.setLineColor(model.currentLineColor);

		// Check the inheritance of the Shape
		if (shape instanceof Rectangle) {
			// Downcast to get fill methods
			((Rectangle) shape).setFill(model.isFill());
			((Rectangle) shape).setFillColor(model.currentFillColor);
		}
		if (shape instanceof PolyTri) {
			// Downcast to get fill methods
			((PolyTri) shape).setFill(model.isFill());
			((PolyTri) shape).setFillColor(model.currentFillColor);
		}
		if (shape instanceof PolyOctagon) {
			// Downcast to get fill methods
			((PolyOctagon) shape).setFill(model.isFill());
			((PolyOctagon) shape).setFillColor(model.currentFillColor);
		}

	}

	private void makeShape() {

		// Call the create() method on the model
		shape = model.createShape();

		// If we got a shape...
		if (shape != null) {

			// Set the x and y of the shape to the mouse event coordinates
			shape.setX(startX);
			shape.setY(startY);
		}

	}

	/*
	 * Overrides MouseAdapter's mouseDragged method.
	 */
	public void mouseDragged(MouseEvent e) {

		// Get the current shape from the Model
		shape = model.getCurrentShape();

		// Get the action from the Model
		action = model.getAction();

		// Make sure the model has a current shape before trying any actions
		if (shape != null) {

			if (action == ShapeAction.DRAW) {
				// reDrawShape( e.getX(), e.getY() );
				resizeShape(e.getX(), e.getY());
			}

			if (action == ShapeAction.MOVE) {

				moveShape(e.getX(), e.getY());
			}

			if (action == ShapeAction.RESIZE) {

				resizeShape(e.getX(), e.getY());
			}

			// tell the model to repaint the applet or application.
			model.repaint();
		}

	}

	/*
	 * Overrides MouseAdapter mousePressed method.
	 */
	@Override
	public void mousePressed(MouseEvent e) {

		// Get the x,y coordinates of the mouse event
		startX = e.getX();
		startY = e.getY();

		// Find out if a shape was clicked
		shape = model.findClickedShape(startX, startY);

		// Update the Model with the results of findClickedShape()
		model.setCurrentShape(shape);

		// Ask the Model what the Action is
		action = model.getAction();

		// Make a decision based on whether a shape was clicked
		if (shape != null) {

			// A shape was clicked

			// Set the offset
			offsetX = startX - shape.getX();
			offsetY = startY - shape.getY();

			// Change the shape
			if (action == ShapeAction.CHANGE) {
				changeShape();
			}
			// Remove the shape
			if (action == ShapeAction.REMOVE) {
				removeShape();
			}
			// Draw a shape on top of another shape
			if (action == ShapeAction.DRAW) {
				makeShape();
			}
		} else {

			// No shape was clicked

			if (model.getAction() == ShapeAction.DRAW) {
				makeShape();
			}
		}

		// Call the repaint() method on the Model
		model.repaint();

	}

	private void moveShape(int x, int y) {
		// if there is a current shape in the model.
		if (shape != null) {

			// Set the difference between the shape position and the event
			// position
			diffX = shape.getX() - x;
			diffY = shape.getY() - y;

			// Include the offset in the calculation to keep the mouse icon
			// in relative position to the shape
			shape.setX(shape.getX() - diffX - offsetX);
			shape.setY(shape.getY() - diffY - offsetY);
		}

	}

	private void removeShape() {
		model.shapes.remove(shape);
	}

	private void resizeShape(int x, int y) {

		// if the shape is an instance of Rectangle or a descendant of Rectangle
		if (shape instanceof Rectangle) {
			// set its width and height.
			// allows for rubber banding.
			((Rectangle) shape).setWidth(Math.abs(startX - x - offsetX));
			((Rectangle) shape).setHeight(Math.abs(startY - y - offsetY));
		} else if (shape instanceof PolyTri) {

			((PolyTri) shape).setWidth(Math.abs(startX - x));
			((PolyTri) shape).setHeight(Math.abs(startY - y));
		} else if (shape instanceof PolyOctagon) {

			((PolyOctagon) shape).setWidth(Math.abs(startX - x));
			((PolyOctagon) shape).setHeight(Math.abs(startY - y));
		} else {

			((Triangle) shape).setWidth(Math.abs(startX - x));
			((Triangle) shape).setHeight(Math.abs(startY - y));
		}

	}
}