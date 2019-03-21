package controller.strategies;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Point;
import model.Shapes.Entity;

public class triangleDraw implements ADrawStrategy{

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

	@Override
	public void selectDraw(Entity shape, Graphics2D graphic) {
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		graphic.setStroke(stroke);
	    graphic.setColor(Color.BLACK);
	    
	    int [] xArray = new int [3];
	    int [] yArray = new int [3];
	    
	    xArray[0] = shape.getStartPoint().x - 5;
	    yArray[0] = shape.getStartPoint().y - 5;
	    
	    xArray[1] = xArray[0];
	    yArray[1] = yArray[0] + shape.getHeight() + 5;
	    
	    xArray[2] = xArray[1] + shape.getWidth() + 5;
	    yArray[2] = yArray[1];
	    
	    graphic.drawPolygon(xArray, yArray, 3);
		
	}

}
