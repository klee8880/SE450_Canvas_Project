package controller;

import java.util.LinkedList;

import model.Shapes.Shape;
import view.interfaces.PaintCanvasBase;

//Observer-Subject Build Pattern Object
public interface IShapeList {

	public void add(Shape shape);
	
	public void removeLast();
	
	public void remove(Shape e);
	
	public void clear();
	
	public boolean isEmpty();
	
	public void drawAll(PaintCanvasBase Canvas);
	
	public void selectDrawAll(PaintCanvasBase Canvas);
	
	public void moveAll(int x, int y);
	
	public void groupAll(int g);
	
	public void unGroupAll();
	
	public void clearObservers();
	
	public LinkedList <Shape> getShapes();
	
	public IShapeList clone();
	
}
