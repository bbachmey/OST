package model;

import interfaces.Resettable;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import shapes.Oval;
import shapes.PolyOctagon;
import shapes.PolyTriangle;
import shapes.Rectangle;
import shapes.Shape;
import enums.ShapeAction;
import enums.ShapeType;

/**
 * Model class hold all data for the application
 * 
 * @author bbachmey
 * 
 */
public class Model implements Resettable {
	
	// Container object
	private Container container;
	
	// Fill option
	private boolean fill;

	// Shape action
	private ShapeAction action;

	// Array of Strings for the shape choice
	public final static String[] choices = { 
		ShapeType.RECTANGLE.getName(),
		ShapeType.OVAL.getName(), 
		ShapeType.POLYTRI.getName(),
		ShapeType.POLYOCTAGON.getName() 
		};

	// Current shape type
	private ShapeType currentShapeType;

	// Current shape
	private Shape currentShape;

	// Hash map of colors
	public static final LinkedHashMap<String, Color> COLORS = new LinkedHashMap<String, Color>() {
		{
			put("Red", Color.RED);
			put("White", Color.WHITE);
			put("Blue", Color.BLUE);
			put("Black", Color.BLACK);
			put("Orange", Color.ORANGE);
			put("Pink", Color.PINK);
			put("Yellow", Color.YELLOW);
			put("Magenta", Color.MAGENTA);
		}	
	};

	// Color object for the model to keep track of the current Color
	public Color currentLineColor;
	public Color currentFillColor;

	// Shapes collection
	public ArrayList<Shape> shapes = new ArrayList<Shape>();

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
	 * Make a shape
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

		// Add the current shape to the shapes collection
		shapes.add(currentShape);

		return currentShape;
	}


	/**
	 * Take two int values and figure out if the Shape in question contains the
	 * x and y
	 * 
	 * @param clickX
	 * @param clickY
	 * @return
	 */
	public Shape findClickedShape(int clickX, int clickY) {

		int size = shapes.size();
		
		// Reverse loop through all of the shapes to see if any of them were
		// clicked
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

	public ShapeAction getAction() {
		return action;
	}

	public Container getContainer() {
		return container;
	}

	public Color getCurrentFillColor() {
		return currentFillColor;
	}

	public Color getCurrentLineColor() {
		return currentLineColor;
	}

	public Shape getCurrentShape() {
		return currentShape;
	}

	public ShapeType getCurrentShapeType() {
		return currentShapeType;
	}

	public boolean isFill() {
		return fill;
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

		// No current shape
		currentShape = null;
		
		// No fill
		fill = false;
		
		// No shapes
		shapes =  new ArrayList<Shape>();
		
		// Default shape type
		currentShapeType = ShapeType.RECTANGLE;
		
		// Does the Applet object implement the Resettable interface?
		if (container instanceof Resettable) {
			// If so, call the resetComponents() method of the Applet
			((Resettable) container).resetComponents();
		}
	}

	public void setAction(ShapeAction action) {
		this.action = action;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public void setCurrentFillColor(Color color) {
		this.currentFillColor = color;

	}

	public void setCurrentLineColor(Color color) {
		this.currentLineColor = color;

	}

	public void setCurrentShape(Shape currentShape) {
		this.currentShape = currentShape;
	}

	public void setCurrentShapeType(ShapeType currentShapeType) {
		this.currentShapeType = currentShapeType;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Model:\n\tAction: " + action + "\n\tFill: " + fill;
	}
}