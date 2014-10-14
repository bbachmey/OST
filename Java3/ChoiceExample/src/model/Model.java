package model;

import java.awt.Container;
import view.ChoiceApplet;
import interfaces.Resettable;

public class Model implements Resettable{
  
    private Container view;
    private String message;
    
    public static String[] selections = {"The Beatles", "John", "Paul", "George", "Ringo"};
    
    public Model(Container view) {
        this.view = view;
        message = selections[0];
    }
    
    public void setMessage(String msg) {
        this.message = msg;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void repaint() {
        view.repaint();
    }
    
    public void resetComponents() {
        //cast view to a Resettable type in order to see resetComponents().
        ((Resettable)view).resetComponents();
        repaint();
    }
}