package model;

import interfaces.Resettable;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import shapes.Oval;
import shapes.PolyOctagon;
import shapes.PolyTriangle;
import shapes.Rectangle;
import shapes.Shape;
import enums.ShapeAction;
import enums.ShapeType;

/**
 * @author bbachmey
 *
 */
public class Model implements Resettable {
	// declare a Container object
	private Container container;
	// by default, the fill option is false
	private boolean fill = false;

	// Homework 12
	// Convert the Model action final static String variables
	// (DRAW, MOVE, REMOVE, RESIZE, CHANGE, FILL) to an enum and modify your
	// code to use the
	// new data structure instead of the constants.

	// public final static String DRAW = "Draw";
	// public final static String MOVE = "Move";
	// public final static String REMOVE = "Remove";
	// public final static String RESIZE = "Resize";
	// public final static String CHANGE = "Change";
	// public final static String FILL = "Fill";

	// Set the default ShapeAction
	private ShapeAction action = ShapeAction.DRAW;

	// Lesson 6
	// create final static String variables to represent the different Shape
	// types,
	// "Rectangle," "Oval," etc. Use these variables to fill your Choice
	// component.

	// Homework 12
	// Convert the Model shape type final static String variables (RECTANGLE,
	// OVAL, etc)
	// to an enum and modify your code to use the new data structure instead of
	// the constants.

	// public final static String RECTANGLE = "Rectangle";
	// public final static String OVAL = "Oval";
	// public final static String TRIANGLE = "Triangle";

	// Make an array of Strings for the shape choice
	public final static String[] choices = { ShapeType.RECTANGLE.getName(),
			ShapeType.OVAL.getName(), ShapeType.POLYTRI.getName(),
			ShapeType.POLYOCTAGON.getName() };

	// Lesson 6
	// create a String instance variable named currentShapeType and set it to
	// whatever
	// your default shape will be (using the final static String variables you
	// just created).
	private ShapeType currentShapeType = ShapeType.RECTANGLE;

	// Lesson 7
	private Shape currentShape;

	// Homework 8
	// public final static Color BLACK = Color.BLACK;
	// public final static Color WHITE = Color.WHITE;
	// Make an array of the choice Strings
	public static final Map<String, Color> COLORS = new HashMap<String, Color>() {
		{
			put("Black", Color.BLACK);
			put("White", Color.WHITE);
			put("Orange", Color.ORANGE);
			put("Red", Color.RED);
			put("Blue", Color.BLUE);
			put("Magenta", Color.MAGENTA);
			put("Yellow", Color.YELLOW);
			put("Pink", Color.PINK);
		}
	};

	// declare a Color object for the model to keep track of the current Color
	public Color currentLineColor;
	public Color currentFillColor;

	// Homework 9
	// In the model of your java3_Homework09 project, add an array
	// of type Shape of size 2 as an instance variable. (in the Model class)
	/*
	 * public Shape [] shapes = new Shape[2];
	 */
	// Homework 10
	// For java3_Homework10, use Vector or ArrayList to add components drawn to
	// a
	// list for multiple figure storage. Add this Vector (or ArrayList) to the
	// model
	// and allow users to draw as many figures as they want (that is, it should
	// not
	// erase each time but draw everything that the user has thus far drawn).
	// Basically
	// you will need to replace your array of Shapes with this collection and
	// modify any
	// methods that utilized that array. Your Vector or ArrayList should only
	// allow
	// objects of type Shape
	public ArrayList<Shape> shapes = new ArrayList<Shape>();

	// Homework 9
	// Add a method to your model called compareShapes(), which will return
	// either 0, 1, or 2--1 if the area of the first Shape is bigger than the
	// second, 2 if it is smaller, and 0 if the two Shapes are the same size.
	/*
	 * public int compareShapes(){ //set the default return value int value = 0;
	 * //check to see if shapes 0 and 1 are instances of ComparableShape if
	 * (shapes[0] instanceof ComparableShape){ if (shapes[1] instanceof
	 * ComparableShape){ //cast the Shapes to ComparableShape objects
	 * ComparableShape first = (ComparableShape) shapes[0]; ComparableShape
	 * second = (ComparableShape) shapes[1]; //set the area for both
	 * first.setArea(); second.setArea(); // if (first.getArea() >
	 * second.getArea() ){ value = 1; } // if (first.getArea() <
	 * second.getArea() ){ value = 2; } //if (first.getArea() ==
	 * second.getArea() ){ // value = 0; //} } else{ value = -1; } } return
	 * value; }
	 */

