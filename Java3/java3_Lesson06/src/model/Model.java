package model;

import java.awt.Container;  
import interfaces.Resettable;

public class Model implements Resettable{
    private Container container;
    // Cut and paste these from the ActionPanel class, then make them public and static 
    public final static String DRAW = "Draw";
    public final static String MOVE = "Move";
    public final static String REMOVE = "Remove";
    public final static String RESIZE = "Resize";
    public final static String CHANGE = "Change";
    public final static String FILL = "Fill";
  
    private String action = DRAW;
    private boolean fill = false;
  
    public Model (Container container) {
        this.container = container;
    }
  
    public void repaint() {
        container.repaint();
    }
  
    public void resetComponents() {
        action = DRAW;
        fill = false;
        if(container instanceof Resettable) {
            ((Resettable)container).resetComponents();
        }
    }
}