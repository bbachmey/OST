import java.awt.Color;
import java.awt.Graphics;


public class Head extends Part {

	public Head(Color c, int x, int y, int w, int h) {
		super(c, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		//draw the oval
		g.fillOval(this.getxPos(), this.getyPos(), this.getWidth(), this.getHeight());

	}
	
}
