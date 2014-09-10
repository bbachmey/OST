
public class Student {
	/*
	 * The Student class should have instance variables (with getters and setters) for a student's last name (String), first name (String), student id number (int), an array for up to 15 project scores that are represented as double values, named "projects," and an array for up to 10 quiz scores that are represented as double values, named "quizzes."
	 */
	String lastName;
	String firstName;
	int studentId;
	double[] projects;
	double[] quizzes;

	/**
	 * @param fname
	 * @param lname
	 * @param sid
	 * 
	 * The constructor of the Student class should take the student's last and first name 
	 * and a student id as parameters and set the instance variables to those values. 
	 * It should also instantiate the arrays to their size. 
	 * There should be no console I/O in the Student class unless it is in the main 
	 * method or a private static method called by the main method. 
	 * The constructor should initialize all elements of the arrays to -1.0 
	 * to indicate there is no score in that element yet.
	 * 
	 */
	public Student(String fname, String lname, int sid){
		this.setFirstName(fname);
		this.setLastName(lname);
		this.setStudentId(sid);

		projects = new double[15];
		quizzes = new double[10];
		
		for (int i=0;i<projects.length;i++){
			projects[i]=-1;
		}
		for (int i=0;i<quizzes.length;i++){
			quizzes[i]=-1;
		}
	}
	
	/*
	 * 
	 */

	/**
	 * @param index
	 * @param score
	 * 
	 * Create setProjectScore() and setQuizScore() methods for the arrays. 
	 * These should only take a double as a parameter and an int as a project or quiz number. 
	 * These methods should return a boolean to indicate success or failure, 
	 * depending on if the project or quiz number is out of the bounds of the array. 
	 * The setProjectScore() and setQuizScore() methods will place the double value 
	 * into the project or quiz number index of its respective array.
	 * 
	 */
	public boolean setProjectScore(int index, double score){
		int uBound = projects.length;
		int lBound = 0;
		
		if (index > uBound || index < lBound){
			return false;
		}
		else {
			projects[index] = score;
			return true;
			
		}
				
	}
	
	/**
	 * @param index
	 * @param score
	 */
	public boolean setQuizScore(int index, double score){
		int uBound = quizzes.length;
		int lBound = 0;
		
		if (index > uBound || index < lBound){
			return false;
		}
		else {
			quizzes[index] = score;
			return true;
			
		}
	}
	
	/**
	 * Create getProjectScore() and getQuizScore() methods for the arrays. 
	 * These methods will return a double value. 
	 * These will take an index parameter, representing the project or quiz number to return. 
	 * They will return the value stored at that index in the array. 
	 * This method should return -1.0 if the array index is out of bounds. 
	 * -1.0 is a common flag to indicate failure in methods that should only return 
	 * non-negative floats or doubles. 
	 * If the element in the array is a -1.0, that indicates there is no valid 
	 * score in that slot and -1.0 should be returned as a failure code.
	 */
	public double getProjectScore(int index){
		int uBound = projects.length;
		int lBound = 0;
		
		if (index > uBound && index < lBound){
			return -1;
		}
		else {
			return projects[index];
			
		}
	}
	
	public double getQuizScore(int index){
		int uBound = quizzes.length;
		int lBound = 0;
		
		if (index > uBound && index < lBound){
			return -1;
		}
		else {
			return quizzes[index];
			
		}
	}
	
	/**
	 * @return
	 * Create a method named getNextProjectIndex() that returns an int that gets the next 
	 * index of the projects array that contains a -1.0. 
	 * Find the next item in the projects array that contains a -1.0 and return that index of the array. 
	 * This method should return -1 if the array is full. 
	 * -1 is a common flag to indicate failure in methods that should only return 
	 * non-negative integers.
	 */
	public int getNextProjectIndex(){
		int index = -1;
		
		for (int i=0;i<projects.length;i++){
			if (projects[i]==-1){
				index = i;
				break;
			}
		}
		return index;
		
	}
	
	/**
	 * @return
	 * Create a method named getNextQuizIndex() that returns an int that gets the 
	 * next index of the quizzes array that contains a -1.0. 
	 * Find the next item in the quizzes array that contains a -1.0 and return that index of the array. 
	 * This method should return -1 if the array is full.
	 */
	public int getNextQuizIndex(){
		int index = -1;
		
		for (int i=0;i<quizzes.length;i++){
			if (quizzes[i]==-1){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * @return
	 * You may add other methods as needed, such as a method to return the size of the projects and quizzes arrays. 
	 * Keep in mind that any method you add that is not meant to be called from an outside class should be private.
	 */
	public int getProjectsArraySize(){
		return projects.length;
	}
	public int getQuizzesArraySize(){
		return quizzes.length;
	}
	
	/*
	 * There should be no getters for the arrays, since we don't want any outside program 
	 * modifying their contents without going through the setProjectScore() and setQuizScore() methods.
	 */
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
