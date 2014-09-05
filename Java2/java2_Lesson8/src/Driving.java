import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Driving extends Applet
    implements ActionListener {
 
    private TextField ageField;
    private int age = 0;
 
    public void init() {
    	
        Label l = new Label("Enter your age"); // the "l" is a lower-case "L," not a One.
        add(l);                         // Same with this "l."
        
        ageField = new TextField(3);
    	add(ageField);
    	ageField.addActionListener(this);

        Button reset = new Button("Reset");
        add(reset);
        reset.addActionListener(this); 
    }

   public void paint(Graphics g) {
    	if ( ! (age < 100) )  
            {
              g.drawString ("Are you kidding me!", 30, 70); 
              g.drawString ("Delete some of those numbers." , 30, 80);
             }
    	else if (age > 15)
    	 {
    	   g.drawString ("Congratulations", 50, 50);
    	   g.drawString ("You may drive", 50, 70);
    	 }
    	else
    	 {
           g.drawString ("Wait a few years", 50, 50);
           g.drawString ("You may not drive yet", 50, 70);
    	 }
    	g.drawString("Age is " + age, 50, 90);
    }

   public void actionPerformed(ActionEvent event) {
    	if (event.getSource() instanceof Button)
            {
    		 age = 0;
    		 ageField.setText("");
            }
            else if (event.getSource() instanceof TextField)
            if (ageField.getText().length() == 0) 
    	     age = 0; 
    	   else 
    	     age = Integer.parseInt(ageField.getText());
    	   repaint();

    }
}