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
		//Sortable [] figures = {rect1, rect3};
        Oval oval1 = new Oval(60,30,160,100);
        Sortable oval2 = new Oval(10,120,40,150);
        Oval oval3 = (Oval)oval2;
		
		System.out.println("rect1 Area: " + rect1.getArea() );
		//System.out.println("rect1 Upper Left: (" + rect1.uLX + "," + rect1.uLY + ")");
		System.out.println("rect3 Area: " + rect3.getArea());
        //System.out.println("rect3 Upper Left: (" + rect3.uLX + ","+ rect3.uLY + ")");
		System.out.println("oval1 Area: " + oval1.getArea());
        System.out.println("oval3 Area: " + oval3.getArea());
        System.out.println();
    
        Sortable [] figures = {rect1, rect3, oval1, oval3};
        
		int compareTest1 = rect1.compareTo(rect3);
		int compareTest2 = rect3.compareTo(rect1);

		System.out.println("Before shellSort:");
		
        for (int i = 0; i < figures.length; i++) {
        	//cast the item in the figures array from a Sortable object
        	//back to a Rectangle object
        	//rect1 and rect3 are still rectangles, even though they "are-a" Sortable object too
        	//Rectangle current = (Rectangle)figures[i];
        	//System.out.println("Area is " + current.getArea());

            Shape current = null;
            if (figures[i] instanceof Rectangle) 
                current = (Rectangle)figures[i];
            else 
                current = (Oval)figures[i];
  
            System.out.println("Area is " + current.getArea());
        }
            
		//if (compareTest1 > compareTest2){
		//	System.out.println("rect1 is bigger than rect3");
		//}
		//else{
		//	System.out.println("rect3 is bigger than rect1");
		//}
        
        Sorts.shellSort(figures);

        System.out.println("\nAfter shellSort:");
        for (int i = 0; i < figures.length; i++){ 
            Shape current = null;
            if (figures[i] instanceof Rectangle) 
                current = (Rectangle)figures[i];
            else 
                current = (Oval)figures[i];
            System.out.println("Area is " + current.getArea());
        }
    }
}  
