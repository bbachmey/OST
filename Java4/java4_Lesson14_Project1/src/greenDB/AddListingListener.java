package greenDB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Action listener for phone book frame
 */
class AddListingListener implements ActionListener {
    /** 
     * The SimplePhoneBook application frame 
     */
    PhoneBookFrame pbf;
    
    public AddListingListener(PhoneBookFrame pbFrame) {
        pbf = pbFrame;
    }
    
    public void actionPerformed(ActionEvent aEvent) {
        AddListingDialog addDialog = new AddListingDialog(pbf);
        addDialog.setVisible(true);
    }
}  