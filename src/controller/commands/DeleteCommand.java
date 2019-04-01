package controller.commands;

import java.util.LinkedList;

import controller.IShapeList;
import model.Shapes.Shape;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class DeleteCommand implements Command{
	
    private IShapeList shapes;
    private IShapeList deleteList;
    private LinkedList <Shape> oldList;

    private PaintCanvasBase Canvas;
    
    public DeleteCommand(IApplicationState AppState, IShapeList selected, PaintCanvasBase Canvas) {
    	
    	this.Canvas = Canvas;
    	deleteList = selected;
    	oldList = new LinkedList <Shape> ();
    	
    	shapes = AppState.getShapes();
    	for (Shape i: shapes.getShapes()) {
    		//Old list for undo purposes
    		oldList.add(i);
    	}
    }

	@Override
	public boolean run() {
		
		if (deleteList.isEmpty()) { return false;}
		
		for (Shape i: deleteList.getShapes()) {
			shapes.remove(i);
		}
		
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		shapes.drawAll(Canvas);
		
		return true;
	}

	@Override
	public void redo() {
		run();
	}

	@Override
	public void undo() {
		//Reset list to before delete
		shapes.clear();
		for (Shape i: oldList) {
			shapes.add(i);
		}
		
		Canvas.paintImmediately(0,  0, Canvas.getWidth(), Canvas.getHeight());
		shapes.drawAll(Canvas);
	}

}
