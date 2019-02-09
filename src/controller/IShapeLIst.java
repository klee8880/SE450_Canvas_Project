package controller;

import model.interfaces.Entity;
import view.interfaces.PaintCanvasBase;

//Observer-Subject Build Pattern Object
interface IShapeList {

	public void add(Entity shape);
	
	public void drawAll(PaintCanvasBase Canvas);
	
	public void moveAll(int x, int y);
	
	public void clearObservers();
	
	public IShapeList clone();
	
}
