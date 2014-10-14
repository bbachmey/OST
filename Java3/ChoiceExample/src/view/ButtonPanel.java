package view;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;

public class ButtonPanel extends Panel {
  
    Model model;
    Button resetBtn = new Button("Reset");
    
    public ButtonPanel(Model mdl) {
        model = mdl;
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.resetComponents();
            }
        });
    this.add(resetBtn);
    }
}