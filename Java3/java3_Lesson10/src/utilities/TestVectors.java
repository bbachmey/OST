package utilities;

import java.awt.*;
import java.util.*;

public class TestVectors {

	public static void main(String[] args){
		TestVectors testMe = new TestVectors();
		testMe.tryVectors();
	}
	
	public void tryVectors(){
		
		Rectangle rect1 = new Rectangle(60,30,160,100);
		Sortable rect2 = new Rectangle(10,120,40,150);
		
		Rectangle rect3 = (Rectangle)rect2;
		
		Oval oval1 = new Oval(60,30,160,100);
		Sortable oval2 = new Oval(20,120,40,150);
		
		Oval oval3 = (Oval)oval2;
		// When we made rect3 and oval3, we did not make new objects. 
		//Instead, we cast an existing object to be seen differently from how it was declared earlier. 
		//They do point to the same place though, so be careful making changes to either.
		Point myPoint = new Point(55,55);
		
		//The Vector named moreFigures is created to hold 2 objects initially. 
		Vector <Point> moreFigures = new Vector<Point>(2);

		// As we add objects to the vector, it grows automatically to accommodate more objects. 
//		moreFigures.add(rect1);
//		moreFigures.add(rect2);
		//But this convenience comes at a price. 
		//Each time the Vector is called upon to grow, it doubles in size, 
		//so make sure to set the initial capacity of your vector a bit higher 
		//than the maximum number of objects you anticipate it will hold.
//		moreFigures.add(rect3);
//		moreFigures.add(oval1);
//		moreFigures.add(oval2);
//		moreFigures.add(oval3);
		moreFigures.add(myPoint);		
		//When we loop through the moreFigures Vector, we are no longer dealing with an array, 
		//so we can't use the length constant from an array. We have to use the Vector's size() method, 
		//which gives us the number of objects in the Vector.
		for (int i=0; i<moreFigures.size(); i++){
			System.out.println("Element " + i + " is " + moreFigures.elementAt(i));
			//Let's cast the elements to something.
            Point myBad =(Point)moreFigures.elementAt(i);
            System.out.println("Vector Element "+ myBad);
            //Even though we can't cast a Rectangle to a Point, we weren't given any errors. 
            //A problem like this may go unnoticed until runtime. 
            //Fortunately, in version 1.5, Java made Vectors a Generic class, 
            //so if we use the generics framework properly, we cannot cast incorrectly.
		}
		
	}
	
}
