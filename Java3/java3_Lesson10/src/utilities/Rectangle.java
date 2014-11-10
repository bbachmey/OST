package utilities;

public class Rectangle extends Shape implements Sortable {
	int uLX, uLY, lRX, lRY;
	private int area;
	
	public Rectangle(int upperLeftX, int upperLeftY, int lowerRightX, int lowerRightY){
		uLX = upperLeftX;
		uLY = upperLeftY;
		lRX = lowerRightX;
		lRY = lowerRightY;
		setArea();
	}

	private void setArea(){
		area = (lRX - uLX) * (lRY - uLY);
	}
	
	public int getArea(){
		return area;
	}
	
	public int compareTo(Sortable sortable) {
        //Rectangle oneToCompare = (Rectangle)b;
        Shape shape = null;
    
        if (sortable instanceof Shape){ 
            shape = (Shape)sortable;
            if (getArea() < shape.getArea()) return -1;  	// this one is smaller
            if (getArea() > shape.getArea()) return 1;   	// this one is larger
            return 0;                                   	// they are the same
        }
        return 0;
    }
}  