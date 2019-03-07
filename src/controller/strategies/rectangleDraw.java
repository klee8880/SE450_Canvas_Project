package controller.strategies;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Shapes.Entity;

public class rectangleDraw extends ADrawStrategy{

	@Override
	public void drawShape(Entity shape, Graphics2D graphic) {
		
		int x = shape.getStartPoint().x;
		int y = shape.getStartPoint().y;
		int height = shape.getHeight();
		int width = shape.getWidth();
		
		switch(shape.getShading()) {
		
		case FILLED_IN:	
			graphic.setColor(shape.getPrimary());
			graphic.fillRect(x, y, width, height);
			break;
			
		case OUTLINE:
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(shape.getPrimary());
			graphic.drawRect(x, y, width, height);
			break;
			
		case OUTLINE_AND_FILLED_IN:
			
			graphic.setColor(shape.getPrimary());
			graphic.fillRect(x, y, width, height);
			
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(shape.getSecondary());
			graphic.drawRect(x, y, width, height);
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected fillType encountered when drawing shape");
		
		}
		
	}

	public void selectDraw(Entity shape, Graphics2D graphic) {
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		graphic.setStroke(stroke);
	    graphic.setColor(Color.BLACK);
		graphic.drawRect(shape.getStartPoint().x - 5, shape.getStartPoint().y - 5, shape.getWidth() + 10, shape.getHeight() + 10);
		
	}
	
}
