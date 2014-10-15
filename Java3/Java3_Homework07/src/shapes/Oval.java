package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rectangle {
    /**
    * Constructor.  Just passes the params to the Rectangle constructor.
    */
    public Oval(
    		Color lineColor, 
    		int x, 
    		int y, 
    		int w, 
    		int h, 
    		Color fillColor, 
    		boolean fill
    		){
        super(lineColor, x, y, w, h, fillColor, fill);
    }
  
    /*
    * Override Rectangle draw(Graphics g) method.
    */
    public void draw(Graphics g) {
        // Be nice. Save the state of the object before changing it.
        Color oldColor = g.getColor();
        if (isFill()) {
            g.setColor(getFillColor());
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
        g.setColor(getLineColor());
        g.drawOval(getX(), getY(), getWidth(), getHeight());
        // Set the state back when done.
        g.setColor(oldColor);
    }
  
    /**
    * Returns a String that represents this object.
    */
    public String toString() {
        return "Oval: \n\tx = " + getX() + "\n\ty = " + getY() + "\n\tw = " + getWidth() + "\n\th = " + getHeight();
    }
}