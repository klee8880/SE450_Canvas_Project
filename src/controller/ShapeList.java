package controller;

import java.awt.Graphics2D;
import java.util.LinkedList;

import controller.strategies.ADrawStrategy;
import controller.strategies.circleDraw;
import controller.strategies.rectangleDraw;
import controller.strategies.triangleDraw;
import model.interfaces.Entity;
import view.interfaces.PaintCanvasBase;

class ShapeList implements IShapeList {

	private LinkedList <Entity> shapes = new LinkedList <Entity> ();

	@Override
	public void add(Entity newShape) {
		shapes.add(newShape);
	}

	@Override
	public void drawAll(PaintCanvasBase Canvas) {
		
		ADrawStrategy draw;
		Graphics2D graphic = Canvas.getGraphics2D();
		
		for (Entity e: shapes) {
			switch(e.getType()) {
			case ELLIPSE:
				draw = new circleDraw();
				break;
			case RECTANGLE:
				draw = new rectangleDraw();
				break;
			case TRIANGLE:
				draw = new triangleDraw();
				break;
			default:
				throw new IllegalArgumentException("Unexpected shape type");
			
			}
			
			draw.drawShape(e, graphic);
		}
		
	}

	@Override
	public void moveAll(int x, int y) {

		for (Entity s: shapes) {
			s.move(x, y);
		}
		
	}

	@Override
	public void clearObservers() {
		shapes.clear();
	}
	
	@Override
	public IShapeList clone() {
		
		ShapeList newList= new ShapeList();
		
		for (Entity e: this.shapes) {
			newList.add(e);
		}
		
		return newList;
		
	}
	
	
}
