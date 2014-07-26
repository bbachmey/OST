import java.applet.Applet;
import java.awt.*;

public class FirstLine extends Applet {
	@Override
	public void paint(Graphics g){
		g.drawLine(20, 10, 200, 10);
		
		g.fillRect(20, 50, 20, 20);
	}
}
