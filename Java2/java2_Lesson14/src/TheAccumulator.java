class TheAccumulator {  

    public static void main(String[] args){
        TheAccumulator myInstance = new TheAccumulator();
        int myArray [] = {1,2,3,4,5,6,7,8,9,10};
        int myArrayTotal = myInstance.sum(myArray);
        System.out.println("Total is : " + myArrayTotal);
    }

    // method definition
   
    public int sum( int [] array) {
        int total = 0;
        for (int s=0; s < array.length; s++)
            total = total + array[s];
                        // find the sum of all of the elements in the array
                        // total here is called an accumulator - it accumulates the sum
        return total;
    }
}