
/**
 * @author bbachmey
 * Create a Java class, named Main, that has a main method. 
 * The main() method of the class is a tester. 
 * We will exercise the methods of the Student class to make sure they are working properly. 
 * Any console I/O must be in the main() method or a private static method called by the main method. 
 * This Main class is only there to test the functionality of your Student class. 
 * The Student class should not do any I/O to the console (debugging output is allowed 
 * but should be removed in the final product); only the Main class' main() method should interact 
 * with the console.
 * 
 */
public class Main {

	static Student student;

	/**
	 * @param args
	 * Instantiate a Student object in the main() method. 
	 * You should not make local copies of the Student object's arrays in the main() method, 
	 * but rather only access them via the object's methods. 
	 * Remember, these requirements state that no getters for the arrays in Student are allowed.
	 */
	public static void main(String[] args) {
		student = new Student("Mickey","Mouse",1);
		displayStudentInformation();
		fillTheProjectsAndQuizzes();
		//Try to go out of bounds to add a project and a quiz to the student 
		addOutOfBounds();
		//Once full, display the student's information to the console. 
		//Use a loop to get project and quiz scores from the student object.
		displayStudentInformation();
		
	}
	

	/**
	 * Try to display the student's information to the console. 
	 * Use a loop to get project and quiz scores from the student object. 
	 * This will test your code to make sure it handles a student with no project or quiz scores.
	 */
	private static void displayStudentInformation(){
		String fname;
		String lname;
		int sID;
		StringBuilder sb;
		
		sb = new StringBuilder();
		
		//Project scores
		for (int i=0;i<student.getProjectsArraySize();i++){
			double s = student.getProjectScore(i);
			if (s>-1){
				sb.append("Project "+ i +" score: " + student.getProjectScore(i));
				sb.append("\n");	
			}
		}

		int index = student.getNextProjectIndex();
		if (index>-1){
			double score = student.getProjectScore(index);
			
		}
		
		//Quiz scores
		for (int i=0;i<student.getQuizzesArraySize();i++){
			double s = student.getQuizScore(i);
			if (s>-1){
				sb.append("Project "+ i +" score: " + student.getProjectScore(i));
				sb.append("\n");	
			}
		}

		index = student.getNextQuizIndex();
		if (index>-1){
			double score = student.getQuizScore(index);
			
		}

		System.out.println("Student first name: " + student.getFirstName());
		System.out.println("Student last name: " + student.getLastName());
		System.out.println("Student ID: " + student.getStudentId());
		System.out.println(sb.toString());
		System.out.println();
	}

	/**
	 * Fill the projects and quizzes for this student. 
	 * Use the getNextProjectIndex() and getNextQuizIndex() methods to find the indexes 
	 * in which to add the scores.
	 */
	private static void fillTheProjectsAndQuizzes() {
		double[] P = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		double[] Q = {1.5,2.5,3.5,4.5,5.5,6.5,7.5,8.5,9.5,10.5};
		
		for (double d : P){
			student.setProjectScore(student.getNextProjectIndex(), d);
		}	
		
		for (double d : Q){
			student.setQuizScore(student.getNextQuizIndex(), d);
		}
		
	}
	
	/**
	 * Try to go out of bounds to add a project and a quiz to the student to test the ability 
	 * of the Student class's methods to handle full arrays.
	 */
	public static void addOutOfBounds(){
		student.setProjectScore(student.getProjectsArraySize()+1, 0);
		student.setQuizScore(student.getQuizzesArraySize()+1, 0);
	}

}
