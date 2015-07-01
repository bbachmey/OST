package greenDB;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 Document listener for changes made to phone number
 */
class PhoneDocumentListener implements DocumentListener {
    /*** The phone number text field to which this listener applies */
    private JTextField txtField;
    /*** The number of characters that will cause focus to be transferred */
    private int numsAllowed;
    
    /**
     Constructor
     */
    public PhoneDocumentListener(JTextField tf, int numsAllowed) {
        txtField = tf;
        this.numsAllowed = numsAllowed;
    }
    
    /**
     * (non-Javadoc)
     * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.DocumentEvent)
     */
    public void insertUpdate(DocumentEvent dEvent) {
        if(dEvent.getDocument().getLength() == numsAllowed)
            txtField.transferFocus();
    }


    /**
     * (non-Javadoc)
     * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.DocumentEvent)
     */
    public void removeUpdate(DocumentEvent dEvent) {}

    /**
     * (non-Javadoc)
     * @see javax.swing.event.DocumentListener#changedUpdate(javax.swing.event.DocumentEvent)
     */
    public void changedUpdate(DocumentEvent dEvent) {}
} 
