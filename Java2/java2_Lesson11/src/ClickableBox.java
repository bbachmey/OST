import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
     
public class ClickableBox extends MouseAdapter {
     
    private int x, y, width, height;
    private Color borderColor, backColor, oldColor;
    private boolean drawBorder;
     
    public ClickableBox(int x, 
    		int y, 
    		int width, 
    		int height, 
    		Color borderColor, 
    		Color backColor,
    		boolean drawBorder) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.backColor = backColor;
        this.drawBorder = drawBorder;
    }
    
    public void draw(Graphics g) {
        oldColor = g.getColor();
        g.setColor(backColor);
        g.fillRect(x, y, width, height);
        if(drawBorder) {
            g.setColor(borderColor);
            g.drawRect(x, y, width, height);
        }
        g.setColor(oldColor);
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getBackColor() {
		return backColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	public Color getOldColor() {
		return oldColor;
	}

	public void setOldColor(Color oldColor) {
		this.oldColor = oldColor;
	}

	public boolean isDrawBorder() {
		return drawBorder;
	}

	public void setDrawBorder(boolean drawBorder) {
		this.drawBorder = drawBorder;
	}
    
}