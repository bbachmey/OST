import java.applet.Applet;
import java.awt.Graphics;



public class NameTest extends Applet {

	public void paint(Graphics g){
		String str = "Java is Cool";
		g.drawString(str.replace("Java",  "Brian"), 30, 30);
		
	}

}
