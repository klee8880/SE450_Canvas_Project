package model.Shapes;

import java.awt.*;
import model.Point;
import model.ResolveColor;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public class Entity {

	protected Point StartPoint;
	protected int height;
	protected int width;
	protected ShapeShadingType shading;
	protected int group; //Group 0 is the default
	protected ShapeType type;
	protected Color primary;
	protected Color secondary;
	
	//Constructor
	public Entity() {
		super();
	}
	
	protected Entity(Point begin, int height, int width) {
		
		this.height = height;
		this.width = width;
		this.StartPoint = new Point(begin);
		
		//Create Start Point
		StartPoint = begin;
		
		//default group
		group = 0;
	}
	
	protected Entity(ShapeType type, ShapeShadingType shading, Color primary, Color secondary, Point begin, int height, int width) {
		
		this.type = type;
		
		this.height = height;
		this.width = width;
		this.StartPoint = new Point(begin);
		
		//Create Start Point
		this.StartPoint = begin;
		
		//default group
		this.group = 0;
		
		//Set coloring
		this.shading = shading;
		this.primary = primary;
		this.secondary = secondary;
		
	}

	protected Entity (Entity old) {
		this.StartPoint = new Point(old.getStartPoint());
		this.height = old.height;
		this.width = old.width;
		this.shading = old.shading;
		this.group = 0;
		this.type = old.type;
		this.primary = old.primary;
		this.secondary = old.secondary;
		
	}
	
	//Getters & Setters
	public Point getStartPoint() {
		return StartPoint;
	}

	public void setStartPoint(Point startPoint) {
		StartPoint = startPoint;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getGroup() {
		return group;
	}
	
	public void setGroup(int group) {
		this.group = group;
	}

	public Color getPrimary() {
		return primary;
	}

	public void setPrimary(Color primary) {
		this.primary = primary;
	}
	
	public void setPrimary(ShapeColor primary) {
		this.primary = ResolveColor.resolve(primary);
	}

	public Color getSecondary() {
		return secondary;
	}
	
	public void setSecondary(Color secondary) {
		this.secondary = secondary;
	}

	public void setSecondary(ShapeColor secondary) {
		this.secondary = ResolveColor.resolve(secondary);
	}
	
	public ShapeType getType() {
		return type;
	}

	public ShapeShadingType getShading() {
		return shading;
	}

	public void setShading(ShapeShadingType shading) {
		this.shading = shading;
	}
	
	//Methods
	public void move(int x, int y) {
		StartPoint.x = StartPoint.x + x;
		StartPoint.y = StartPoint.y + y;
	}
	
	public Entity clone() {
		return new Entity (this);
	}
	
}









