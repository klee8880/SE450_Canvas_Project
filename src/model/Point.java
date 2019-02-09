package model;

import java.awt.event.MouseEvent;

public class Point {
	public int x;
	public int y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point (MouseEvent e) {
		Point Point = new Point();
		Point.x = e.getX();
		Point.y = e.getY();
	}
	
	public Point(Point old) {
		this.x = old.x;
		this.y = old.y;
	}
	
	public boolean equals(Point other) {
		
		if (x != other.x) return false;
		if (y != other.y) return false;
		
		return true;
	}
}
