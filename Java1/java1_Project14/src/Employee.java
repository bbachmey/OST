
/**
 * 
 * @author bbachmey
 * @instructions see EmployeeApplet.java
 * 
 */
public class Employee {
	private static int topSalary;
	private int hoursPerWeek;

	public static void main(String[] args){
		
		//set the top salary
		topSalary = 195000;
				
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
