import java.awt.*;
import java.util.ArrayList;


/**
 * @author bbachmey
 *
 */
public class MathGraph extends MathShape {
	/* Graph dimensions */
	int rows;
	int columns;
	int unit;
	int margin;
	/* Graph components */
	MathPoint center;
	ArrayList<MathShape> shapes;

	/**
	 * @param cl
	 * @param rw
	 * @param un
	 * @param ma
	 */
	MathGraph(int cl, int rw, int un, int ma){
		//super(Color.BLACK);
		this.columns = cl;
		this.rows = rw;
		this.unit = un;		
		this.margin = ma;
		int x = (int)(cl*un/2);
		int y = (int)(rw*un/2);
		this.center = new MathPoint(x+margin,y+margin);
		this.shapes = makeShapes();
	}

	private ArrayList<MathShape> makeShapes() {
		//
		//Declare local variables
		//
		ArrayList<MathShape> maths = new ArrayList<MathShape>();
		Dot centerDot;
		MathLine xline;
		MathLine yline;

		//
		//Initialize local variables
		//
		
		//make a Dot centered around the Point which is given as the conceptual center of the Graph
		//the constructor for Dot object has logic which centers itself around the point given
		centerDot = new Dot(center,20);
		//add the shape to the array list
		maths.add(centerDot);
		
		//make the x-coordinate line
		xline = new MathLine(
					new MathPoint(
						(int)(center.getX()-(rows*unit/2)), 
						(int)center.getY() 
						), 
					new MathPoint(
						(int)(center.getX()+(rows*unit/2)), 
						(int)center.getY()
						),
					Color.BLUE
				);
		//add the shape to the array list
		maths.add(xline);
		
		//make the y-coordinate line
		yline = new MathLine(
					new MathPoint(
						(int)(center.getX()), 
						(int)(center.getY()+(rows*unit/2))
						), 
					new MathPoint(
						(int)(center.getX()), 
						(int)(center.getY()-(rows*unit/2))
						),
					Color.PINK
				);
		//add the shape to the array list
		maths.add(yline);

		//make the x lines above the x-axis
		/* for i equals 1 while i is less than or equal to half of the number of rows */
		for (int i = 1; i <= rows/2; i++){
			//make Point A
			MathPoint a = new MathPoint (
					(int)center.getX()-(columns*unit/2), // x-coordinate of the first line is equal to the x-coordinate of the center point 
					(int)center.getY()-(i*unit) // y-coordinate of the first line is equal to the y-coordinate of the center point minus the incremental counter multiplied by the space unit
					);
			
			//make Point B
			MathPoint b = new MathPoint(
					(int)center.getX()+(columns*unit/2),
					(int)center.getY()-(i*unit)
					);
		
			//make a new line
			MathLine line = new MathLine(a,b);
			
			//add the line to the shapes array
			maths.add(line);
			
		}
//
//		//draw the x rows below the x-axis
//		/* for i equals 1 while i is less than or equal to half of the number of rows */
//		for (int i = 1; i <= rows/2; i++){
//			//jot the current color of the graphics object
//			Color jot = g.getColor();
//			//set a temporary color for the graphics object
//			g.setColor(Color.MAGENTA);
//			//draw a horizontal line
//			g.drawLine(
//					(int)center.getX()-(columns*unit/2), // x-coordinate of the first line is equal to the x-coordinate of the center point 
//					(int)center.getY()-(i*unit*-1), // y-coordinate of the first line is equal to the y-coordinate of the center point minus the incremental counter multiplied by the space unit 
//					(int)center.getX()+(columns*unit/2),
//					(int)center.getY()-(i*unit*-1)
//					);
//			g.setColor(jot);			
//		}
//
//
//		//draw the columns to the right of the y-axis
//		for (int i = 1; i <= columns/2; i++){
//			//jot the current color of the graphics object
//			Color jot = g.getColor();
//			//set a temporary color for the graphics object
//			g.setColor(Color.ORANGE);
//			//draw a horizontal line
//			g.drawLine(
//					(int)center.getX()+(i*unit), // x-coordinate of the first line is equal to the x-coordinate of the center point 
//					(int)center.getY()-(rows*unit/2), // y-coordinate of the first line is equal to the y-coordinate of the center point minus the incremental counter multiplied by the space unit 
//					(int)center.getX()+(i*unit),
//					(int)center.getY()+(rows*unit/2)
//					);
//			g.setColor(jot);			
//		}
//
//
//		//draw the columns to the left of the y-axis
//		for (int i = 1; i <= columns/2; i++){
//			//jot the current color of the graphics object
//			Color jot = g.getColor();
//			//set a temporary color for the graphics object
//			g.setColor(Color.PINK);
//			//draw a horizontal line
//			g.drawLine(
//					(int)center.getX()-(i*unit), // x-coordinate of the first line is equal to the x-coordinate of the center point 
//					(int)center.getY()-(rows*unit/2), // y-coordinate of the first line is equal to the y-coordinate of the center point minus the incremental counter multiplied by the space unit 
//					(int)center.getX()-(i*unit),
//					(int)center.getY()+(rows*unit/2)
//					);
//			g.setColor(jot);			
//		}
//		//draw the cross marks
//
//		//draw the x line
//
//		//draw the y line
//
//		//draw the x line end mark
//
//		//draw the y line end mark

		return maths;
	}

	/**
	 * @param g
	 */
	public void draw(Graphics g){

		for (MathShape ms : shapes){
			ms.draw(g);
		}

	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public MathPoint getCenter() {
		return center;
	}

	public void setCenter(MathPoint center) {
		this.center = center;
	}

	public ArrayList<MathShape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<MathShape> shapes) {
		this.shapes = shapes;
	}



}
