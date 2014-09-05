
class Test {   

	public static void main(String[] args){
	
		String [] studentGrade = new String[30];
		// begin for body (or block)
		for (int i=0; i < studentGrade.length; i++){  
			// begin switch block
			switch (i % 5) { 
				case 0: studentGrade[i] = "A"; break;
				case 1: studentGrade[i] = "B"; break;
				case 2: studentGrade[i] = "C"; break;
				case 3: studentGrade[i] = "D"; break;
				case 4: studentGrade[i] = "F"; break;
			} // end switch
			
			System.out.println("The grade for student number " + i + " is " + studentGrade[i]);
		}   // end for
	}      // end main method
}         // end Test class
