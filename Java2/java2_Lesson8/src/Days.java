import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Days extends Applet implements ActionListener{

    private TextField dayField;
    private int day;

    public void init() {
        dayField=new TextField(2);
        this.add(dayField);
        dayField.addActionListener(this);
    }

    public void paint(Graphics g) {

        g.drawString("Give a number from 1 to 7", 5, 80); 
       

        switch (day) {
              case 1: g.drawString("Monday", 50, 50); break;
              case 2: g.drawString("Tuesday", 50, 50); break;
              case 3: g.drawString("Wednesday", 50, 50); break;
              case 4: g.drawString("Thursday", 50, 50); break;
              case 5: g.drawString("Friday", 50, 50); break;
              case 6: g.drawString("Saturday", 50, 50); break;
              case 7: g.drawString("Sunday", 50, 50); break;
              default: g.drawString("Please follow directions", 5, 50); break;
              }
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource()==dayField)
            day=Integer.parseInt(dayField.getText());
        repaint();
    }
}