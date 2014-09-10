import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

public class TickableBox extends ClickableBox {
    private boolean mask;
    private Color maskColor;
    Container parent;
    private boolean matched;

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
    }
  
    public void draw(Graphics g) {
        super.draw(g);
        if(mask) {
            setOldColor(g.getColor());
            g.setColor(maskColor);
            g.fillRect(getX(), getY(), getWidth(), getHeight());
            if(isDrawBorder()) {
                g.setColor(getBorderColor());
                g.drawRect(getX(), getY(), getWidth(), getHeight());
            }
            g.setColor(getOldColor());
        }
    }
  
    public boolean isMask() {
        return mask;
    }
  
    public void setMask(boolean mask) {
        this.mask = mask;
    }

    public Color getMaskColor() {
        return maskColor;
    }
  
    public void setMaskColor(Color maskColor) {
        this.maskColor = maskColor;
    }

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}
}   