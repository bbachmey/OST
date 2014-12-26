package event;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;

public class ShapeMouseHandler extends MouseAdapter {
    private Model model;
    //Start x and y location used to mark where the upper left corner of a
    //shape is.
    private int startX;
    private int startY;
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
        if (model.getAction() == Model.DRAW) {
            // original upper left x and y of the shape.
            startX = e.getX();
            startY = e.getY();
            // have the model create a new shape for us.
            shape = model.createShape();
            // if the shape was created.
            if (shape != null) {
            	//set its upper left x and y to where the mouse was pressed.
                shape.setX(e.getX());
                shape.setY(e.getY());
                // We should set a default width and height or ending location in
                // case the user does not drag the mouse.
                // Currently we only have instances of Rectangle or its descendants.
                if (shape instanceof Rectangle) {
                	//set the shape size
                    ((Rectangle) shape).setWidth(50);
                    ((Rectangle) shape).setHeight(50);
                }
                else {
                    ((Triangle) shape).setWidth(50);
                    ((Triangle) shape).setHeight(50);
                	
                }
            }
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

        
        // if there is a current shape in the model.
        if (shape != null) {
        	
            // if we are in DRAW mode.
            if (model.getAction() == Model.DRAW) {
                // set the x and y location of the shape (allows rubber banding).
                shape.setX(Math.min(startX, e.getX()));
                shape.setY(Math.min(startY, e.getY()));
            }
            // if the shape is an instance of Rectangle or a descendant of Rectangle
            if (shape instanceof Rectangle) {
                // set its width and height.
                // allows for rubber banding.
                ((Rectangle) shape).setWidth(Math.abs(startX - e.getX()));
                ((Rectangle) shape).setHeight(Math.abs(startY - e.getY()));
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