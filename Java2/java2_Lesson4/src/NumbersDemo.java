import java.applet.Applet;
import java.awt.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;;


public class NumbersDemo extends Applet {
	
	@Override
	public void start(){
		resize(300,200);
		
	}
	
	@Override
	public void paint(Graphics g){

		DecimalFormat myFormat1 = new DecimalFormat("###,###.##");
		DecimalFormat myFormat2 = new DecimalFormat("###,###");
		
//		NumberFormat nf = NumberFormat.getInstance();
//		nf.setMaximumFractionDigits(2);
		double area;
		double radius = 12;
		double amountOwed = 12.00;

		g.drawString("Area of a circle = (radius)^2*Pi", 10, 20);
		g.drawString("If radius = " + radius, 10, 40);
		//g.drawString("The circle's area = " + nf.format(Math.pow(radius, 2)*Math.PI), 10, 60);
		g.drawString("The circle's area = " + myFormat1.format(Math.pow(radius, 2)*Math.PI), 10, 60);
		g.drawString("An alternate formatting without decimals ", 10, 95);
		g.drawString("The circle's area= " + myFormat2.format(Math.pow(radius, 2)*Math.PI), 10, 110);
		
		g.drawString("The money owed is " + myFormat1.format(amountOwed), 10, 130);
		
		
	}


}
