package prodcons;

class Consumer extends Thread {
    private Soup soup;
    private MyTableSetting bowlView;

    public Consumer(MyTableSetting bowl, Soup s) {
        bowlView = bowl;
        soup = s;
    }

    public void run() {
        String c;
        for (int i = 0; i < 10; i++) {       // stop thread when we know there are no more coming
            c = soup.eat();
            System.out.println("Ate a letter: " + c);
            bowlView.recentlyAte(c);          // tell what alphabet character to put in the spoon
            bowlView.repaint();

            try {
                sleep((int)(Math.random() * 3000));  // have consumer sleep a little longer or sometimes we never see them!
            } catch (InterruptedException e) { }
        }
    }
} 