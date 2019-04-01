package controller.strategies;

import java.awt.Graphics2D;

import model.Shapes.Shape;

public interface ADrawStrategy {

	public void drawShape(Shape shape, Graphics2D graphic);
	
	public void selectDraw(Shape shape, Graphics2D graphic);
		
}
