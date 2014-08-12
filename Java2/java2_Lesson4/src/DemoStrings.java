import java.applet.Applet;
import java.awt.*;


public class DemoStrings extends Applet {

	@Override
	public void start(){
		
	}
	
	public void paint(Graphics g){
		int y = 15;
		String str = "Java is hot";
		g.drawString(str, 10, y*1);
		String modify = str.replace("v","bb").replace('o','u').replace("is", "the");
		g.drawString(str.substring(0,7) + " still" + str.substring(7,11), 10, y*2);
		g.drawString("But used to make: ", 10, y*4);
		g.drawString(modify, 10, y*5);
		
        
	}

}
