package controller.strategies;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Shapes.Entity;

public abstract class ADrawStrategy {

	public abstract void drawShape(Entity shape, Graphics2D graphic);
	
	public void selectDraw(Entity shape, Graphics2D graphic) {
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		graphic.setStroke(stroke);
	    graphic.setColor(Color.BLACK);
		graphic.drawRect(shape.getStartPoint().x - 5, shape.getStartPoint().y - 5, shape.getWidth() + 10, shape.getHeight() + 10);
	}
		
}
