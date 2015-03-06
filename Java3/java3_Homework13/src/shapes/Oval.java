package shapes;

import interfaces.ComparableShape;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rectangle implements ComparableShape {
	int area;
	
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

    public void setArea(){
    	// http://courses.oreillyschool.com/java3/java309.html
        // not necessarily a circle, so rather than PI*r*r, 
        // we have for ellipses PI*a*b where a and b are half of width and height
        area = (int)(
        		Math.PI *
        		.5 *
        		super.getWidth() * 
        		.5 *
        		super.getHeight()
        );   
    }
    
	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return area;
	}
}