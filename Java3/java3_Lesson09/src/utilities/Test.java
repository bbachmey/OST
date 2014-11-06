package utilities;

public class Test {
	public static void main(String[] args){
		Test testMe = new Test();
		testMe.tryTypes();
		
	}
	
	public void tryTypes(){
		Rectangle rect1 = new Rectangle(60, 30, 260, 100);
		Sortable rect2 = new Rectangle(10,120,40,150);
		Sortable [] figures = {rect1, rect2};
		
		System.out.println("rect1 Area: " + rect1.getArea() );
		System.out.println("rect1 Upper Left: (" + rect1.uLX + "," + rect1.uLY + ")");
		
		int compareTest1 = rect1.compareTo(rect2);
		int compareTest2 = rect2.compareTo(rect1);
		if (compareTest1 > compareTest2){
			System.out.println("rect1 is bigger than rect2");
		}
		else{
			System.out.println("rect2 is bigger than rect1");
		}
	}
}
