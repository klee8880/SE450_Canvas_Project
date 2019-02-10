package model.Shapes;

import java.awt.Color;

import model.Point;
import model.ShapeShadingType;
import model.ShapeType;

class entityBuilder {

	private Point StartPoint;
	private int height;
	private int width;
	private ShapeShadingType shading;
	private ShapeType type;
	private Color primary;
	private Color secondary;
	
	public entityBuilder dimensionsFromPoints(Point begin, Point end) {
		this.height = Math.abs(begin.y - end.y);
		this.width = Math.abs(begin.x - end.x);
		return this;
	}
	
	public entityBuilder setStartPoint(Point startPoint) {
		StartPoint = startPoint;
		return this;
	}
	public entityBuilder setHeight(int height) {
		this.height = height;
		return this;
	}
	public entityBuilder setWidth(int width) {
		this.width = width;
		return this;
	}
	public entityBuilder setShading(ShapeShadingType shading) {
		this.shading = shading;
		return this;
	}
	public entityBuilder setType(ShapeType type) {
		this.type = type;
		return this;
	}
	public entityBuilder setPrimary(Color primary) {
		this.primary = primary;
		return this;
	}
	public entityBuilder setSecondary(Color secondary) {
		this.secondary = secondary;
		return this;
	}
	
	public Entity buildEntity () {
		
		return new Entity(
				type, shading, primary, secondary, StartPoint, height, width);
	}
	
	
}
