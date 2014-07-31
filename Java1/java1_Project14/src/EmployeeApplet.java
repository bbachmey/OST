import java.applet.Applet;


/**
 * 
 * @author bbachmey
 * In the java1_Project14 project you made for the first objective of this lesson: 
 * Make an applet named EmployeeApplet.java.  Use this Applet to create two instances 
 * of the Employee class, just like you did in the main() method in the  first objective.  
 * 
 * This time, display the data on the Graphics object, instead of the console. 
 * Display in the applet the names and values of all of the instance variables in each 
 * instance of the class. Also display the value of any static variables. 
 * 
 * Note that, if you access a static variable via an instance, Eclipse will warn you 
 * that this is not optimal behavior. Use the correct form for accessing and displaying 
 * any static information.  You might need to create the proper getters and setters in 
 * Employee.java in order to correctly access them from the Applet.
 * 
 */
public class EmployeeApplet extends Applet {

Employee e1;
Employee e2;

public void init(){
	e1 = new Employee();
	e2 = new Employee();

	//set instance variables of instantiated employees
	e1.setHoursPerWeek(40);
	e2.setHoursPerWeek(45);
	
}

}
