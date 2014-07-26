
import java.applet.Applet;
import java.awt.Graphics;

public class MyName extends Applet {
    public void paint(Graphics g) {
        g.drawRect(0, 0, 100, 100);
        g.drawString("Hello, my name is Brian.", 5, 150);
        
    }
}