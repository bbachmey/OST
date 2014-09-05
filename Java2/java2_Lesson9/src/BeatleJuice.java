
public class BeatleJuice {

    
    public static void main(String[] args) {
        String[] beatles;                // declares an array of Strings
         
        beatles = new String[5];         // allocates memory for 5 Strings
         
        beatles[0] = "John Lennon";      // initialize first element at index 0
        beatles[1] = "Paul McCartney";   // initialize second element
        beatles[2] = "George Harrison";  // etc.
        beatles[3] = "Ringo Starr";
        beatles[4] = "George Martin";
 
        System.out.println("Element at index 0: " + beatles[0]);
        System.out.println("Element at index 1: " + beatles[1]);
        System.out.println("Element at index 2: " + beatles[2]);
        System.out.println("Element at index 3: " + beatles[3]);
        System.out.println("Element at index 4: " + beatles[4]);

        System.out.println("\nSize of the beatles array is " + beatles.length);
        
        int x = 1; 
        System.out.println();
        System.out.println("When x=" + x + ", the element at beatles[x] is " + beatles[x]);
        System.out.println("With x=" + x + ", the element at beatles[x++] is " + beatles[x++]);
        System.out.println("After use and then increment, x is now " + x);
        System.out.println("With x=" + x + ", Element at beatles[++x] is " + beatles[++x]);
        System.out.println("After increment and then use, x is now " + x);
    }

}
