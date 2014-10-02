package shapes;

import java.awt.Color;

/**
 * @author bbachmey
 *
 */
public abstract class Shape {
	Color outline;
	Color fill;

	/**
	 * 
	 */
	public Shape(){
		outline = Color.BLACK;
		fill = Color.BLACK;
		
	}

	/**
	 * @param outline
	 * @param fill
	 */
	public Shape(
			Color outline, 
			Color fill){

		this.outline = outline;
		this.fill = fill;
	}

	/**
	 * This is an abstract method because different shapes need to be drawn differently
	 */
	public abstract void draw();
	
	/**
	 * This is an abstract method because different shapes have different position properties
	 */
	public abstract void move();
	
	/**
	 * This is an abstract method because different shapes have different size properties
	 */
	public abstract void resize();
	
	/**
	 * 
	 */
	public void remove() {
	}
	
	/**
	 * 
	 */
	public void change() {
	}

	/**
	 * @return
	 */
	public Color getOutline() {
		return outline;
	}
	/**
	 * @param outline
	 */
	public void setOutline(Color outline) {
		this.outline = outline;
	}
	/**
	 * @return
	 */
	public Color getFill() {
		return fill;
	}
	/**
	 * @param fill
	 */
	public void setFill(Color fill) {
		this.fill = fill;
	}

}
