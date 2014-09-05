class Beatlejuice {
    public static void main(String[] args) {
        String[] beatles;              
        beatles = new String[5];     
        
        beatles[0] = "John Lennon"; 
        beatles[1] = "Paul McCartney"; 
        beatles[2] = "George Harrison"; 
        beatles[3] = "Ringo Starr";
        beatles[4] = "George Martin";
        
//        System.out.println("Element at index 0: " + beatles[0]);
//        System.out.println("Element at index 1: " + beatles[1]);
//        System.out.println("Element at index 2: " + beatles[2]);
//        System.out.println("Element at index 3: " + beatles[3]);
//        System.out.println("Element at index 4: " + beatles[4]);

        for (int i=0; i < beatles.length; i++){
          System.out.println("Element at index " + i + ": " + beatles[i]);
        }
                
        System.out.println("\nSize of the beatles array is " + beatles.length);
    }
} 