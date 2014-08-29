
class Test {

	public static void main(String[] args) {
		
		int[] myIntArray = new int[4];
		double [] myDoubleArray = new double[2];
		char [] myCharArray = new char[2];
		boolean [] myBooleanArray = new boolean[2];
		String [] myStringArray = new String[6];
		Object [] myObjectArray = new Object[5];
		Thread [] myThreadArray = new Thread[2];

		// this is what the null character looks like
		char showMe = '\u0000';  
		
		// What does the first element in each look like?
		System.out.println("The value of myIntArray[0] is " + myIntArray[0]);
		System.out.println("The value of myDoubleArray[0] is " + myDoubleArray[0]);
		System.out.println("The value of myCharArray[0] is " + myCharArray[0]);
		System.out.println("The value of myBooleanArray[0] is " + myBooleanArray[0]);
		System.out.println("The value of myStringArray[0] is " + myStringArray[0]);
		System.out.println("The value of myObjectArray[0] is " + myObjectArray[0]);
		System.out.println("The value of myThreadArray[0] is " + myThreadArray[0]);
		
		// to compare with the char array element
		System.out.println("The value of showMe is " + showMe);  

	}

} 