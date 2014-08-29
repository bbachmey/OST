import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
     
public class OneDArrayApplet extends Applet {
    private final int START_X = 25;
    private final int START_Y = 70;
    private final int BOX_WIDTH = 60;
    private final int BOX_HEIGHT = 20;
     
    private ClickableBox[] boxes = new ClickableBox[6];
    
    private Color[] boxColors = { Color.blue, Color.red, Color.green, Color.cyan,
         Color.magenta, Color.yellow };
     
    public void init() {
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new ClickableBox(START_X, START_Y + i * BOX_HEIGHT, BOX_WIDTH,
               BOX_HEIGHT, Color.black, Color.red, true);
        }
        defaultBoxColors();
    }

    public void paint(Graphics g) {
        for(int i = 0; i < boxes.length; i++) {
            boxes[i].draw(g);
        }
    }
    
    public void defaultBoxColors() {
        for(int i = 0; i < boxes.length; i++) {
            boxes[i].setBackColor(boxColors[i]);
        }
    }
    
}