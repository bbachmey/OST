package view;

import java.awt.Choice;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoicePanel extends Panel{
    Choice selection;
    
    public ChoicePanel() {
        selection = new Choice();
        selection.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            }
        });
        this.add(selection);
    }
}