package dice;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Craps extends Applet 
    implements ActionListener {
    private Button die1, die2;
    private int value1 = 0, value2 = 0;
    private AudioClip roll;
    private Image die;
    
    public void init() {
        die1 = new Button("Die1");
        add(die1);
        die1.addActionListener( this);
        die2 = new Button("Die2");
        add(die2);
        die2.addActionListener( this);
        roll = getAudioClip(getDocumentBase(),"../audio/dice/rollDie.wav");
    }
 
    public void paint(Graphics g) {
    	int total;
        total = value1+value2;
        g.drawString("Die 1 is " +value1 + "     Die 2 is " + value2, 40, 50);
        g.drawString("Total is " + total, 40, 65);
        if (total==7)
            g.drawString ("You have won!" , 50, 90);
        switch (value1) {
           case 1: die = getImage(getDocumentBase(),"../images/dice/die1s.jpg"); break;
           case 2: die = getImage(getDocumentBase(),"../images/dice/die2s.jpg"); break;
           case 3: die = getImage(getDocumentBase(),"../images/dice/die3s.jpg"); break;
           case 4: die = getImage(getDocumentBase(),"../images/dice/die4s.jpg"); break;
           case 5: die = getImage(getDocumentBase(),"../images/dice/die5s.jpg"); break;
           case 6: die = getImage(getDocumentBase(),"../images/dice/die6s.jpg"); break;
           default: die = getImage(getDocumentBase(),"../images/dice/Crapslayout.png");
        }
        g.drawImage(die, 10, 110, Color.white, this);          
        switch (value2) {
           case 1: die = getImage(getDocumentBase(),"../images/dice/die1s.jpg"); break;
           case 2: die = getImage(getDocumentBase(),"../images/dice/die2s.jpg"); break;
           case 3: die = getImage(getDocumentBase(),"../images/dice/die3s.jpg"); break;
           case 4: die = getImage(getDocumentBase(),"../images/dice/die4s.jpg"); break;
           case 5: die = getImage(getDocumentBase(),"../images/dice/die5s.jpg"); break;
           case 6: die = getImage(getDocumentBase(),"../images/dice/die6s.jpg"); break;
           default: die = getImage(getDocumentBase(),"../images/dice/Crapslayout.png");
        }
        if (value2 != 0) g.drawImage(die, 110, 110, Color.white, this);  // if is so only draw default image once
    }
 
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().toString() == "Die1") 
               value1= (int)(Math.random() * 6) + 1;
        else
               value2= (int)(Math.random() * 6) + 1;
        roll.play();
        try{
        	Thread.sleep(1000);                     // let roll before show image
        }catch(InterruptedException e){}
        repaint();
    }
}