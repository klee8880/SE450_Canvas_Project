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

class ERectangle extends Entity{

	ERectangle(IApplicationState AppState, Point start, int height, int width) {
		
		super(AppState, start, height, width);
		this.type = ShapeType.RECTANGLE;
		
	}
	
	private ERectangle(Point start, int height, int width) {
		super(start, height, width);
		this.type = ShapeType.RECTANGLE;
	}
	
	public void draw(PaintCanvasBase Canvas) {
		
		Graphics2D graphic = Canvas.getGraphics2D();
		
		//Fill Shape
		if (fill) {
			graphic.setColor(primary);
			graphic.fillRect(this.StartPoint.x, this.StartPoint.y, width, height);
		}
		
		//Outline Shape
		if (outline) {
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(secondary);
			graphic.drawRect(this.StartPoint.x, this.StartPoint.y, width, height);
		}
		
		//Selected Shape
		if (selected) selectDraw(graphic);
		
	}
	
	@Override
	public void selectDraw(Graphics2D graphic) {
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		graphic.setStroke(stroke);
	    graphic.setColor(Color.BLACK);
		graphic.drawRect(this.StartPoint.x - 5, this.StartPoint.y - 5, width + 10, height + 10);
		
	}

	@Override
	public boolean contains(Point Point) {
		
		//Test Outside of x range
		if (Point.x < StartPoint.x || Point.x > StartPoint.x + width) {
			return false;
		}
		
		//Test Outside of y range
		if (Point.y < StartPoint.y || Point.y > StartPoint.y + height) {
			return false;
		}
		return true;
	}
	
	@Override
	public Entity clone() {
		ERectangle rectangle = new ERectangle(new Point(this.StartPoint.x,this.StartPoint.y), this.height, this.width);
		rectangle.setFill(this.fill);
		rectangle.setOutline(this.outline);
		rectangle.setSelected(this.selected);
		rectangle.setPrimary(this.primary);
		rectangle.setSecondary(secondary);
		
		return rectangle;
	}

}
