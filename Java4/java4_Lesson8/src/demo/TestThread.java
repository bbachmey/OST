package demo;                                    // Define our simple threads.  They will pause for a short time
                                                 // and then print out their names
class TestThread extends Thread {
    private String whoAmI;
    private int delay;

    public TestThread(String s, int d) {  // Our constructor to receive the name (whoAmI) and time to sleep (delay)
        whoAmI = s;
        delay = d;
    }
                                          // run--the thread method similar to main()--when run is finished, the thread dies.
    public void run() {                   // run is called from the start() method of Thread
        try {
            sleep(delay);
        } 
        catch (InterruptedException e) {
        }
        System.out.println(whoAmI + " has delay time of " + delay);
    }
}