import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Lesson2 extends JPanel {

	private static final long serialVersionUID = 1L;
	
	String[] columnNames;
    Object[][] data;
    		
    public Lesson2() {
        super(new GridLayout(1,0));

        buildModel();

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void buildModel() {
		columnNames = new String[] {"First Name",
		  "Last Name",
		  "Birthday",
		  "Phone",
		  "Address",
		  "City",
		  "Zip"};
		
		  data = new Object[][] {
			{"Amanda",	"Anderson", 	"Jan 1",	"000-123-4567", 	"123 Apple St.",	"Appleton", "01234" },
			{"Betsy", 	"Baldwin", 	"Feb 1",	"000-123-4567", 	"123 Blueberry St.",	"Boston", "12345"  },
			{"Carrie", 	"Caldwell", 	"Mar 1",	"000-123-4567", 	"123 Cherry St.",	"Cincinnati", "23456"  },
			{"Diane", 	"Davis", "Apr 1",	"000-123-4567", 	"123 Dill St.",	"Denver", "34567"  },
			{"Erma", 	"Edwards", 	"May 1",	"000-123-4567", 	"123 Eggplant St.",	"Empire", "45678"  }
		  };
		
	}

	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void buildView() {
        // Frame
        JFrame jFrame = new JFrame("Lesson2");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Content pane
        Lesson2 newContentPane = new Lesson2();
        jFrame.setContentPane(newContentPane);

        // Display
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                buildView();
            }
        });
    }
}