package utilities;

public class Sorts {
	
	//get an array of objects that implements the Sortable interface
	//implementing the Sortable interface makes the objects in the array is-a Sortable
	public static  void shellSort(Sortable[] sortableArray){
		//get the length of the is-a Sortable array
		int fullLength = sortableArray.length;
		//declare an integer and set it to half the length of the sortable array
		//if half the length is a floating point number, the floating part is dropped
		//and the value is whatever is to the left of the decimal point
		//for example: 3/2 = 1.5 = 1
		int halfLength = fullLength /2;
		
		//while the halfLength value is 1 or greater than one...
		//basically if the fullLength is greater than 1
		//because half of two would be 1
		while (halfLength >= 1){
			//use the halfLength as an increment value and loop by 1 for as long as 
			//the loop counter is less than the array fullLength
			//For example, if the fullLength is 5, the halfLength is 2,
			//so loop three times (i=2, i++, i=3, i++, i=4, i++, don't loop again) 
			for (int i = halfLength; i < fullLength; i++){
				// make a temporary Sortable object from the Sortable object 
				//in the Sortable array at the position indicated by the loop counter
				//For example, if the fullLength is 5, the halfLength is 2, start with 
				//sortableArray[2], which is the third object in the array
				Sortable temp = sortableArray[i];
				//make a subcounter integer that matches the value of the for loop counter
				//For example, if the fullLength is 5, the halfLength is 2,
				//the subcounter integer is 2
				int j = i;
				//check to see, at this point in the loop, if the subcounter integer is greater than 
				//halfLength integer value, which was initially set to half the length of the Sortable array
				//Also, call the compareTo() method on the temp Sortable object,
				//and send as the actual parameter the object in the Sortable array at 
				//the position equal to the subcounter minus the halfLength integer.
				//If the halfLength is greater than 0 and temp object gets a 1 back from the 
				//call to the compareTo() method, meaning this one is larger,
				//then go into the while code block
				while (j>= halfLength && temp.compareTo(sortableArray[j - halfLength]) < 0){
					//Take the object used in the call to the compareTo() method
					//of the temporary Sortable object, and assign that object to
					//the element in the Sortable array  
					//at the position indicated by the subcounter integer (j)
					sortableArray[j] = sortableArray[j - halfLength];
					//set the subcounter integer to the value of the subcounter integer
					//minus the halfLength integer
					j = j - halfLength;
				}
				//say that the object in the sortable array at the position indicated by the 
				//subcounter integer is actually the temp Sortable object
				sortableArray[j] = temp;
			}
			//set the increment integer to half the increment integer
			//remember that integer division drops the numbers to the right of the 
			//decimal point
			halfLength = halfLength/2;
		}
	}
}
