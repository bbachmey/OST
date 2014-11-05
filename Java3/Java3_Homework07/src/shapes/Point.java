package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	public Point(
			Color lineColor,
			int x, 
			int y
			){
		super(lineColor, x, y);
	}
	
	@Override
	public void draw(Graphics g) {

        // Jot down the Color of the Graphics object
        Color jot = g.getColor();
        g.setColor(getLineColor());
        g.drawOval(getX(), getY(), 1, 1);

        // Re-jot the Color
        g.setColor(jot);
		
	}

	@Override
	public boolean containsLocation(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
