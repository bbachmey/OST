import java.awt.Color;
import java.awt.Graphics;


public class Box {
	//declare instance variables
	private int upperLeftX;
	private int upperLeftY;
	private int height;
	private int width;
	private Color boxColor;
	
	public Box(int upperX, int upperY, int h, int w, Color myColor){
		//use the parameter to set the instance variables
		this.setUpperLeftX(upperX);
		this.setUpperLeftY(upperY);
		this.setHeight(h);
		this.setWidth(w);
		this.setBoxColor(myColor);
	}
	
	void display(Graphics g){
		//call set and fill methods on the Graphics object
		g.setColor(boxColor);
		g.fillRect(upperLeftX, upperLeftY, width, height);
		
	}
	
	//getters and setters
	public int getUpperLeftX() {
		return upperLeftX;
	}
	public void setUpperLeftX(int upperLeftX) {
		this.upperLeftX = upperLeftX;
	}
	public int getUpperLeftY() {
		return upperLeftY;
	}
	public void setUpperLeftY(int upperLeftY) {
		this.upperLeftY = upperLeftY;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Color getBoxColor() {
		return boxColor;
	}
	public void setBoxColor(Color boxColor) {
		this.boxColor = boxColor;
	}

}
