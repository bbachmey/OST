package prodcons;

class Consumer extends Thread {

	private Soup soup;
	private Bowl bowl;

	public Consumer(Bowl b, Soup s) {

		// the GUI that will show what is happening
		this.bowl = b;                               

		// the soup--the monitor
		this.soup = s;     

	}

	public void run() {

		String c;

		while (true) {     
			// eat it from the soup
			c = soup.eat();    

			// show what happened in Console
			System.out.println("Ate a letter: " + c);  

			// show it in the bowl
			bowl.repaint();                          

			// have consumer sleep a little longer or sometimes we never see the alphabets!
			try {
				sleep((int)(Math.random() * 3000));    
			} catch (InterruptedException e) { }

		}
	}

}