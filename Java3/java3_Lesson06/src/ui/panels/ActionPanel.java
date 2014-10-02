package ui.panels;

import interfaces.Resettable;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;
import model.Model;

public class ActionPanel extends Panel implements Resettable{
    private CheckboxGroup actionGroup;
    private Checkbox chkDraw, chkMove, chkResize, chkRemove, chkChange, chkFill;
  
    public ActionPanel(final Model model){
        actionGroup = new CheckboxGroup();
        chkDraw = new Checkbox(Model.DRAW, actionGroup, true); 
        chkMove = new Checkbox(Model.MOVE, actionGroup, false);
        chkResize = new Checkbox(Model.RESIZE, actionGroup, false);
        chkRemove = new Checkbox(Model.REMOVE, actionGroup, false);
        chkChange = new Checkbox(Model.CHANGE, actionGroup, false);
        chkFill = new Checkbox(Model.FILL, false);
        setLayout(new GridLayout(1,6));
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