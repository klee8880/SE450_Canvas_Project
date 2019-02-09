package controller.commands;

import java.util.LinkedList;
import model.interfaces.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class DeleteCommand implements Command{
	
    private LinkedList <Entity> shapes;
    private LinkedList <Entity> deleteList;
    private LinkedList <Entity> oldList;

    private PaintCanvasBase Canvas;
    
    public DeleteCommand(IApplicationState AppState, PaintCanvasBase Canvas) {
    	
    	this.Canvas = Canvas;
    	deleteList = new LinkedList <Entity> ();
    	oldList = new LinkedList <Entity> ();
    	
    	shapes = AppState.getShapes();
    	for (Entity i: shapes) {
    		//Old list for undo purposes
    		oldList.add(i);
    		//get list of items to delete
    		if (i.isSelected()) {deleteList.add(i);}
    	}
    }

	@Override
	public boolean run() {
		
		if (deleteList.isEmpty()) { return false;}
		
		for (Entity i: deleteList) {
			shapes.remove(i);
		}
		
		Canvas.paintImmediately(0,  0, Canvas.getWidth(), Canvas.getHeight());
		for (Entity i: shapes) {
			i.draw(Canvas);
		}
		
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
		for (Entity i: oldList) {
			shapes.add(i);
		}
		
		Canvas.paintImmediately(0,  0, Canvas.getWidth(), Canvas.getHeight());
		for (Entity i: shapes) {
			i.draw(Canvas);
		}
	}

}
