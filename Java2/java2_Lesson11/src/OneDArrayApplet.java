import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
     
public class OneDArrayApplet extends Applet {
	/* DECLARATIONS */
    private final int START_X = 25;
    private final int START_Y = 70;
    private final int BOX_WIDTH = 60;
    private final int BOX_HEIGHT = 20;
    //declare an array of 6 boxes
    private ClickableBox[] boxes = new ClickableBox[6];
    private Color[] boxColors = { Color.blue, Color.red, Color.green, Color.cyan,
         Color.magenta, Color.yellow };
    private Button resetColors = new Button("Reset Colors");
    
    /* METHODS */
    public void init() {
    	//loop through the declared length of the boxes array
        for (int i = 0; i < boxes.length; i++) {
        	//create a ClickableBox object and add it to the array
            boxes[i] = new ClickableBox(START_X, START_Y + i * BOX_HEIGHT, BOX_WIDTH,
               BOX_HEIGHT, Color.black, Color.red, true, this);
            //add the applet to the ClickableBox as a mouse listener
            this.addMouseListener(boxes[i]);
        }
        
        //set the default box colors
        defaultBoxColors();
        
        //add an action listener to the Reset buton
        resetColors.addActionListener(new ActionListener() {
            //
        	//this is what the button will do
        	public void actionPerformed(ActionEvent e) {
                defaultBoxColors();
                repaint();  
            }
            //
        	//
         });
        
        //add the button to the applet
         this.add(resetColors);
    }

    public void paint(Graphics g) {
    	//loop through the 
        for(int i = 0; i < boxes.length; i++) {
        	//check to see if the clicked value is true
            if(boxes[i].isClicked()) {
            	//set the background to a random color
                boxes[i].setBackColor(new Color(
                  (int)(Math.random() * 256), 
                  (int)(Math.random() * 256), 
                  (int)(Math.random() * 256)));
                //reset the clicked value
                boxes[i].setClicked(false);
            }
            //draw the box on the Graphics object
            boxes[i].draw(g);
        }
    }
    
    public void defaultBoxColors() {
    	//loop through the boxes and set the background color of each
        for(int i = 0; i < boxes.length; i++) {
            boxes[i].setBackColor(boxColors[i]);
        }
    }
    
}