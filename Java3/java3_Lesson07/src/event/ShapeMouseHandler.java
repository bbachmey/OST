package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.Rectangle;
import shapes.Shape;

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
                    ((Rectangle) shape).setWidth(50);
                    ((Rectangle) shape).setHeight(50);
                }
            }
        }
        // tell the model to repaint the applet or application.
        model.repaint();
    }
}