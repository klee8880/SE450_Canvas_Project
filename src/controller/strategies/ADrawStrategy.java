package controller.strategies;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.interfaces.Entity;
import view.interfaces.PaintCanvasBase;

public abstract class ADrawStrategy {

	public abstract void drawShape(Entity shape, PaintCanvasBase canvas);
	
	public void selectDraw(Entity shape, PaintCanvasBase canvas) {
		
		Graphics2D graphic = canvas.getGraphics2D();
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		graphic.setStroke(stroke);
	    graphic.setColor(Color.BLACK);
		graphic.drawRect(shape.getStartPoint().x - 5, shape.getStartPoint().y - 5, shape.getWidth() + 10, shape.getHeight() + 10);
	}
		
}
