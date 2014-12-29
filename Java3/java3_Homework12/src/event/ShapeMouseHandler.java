package event;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import enums.ShapeAction;
import model.Model;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

public class ShapeMouseHandler extends MouseAdapter {
	private Model model;
	// Integers to mark the x,y position of a mouse click
	private int startX;
	private int startY;
	private int offsetX;
	private int offsetY;
	// Shape object
	private Shape shape;

	/**
	 * Constructor. Sets the model for this Listener.
	 * 
	 * @param model
	 */
	public ShapeMouseHandler(Model model) {
		//persist local variable model to this.model.
		this.model = model;
	}

	/*
	 * Overrides MouseAdapter mousePressed method.
	 */
	@Override
	public void mousePressed(MouseEvent e) {

		// Get the x,y coordinates of the mouse event
		startX = e.getX();
		startY = e.getY();
		
		// Find the clicked shape
		shape = model.findClickedShape(startX,startY);
		
		// Set the current shape in the model
		model.setCurrentShape( shape );
		
		// Set the offset
		if(shape != null){
			offsetX = startX - shape.getX();
			offsetY = startY - shape.getY();		
		}
		
		// Proceed with the action

		if ( model.getAction() == ShapeAction.DRAW ){
			// Call the create() method on the model
			shape = model.createShape();
			// If we got a shape...
			if (shape != null) {
				// Set the x and y of the shape to the mouse event coordinates
				shape.setX( startX );
				shape.setY( startY );

				// We should set a default width and height or ending location in
				//case the user does not drag the mouse.

				// Check the object inheritance of the shape.
				if (shape instanceof Rectangle) {
					// Set the default shape size
					((Rectangle) shape).setWidth(50);
					((Rectangle) shape).setHeight(50);
				}
				else {
					((Triangle) shape).setWidth(50);
					((Triangle) shape).setHeight(50);                	
				}
			}
		}


		if (model.getAction() == ShapeAction.CHANGE){

			if (shape != null){
				
				shape.setLineColor(model.currentLineColor);
				if (shape instanceof Rectangle) {
					((Rectangle) shape).setFill( model.isFill() );
					((Rectangle) shape).setFillColor( model.currentFillColor );
				}
			}
			
		}

		if(model.getAction() ==  ShapeAction.REMOVE){

			model.shapes.remove(shape);
			
		}

		// tell the model to repaint the applet or application.
		model.repaint();
	}

	/*
	 * Overrides MouseAdapter's mouseDragged method.
	 */
	public void mouseDragged(MouseEvent e) {
		// get the current shape handled by the model.
		shape = model.getCurrentShape();



		if (model.getAction() ==  ShapeAction.DRAW){

			// set the x and y location of the shape (allows rubber banding).
			shape.setX(Math.min(startX, e.getX()));
			shape.setY(Math.min(startY, e.getY()));

			// if the shape is an instance of Rectangle or a descendant of Rectangle
			if (shape instanceof Rectangle) {
				// set its width and height.
				// allows for rubber banding.
				((Rectangle) shape).setWidth(Math.abs( startX - e.getX() ));
				((Rectangle) shape).setHeight(Math.abs( startY - e.getY() ));
			}
			else{

				((Triangle) shape).setWidth(Math.abs(startX - e.getX()));
				((Triangle) shape).setHeight(Math.abs(startY - e.getY()));
			}
		}

		if (model.getAction() ==  ShapeAction.MOVE){

			// if there is a current shape in the model.
			if (shape != null) {
				// Set the difference between the shape position and the event position
				int diffX = shape.getX() - e.getX();
				int diffY = shape.getY() - e.getY();

				// Include the offset in the calculation to keep the mouse icon 
				//in relative position to the shape
				shape.setX( shape.getX() - diffX - offsetX );
				shape.setY( shape.getY() - diffY - offsetY );
			}
		}

		if (model.getAction() ==  ShapeAction.RESIZE){
			
			// if the shape is an instance of Rectangle or a descendant of Rectangle
			if (shape instanceof Rectangle) {
				// set its width and height.
				// allows for rubber banding.
				((Rectangle) shape).setWidth(Math.abs( startX - e.getX() - offsetX ));
				((Rectangle) shape).setHeight(Math.abs( startY - e.getY() - offsetY ));
			}
			else{

				((Triangle) shape).setWidth(Math.abs(startX - e.getX()));
				((Triangle) shape).setHeight(Math.abs(startY - e.getY()));
			}
		}

		// tell the model to repaint the applet or application.
		model.repaint();
	}
}