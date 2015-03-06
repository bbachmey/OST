package games;

import java.util.List;
import javax.swing.*;
import java.applet.Applet;
import java.awt.Graphics;                                    

public class CardDemoApplet extends Applet {
 
    private static RealCards[] _deck = new RealCards[52];
    CardTable table;

    public void init() {
        resize(400,400);
        makeCards();
        table = new CardTable(_deck);  
        add(table);
    }
	 
    public void makeCards(){
        int n = 0;         
        int xPos = 0;      
        int yPos = 0;

        Deck myDeck = new Deck();
        List<ImageIcon> aVisualDeck = myDeck.getVisualDeck();
        for(ImageIcon each: aVisualDeck)
        {
            RealCards card = new RealCards(each);
            card.moveTo(xPos, yPos);
            _deck[n] = card;

            //... Update local vars for next card.
            xPos += 5;
            yPos += 4;
            n++;
        }
    }

    public void paint(Graphics g) {
        table.paintComponent(g);
    }
}