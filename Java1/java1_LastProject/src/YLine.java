import java.awt.Color;
import java.awt.Graphics;


public class YLine extends MathShape {
	MathPoint center;
	int length;
	int thick;
	
	YLine(MathPoint cen, int len){
		super(Color.BLACK);
		this.center = cen;
		this.length = len;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.drawLine(
				(int)center.getX(), 
				(int)center.getY()+(length/2), 
				(int)center.getX(), 
				(int)center.getY()-(length/2)
				);
		
		g.setColor(Color.BLACK);
		
	}
}
