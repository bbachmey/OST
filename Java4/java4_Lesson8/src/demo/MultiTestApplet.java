package demo;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
                                                                
public class MultiTestApplet extends Applet implements ActionListener {

    TestThread t1, t2, t3;

    public void init() {
        Button runUs = new Button("Run Threads");                  // create a Button 
        add(runUs);                                                // add it to the Applet
        runUs.addActionListener(this);                             // add a Listener to the Button

        t1 = new TestThread("Thread1",(int)(Math.random()*1000));  // instantiate our 3 TestThreads
        t2 = new TestThread("Thread2",(int)(Math.random()*2000));
        t3 = new TestThread("Thread3",(int)(Math.random()*3000));
    }

    public void actionPerformed(ActionEvent e){
        t1.start();                                                // clicking the Button will allow us to start the threads
        t2.start();
        t3.start(); 
    }
    
}