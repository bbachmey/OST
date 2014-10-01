package shapes;

import java.awt.Color;

public class Shape {
	Color outline;
	Color fill;

	public Shape(){
		outline = Color.BLACK;
		fill = Color.BLACK;
		
	}

	public Shape(
			Color outline, 
			Color fill){

		this.outline = outline;
		this.fill = fill;
	}

	public void draw() {
	}
	
	public void move() {
	}
	
	public void resize() {
	}
	
	public void remove() {
	}
	
	public void change() {
	}

	public Color getOutline() {
		return outline;
	}
	public void setOutline(Color outline) {
		this.outline = outline;
	}
	public Color getFill() {
		return fill;
	}
	public void setFill(Color fill) {
		this.fill = fill;
	}

}
