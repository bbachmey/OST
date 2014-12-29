package ui.panels;

import interfaces.Resettable;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import enums.ShapeAction;
import model.Model;

public class ActionPanel extends Panel implements Resettable {

    private CheckboxGroup actionGroup;
    private Checkbox chkDraw, chkMove, chkResize, chkRemove, chkChange, chkFill;
  
    public ActionPanel(final Model model) {
    	//Instantiate the CheckboxGroup
        actionGroup = new CheckboxGroup();
       
        //instantiate the Checkboxes
        chkDraw = new Checkbox(ShapeAction.DRAW.getName(), actionGroup, true);
        chkMove = new Checkbox(ShapeAction.MOVE.getName(), actionGroup, false);
        chkResize = new Checkbox(ShapeAction.RESIZE.getName(), actionGroup, false);
        chkRemove = new Checkbox(ShapeAction.REMOVE.getName(), actionGroup, false);
        chkChange = new Checkbox(ShapeAction.CHANGE.getName(), actionGroup, false);
        chkFill = new Checkbox(ShapeAction.FILL.getName(), false);
        
        //add anonymous inner class ItemListeners to the Checkboxes
        chkDraw.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ShapeAction.DRAW);
            }
        });
        chkMove.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ShapeAction.MOVE);
            }
        });
        chkResize.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ShapeAction.RESIZE);
            }
        });
        chkRemove.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ShapeAction.REMOVE);
            }
        });
        chkChange.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setAction(ShapeAction.CHANGE);
            }
        });
        chkFill.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                model.setFill(chkFill.getState());
                
                model.repaint();
            }
        });
        
        //add Checkboxes to this Panel
        setLayout(new GridLayout(1, 6));
        add(chkDraw);
        add(chkMove);
        add(chkResize);
        add(chkRemove);
        add(chkChange);
        add(chkFill);
    }
  
    public void resetComponents() {
        chkDraw.setState(true);
        chkMove.setState(false);
        chkResize.setState(false);
        chkRemove.setState(false);
        chkChange.setState(false);
        chkFill.setState(false);
    }
}