import java.applet.Applet;
import java.awt.*;


public class JavaFont extends Applet {
	Font bigFont = new Font("Serif", Font.BOLD, 56);
	//Font smallFont = new Font("Helvetica", Font.PLAIN, 20);
	Font smallFont = new Font("Helvetica", 3, 20);
	
	//Make a dark read for OST
	private static final Color leafRed = new Color(115, 0, 0);
	
	String line1 = "JAVA";
	String line2 = "O'REILLY";
	
	public void paint(Graphics g){
		//draw the text 
		g.setColor(leafRed);
		g.setFont(bigFont);
		g.drawString(line1,  15,  100);
		g.setFont(smallFont);
		g.drawString(line2,  46,  140);
		
	}

}
