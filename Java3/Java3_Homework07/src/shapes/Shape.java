package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author bbachmey
 *
 */
public abstract class Shape {
	//all Shapes have x and y positions and a line Color
    private int x, y;
    private Color lineColor;
  
    /**
     * @param x
     * @param y
     * @param lineColor
     * 
     * The constructor requires all three Shape properties
     */
    public Shape(int x, int y, Color lineColor) {
        this.x = x;
        this.y = y;
        this.lineColor = lineColor;
    }
  
    //Abstract methods must be implemented by subclasses
    public abstract void draw(Graphics g);
    public abstract boolean containsLocation(int x, int y);
  
    //getters and setters
    public int getX() {
        return x;
    }
  
    public void setX(int x) {
        this.x = x;
    }
  
    public int getY() {
        return y;
    }
  
    public void setY(int y) {
        this.y = y;
    }
  
    public Color getLineColor() {
        return lineColor;
    }
  
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }
}