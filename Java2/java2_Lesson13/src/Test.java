class Test {   
   public static void main(String[] args){
     int [] arrayValues = {5,6,6,44,6,7,34,4,9,89};
     int sum = 0; 
     for (int e : arrayValues) // e is short for element
        sum += e; 
     System.out.println("Sum of the array is " + sum);
   }                                            
} 