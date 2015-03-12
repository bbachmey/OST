package ui.applet;

import interfaces.Resettable;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import event.ShapeMouseHandler;
import shapes.Oval;
import shapes.PolyOctagon;
import shapes.PolyTri;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Triangle;
import ui.panels.MainPanel;
import model.Model;

public class GUIDemo extends Applet implements Resettable {
	MainPanel mainPanel;
	Model model;

	public void init() {
		//set the applet window size
		resize(600,400);

		//make a Model object and send it this Applet
		model = new Model(this);
		
		//make a MainPanel object
		mainPanel = new MainPanel(model);

		//add the MainPanel to this Applet
		this.add(mainPanel);

		//make a ShapeMouseHandler
		ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
		
		//add the ShapeMouseHandler to this applet as a MouseListener
		this.addMouseListener(mouseHandler);
		
		//add the ShapeMouseHandler to this applet as a MouseMotionListener
		this.addMouseMotionListener(mouseHandler);

	}

	public void paint(Graphics g) {
		//declare an index counter
		int i = -1;
		//Loop through instantiation of Shapes from the Model
		for (Shape shape : model.shapes){
			//increment the counter
			i++;
			//If the Model provided a Shape, then draw() it
			if(shape != null) {
				// The logic for how the Shape is drawn is in the draw() method of the Shape. 
				shape.draw(g);
			}

			//Log the Model and Shape to the console
			System.out.println(model);
			System.out.println(shape);

			//Homework 10
			// So that we can see how they are stored, each time a new figure is added 
			//to the list, provide output in the console of all of the elements in the 
			//Vector (or ArrayList) at that time. 
			if (shape instanceof Rectangle){
				System.out.println("Element " + i + " is a rectangle");
			} 
			if (shape instanceof Oval){
				System.out.println("Element " + i + " is a oval");                
			} 
			if (shape instanceof Triangle){
				System.out.println("Element " + i + " is a triangle");                
			}
			if (shape instanceof PolyTri){
				System.out.println("Element " + i + " is a polytri");                
			}
			if (shape instanceof PolyOctagon){
				System.out.println("Element " + i + " is an octagon");                
			}

			//Homework 9
			//Then if two figures have been drawn and the two objects drawn can be compared,
			//have the objects compared using the model's compareShapes() method.
			//The applet output should show the two drawings and also specify which one 
			//is larger than the other, or if they are the same area.
			
			//Homework 10
			//compareShapes() is only relevant to the previous objective.  
			//Now that multiple figures can be drawn, compareShapes() won't work as 
			//previously designed.  You are free to update compareShapes() to compare 
			//multiple shapes or comment this method out.
			
			/*
            if (model.shapes[1] != null){
            	int comparison = model.compareShapes();
            	switch (comparison){
            	case -1:
        			g.drawString("The shapes cannot be compared", 200, 200);
            		break;
            	case 0:
        			g.drawString("The shapes are the same size", 200, 200);
            		break;
        		case 1:
        			g.drawString("The first shape is bigger than the second shape", 200, 200);
            		break;
        		case 2:
        			g.drawString("The second shape is bigger than the first shape", 200, 200);
            		break;
            	}
            }
			 */

		}
	}

	public void resetComponents() {
		//call the resetComponents() method of the MainPanel object
		if(mainPanel != null){
			mainPanel.resetComponents();			
		}
	}
}