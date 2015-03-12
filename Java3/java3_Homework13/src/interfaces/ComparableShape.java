package interfaces;

/* Homework 9
 * Create an interface named ComparableShape for the shape objects, 
 * that will specify that objects that implement the interface can be 
 * compared. The interface should require implementing classes to have a 
 * method getArea() capable of returning the area of the object. Obviously, 
 * only closed shapes can do this. How do you get the area of a line? 
 * The instanceof operator will be handy here.
 */
public interface ComparableShape {

	public int getArea();

	public void setArea();

}
