package controller.commands;

import model.Point;
import model.ShapeType;
import model.Shapes.Shape;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class CommandFactory {
	

	public static Command makeDrawCommand(Point begin, Point end, IApplicationState App, ShapeType Shape, PaintCanvasBase Canvas) {
		return null;
	}
	
	public static Command makeMoveCommand(Point begin, Point end, IApplicationState App, PaintCanvasBase Canvas) {
		return null;	
	}
	
	public static Command makePasteCommand(Point target, IApplicationState App, Shape Shape, PaintCanvasBase Canvas) {
		return null;
	}
	
	public static Command makeDeleteCommand(Shape thisShape, IApplicationState App, PaintCanvasBase Canvas) {
		return null;	
	}
	
	public static Command makeGroupCommand() {
		return null;
	}
	
	public static Command makeUngroupCommand() {
		return null;
	}
	
}
