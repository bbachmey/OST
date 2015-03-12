package enums;

/**
 * @author bbachmey
 *
 */
public enum ShapeType {
	RECTANGLE("Rectangle"), OVAL("Oval"), POLYTRI("Triangle"), POLYOCTAGON(
			"Octagon");

	private String name;

	ShapeType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
