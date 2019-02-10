package controller;

import java.util.LinkedList;

import model.Shapes.Entity;
import view.interfaces.PaintCanvasBase;

//Observer-Subject Build Pattern Object
public interface IShapeList {

	public void add(Entity shape);
	
	public void removeLast();
	
	public void remove(Entity e);
	
	public void clear();
	
	public boolean isEmpty();
	
	public void drawAll(PaintCanvasBase Canvas);
	
	public void moveAll(int x, int y);
	
	public void groupAll(int g);
	
	public void unGroupAll();
	
	public void clearObservers();
	
	public LinkedList <Entity> getShapes();
	
	public IShapeList clone();
	
}
