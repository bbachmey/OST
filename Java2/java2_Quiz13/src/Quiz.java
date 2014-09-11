
public class Quiz {

	public static void main(String[] args) {

		//Question 2:

		//In the following code segment, how many times is the message "Java rules!" displayed?  
		int i = 1;
		while ( i<=10 ) {
			System.out.println("Java rules!");
			++i;
		}


		// Question 3
		i = 1;
		while (i < 10)
		{ 
			i++;
			System.out.println("i is now: " + i);
		}

		i = 1;
		do { 
			i++;
			System.out.println("i is now: " + i);
		} while (i < 10);

		//Question 4
		//What is wrong with the following piece of code? 
		//What are two different ways it could be changed to fix the error? 
		//The results will be different, but neither solution should have errors.   
		//		int num = 25;
		//		while (num >= 0)
		//		{ 
		//			System.out.println("num is now: " + num);
		//			num = num +1;
		//		}

		int num = 25;
		while (num >= 0)
		{ 
			System.out.println("num is now: " + num);
			num--;
		}

	}

}