	/*
	 * In your model, write a method that returns an instance of a Shape, given
	 * a set of x and y coordinates. You will need to search your Vector or
	 * Array list. If no object contains those coordinates, return null.
	 */
	/**
	 * @param clickX
	 * @param clickY
	 * @return
	 */
	public Shape findClickedShape(int clickX, int clickY) {

		// Remember that: All Shapes have x and y position properties
		// Our shapes are kept in an instance of this model class in a property
		// called shape
		// The x,y position of a shape can be compared to the x,y position of a
		// click,
		// by adding the width and height values to the click position and
		// comparing the ranges with the
		// click x,y position
		// The abstract class Shape requires implementation of a
		// containsLocation() method
		// This can be used to compare the click x,y position.

		// Reverse loop through all of the shapes to see if any of them were
		// clicked

		int size = shapes.size();

		for (int i = size; i > 0; i--) {
			Shape it = shapes.get(i - 1);
			boolean within = it.containsLocation(clickX, clickY);

			// Evaluate the boolean value
			if (within) {
				// Return the shape
				return it;
			}
		}

		// Execution only arrives here if no shape was found containing the x,y
		// location
		return null;
	}

	public Color getCurrentLineColor() {
		return currentLineColor;
	}

	public Color getCurrentFillColor() {
		return currentFillColor;
	}

	/**
	 * @return Homework 7 Give your Model.createShape() the ability to make
	 *         whatever shape the Model.currentShapeType variable (created in
	 *         the last project) indicates.
	 */
	public Shape createShape() {
		if (currentShapeType == ShapeType.RECTANGLE) {
			currentShape = new Rectangle(currentLineColor, 0, 0, 50, 50,
					currentFillColor, fill);
		}
		if (currentShapeType == ShapeType.OVAL) {
			// Create a new Oval with zeros and nulls for position, size, fill
			// color, and fill
			currentShape = new Oval(currentLineColor, 0, 0, 50, 50,
					currentFillColor, fill);
		}
		if (currentShapeType == ShapeType.POLYTRI) {
			currentShape = new PolyTriangle(currentLineColor, 0, 0, 50, 50,
					currentFillColor, fill);
		}
		if (currentShapeType == ShapeType.POLYOCTAGON) {
			currentShape = new PolyOctagon(currentLineColor, 0, 0, 50, 50,
					currentFillColor, fill);
		}
		// Homework 9
		// Allow the user to draw two Shapes, which when instantiated,
		// get put into the array.(store the shapes in the createShape() method.
		// When a third figure is drawn, reset the array and allow the process
		// to repeat.
		/*
		 * if (shapes[0] != null){ if (shapes[1] != null){ shapes[1]=null;
		 * shapes[0]=currentShape; }else{ shapes[1]=currentShape; } } else{
		 * shapes[0]=currentShape; }
		 */

		// Homework 10
		// Each time something is drawn, it should stay until it is removed
		// (no need to implement the Remove action yet).
		// Since objects are stored in vectors as Objects, you will need to cast
		// them back to Shape to have access to the correct draw methods.
		shapes.add(currentShape);

		return currentShape;
	}

	/**
	 * Model constructor
	 * 
	 * @param container
	 *            An Applet is-a Container. The Container parameter accepts an
	 *            Applet object which becomes a property of this Model
	 * 
	 */
	public Model(Container container) {
		// Local reference of Applet
		this.container = container;

		// Set the default values of the UI components
		this.resetComponents();
	}

	/**
	 * This is how the Applet can be made to repaint itself by the Model
	 */
	public void repaint() {
		// This method call is sent to the repaint method of the Applet object
		container.repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.Resettable#resetComponents()
	 */
	public void resetComponents() {

		// Default colors
		this.setCurrentFillColor(Color.RED);
		this.setCurrentLineColor(Color.RED);

		// Default action
		action = ShapeAction.DRAW;

		currentShape = null;
		fill = false;
		// Does the Applet object implement the Resettable interface?
		if (container instanceof Resettable) {
			// If so, call the resetComponents() method of the Applet
			((Resettable) container).resetComponents();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Model:\n\tAction: " + action + "\n\tFill: " + fill;
	}

	public ShapeAction getAction() {
		return action;
	}

	public void setAction(ShapeAction action) {
		this.action = action;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public ShapeType getCurrentShapeType() {
		return currentShapeType;
	}

	public void setCurrentShapeType(ShapeType currentShapeType) {
		this.currentShapeType = currentShapeType;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Shape getCurrentShape() {
		return currentShape;
	}

	public void setCurrentShape(Shape currentShape) {
		this.currentShape = currentShape;
	}

	public void setCurrentLineColor(Color color) {
		this.currentLineColor = color;

	}

	public void setCurrentFillColor(Color color) {
		this.currentFillColor = color;

	}
}