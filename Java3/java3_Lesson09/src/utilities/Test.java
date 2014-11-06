package utilities;

public class Test {
	public static void main(String[] args){
		Test testMe = new Test();
		testMe.tryTypes();
		
	}
	
	public void tryTypes(){
		Rectangle rect1 = new Rectangle(60, 30, 260, 100);
		Sortable rect2 = new Rectangle(10,120,40,150);
		Rectangle rect3 = (Rectangle)rect2;
		Sortable [] figures = {rect1, rect3};
		
		System.out.println("rect1 Area: " + rect1.getArea() );
		System.out.println("rect1 Upper Left: (" + rect1.uLX + "," + rect1.uLY + ")");
		System.out.println("rect3 Area: " + rect3.getArea());
        System.out.println("rect3 Upper Left: (" + rect3.uLX + ","+ rect3.uLY + ")");
		
		int compareTest1 = rect1.compareTo(rect3);
		int compareTest2 = rect3.compareTo(rect1);

        for (int i = 0; i < figures.length; i++) {
        	//cast the item in the figures array from a Sortable object
        	//back to a Rectangle object
        	//rect1 and rect3 are still rectangles, even though they "are-a" Sortable object too
        	Rectangle current = (Rectangle)figures[i];
        	System.out.println("Area is " + current.getArea());
        }
            
		if (compareTest1 > compareTest2){
			System.out.println("rect1 is bigger than rect3");
		}
		else{
			System.out.println("rect3 is bigger than rect1");
		}
	}
}
