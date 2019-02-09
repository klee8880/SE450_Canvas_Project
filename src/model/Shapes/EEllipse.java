package model.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Point;
import model.ShapeType;
import model.interfaces.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

class EEllipse extends Entity{
	
	EEllipse(IApplicationState AppState, Point start, int height, int width) {
		
		super(AppState, start, height, width);
		this.type = ShapeType.ELLIPSE;
		
	}
	
	private EEllipse(Point start, int height, int width){
		
		super(start, height, width);
		this.type = ShapeType.ELLIPSE;
	}
	
	public void draw(PaintCanvasBase Canvas) {
		
		Graphics2D graphic = Canvas.getGraphics2D();
		
		//Fill Shape
		if (fill) {
			graphic.setColor(primary);
			graphic.fillOval(this.StartPoint.x, this.StartPoint.y, width, height);
		}
		
		//Outline Shape
		if (outline) {
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(secondary);
			graphic.drawOval(this.StartPoint.x, this.StartPoint.y, width, height);
		}
		
		//Selected Shape
		if (selected) selectDraw(graphic);
		
	}

	public void selectDraw (Graphics2D graphic) {
	
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
	    graphic.setStroke(stroke);
	    graphic.setColor(Color.BLACK);
		graphic.drawOval(this.StartPoint.x - 5, this.StartPoint.y - 5, width + 10, height + 10);
	
	}

	@Override
	public boolean contains(Point Point) {
		// TODO Figure out and implement Ellipse math 
		return false;
	}
	
	@Override
	public Entity clone() {
		
		EEllipse ellipse = new EEllipse(new Point(this.StartPoint.x,this.StartPoint.y),this.height, this.width);
		ellipse.setFill(this.fill);
		ellipse.setOutline(this.outline);
		ellipse.setSelected(this.selected);
		ellipse.setPrimary(this.primary);
		ellipse.setSecondary(secondary);
		
		return ellipse;
	}

}
