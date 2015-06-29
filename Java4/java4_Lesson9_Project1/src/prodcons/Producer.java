package prodcons;

class Producer extends Thread {
    private Soup soup;
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Bowl bowlView;
 
    public Producer(Bowl bowl, Soup s) {
        bowlView = bowl;        // the producer is given the GUI that will show what is happening
        soup = s;               // the producer is given the soup--the monitor
    }

    public void run() {
        String c;
        while (true) {                      
            c = String.valueOf(alphabet.charAt((int)(Math.random() * 26)));   // randomly pick a number to associate with an alphabet letter
            soup.add(c);                                            // add it to the soup
            System.out.println("Added " + c + " to the soup.");     // show what happened in Console
            bowlView.repaint();                                     // show it in the bowl  

            try {
                sleep(1000);  // sleep for a while so it is not too fast to see
            } catch (InterruptedException e) { }
        }
    }
}