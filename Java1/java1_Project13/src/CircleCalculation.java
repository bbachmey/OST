// calculate area of circle 
 import java.awt.*;
 import java.applet.Applet;
 import java.awt.event.*;
 import java.text.*;

 /**
 * @author bbachmey
 * @instructions First, employ what you have learned about data encapsulation/hiding. 
 * Secondly, fix the applet so that if a user enters a radius and then presses Enter, 
 * the area text box will show the true area. 
 */
public class CircleCalculation extends Applet implements ActionListener {
     private double radius;
     private double area;
     private TextField tfRadius, tfArea;
     private NumberFormat nf;
      
 	/* (non-Javadoc)
 	 * @see java.applet.Applet#init()
 	 */
 	public void init() {
    	 //set the number format
    	 this.setNf( NumberFormat.getInstance() );
    	 //set the maximum number of digits in the number format
    	 this.getNf().setMaximumFractionDigits(2);
    	 
         //set the initial value of radius
    	 this.setRadius(4.0);
    	 //calculate the area given the radius
    	 this.setArea(calculateArea(radius));
    	 //set the value of the radius text field
         this.setTfRadius(new TextField(String.valueOf(nf.format(radius)), 15)); 
         //create a new label
         this.add(new Label("Radius"));
         //add the label to the radius text field
         this.add(tfRadius); 
         //
         this.tfArea = new TextField(String.valueOf(nf.format(area)), 15);  
         this.add(new Label("Area"));
         this.add(tfArea); 

         //add this applet as an action listener to both text fields
         this.tfRadius.addActionListener(this);
         this.tfArea.addActionListener(this); 
     }
 	
     /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e){  
         //use getSource() to determine which textfield sent the event
    	 TextField tfEvent = (TextField)e.getSource(); 
    	 //parse the text value into a double
    	 double givenNumber = Double.parseDouble(tfEvent.getText());
         //use an if statement to decide what to do in response
    	 //use the getText() method to change the value of 
    	 //the corresponding instance variable
    	 if (tfEvent == tfRadius) {
    		 this.setArea(calculateArea(givenNumber));
    		 this.setRadius(givenNumber);
    		 tfArea.setText((String.valueOf(nf.format(this.getArea()))));
    		 
    	 }
    	 else if (tfEvent == tfArea) {
        	 this.setRadius(calculateRadius(givenNumber));
        	 this.setArea(givenNumber);
    		 tfRadius.setText((String.valueOf(nf.format(this.getRadius()))));
         }
    	 
         //repaint the applet
         this.repaint();
     }
     
     /**
     * @param rad
     * @return
     */
    private double calculateArea(double rd){
    	// hint: area = Math.PI*radius*radius)
     	double a;
     	a = Math.PI * rd * rd;
     	return a;
      }

     /**
     * @param ar
     * @return
     */
    private double calculateRadius(double ar){
     	double r;
     	r = Math.sqrt(ar /Math.PI);
     	return r;
      }
	
	/* (non-Javadoc)
     * @see java.awt.Container#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {
         //the paint method just redraws the string below the text fields
    	 g.drawString(
    			 "Radius is " + 
    				nf.format(this.getRadius()) + 
    				" Area is " + 
    				nf.format(this.getArea()), 
				 10, 100);            
    	 
     }
    
    
    //getters and setters
    
     public double getArea() {
		return area;
	}
     public NumberFormat getNf() {
		return nf;
	}
	public double getRadius() {
		return radius;
	}
	public TextField getTfArea() {
		return tfArea;
	}
	public TextField getTfRadius() {
		return tfRadius;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public void setNf(NumberFormat nf) {
		this.nf = nf;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setTfArea(TextField tfArea) {
		this.tfArea = tfArea;
	}
	public void setTfRadius(TextField tfRadius) {
		this.tfRadius = tfRadius;
	}
	
 }
