package ui.applet;
import java.applet.Applet;
import java.awt.*;

public class GUIDemo extends Applet {

    private final String DRAW = "Draw";
    
    public void init(){
        Checkbox draw = new Checkbox(DRAW);
        add(draw);		                       
    }
}