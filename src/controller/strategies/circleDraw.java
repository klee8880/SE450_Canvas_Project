package controller.strategies;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import model.interfaces.Entity;

public class circleDraw extends ADrawStrategy {

	@Override
	public void drawShape(Entity shape, Graphics2D graphic) {
		
		int x = shape.getStartPoint().x;
		int y = shape.getStartPoint().y;
		int height = shape.getHeight();
		int width = shape.getWidth();
		
		switch(shape.getShading()) {
		
		case FILLED_IN:	
			graphic.setColor(shape.getPrimary());
			graphic.fillOval(x, y, width, height);
			break;
			
		case OUTLINE:
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(shape.getPrimary());
			graphic.drawOval(x, y, width, height);
			break;
			
		case OUTLINE_AND_FILLED_IN:
			
			graphic.setColor(shape.getPrimary());
			graphic.fillOval(x, y, width, height);
			
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(shape.getSecondary());
			graphic.drawOval(x, y, width, height);
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected fillType encountered when drawing shape");
		
		}
		
	}

}
