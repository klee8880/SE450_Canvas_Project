package model.Shapes;

import model.Point;
import model.ResolveColor;
import model.ShapeType;
import model.interfaces.IApplicationState;

public class ShapeFactory {

	public static Entity makeRectangle(IApplicationState AppState, Point begin, Point end) {
		
		Point StartPoint = new Point();
		
		if (begin.x > end.x) StartPoint.x = end.x;
		else StartPoint.x = begin.x;
		if (begin.y > end.y) StartPoint.y = end.y;
		else StartPoint.y = begin.y;
		
		entityBuilder builder = new entityBuilder();
		
		builder.dimensionsFromPoints(begin, end)
		.setType(ShapeType.RECTANGLE)
		.setStartPoint(StartPoint)
		.setPrimary(ResolveColor.resolve(AppState.getActivePrimaryColor()))
		.setSecondary(ResolveColor.resolve(AppState.getActiveSecondaryColor()))
		.setShading(AppState.getActiveShapeShadingType());
		
		return builder.buildEntity();
	}
	
	public static Entity makeEllipse(IApplicationState AppState, Point begin, Point end) {
		
		Point StartPoint = new Point();
		
		if (begin.x > end.x) StartPoint.x = end.x;
		else StartPoint.x = begin.x;
		if (begin.y > end.y) StartPoint.y = end.y;
		else StartPoint.y = begin.y;
		
		entityBuilder builder = new entityBuilder();
		
		builder.dimensionsFromPoints(begin, end)
		.setType(ShapeType.ELLIPSE)
		.setStartPoint(StartPoint)
		.setPrimary(ResolveColor.resolve(AppState.getActivePrimaryColor()))
		.setSecondary(ResolveColor.resolve(AppState.getActiveSecondaryColor()))
		.setShading(AppState.getActiveShapeShadingType());
		
		return builder.buildEntity();
	}
	
	public static Entity makeTriangle(IApplicationState AppState, Point begin, Point end) {
	
		Point StartPoint = new Point();
		
		if (begin.x > end.x) StartPoint.x = end.x;
		else StartPoint.x = begin.x;
		if (begin.y > end.y) StartPoint.y = end.y;
		else StartPoint.y = begin.y;
		
		entityBuilder builder = new entityBuilder();
		
		builder.dimensionsFromPoints(begin, end)
		.setType(ShapeType.TRIANGLE)
		.setStartPoint(StartPoint)
		.setPrimary(ResolveColor.resolve(AppState.getActivePrimaryColor()))
		.setSecondary(ResolveColor.resolve(AppState.getActiveSecondaryColor()))
		.setShading(AppState.getActiveShapeShadingType());
		
		return builder.buildEntity();
	}
	
}
	