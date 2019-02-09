package controller.strategies;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import model.Point;
import model.interfaces.Entity;

public class triangleDraw extends ADrawStrategy{

	@Override
	public void drawShape(Entity shape, Graphics2D graphic) {
		
		//Set dimensions
		int height = shape.getHeight();
		int width = shape.getWidth();
		Point StartPoint = shape.getStartPoint();
		int [] xArray = new int[3];
		int [] yArray = new int[3];
		
		//Find points
		xArray[0] = StartPoint.x;
		yArray[0] = StartPoint.y;
		
		xArray[1] = StartPoint.x;
		yArray[1] = StartPoint.y + height;
		
		xArray[2] = StartPoint.x + width;
		yArray[2] = StartPoint.y + height;
		
		
		//Draw this shape
		
		switch(shape.getShading()) {
		
		case FILLED_IN:	
			graphic.setColor(shape.getPrimary());
			graphic.fillPolygon(xArray, yArray, 3);
			break;
			
		case OUTLINE:
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(shape.getPrimary());
			graphic.drawPolygon(xArray, yArray, 3);
			break;
			
		case OUTLINE_AND_FILLED_IN:
			
			graphic.setColor(shape.getPrimary());
			graphic.fillPolygon(xArray, yArray, 3);
			
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(shape.getSecondary());
			graphic.drawPolygon(xArray, yArray, 3);
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected fillType encountered when drawing shape");
		}
		
	}

}
