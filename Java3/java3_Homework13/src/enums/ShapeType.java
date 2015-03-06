package enums;

public enum ShapeType {
	RECTANGLE ( "Rectangle"),
	OVAL ( "Oval"),
	TRIANGLE ( "Triangle"),
	POLYTRI ( "PolyTri")
	;
	
	private String name;
	
	ShapeType(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
