// calculate area of circle 
 import java.awt.*;
 import java.applet.Applet;
 import java.awt.event.*;
 import java.text.*;

 public class CircleCalculation extends Applet implements ActionListener {
     private double radius = 4.0;
     private double area = 50.27;
     private TextField tf1, tf2;
      
     public void init() {
         tf1 = new TextField("4.0",15); 
         tf2 = new TextField("50.27",15);  
         this.add(new Label("Radius"));
         this.add(tf1); 
         this.add(new Label("Area"));
         this.add(tf2); 

         this.tf1.addActionListener(this); 
         this.tf2.addActionListener(this); 
     }
     public void actionPerformed(ActionEvent e){  
         TextField temp = (TextField)e.getSource(); 
         if (temp == tf1) radius = Double.parseDouble(temp.getText()); 
         if (temp == tf2) area = Double.parseDouble(temp.getText());
         repaint();
     }

     public void paint(Graphics g) {
    	 NumberFormat nf = NumberFormat.getInstance();
         nf.setMaximumFractionDigits(2);
         g.drawString("Radius is " + radius + " Area is " + nf.format(area), 10, 100);
            // hint: area = Math.PI*radius*radius)
     }
 }
