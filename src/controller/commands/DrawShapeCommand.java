package controller.commands;

import model.Point;
import model.ShapeType;
import model.Shapes.ShapeFactory;
import model.interfaces.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawShapeCommand implements Command{
	private ShapeType Type;
	private IApplicationState State;
	PaintCanvasBase Canvas;
	Entity newShape;
	
	public DrawShapeCommand(IApplicationState state, PaintCanvasBase Canvas, Point begin, Point end) {
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
		
		//Draw Shape
		newShape.draw(Canvas);
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
		for (Entity i: State.getShapes()) {
			i.draw(Canvas);
		}
		
	}
	
}
