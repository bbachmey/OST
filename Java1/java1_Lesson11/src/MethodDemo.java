
import java.applet.Applet;
import java.awt.*;


/**
 * @author bbachmey
 * This class is an applet with a method 
 * that draws two triangles
 */
public class MethodDemo extends Applet {

    public void paint(Graphics g) {
        drawHouse(g, 10, 100, 70, 30);
        drawHouse(g, 100, 50, 60, 20);
    }
      
    private void drawTriangle(Graphics g, int bottomX, int bottomY, int base, int height){
        int rightX = bottomX + base;
        g.drawString("rightX in the method is " + rightX, 5,185);
        int topX = bottomX + base/2;
        int topY = bottomY - height;
            
        g.drawLine(bottomX, bottomY, rightX, bottomY);
        g.drawLine(rightX, bottomY, topX, topY);
        g.drawLine(topX, topY, bottomX, bottomY);
    }
        
    private void drawHouse(Graphics g, int bottomX, int bottomY, int width, int height){
        int rightX = bottomX + width;
        int topX = bottomX + width/2;
        int topY = bottomY - height;
        int halfHeight = height/2;
     
        g.drawRect(bottomX, topY, width, height);
        this.drawTriangle(g, bottomX, topY, width, halfHeight);
    }

}
