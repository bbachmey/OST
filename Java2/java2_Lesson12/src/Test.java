class Test {
//    public static void main(String[] args) {                  
//        int[][] twoDimArray = { {2,1},{5,4,3},{9,8,7,6} };
//                        
//        System.out.println("The length of the array"); 
//        System.out.println(" (or the number of rows) = " + twoDimArray.length);
//        System.out.println("The width of the array");
//        System.out.println(" (or the number of columns)");
//        System.out.println("    in twodim[0].length is " + twoDimArray[0].length);
//        System.out.println("Which is not the same as");
//        System.out.println("    in twodim[1].length is " + twoDimArray[1].length);
//        System.out.println("Which is not the same as");
//        System.out.println("    in twodim[2].length is " + twoDimArray[2].length);
//        System.out.println("Printing out the array results in:");
//        for(int row = 0; row < twoDimArray.length; row ++) {
//            for(int col = 0; col < twoDimArray[row].length; col ++) {
//                System.out.print(twoDimArray[row][col] + " ");
//            }
//            System.out.println();
//        }
//    }
	
	  
	    int total;
	                                                                    
	    public static void main(String[] args){
	        Test myTest = new Test();     // instantiate the class Test
	        myTest.demo();                      // start the class
	    }
	 
	    public void demo(){
	        int[] table = new int[12];          // instantiate the array table
	        for (int i=0; i < table.length; i++)
	        {   
	            table[i] = 1;                   // populate the array table with all 1's
	            System.out.print(table[i] + " ");
	        }

	        int[] table2 = new int[12];
	        System.arraycopy(table, 0, table2, 0, table.length);
	        total = sum(table2);                // call the method sum and pass the copy of array table
	        
	        System.out.println("The total is " + total);
	        System.out.println("After method invocation completes \n and control has returned, values are");
	        for (int i=0; i < table.length; i++) 
	            System.out.print(table[i] + " ");
	    }

	    public int sum(int [] array) {
	        total = 0;
	        for (int s=0; s < array.length; s++)    // when the index s equals the length, loop will stop
	        {
	           total = total + array[s];               // find the sum of all of the elements in the array
	           array[s]= array[s] + 1;
	        } 
	        return total;
	    }
	
	
} 