package model.interfaces;

import java.awt.*;
import model.Point;
import model.ResolveColor;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public abstract class Entity {

	protected Point StartPoint;
	protected int height;
	protected int width;
	protected ShapeShadingType shading;
	protected boolean fill = false;
	protected boolean outline = false;
	protected boolean selected = false;
	int group; //Group 0 is the default
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
	
	protected Entity(IApplicationState AppState, Point begin, int height, int width) {
		
		this.height = height;
		this.width = width;
		this.StartPoint = new Point(begin);
		
		//Create Start Point
		StartPoint = begin;
		
		//Set fill type
		switch(AppState.getActiveShapeShadingType()) {
		case FILLED_IN:
			fill = true;
			break;
		case OUTLINE:
			outline = true;
			break;
		case OUTLINE_AND_FILLED_IN:
			fill = true;
			outline = true;
			break;
		default:
			break;
		}
		
		//default group
		group = 0;
		
		//Set coloring
		this.primary = ResolveColor.resolve(AppState.getActivePrimaryColor());
		this.secondary = ResolveColor.resolve(AppState.getActiveSecondaryColor());
		
	}

	protected Entity (Entity old) {
		this.StartPoint = new Point(old.getStartPoint());
		this.height = old.height;
		this.width = old.width;
		this.fill = old.fill;
		this.outline = old.outline;
		this.selected = false;
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

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public boolean isOutline() {
		return outline;
	}

	public void setOutline(boolean outline) {
		this.outline = outline;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
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

	//Abstract
	public abstract void draw(PaintCanvasBase Canvas);
	
	public abstract void selectDraw(Graphics2D graphic);
	
	public abstract boolean contains(Point Point);
	
	public abstract Entity clone();
	
	//Methods
	public void move(int x, int y) {
		StartPoint.x = StartPoint.x + x;
		StartPoint.y = StartPoint.y + y;
	}
	
}









