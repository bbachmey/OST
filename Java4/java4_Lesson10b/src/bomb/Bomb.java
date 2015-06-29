package bomb;

import java.awt.*;
import java.applet.Applet;

public class Bomb extends Thread {
    String word;
    int x, y, ticker;
    int width = 62;
    int height = 65;
    Applet apl;
    boolean being_disarmed = false;
    boolean disarmed = false;
    boolean exploded = false;
    int amount_disarmed = 0;
    Image bomb;
	
    public Bomb(String word, int x, int y, Applet apl){
        super(word);
        this.word = word;
        this.x = x;
        this.y = y;
        this.ticker = word.length()*6;  // time to type is relative to length of word
        this.apl = apl;
        bomb = apl.getImage(this.apl.getDocumentBase(), "../images/bomb.png");
    }

    public void run(){
        while (ticker > 0)                                    // have sleep in while loop to show kaboom!!!!!
        {
            try {
                sleep(600);
            }
            catch (InterruptedException e) {}
            ticker--;
            if (disarmed)                                      //check if disarmed here
            {
                break;                                          // jump out of while - this bomb is done
            }
            //System.out.println(word+":"+ticker);
            apl.repaint();
        }
        exploded = true;                                    // KABOOM!!! in draw method of this class - 
    }                                                       // will draw in Graphics passed from Applet

    public int getX(){
        return x;                                            // The horizontal component of the bomb's location is returned
    }            
	
    public int getY(){
        return y;                                            // the vertical component of the bomb's location is returned
    }  
	
    public int getWidth(){
        return width;                                        // The width of the bomb is returned
    }  
	
    public int getHeight(){
        return height;                                       // The height of the bomb is returned
    } 

    public void draw(Graphics g){                           // The bomb will be drawn to the Graphics object passed in
        if (!exploded)
        {
            g.drawImage(bomb, x, y,  Color.WHITE, apl);       // not exploded so show bomb			
            g.setFont(new Font("Monospaced", Font.PLAIN, 12));  
            g.setColor(Color.RED);
            g.drawChars(word.toCharArray(), 0, amount_disarmed, x, y+60);  // letters user typed turn red
            g.setColor(Color.BLACK);
            if (amount_disarmed != word.length())              // letters not typed stay black	
            {
                g.drawChars(word.toCharArray(), amount_disarmed, word.length()-amount_disarmed, x+(amount_disarmed*7), y+60);	
            }
            if (being_disarmed)
            {
                //System.out.println(word+" is being_disarmed");  // commented out System.outs that helped debug code
                g.setColor(Color.BLUE);                           // word being "worked on" is circled in blue
                g.drawRoundRect(x-2, y+49, word.length()*9, 14, 10, 10);
            }
                                                              // draw fuse
            g.setColor(Color.RED);                           
            double bar = (double)ticker/(word.length()*5);     
            g.fillRect(x, y+64, (int)(word.length()*7*bar), 5);  // red bar underneath shows progress
        }
        else
        {
            g.setColor(Color.RED);                               // else - bomb explodes 
            g.setFont(new Font("Courier Bold", Font.PLAIN, 12));
            g.drawString("KABOOM!!!", x, y+30);
        }
    }

    public boolean startsWith(char c)  {                      // does the current word start with the value typed (passed in here)
        if (word.charAt(0) == c)
            return true;
        return false;
    }

    public boolean exploded(){  
        return exploded;                                       // The Bomb's exploded variable will be returned 
    } 

    public boolean hasPoint(int x, int y){                    // If the Bomb occupies the location passed in, a boolean will be returned true
        if ( (this.x <= x && x <= (this.x + this.width)) && (this.y <= y && y <= (this.y + this.height)) )
            return true;
        else
            return false;	
    }

    public void setdisarming(){   
        being_disarmed = true;                                 // The bomb will be set to being disarmed  
    }

    public void setarming(){  
        being_disarmed = false;                                // The bomb will be set to  not being disarmed
    }

    public boolean attemptDisarm(char c){  
        assert amount_disarmed < word.length();             // assert - another debugging tool
        if (word.charAt(amount_disarmed) == c)                 // If the Bomb has been totally disarmed i.e. the char passed in was the last char needed to diffuse the bomb, 
        {                                                      // then true is returned, otherwise false
            //System.out.println(c+" is a hit on "+word);
            amount_disarmed++;
                                                             //check if bomb is totally disarmed
            if (amount_disarmed == word.length())
            {
                //System.out.println(word+" is defused");
                disarmed = true;
                return true;
            }
            return false;
        }
        //System.out.println(c+" is a miss on "+word);
        return false;
    }
}