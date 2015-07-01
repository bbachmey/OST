package greenDB;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/*
 Focus listener for phone number
 */
class PhoneFocusListener implements FocusListener {

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
    public void focusGained(FocusEvent fEvent) {
        JTextField tf = (JTextField)fEvent.getSource();
        tf.setText("");
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
     */
    public void focusLost(FocusEvent fEvent){}
    
}  