import java.awt.Color;
import java.awt.Graphics;


public abstract class MathShape {
	Color color;

	MathShape(){
		//the no-constructor color is BLACK
		this.color = Color.BLACK;
	}
	
	MathShape(Color c){
		this.color = c;
	}
	//every math shape has to have a draw method
	public abstract void draw(Graphics g);
	
}
