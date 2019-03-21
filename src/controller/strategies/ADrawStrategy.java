package controller.strategies;

import java.awt.Graphics2D;

import model.Shapes.Entity;

public interface ADrawStrategy {

	public void drawShape(Entity shape, Graphics2D graphic);
	
	public void selectDraw(Entity shape, Graphics2D graphic);
		
}
