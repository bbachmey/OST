package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class PolyOctagon extends Shape {
	private Color fillColor;
	private int width; 
	private int height;
	private boolean fill;
	private Point A;
	private Point B;
	private Point C;
	private Point D;
	private Point E;
	private Point F;
	private Point G;
	private Point H;

	private int sides = 8;
	private Polygon p;

	public PolyOctagon(
			Color lineColor, 
			int x, 
			int y,
    		Color fillColor, 
    		boolean fill
			){
		
		// Super constructor
		super(lineColor, x, y);
		
		A = new Point(lineColor,x,y);
		B = new Point(lineColor,x,y);
		C = new Point(lineColor,x,y);
		D = new Point(lineColor,x,y);
		E = new Point(lineColor,x,y);
		F = new Point(lineColor,x,y);
		G = new Point(lineColor,x,y);
		H = new Point(lineColor,x,y);

		this.fillColor = fillColor;
		this.fill = fill;
		
	}

	@Override
	public void draw(Graphics g) {

        // Be nice. Save the state of the object before changing it.
        Color oldColor = g.getColor();
        
		int [] polyx = new int [8];
		int [] polyy = new int [8];
		
		
//		Octagon numbers
//		0	0
//		62	0
//		106	44
//		106	106
//		62	150
//		0	150
//		-44	106
//		-44	44
	      
	      
		A.setX( super.getX() );
		A.setY( super.getY() );

		B.setX( A.getX() + 62 );
		B.setY( A.getY() );
		
		C.setX( A.getX() + 106 );
		C.setY( A.getY() + 44  ); //TODO: Finish the math for making an octagon
		
		D.setX( A.getX() + 106 );
		D.setY( A.getY() + 106 );
		
		E.setX( A.getX() + 62 );
		E.setY( A.getY() + 150 );
		
		F.setX( A.getX() + 0 );
		F.setY( A.getY() + 150 );
		
		G.setX( A.getX() - 44 );
		G.setY( A.getY() + 106 );
		
		H.setX( A.getX() - 44 );
		H.setY( A.getY() + 44 );
		
		polyx[0]=A.getX(); 
		polyx[1]=B.getX(); 
		polyx[2]=C.getX();
		polyx[3]=D.getX();
		polyx[4]=E.getX();
		polyx[5]=F.getX();
		polyx[6]=G.getX();
		polyx[7]=H.getX();

		polyy[0]=A.getY(); 
		polyy[1]=B.getY(); 
		polyy[2]=C.getY();
		polyy[3]=D.getY();
		polyy[4]=E.getY();
		polyy[5]=F.getY();
		polyy[6]=G.getY();
		polyy[7]=H.getY();
		
		p = new Polygon(polyx, polyy, sides);
		
        if (isFill()) { //TODO: Add Fill property to PolyTri
            g.setColor(getFillColor());
            g.fillPolygon(p);
        }
        g.setColor(getLineColor());

        g.drawPolygon(p);
        // Set the state back when done.
        g.setColor(oldColor); 

	}

	// Override abstract method containsLocation in the Shape class.
	@Override
	public boolean containsLocation(int x, int y) {
		if ( p.contains(x,y) ){
			return true;
		}
		return false;
	}


	/**
	 * Returns a String representing this object.
	 * Overrides toString() in java.lang.Object
	 */
	@Override
	public String toString() {
		return "Octagon: " +
				"\n\tA = ( " + A.getX() + "," + A.getY() + " )" + 
				"\n\tB = ( " + B.getX() + "," + B.getY() + " )" + 
				"\n\tB = ( " + C.getX() + "," + C.getY() + " )" + 
				"\n\tB = ( " + D.getX() + "," + D.getY() + " )" + 
				"\n\tB = ( " + E.getX() + "," + E.getY() + " )" + 
				"\n\tB = ( " + F.getX() + "," + F.getY() + " )" + 
				"\n\tB = ( " + G.getX() + "," + G.getY() + " )" +  
				"\n\tC = ( " + H.getX() + "," + H.getY() + " )"  
				;
	}
	
	//getters and setters
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public Point getC() {
		return C;
	}

	public void setC(Point c) {
		C = c;
	}

	public Point getD() {
		return D;
	}

	public void setD(Point d) {
		D = d;
	}

	public Point getE() {
		return E;
	}

	public void setE(Point e) {
		E = e;
	}

	public Point getF() {
		return F;
	}

	public void setF(Point f) {
		F = f;
	}

	public Point getG() {
		return G;
	}

	public void setG(Point g) {
		G = g;
	}

	public Point getH() {
		return H;
	}

	public void setH(Point h) {
		H = h;
	}

}
