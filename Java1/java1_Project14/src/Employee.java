
/**
 * 
 * @author bbachmey
 * @instructions Copy the Employee.java file from the java1_Lesson14 project 
 * to the java1_Project14 project.
 *   
 * First, use what you've learned about encapsulation to protect your data.
 * 
 * Use a call to the System.out.println() method to display in the console 
 * the names and values of all of the instance variables in each instance 
 * of the Employee class. 
 * 
 * Also print to the console the value of any static variables. 
 * 
 * Note that, if you access a static variable via an instance, 
 * Eclipse will warn you that this is not optimal behavior. 
 * 
 * Use the correct form for accessing and displaying any static information.
 * 
 */
public class Employee {
	private static int topSalary;
	private int hoursPerWeek;

	public static void main(String[] args){
		//set the top salary
		topSalary = 195000;
		//declare two employees
		Employee e1, e2;
		//instantiate two employees
		e1 = new Employee();
		e2 = new Employee();
		
		//reset the top salary of the Employee class, calling by class
		Employee.setTopSalary(199000);
		//Employee.topSalary = 200000;
		
		//set instance variables of instantiated employees
		e1.hoursPerWeek = 40;
		e2.hoursPerWeek = 45;

		//print names and values of the instance variables in each instance of the Employee class
		System.out.println("WEEK 1");
		System.out.println("Employee 1");
		System.out.println("Hours per week: " + e1.getHoursPerWeek());
		//System.out.println("Top salary: " + e1.getTopSalary());
		//System.out.println("Top salary: " + e1.topSalary);
		//System.out.println("Top salary: " + Employee.getTopSalary());
		System.out.println("Top salary: " + Employee.topSalary);
		
		System.out.println("Employee 2");
		System.out.println("Hours per week: " + e2.getHoursPerWeek());
		//System.out.println("Top salary: " + e2.getTopSalary());
		//System.out.println("Top salary: " + e1.topSalary);
		System.out.println("Top salary: " + Employee.getTopSalary());
		//System.out.println("Top salary: " + Employee.topSalary);		
		System.out.println();
		
		/*
		 * add more hours
		 */
		e1.addMoreHours();
		e2.addMoreHours();

		//print names and values of the instance variables in each instance of the Employee class
		System.out.println("WEEK 2");
		System.out.println("Employee 1");
		System.out.println("Hours per week: " + e1.getHoursPerWeek());
		//System.out.println("Top salary: " + e1.getTopSalary());
		//System.out.println("Top salary: " + e1.topSalary);
		//System.out.println("Top salary: " + Employee.getTopSalary());
		System.out.println("Top salary: " + Employee.topSalary);
		
		System.out.println("Employee 2");
		System.out.println("Hours per week: " + e2.getHoursPerWeek());
		//System.out.println("Top salary: " + e2.getTopSalary());
		//System.out.println("Top salary: " + e1.topSalary);
		System.out.println("Top salary: " + Employee.getTopSalary());
		//System.out.println("Top salary: " + Employee.topSalary);		
		System.out.println();
		
	}
	
	public void addMoreHours () {
		hoursPerWeek++; 
	}
	
	//getters and setters
	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public static int getTopSalary() {
		return topSalary;
	}
	
	public static void setTopSalary (int s){
		if (s > topSalary)
			topSalary = s;
	}
	
}
