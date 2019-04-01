package controller.commands;

import controller.strategies.*;
import model.Point;
import model.ShapeType;
import model.Shapes.Shape;
import model.Shapes.ShapeFactory;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class NewShapeCommand implements Command{
	private ShapeType Type;
	private IApplicationState State;
	PaintCanvasBase Canvas;
	Shape newShape;
	
	public NewShapeCommand(IApplicationState state, PaintCanvasBase Canvas, Point begin, Point end) {
		super();
		Type = state.getActiveShapeType();
		State = state;
		this.Canvas = Canvas;
		
		//Create Instance of a shape
		switch (Type) {
		case ELLIPSE:
			newShape = ShapeFactory.makeEllipse(State, begin, end);
			break;
		case RECTANGLE:
			newShape = ShapeFactory.makeRectangle(State, begin, end);
			break;
		case TRIANGLE:
			newShape = ShapeFactory.makeTriangle(State, begin, end);
			break;
		default:
			break;
		}
	}

	@Override
	public boolean run() {
		
		//Add shape to shape list
		State.getShapes().add(newShape);
		
		ADrawStrategy draw;
		
		//Draw Shape
		switch (newShape.getType()) {
		case ELLIPSE:
			draw = new circleDraw();
			break;
		case RECTANGLE:
			draw = new rectangleDraw();
			break;
		case TRIANGLE:
			draw = new triangleDraw();
			break;
		default:
			return false;
		}
		
		draw.drawShape(newShape, Canvas.getGraphics2D());
		
		return true;
	}
	
	@Override
	public void redo() {
		run();
		
	}

	@Override
	public void undo() {
		//Pop last shape off the list
		State.getShapes().removeLast();
		
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		
		//Redraw remaining shapes
		State.getShapes().drawAll(Canvas);
		
	}
	
}
