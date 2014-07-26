
import java.awt.*;
import java.applet.Applet;


public class MyPicture extends Applet {
	public void init(){
		this.setBackground(Color.LIGHT_GRAY.darker());
	}

	public void paint(Graphics g){
		g.drawLine(0,0,100,100);
		g.setColor(Color.RED.darker());
		g.fillOval(45,15,40,40);
		
		g.setColor(Color.GREEN);
		g.fillRect(5,5,4,95);
		g.fillRect(65,65,4,35);
		
		g.setColor(Color.black);
		g.drawLine(100,100,200,100);

	}
}
