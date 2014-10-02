package model;

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
    //Lesson 6
    //create a String instance variable named currentShapeType and set it to whatever 
    // your default shape will be (using the final static String variables you just created). 
    private String currentShapeType = RECTANGLE;

    
    private String action = DRAW;
    private boolean fill = false;
  
    /**
     * @param container
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
        fill = false;
        if(container instanceof Resettable) {
            ((Resettable)container).resetComponents();
        }
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
  
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Model:\n\tAction: " + action + "\n\tFill: " + fill;
    }

	public String getCurrentShapeType() {
		return currentShapeType;
	}

	public void setCurrentShapeType(String currentShapeType) {
		this.currentShapeType = currentShapeType;
	}
}