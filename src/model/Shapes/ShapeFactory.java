package model.Shapes;

import model.Point;
import model.interfaces.Entity;
import model.interfaces.IApplicationState;

public class ShapeFactory {

	public static Entity makeRectangle(IApplicationState AppState, Point begin, Point end) {
		
		//Set dimensions
		int height = Math.abs(begin.y - end.y);
		int width = Math.abs(begin.x - end.x);
		
		Point StartPoint = new Point();
		
		if (begin.x > end.x) StartPoint.x = end.x;
		else StartPoint.x = begin.x;
		if (begin.y > end.y) StartPoint.y = end.y;
		else StartPoint.y = begin.y;
		
		return new ERectangle(AppState, StartPoint, height, width);
	}
	
	public static Entity makeEllipse(IApplicationState AppState, Point begin, Point end) {
		
		//Set dimensions
		int height = Math.abs(begin.y - end.y);
		int width = Math.abs(begin.x - end.x);
		
		Point StartPoint = new Point();
		
		if (begin.x > end.x) StartPoint.x = end.x;
		else StartPoint.x = begin.x;
		if (begin.y > end.y) StartPoint.y = end.y;
		else StartPoint.y = begin.y;
		
		return new EEllipse(AppState, StartPoint, height, width);
	}
	
	public static Entity makeTriangle(IApplicationState AppState, Point begin, Point end) {
		
		//Set dimensions
		int height = Math.abs(begin.y - end.y);
		int width = Math.abs(begin.x - end.x);
		
		Point StartPoint = new Point();
		int [] xArray = new int[3];
		int [] yArray = new int[3];
		
		if (begin.x > end.x) StartPoint.x = end.x;
		else StartPoint.x = begin.x;
		if (begin.y > end.y) StartPoint.y = end.y;
		else StartPoint.y = begin.y;
		
		//Find points
		xArray[0] = StartPoint.x;
		yArray[0] = StartPoint.y;
		
		xArray[1] = StartPoint.x;
		yArray[1] = StartPoint.y + height;
		
		xArray[2] = StartPoint.x + width;
		yArray[2] = StartPoint.y + height;
		
		return new ETriangle(AppState, xArray, yArray, height, width);
	}
	
}
	