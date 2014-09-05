class Gigantic {
     public static void main(String[] args) {
          int arr[];              // declares an array of integers

          //int = 32 bits (00000000 00000000 00000000 00000000)
          //int = 4 bytes (255 255 255 255)
          //megabyte = 1024 bytes
          //megabyte = int[256]
          
          //arr = new int[256];     
          
          //arr = new int[2560000];
          //123,456,789 * 32 = 3,950,617,248 bits = 493,827,156 bytes
          arr = new int[123456789];
          
          //1,234,567,890 * 32 = 39,506,172,480 bits = 4,938,271,560 bytes
          arr = new int[1234567890];

          //arr = new int[8];
          
          for (int i=0; i<arr.length; i++) {
        	  arr[i] = i;  
          }

          System.out.println("Size of the array array1 is " + arr.length);
          System.out.println();

          for (int i=0; i<arr.length; i++) {
              System.out.println("Element at index " + i +": " + arr[i]);
          }


     }
}   