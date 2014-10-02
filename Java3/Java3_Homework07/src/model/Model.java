package model;

import java.awt.Color;

import shapes.Oval;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

import java.awt.Container;  

import interfaces.Resettable;

public class Model implements Resettable{

	private Container container;

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
    //Homework 7
    public static String[] choices = {RECTANGLE, OVAL, TRIANGLE};
    
    //Lesson 6
    //create a String instance variable named currentShapeType and set it to whatever 
    // your default shape will be (using the final static String variables you just created). 
    private String currentShapeType = RECTANGLE;

    //Lesson 7
    private Shape currentShape;
    
    /**
     * @return
     * Homework 7
     * Give your Model.createShape() the ability to make whatever shape 
     * the Model.currentShapeType variable (created in the last project) indicates.
     */
    public Shape createShape() { 
        if(currentShapeType == RECTANGLE){
            currentShape =  new Rectangle(0, 0, 0, 0, Color.black, Color.red, fill);
          }
        if(currentShapeType == OVAL){
            currentShape =  new Oval(0, 0, 0, 0, Color.black, Color.red, fill);
          }
        if(currentShapeType == TRIANGLE){
            currentShape =  new Triangle(0, 0, Color.black);
          }
        return currentShape;
    }
    
    private String action = DRAW;
    private boolean fill = false;
  
    /**
     * @param container
     * The Container being passed to this constructor is GUIDemo
     */
    public Model (Container container) {
        this.container = container;
    }
  
    /**
     * 
     */
    public void repaint() {
        container.repaint();
    }
  
    /* (non-Javadoc)
     * @see interfaces.Resettable#resetComponents()
     */
    public void resetComponents() {
        action = DRAW;

        currentShape = null;
        fill = false;
        if(container instanceof Resettable) {
        	//This is a call to the resetComponents() method of GUIDemo
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
}