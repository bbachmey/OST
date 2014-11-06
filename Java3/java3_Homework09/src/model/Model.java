package model;

import java.awt.Color;

import shapes.Oval;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

import java.awt.Container;  
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import interfaces.Resettable;

public class Model implements Resettable{
	//declare a Container object
    private Container container;
    //by default, action is draw
    private String action = DRAW;
    //by default, no fill
    private boolean fill = false;
    
    //declare a set of String constants
    public final static String DRAW = "Draw";
    public final static String MOVE = "Move";
    public final static String REMOVE = "Remove";
    public final static String RESIZE = "Resize";
    public final static String CHANGE = "Change";
    public final static String FILL = "Fill";
    
    //Lesson 6
    //create final static String variables to represent the different Shape types, 
    //"Rectangle," "Oval," etc. Use these variables to fill your Choice component.
    public final static String RECTANGLE = "Rectangle";
    public final static String OVAL = "Oval";
    public final static String TRIANGLE = "Triangle";
    
    //Make an array of Strings for the shape choice
    public final static String [] choices = {RECTANGLE, OVAL, TRIANGLE};
    
    //Lesson 6
    //create a String instance variable named currentShapeType and set it to whatever 
    // your default shape will be (using the final static String variables you just created). 
    private String currentShapeType = RECTANGLE;

    //Lesson 7
    private Shape currentShape;

    //Homework 8    
    //public final static Color BLACK = Color.BLACK;
    //public final static Color WHITE = Color.WHITE;    
    //Make an array of the choice Strings
    public static final Map<String, Color> COLORS = new HashMap<String , Color>() {
    	{
        put("Black", Color.BLACK);
        put("White", Color.WHITE);
        put("Orange",   Color.ORANGE);
        put("Red",   Color.RED);
        put("Blue",   Color.BLUE);
        put("Magenta",   Color.MAGENTA);
        put("Yellow",   Color.YELLOW);
        put("Pink",   Color.PINK);
    	}
    };
    
    //declare a Color object for the model to keep track of the current Color
	public Color currentLineColor;
	public Color currentFillColor;
    
	//Homework 9
	//In the model of your java3_Homework09 project, add an array 
	//of type Shape of size 2 as an instance variable. (in the Model class)
	public Shape [] shapes = new Shape[2];
	
	//Homework 9
	//Add a method to your model called compareShapes(), which will return 
	//either 0, 1, or 2--1 if the area of the first Shape is bigger than the 
	//second, 2 if it is smaller, and 0 if the two Shapes are the same size.
	public int compareShapes(){
		
		
		return 0;
	}
    
    public Color getCurrentLineColor() {
		return currentLineColor;
	}


	public Color getCurrentFillColor() {
		return currentFillColor;
	}


	/**
     * @return
     * Homework 7
     * Give your Model.createShape() the ability to make whatever shape 
     * the Model.currentShapeType variable (created in the last project) indicates.
     */
    public Shape createShape() { 
        if(currentShapeType == RECTANGLE){
            currentShape =  new Rectangle(currentLineColor, 0, 0, 0, 0, currentFillColor, fill);
          }
        if(currentShapeType == OVAL){
            currentShape =  new Oval(currentLineColor, 0, 0, 0, 0, currentFillColor, fill);
          }
        if(currentShapeType == TRIANGLE){
            currentShape =  new Triangle(currentLineColor, 0, 0 );
          }
        //Homework 9
        //Allow the user to draw two Shapes, which when instantiated, 
        //get put into the array.(store the shapes in the createShape() method.
        shapes[0]=currentShape;
        
        return currentShape;
    }
    
  
    /**
     * Model constructor
     * @param container
     * An Applet is-a Container. The Container parameter accepts an Applet object 
     * which becomes a property of this Model
     * 
     */
    public Model (Container container) {
        this.container = container;
    }
  
    /**
     * 
     */
    public void repaint() {
    	//This method call is sent to the repaint method of the Applet object
        container.repaint();
    }
  
    /* (non-Javadoc)
     * @see interfaces.Resettable#resetComponents()
     */
    public void resetComponents() {
        action = DRAW;

        currentShape = null;
        fill = false;
        //Does the Applet object implement the Resettable interface?
        if(container instanceof Resettable) {
        	//If so, call the resetComponents() method
            ((Resettable)container).resetComponents();
        }
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Model:\n\tAction: " + action + "\n\tFill: " + fill;
    }

    public String getAction() {
        return action;
    }
  
    public void setAction(String action) {
        this.action = action;
    }
  
    public boolean isFill() {
        return fill;
    }
  
    public void setFill(boolean fill) {
        this.fill = fill;
    }
  
	public String getCurrentShapeType() {
		return currentShapeType;
	}

	public void setCurrentShapeType(String currentShapeType) {
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