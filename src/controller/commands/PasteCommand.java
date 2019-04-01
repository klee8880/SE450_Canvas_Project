package controller.commands;

import java.util.Iterator;
import java.util.LinkedList;
import controller.IShapeList;
import controller.strategies.*;
import model.Shapes.Shape;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class PasteCommand implements Command{
	
    private IShapeList shapes;
    private LinkedList <Shape> copyList;
    private PaintCanvasBase Canvas;
	
	public PasteCommand (IApplicationState AppState, PaintCanvasBase Canvas) {
		this.shapes = AppState.getShapes();
		this.copyList = new LinkedList <Shape> ();
		
		for (Shape i: AppState.getCopyList()) {
			copyList.add(i.clone());
		}
		
		this.Canvas = Canvas;
	}

	@Override
	public boolean run() {
		//Add a copy of shapes from copy list to shapes
		ADrawStrategy draw;
		
		//Shift copy shape points
		for (Shape i: copyList) {
			i.move(-20, -20);
		}
		
		for (Shape i: copyList) {
			shapes.add(i.clone());
			switch (i.getType()) {
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
				throw new IllegalArgumentException("Unknown shapeType");
			}
			
			draw.drawShape(i, Canvas.getGraphics2D());
		}
		
		return true;
	}

	@Override
	public void redo() {
		run();
	}

	@Override
	public void undo() {

		Iterator<Shape> i = copyList.iterator();
		
		while (i.hasNext()) {
			shapes.removeLast();
			i.next();
		}
		
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		
		shapes.drawAll(Canvas);
	}

}
