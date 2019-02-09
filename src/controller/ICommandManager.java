package controller;

import model.Point;

public interface ICommandManager {
	
	public void draw(Point start, Point End);
	
	public void moveShape (Point start, Point end);
	
	public void copy();
	
	public void paste();
	
	public void delete();
	
	public void select(Point begin, Point end);
	
	public void group();
	
	public void ungroup();
	
	public void redo();
	
	public void undo();

}
