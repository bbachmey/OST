class Test {
    public static void main(String[] args) {                  
        int[][] twoDimArray = { {2,1},{5,4,3},{9,8,7,6} };
                        
        System.out.println("The length of the array"); 
        System.out.println(" (or the number of rows) = " + twoDimArray.length);
        System.out.println("The width of the array");
        System.out.println(" (or the number of columns)");
        System.out.println("    in twodim[0].length is " + twoDimArray[0].length);
        System.out.println("Which is not the same as");
        System.out.println("    in twodim[1].length is " + twoDimArray[1].length);
        System.out.println("Which is not the same as");
        System.out.println("    in twodim[2].length is " + twoDimArray[2].length);
        System.out.println("Printing out the array results in:");
        for(int row = 0; row < twoDimArray.length; row ++) {
            for(int col = 0; col < twoDimArray[row].length; col ++) {
                System.out.print(twoDimArray[row][col] + " ");
            }
            System.out.println();
        }
    }
} 