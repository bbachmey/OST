package enums;

public enum ShapeAction {
	DRAW("Draw"), MOVE("Move"), REMOVE("Remove"), RESIZE("Resize"), CHANGE(
			"Change"), FILL("Fill");

	private String name;

	ShapeAction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
