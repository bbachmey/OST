package event;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import enums.ShapeAction;
import model.Model;
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

	/**
	 * Constructor. Sets the model for this Listener.
	 * 
	 * @param model
	 */
	public ShapeMouseHandler(Model model) {		
		// Instantiate a local reference to the Model
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

		// Find out if a shape was clicked
		shape = model.findClickedShape(startX,startY);

		// Update the Model with the results of findClickedShape()
		model.setCurrentShape( shape );
		
		// Ask the Model what the Action is
		action = model.getAction();

		// Make a decision based on whether a shape was clicked
		if(shape != null){ 			
			// A shape was clicked

			// If the action is CHANGE
			if (action == ShapeAction.CHANGE){
				changeShape();
			}

			// If the action is REMOVE
			if(action ==  ShapeAction.REMOVE){
				removeShape();				
			}
		}
		else {
			// No shape was clicked, so draw one if the Action is DRAW
			if ( model.getAction() == ShapeAction.DRAW ){
				drawShape();
			}
		}

		// Call the repaint() method on the Model
		model.repaint();

	}

	private void drawShape() {

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
				// Cast down to the lower type in order to set height and width
				// This is the default shape size
				((Rectangle) shape).setWidth(50);
				((Rectangle) shape).setHeight(50);
			}
			else if (shape instanceof PolyTri) {
				((PolyTri) shape).setWidth(50);
				((PolyTri) shape).setHeight(50);                	
			}
			else {
				((Triangle) shape).setWidth(50);
				((Triangle) shape).setHeight(50);                	
			}
		}
		
	}

	private void changeShape() {

		// Set the offset
		offsetX = startX - shape.getX();
		offsetY = startY - shape.getY();	
		
		// Set the line color of the shape
		shape.setLineColor(model.currentLineColor);
		
		// Check the inheritance of the Shape
		if (shape instanceof Rectangle) {
			// Downcast to get fill methods
			((Rectangle) shape).setFill( model.isFill() );
			((Rectangle) shape).setFillColor( model.currentFillColor );
		}
		if (shape instanceof PolyTri) {
			// Downcast to get fill methods 
			((PolyTri) shape).setFill( model.isFill() );
			((PolyTri) shape).setFillColor( model.currentFillColor );
		}
		
	}

	private void removeShape() {
		model.shapes.remove(shape);		
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
		if (shape != null){

			if (action ==  ShapeAction.DRAW){
				reDrawShape( e.getX(), e.getY() );
			}

			if (model.getAction() ==  ShapeAction.MOVE){

				moveShape( e.getX(), e.getY() );
			}

			if (model.getAction() ==  ShapeAction.RESIZE){

				resizeShape( e.getX(), e.getY() );
			}

			// tell the model to repaint the applet or application.
			model.repaint();
		}

	}

	private void reDrawShape(int x, int y) {

		// set the x and y location of the shape (allows rubber banding).
		shape.setX(Math.min(startX, x ));
		shape.setY(Math.min(startY, y ));

		// if the shape is an instance of Rectangle or a descendant of Rectangle
		if (shape instanceof Rectangle) {
			// set its width and height.
			// allows for rubber banding.
			((Rectangle) shape).setWidth(Math.abs( startX - x ));
			((Rectangle) shape).setHeight(Math.abs( startY - y ));
		}
		else if (shape instanceof PolyTri) {

			((PolyTri) shape).setWidth(Math.abs(startX - x ));
			((PolyTri) shape).setHeight(Math.abs(startY - y ));
		}
		else{

			((Triangle) shape).setWidth(Math.abs(startX - x ));
			((Triangle) shape).setHeight(Math.abs(startY - y ));
		}
		
	}

	private void resizeShape(int x, int y) {
		// if the shape is an instance of Rectangle or a descendant of Rectangle
		if (shape instanceof Rectangle) {
			// set its width and height.
			// allows for rubber banding.
			((Rectangle) shape).setWidth(Math.abs( startX - x - offsetX ));
			((Rectangle) shape).setHeight(Math.abs( startY - y - offsetY ));
		}
		else if (shape instanceof PolyTri) {

			((PolyTri) shape).setWidth(Math.abs(startX - x ));
			((PolyTri) shape).setHeight(Math.abs(startY - y ));
		}
		else{

			((Triangle) shape).setWidth(Math.abs(startX - x ));
			((Triangle) shape).setHeight(Math.abs(startY - y ));
		}
		
	}

	private void moveShape(int x,int y) {
		// if there is a current shape in the model.
		if (shape != null) {
			// Set the difference between the shape position and the event position
			int diffX = shape.getX() - x;
			int diffY = shape.getY() - y;

			// Include the offset in the calculation to keep the mouse icon 
			//in relative position to the shape
			shape.setX( shape.getX() - diffX - offsetX );
			shape.setY( shape.getY() - diffY - offsetY );
		}
		
	}
}