import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


/**
 * @author bbachmey 
 * @goal Use arrays to display 8 colored boxes on the screen.
 * It should have 8 colored boxes on the graphics area, each getting its color 
 * from one of the slots in the colors array. 
 * @instructions Create a class in that project named ArrayTest that extends Applet.
 * Create an instance variable, say colorArray that is an array that will hold 8 Color references.
 * 
 * Create a void method named generateColors()that fills the colorArray with 8 Color objects of your choice. 
 * They can be any of the Color constants from the Color class or you can build your own new Color() objects.
 * 
 * Create an init() method that calls the generateColors() method of your applet.
 * 
 * You should create a paint(Graphics g) method that fills 8 rectangles, each at least 30x30 pixels and 
 * each with a different Color from the array.
 * 
 * You will need to change the color of the Graphics object before each g.fillRect() method call.
 * If you understand loops, feel free to use them but they are not required for this project. 
 * 
 * 8 calls to g.fillRect() are sufficient.
 * 
 */
public class ArrayTest extends Applet {
	Color[] colorArray;
	
	public void generateColors(){
		//instantiate the array
		colorArray = new Color[8];
		//fill the array
		colorArray[0]=Color.BLUE;
		colorArray[1]=Color.RED;
		colorArray[2]=Color.GREEN;
		colorArray[3]=Color.ORANGE;
		colorArray[4]=Color.PINK;
		colorArray[5]=Color.CYAN;
		colorArray[6]=Color.MAGENTA;
		colorArray[7]=Color.YELLOW;
		
	}
	
	@Override
	public void init(){
		generateColors();
		
	}

	@Override
	public void paint(Graphics g) {
		//super.paint(g);

		int i=0;
		for (Color c : colorArray){
			int xpos = 10;
			int ypos = 10;
			int width = 20;
			int height = 20;
			
			g.setColor(c);
			g.fillRect(xpos,ypos+(i*height),width,height); 
			
			i++;
		}
		
	}
	

}
