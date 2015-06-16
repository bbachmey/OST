
public class InfiniteLoop {
	
    public int tryMe(int x){
        System.out.println(x); // Run first without this line--then uncomment just to see how many times it ran before having the overflow
        return tryMe(x+1);
    }

    public static void main(String [] args){
        InfiniteLoop silly = new InfiniteLoop();
        silly.tryMe(1);
    }
}