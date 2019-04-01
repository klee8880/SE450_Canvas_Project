package controller;

import java.awt.Graphics2D;
import java.util.LinkedList;
import controller.strategies.ADrawStrategy;
import controller.strategies.circleDraw;
import controller.strategies.rectangleDraw;
import controller.strategies.triangleDraw;
import model.Shapes.Shape;
import view.interfaces.PaintCanvasBase;

public class ShapeList implements IShapeList {

	private LinkedList <Shape> shapes = new LinkedList <Shape> ();

	@Override
	public void add(Shape newShape) {
		
		if (!shapes.contains(newShape)) {
			shapes.add(newShape);
		}
	}
	
	@Override
	public void removeLast() {
		shapes.removeLast();
	}
	
	@Override
	public void remove(Shape e) {
		shapes.remove(e);
	}
	
	@Override
	public void clear() {
		shapes.clear();
	}
	
	@Override
	public boolean isEmpty() {
		return shapes.isEmpty();
	}

	@Override
	public void drawAll(PaintCanvasBase Canvas) {
		
		ADrawStrategy draw;
		Graphics2D graphic = Canvas.getGraphics2D();
		
		for (Shape e: shapes) {
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
	public void selectDrawAll(PaintCanvasBase Canvas) {
		ADrawStrategy draw = null;
		Graphics2D graphic = Canvas.getGraphics2D();
		
		for (Shape e: shapes) {
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
			
			draw.selectDraw(e, graphic);
		}
	}

	@Override
	public void moveAll(int x, int y) {

		for (Shape s: shapes) {
			s.move(x, y);
		}
		
	}
	
	@Override
	public void groupAll(int g) {
		for (Shape e: shapes) {e.setGroup(g);}
	}
	
	@Override
	public void unGroupAll() {
		
	}

	@Override
	public void clearObservers() {
		shapes.clear();
	}
	
	@Override
	public IShapeList clone() {
		
		ShapeList newList= new ShapeList();
		
		for (Shape e: this.shapes) {
			newList.add(e);
		}
		
		return newList;
		
	}

	@Override
	public LinkedList <Shape> getShapes() {
		
		LinkedList <Shape> newList = new LinkedList <Shape> ();
		
		for (Shape e: shapes) newList.add(e);
		
		return newList;
	}
	
	
}
