import java.applet.Applet;
import java.awt.Graphics;


public class JarExampleApplet extends Applet {

	public void paint(Graphics g){
		g.drawString("This applet was read from a JAR file", 0, 25);
	}
	
}
