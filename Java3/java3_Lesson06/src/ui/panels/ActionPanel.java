package ui.panels;

import interfaces.Resettable;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.Panel;

public class ActionPanel extends Panel implements Resettable{

    private CheckboxGroup actionGroup;
    private Checkbox chkDraw, chkMove, chkResize, chkRemove, chkChange, chkFill;
    private final String DRAW = "Draw";
    private final String MOVE = "Move";
    private final String RESIZE = "Resize";
    private final String REMOVE = "Remove";
    private final String CHANGE = "Change";
    private final String FILL = "Fill";
      
    public ActionPanel(){
        actionGroup = new CheckboxGroup();
        chkDraw = new Checkbox(DRAW, actionGroup, true); 
        chkMove = new Checkbox(MOVE, actionGroup, false);
        chkResize = new Checkbox(RESIZE, actionGroup, false);
        chkRemove = new Checkbox(REMOVE, actionGroup, false);
        chkChange = new Checkbox(CHANGE, actionGroup, false);
        chkFill = new Checkbox(FILL, false);
        setLayout(new GridLayout(1,6));
        add(chkDraw);
        add(chkMove);
        add(chkResize);
        add(chkRemove);
        add(chkChange);
        add(chkFill);
    }
}