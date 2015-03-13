package event;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.PolyOctagon;
import shapes.PolyTriangle;
import shapes.Rectangle;
import shapes.Shape;
import enums.ShapeAction;

/**
 * Custom MouseAdapter to manage actions with Shapes
 * @author bbachmey
 *
 */
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

	// Change in x and y position
	int diffX;
	int diffY;
	
	// placeholder for original line color
	Color originalLineColor;
	
	// placeholder for original fill color
	Color originalFillColor;
	
	// placeholder for original fill setting
	boolean originalFill;

	/**
	 * Constructor. Sets the model for this Listener.
	 * 
	 * @param model
	 */
	public ShapeMouseHandler(Model model) {
		// Instantiate a local reference to the Model
		this.model = model;
	}

	/**
	 * Change the properties of an existing shape
	 */
	private void changeShape() {

		// Set the line color of the shape
		shape.setLineColor(model.currentLineColor);

		// Check the inheritance of the Shape
		if (shape instanceof Rectangle) {
			// Downcast to get fill methods
			((Rectangle) shape).setFill(model.isFill());
			((Rectangle) shape).setFillColor(model.currentFillColor);
		}
		if (shape instanceof PolyTriangle) {
			// Downcast to get fill methods
			((PolyTriangle) shape).setFill(model.isFill());
			((PolyTriangle) shape).setFillColor(model.currentFillColor);
		}
		if (shape instanceof PolyOctagon) {
			// Downcast to get fill methods
			((PolyOctagon) shape).setFill(model.isFill());
			((PolyOctagon) shape).setFillColor(model.currentFillColor);
		}

	}

	private void highlightShape() {
		shape.setLineColor(Color.CYAN);


		// Check the inheritance of the Shape
		if (shape instanceof Rectangle) {
			// Downcast to get fill methods
			((Rectangle) shape).setFill( true );
			((Rectangle) shape).setFillColor( Color.WHITE );
		}
		if (shape instanceof PolyTriangle) {
			// Downcast to get fill methods
			((PolyTriangle) shape).setFill( true );
			((PolyTriangle) shape).setFillColor( Color.WHITE );
		}
		if (shape instanceof PolyOctagon) {
			// Downcast to get fill methods
			((PolyOctagon) shape).setFill( true );
			((PolyOctagon) shape).setFillColor( Color.WHITE );
		}
		
	}
	
	/**
	 * Create a shape that doesn't yet exists
	 */
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

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
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

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
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
			recordShapeOriginals();
			
			// Set the offset
			offsetX = startX - shape.getX();
			offsetY = startY - shape.getY();

			// Change the color of the shape
			if (action == ShapeAction.MOVE) {
				highlightShape();
			}
			// Change the shape
			if (action == ShapeAction.CHANGE) {
				highlightShape();
			}
			// Resize the shape
			if (action == ShapeAction.RESIZE) {
				highlightShape();
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


	private void recordShapeOriginals() {
		originalLineColor = shape.getLineColor();
		
		// Check the inheritance of the Shape
		if (shape instanceof Rectangle) {
			// Downcast to get fill methods
			originalFill = ((Rectangle) shape).isFill();
			originalFillColor = ((Rectangle) shape).getFillColor();
		}
		if (shape instanceof PolyTriangle) {
			// Downcast to get fill methods
			originalFill = ((PolyTriangle) shape).isFill(  );
			originalFillColor = ((PolyTriangle) shape).getFillColor();
		}
		if (shape instanceof PolyOctagon) {
			// Downcast to get fill methods
			originalFill = ((PolyOctagon) shape).isFill();
			originalFillColor = ((PolyOctagon) shape).getFillColor(  );
		}
				
	}

	@Override
	public void mouseReleased(MouseEvent e){
		// Get the current shape from the Model
		shape = model.getCurrentShape();

		// Get the action from the Model
		action = model.getAction();

		// Make sure the model has a current shape before trying any actions
		if (shape != null) {

			if (action == ShapeAction.CHANGE) {
				changeShape();
				model.repaint();
			}
			if (action == ShapeAction.MOVE) {
				unhighlightShape();
				model.repaint();
			}
			if (action == ShapeAction.RESIZE) {
				unhighlightShape();
				model.repaint();
			}
			
		}
		
	}

	/**
	 * Move a shape to another position on the screen
	 * @param x
	 * @param y
	 */
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

	/**
	 * Delete a shape
	 */
	private void removeShape() {
		model.shapes.remove(shape);
	}

	/**
	 * Redraw a shape with new size parameters
	 * @param x
	 * @param y
	 */
	private void resizeShape(int x, int y) {

		// if the shape is an instance of Rectangle or a descendant of Rectangle
		if (shape instanceof Rectangle) {
			// set its width and height.
			// allows for rubber banding.
			((Rectangle) shape).setWidth(Math.abs(startX - x - offsetX));
			((Rectangle) shape).setHeight(Math.abs(startY - y - offsetY));
		} else if (shape instanceof PolyTriangle) {
			((PolyTriangle) shape).setWidth(Math.abs(startX - x));
			((PolyTriangle) shape).setHeight(Math.abs(startY - y));
		} else if (shape instanceof PolyOctagon) {
			((PolyOctagon) shape).setWidth(Math.abs(startX - x));
			((PolyOctagon) shape).setHeight(Math.abs(startY - y));
		} 

	}

	public void setOriginalLineColor(Color originalLineColor) {
		this.originalLineColor = originalLineColor;
	}

	private void unhighlightShape() {
		shape.setLineColor(originalLineColor);
		
		// Check the inheritance of the Shape
		if (shape instanceof Rectangle) {
			// Downcast to get fill methods
			((Rectangle) shape).setFill( originalFill );
			((Rectangle) shape).setFillColor( originalFillColor );
		}
		if (shape instanceof PolyTriangle) {
			// Downcast to get fill methods
			((PolyTriangle) shape).setFill( originalFill );
			((PolyTriangle) shape).setFillColor( originalFillColor );
		}
		if (shape instanceof PolyOctagon) {
			// Downcast to get fill methods
			((PolyOctagon) shape).setFill( originalFill );
			((PolyOctagon) shape).setFillColor( originalFillColor );
		}
			
	}
	
	// getters and setters
	public Color getActualLineColor() {
		return originalLineColor;
	}

	public Color getOriginalLineColor() {
		return originalLineColor;
	}
	
}