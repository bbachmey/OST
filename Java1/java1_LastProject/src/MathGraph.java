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
	MathPoint graphCenterPoint;
	ArrayList<MathShape> graphShapes;

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
		this.graphCenterPoint = new MathPoint(x+margin,y+margin); //all of the MathShapes on the graph are ancored to this MathPoint
		this.graphShapes = makeShapes();
	}

	private ArrayList<MathShape> makeShapes() {
		//
		//Declare local variables
		//
		ArrayList<MathShape> maths = new ArrayList<MathShape>();
		Dot centerDot;
		MathLine xaxis;
		MathLine yaxis;

		//
		//Initialize local variables
		//

		//make a Dot centered around the Point which is given as the conceptual center of the Graph
		//the constructor for Dot object has logic which centers itself around the point given
		centerDot = new Dot(graphCenterPoint,20);
		//add the shape to the array list
		maths.add(centerDot);

		//make the x-axis
		//a MathLine is two MathPoints
		xaxis = new MathLine(
				new MathPoint(
						//the x-coordinate of the FIRST point of the MathLine that represents the line on the graph where x=0
						//is equal to the x-coordinate of the center point of the graph, 
						//  MINUS the product of the number of rows in the graph,
						//  multiplied by the spacing unit, 
						//  divided by two
						(int)(graphCenterPoint.getX()-(rows*unit/2)), 
						//the y-coordinate of the FIRST point of the MathLine that represents the line on the graph where x=0
						//  is the same as the y-coordinate of the center point 
						(int)graphCenterPoint.getY() 
						), 
						new MathPoint(
								//the x-coordinate of the SECOND point of the MathLine that represents the line on the graph where x=0
								//is equal to the x-coordinate of the center point of the graph, 
								//  PLUS the product of the number of rows in the graph,
								//  multiplied by the spacing unit, 
								//  divided by two
								(int)(graphCenterPoint.getX()+(rows*unit/2)), 
								//the y-coordinate of the SECOND point of the MathLine that represents the line on the graph where x=0
								//  is the same as the y-coordinate of the center point 
								(int)graphCenterPoint.getY()
								),
								Color.BLUE
				);
		//add the shape to the array list
		maths.add(xaxis);

		//make the y-axis
		yaxis = new MathLine(
				new MathPoint(
						//the x-coordinate of every point on the y-axis is the same as the x-coordinate of the center point 
						(int)(graphCenterPoint.getX()), 
						(int)(graphCenterPoint.getY()+(rows*unit/2))
						), 
						new MathPoint(
								//the x-coordinate of every point on the y-axis is the same as the x-coordinate of the center point
								(int)(graphCenterPoint.getX()), 
								(int)(graphCenterPoint.getY()-(rows*unit/2))
								),
								Color.PINK
				);
		//add the shape to the array list
		maths.add(yaxis);

		//make the x lines above the x-axis
		/* for i equals 1 while i is less than or equal to half of the number of rows */
		for (int i = 1; i <= rows/2; i++){
			//make Point A
			MathPoint a = new MathPoint (
					// x-coordinate of the first line is equal to the x-coordinate of the center point
					(int)graphCenterPoint.getX()-(columns*unit/2),
					// y-coordinate of the first line is equal to the y-coordinate of the center point 
					//   minus the incremental counter multiplied by the space unit
					(int)graphCenterPoint.getY()-(i*unit) 
					);

			//make Point B
			MathPoint b = new MathPoint(
					// x-coordinate of the first line is equal to the x-coordinate of the center point
					(int)graphCenterPoint.getX()+(columns*unit/2),
					// y-coordinate of the first line is equal to the y-coordinate of the center point 
					//   minus the incremental counter multiplied by the space unit
					(int)graphCenterPoint.getY()-(i*unit)
					);

			//make a new line
			MathLine line = new MathLine(a,b,Color.GREEN);

			//add the line to the shapes array
			maths.add(line);

		}

		//make the x lines below the x-axis
		/* for i equals 1 while i is less than or equal to half of the number of rows */
		for (int i = 1; i <= rows/2; i++){
			//make Point A
			MathPoint a = new MathPoint (
					// x-coordinate of the first line is equal to the x-coordinate of the center point 
					(int)graphCenterPoint.getX()-(columns*unit/2),
					// y-coordinate of the first line is equal to the y-coordinate of the center point 
					// PLUS the incremental counter multiplied by the space unit
					(int)graphCenterPoint.getY()+(i*unit) 
					);

			//make Point B
			MathPoint b = new MathPoint(
					(int)graphCenterPoint.getX()+(columns*unit/2),
					(int)graphCenterPoint.getY()+(i*unit)
					);

			//make a new line
			MathLine line = new MathLine(a,b,Color.CYAN);

			//add the line to the shapes array
			maths.add(line);

		}


		//make the y lines to the right of the y axis
		/* for i equals 1 while i is less than or equal to half of the number of rows */
		for (int i = 1; i <= rows/2; i++){
			//make Point A
			MathPoint a = new MathPoint (
					// x-coordinate of the first line is equal to the x-coordinate of the center point 
					(int)graphCenterPoint.getX()+(i*unit),
					// y-coordinate of the first line is equal to the y-coordinate of the center point 
					// PLUS the incremental counter multiplied by the space unit
					(int)graphCenterPoint.getY()-(rows*unit/2)
					);

			//make Point B
			MathPoint b = new MathPoint(
					(int)graphCenterPoint.getX()+(i*unit),
					(int)graphCenterPoint.getY()+(rows*unit/2)
					);

			//make a new line
			MathLine line = new MathLine(a,b,Color.ORANGE);

			//add the line to the shapes array
			maths.add(line);

		}
		
		//make the y lines to the left of the y axis
		/* for i equals 1 while i is less than or equal to half of the number of rows */
		for (int i = 1; i <= rows/2; i++){
			//make Point A
			MathPoint a = new MathPoint (
					// x-coordinate of the first line is equal to the x-coordinate of the center point 
					(int)graphCenterPoint.getX()-(i*unit),
					// y-coordinate of the first line is equal to the y-coordinate of the center point 
					// PLUS the incremental counter multiplied by the space unit
					(int)graphCenterPoint.getY()-(rows*unit/2)
					);

			//make Point B
			MathPoint b = new MathPoint(
					(int)graphCenterPoint.getX()-(i*unit),
					(int)graphCenterPoint.getY()+(rows*unit/2)
					);

			//make a new line
			MathLine line = new MathLine(a,b,Color.MAGENTA);

			//add the line to the shapes array
			maths.add(line);

		}

		//		//draw the cross marks
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

		for (MathShape ms : graphShapes){
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
		return graphCenterPoint;
	}

	public void setCenter(MathPoint center) {
		this.graphCenterPoint = center;
	}

	public ArrayList<MathShape> getShapes() {
		return graphShapes;
	}

	public void setShapes(ArrayList<MathShape> shapes) {
		this.graphShapes = shapes;
	}



}
