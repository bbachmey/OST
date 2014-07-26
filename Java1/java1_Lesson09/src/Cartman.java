import java.awt.*;

public class Cartman {
	Graphics g;
	public Cartman(Graphics graph){
		this.g = graph;
	}
	
	public void drawMe(){
		
		//face
		g.setColor(Color.PINK);
		g.fillOval(10,30, 180, 150);
		
		//eyes
		g.setColor(Color.white);
		g.fillOval(50, 66, 35, 53);
		g.fillOval(78,66,35,53);
		
		//eyeballs
		g.setColor(Color.BLACK);
		g.fillOval(63,86,10,10);
		g.fillOval(90,86,10,10);
		
		//mouth
		g.setColor(Color.black);
		int [] xValues = {56,89,109};
		int [] yValues = {140,150,140};
		Polygon shapeThing = new Polygon(xValues, yValues, 3);
		//g.fillPolygon(xValues, yValues, 3);
		g.fillPolygon(shapeThing);
		
	}

}
