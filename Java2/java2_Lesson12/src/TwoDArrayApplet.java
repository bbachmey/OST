import java.applet.Applet;
import java.awt.Color;


public class TwoDArrayApplet extends Applet {
	private final int START_X = 20;
	private final int START_Y = 40;
	private final int ROWS = 4;
	private final int COLS = 4; 
	private final int BOX_WIDTH = 20;
	private final int BOX_HEIGHT = 20;

	private ClickableBox boxes[][];
	private Color boxColors[][];

	public void init() {
		boxes = new ClickableBox[ROWS][COLS];
		boxColors = new Color[ROWS][COLS];
		randomizeColors();
		buildBoxes();
	}

	private void buildBoxes(){
		for(int row = 0; row < boxes.length; row++) {
			for(int col = 0; col < boxes[row].length; col++) {
				boxes[row][col] = 
						new ClickableBox(START_X + col * BOX_WIDTH,
								START_Y + row * BOX_HEIGHT,
								BOX_WIDTH,
								BOX_HEIGHT,
								Color.gray,
								boxColors[row][col],
								true,
								this);
			}
		}
	}

	private void randomizeColors() {
		int[] chosenColors = {0, 0, 0, 0, 0, 0, 0, 0 };
		Color[] availableColors = { Color.red, Color.blue, Color.green,
				Color.yellow, Color.cyan, Color.magenta, Color.pink, Color.orange };
		for(int row = 0; row < boxes.length; row++) {
			for(int col = 0; col < boxes[row].length; col++) {
				for(;;) {
					int rnd = (int)(Math.random() * 8);
					if(chosenColors[rnd] < 2) {
						chosenColors[rnd]++;
						boxColors[row][col] = availableColors[rnd];
						break;
					}
				}
			}
		}
	}


}
