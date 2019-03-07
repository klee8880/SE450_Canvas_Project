package controller.strategies;

import java.awt.Graphics2D;

import model.Shapes.Entity;

public abstract class ADrawStrategy {

	public abstract void drawShape(Entity shape, Graphics2D graphic);
	
	public abstract void selectDraw(Entity shape, Graphics2D graphic);
		
}
