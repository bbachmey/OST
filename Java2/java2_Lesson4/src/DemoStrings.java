import java.applet.Applet;
import java.awt.*;


public class DemoStrings extends Applet {

	@Override
	public void start(){
		
	}
	
	public void paint(Graphics g){
		int length = 200;
		int width = 400;
		

        g.drawString("The area of this window is the length times the width", 10, 20);
        g.drawString("Our width is " + width +  " pixels, and length is " + length, 10, 40);
        //g.drawString("The area of this rectangle is " + (width * length), 10, 70);

        g.drawString("The perimeter of this rectangle is " + (2*width) + (2*length), 10, 70);
        
	}

}
