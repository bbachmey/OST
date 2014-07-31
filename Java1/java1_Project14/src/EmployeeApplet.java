import java.applet.Applet;
import java.awt.Label;
import java.awt.TextField;


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

	private Employee e1;
	private Employee e2;
	private TextField tfE1Hours; 
	private TextField tfE2Hours; 
	private TextField tfTopSalary;

	public void init(){
		
		//set the Employee top salary
		Employee.setTopSalary(195000);
		
		//instantiate the employees
		e1 = new Employee();
		e2 = new Employee();

		//set instance variables of instantiated employees
		e1.setHoursPerWeek(40);
		e2.setHoursPerWeek(45);

		//set the value of the text field
		this.setTfE1Hours(new TextField(String.valueOf(e1.getHoursPerWeek()), 15)); 
		//add a label to the applet
		this.add(new Label("Employee 1 Hours"));
		//add the text field to the applet
		this.add(tfE1Hours); 

		//set the value of the text field
		this.setTfE2Hours(new TextField(String.valueOf(e2.getHoursPerWeek()), 15)); 
		//add a label to the applet
		this.add(new Label("Employee 2 Hours"));
		//add the label to the text field
		this.add(tfE2Hours); 

		//set the value of the text field
		this.setTfTopSalary(new TextField(String.valueOf(Employee.getTopSalary()), 15)); 
		//add a label to the applet
		this.add(new Label("Top Salary"));
		//add the text field to the applet
		this.add(tfTopSalary); 

	}

	public Employee getE1() {
		return e1;
	}

	public void setE1(Employee e1) {
		this.e1 = e1;
	}

	public Employee getE2() {
		return e2;
	}

	public void setE2(Employee e2) {
		this.e2 = e2;
	}

	public TextField getTfE1Hours() {
		return tfE1Hours;
	}

	public void setTfE1Hours(TextField tfE1Hours) {
		this.tfE1Hours = tfE1Hours;
	}

	public TextField getTfE2Hours() {
		return tfE2Hours;
	}

	public void setTfE2Hours(TextField tfE2Hours) {
		this.tfE2Hours = tfE2Hours;
	}

	public TextField getTfTopSalary() {
		return tfTopSalary;
	}

	public void setTfTopSalary(TextField tfTopSalary) {
		this.tfTopSalary = tfTopSalary;
	}





}
