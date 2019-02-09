package controller;

import java.util.LinkedList;
import model.interfaces.Entity;
import view.interfaces.PaintCanvasBase;

public class ShapeList implements IShapeList {

	private LinkedList <Entity> shapes = new LinkedList <Entity> ();

	@Override
	public void add(Entity newShape) {
		shapes.add(newShape);
	}

	@Override
	public void drawAll(PaintCanvasBase Canvas) {
		// TODO 
		
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
	
	
}
