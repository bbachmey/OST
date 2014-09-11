import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

public class TickableBox extends ClickableBox {
	Container parent;
	private char [] boxMark;
	Font font;

	public TickableBox(
			int x, 
			int y, 
			int width, 
			int height, 
			Color borderColor,
			Color backColor, 
			boolean drawBorder, 
			Container parent) {

		super(
				x, 
				y, 
				width, 
				height, 
				borderColor, 
				backColor, 
				drawBorder, 
				parent);

		this.parent = parent;
		//this is the default box mark
		this.boxMark = new char[1];
		this.boxMark[0] = 0; //NUL char is 0
		//set the font
		font = new Font(
				Font.SERIF,
	            Font.BOLD,
	            60);
	}

	public void draw(Graphics g) {
		//set the color of the pen
		g.setColor(super.getBackColor());
		//call the fillRect method on the Graphics object to draw a square that represents the box
		g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
		//isDrawBorder is a property defined in the ClickableBox class
		if(super.isDrawBorder()) {
			//change the pen color
			g.setColor(super.getBorderColor());
			//draw a square of a different color around the filled-in square
			g.drawRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
		}

		g.setFont(font);
		g.drawChars(
				this.getBoxMark(), //data - the array of characters to be drawn
				0, //offset - the start offset in the data
				1, //length - the number of characters to be drawn
				(int)(super.getX() + (super.getWidth() * .2) ), //x - the x coordinate of the baseline of the text
				(int)(super.getY() + (super.getHeight() * .8) )   //y - the y coordinate of the baseline of the text
				);

	}

	public void changeBoxMark(char boxMark) {
		this.boxMark[0] = boxMark;
	}
	
	public char[] getBoxMark() {
		return boxMark;
	}

	public void setBoxMark(char[] boxMark) {
		this.boxMark = boxMark;
	}




}   