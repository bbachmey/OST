import java.applet.Applet;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NestTest3 extends Applet {
    String[] listItems = { "John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best" };
    String msg = "";

    public void init() {
        List myList = new List();
        for (String item : listItems) {
            myList.add(item);
        }
        myList.addActionListener(new ListListener());
        add(myList);

        class ListListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                msg = e.getActionCommand();
                repaint();
            }
        }
    }

    public void paint(Graphics g) {
        if (msg != "") {
            g.drawString("Beatle " + msg + " selected.", 0, 100);
        }
    }
}