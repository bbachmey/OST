package shapes;

import java.awt.Color;

public class Shape {
	Color color;
	int x;
	int y;

	public Shape(){
		color = Color.BLACK;
		
	}

	public Shape(int x, int y, Color c){

		this.x = x;
		this.y = y;
		this.color = c;
		
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
}
