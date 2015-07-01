package greenDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/*
Abstract table model for UI display 
 */
class ListingsTableModel extends AbstractTableModel {
    /** The result set from the Listings table to be displayed */
    private ResultSet rs;

    public ListingsTableModel(ResultSet rs) {
        this.rs = rs;
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.TableModel#getRowCount()
     */
    public int getRowCount() {
        try {
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    public int getColumnCount() {
        return 3;
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    public String getColumnName(int column) {
        try {
            String colName = rs.getMetaData().getColumnName(column + 1);
            // Return column names that look better than the database column names.
            // Since getColumnCount always returns 3, we only look for first 3 columns in
            // the result set.
            if(colName.equals("LAST_NAME"))
                return "Last Name";
            else if(colName.equals("FIRST_NAME"))
                return "First Name";
            else if(colName.equals("AREA_CODE"))
                return "Phone Number";
            else return colName;      // Should never get here.

        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    public Object getValueAt(int row, int column) {
        try {
            rs.absolute(row + 1);
            // for the 3rd column in the results, combine all of the phone number fields for output
            if(column == 2)
                return "(" + rs.getObject(column + 1) + ") " + rs.getObject(column + 2) + "-" + rs.getObject(column + 3);
            else
                return rs.getObject(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}   
