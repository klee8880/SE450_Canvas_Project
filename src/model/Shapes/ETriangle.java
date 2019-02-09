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

class ETriangle extends Entity{
	
	private int [] xArray = new int [3];
	private int [] yArray = new int[3];

	protected ETriangle(IApplicationState AppState, int [] xArray, int [] yArray, int height, int width) {
		super(AppState, new Point(xArray[0], yArray[0]), height, width);
		this.xArray = xArray.clone();
		this.yArray = yArray.clone();
		this.type = ShapeType.TRIANGLE;
		
	}
	
	private ETriangle(int [] xArray, int [] yArray, int height, int width) {
		super(new Point(xArray[0], yArray[0]), height, width);
		this.xArray = xArray.clone();
		this.yArray = yArray.clone();
		this.type = ShapeType.TRIANGLE;
	}

	public int[] getXArray() {
		return xArray.clone();
	}

	public int[] getYArray() {
		return yArray.clone();
	}

	@Override
	public void draw(PaintCanvasBase Canvas) {
		
		Graphics2D graphic = Canvas.getGraphics2D();
		
		//Fill Shape
		if (fill) {
			graphic.setColor(primary);
			graphic.fillPolygon(xArray, yArray, 3);
		}
		
		//Outline Shape
		if (outline) {
			graphic.setStroke(new BasicStroke(5));
			graphic.setColor(secondary);
			graphic.drawPolygon(xArray, yArray, 3);
		}
		
		//Selected Shape
		if (selected) selectDraw(graphic);
		
	}
	
	@Override
	public void selectDraw(Graphics2D graphic) {
		
		int xArray [] = new int [3];
		int yArray [] = new int [3];
		
		//Expand Points
		xArray[0] = this.xArray[0] - 5;
		yArray[0] = this.yArray[0] - 10;
		
		xArray[1] = this.xArray[1] - 5;
		yArray[1] = this.yArray[1] + 5;
		
		xArray[2] = this.xArray[2] + 10;
		yArray[2] = this.yArray[2] + 5;
		
		//Select Draw
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		graphic.setStroke(stroke);
	    graphic.setColor(Color.BLACK);
		graphic.drawPolygon(xArray, yArray, 3);
		
	}

	@Override
	public boolean contains(Point Point) {
		
		int x = Point.x;
		int y = Point.y;
		
		//Test Outside of x range
		if (x < xArray[0] || x > xArray[2]) {
			return false;
		}
		
		//Test Outside of y range
		if (y < yArray[0] || y > yArray[2]) {
			return false;
		}
		
		//Test inside of shape
		double slope = (yArray[2] - yArray[0])/(xArray[2] - xArray[0]);		
		
		if ((Point.x - xArray[0]) * slope >  Point.y) return false;
		
		return true;
		
	}
	
	@Override
	public void move(int x, int y) {
		super.move(x, y);
		for (int i = 0; i < 3; i++) {
			xArray[i] = xArray[i] + x;
			yArray[i] = yArray[i] + y;
		}
	}

	@Override
	public Entity clone() {
		
		ETriangle triangle = new ETriangle(this.xArray, this.yArray,this.height,this.width);
		triangle.setFill(this.fill);
		triangle.setOutline(this.outline);
		triangle.setSelected(this.selected);
		triangle.setPrimary(this.primary);
		triangle.setSecondary(secondary);
		
		return triangle;
		
	}
	
}
























