package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import java.awt.Graphics;

import event.ShapeMouseHandler;

import shapes.Shape;

import ui.panels.MainPanel;
import model.Model;

public class GUIDemo extends Applet implements Resettable {
    MainPanel mainPanel;
    Model model;
  
    public void init() {
    	//set the applet window size
        resize(600,400);
        //make a Model object
        model = new Model(this);
        //make a MainPanel object
        mainPanel = new MainPanel(model);
        //add the MainPanel to this Applet
        add(mainPanel);
        //make a ShapeMouseHandler
        ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
        //add the ShapeMouseHandler to this applet as a MouseListener
        addMouseListener(mouseHandler);
        //add the ShapeMouseHandler to this applet as a MouseMotionListener
        addMouseMotionListener(mouseHandler);
    }
  
    public void paint(Graphics g) {
    	//Declare a Shape
        Shape shape;
        //Instantiate the Shape from the Model
        shape = model.getCurrentShape();
        //If the Model provided a Shape, then draw() it
        if(shape != null) {
          shape.draw(g);
        }
        //Log the Model and Shape to the console
        System.out.println(model);
        System.out.println(shape);
    }
  
    public void resetComponents() {
    	//call the resetComponents() method of the MainPanel object
        mainPanel.resetComponents();
    }
}