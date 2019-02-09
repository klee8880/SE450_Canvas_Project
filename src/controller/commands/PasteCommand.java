package controller.commands;

import java.util.Iterator;
import java.util.LinkedList;
import model.interfaces.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class PasteCommand implements Command{
	
    private LinkedList <Entity> shapes;
    private LinkedList <Entity> copyList;
    private PaintCanvasBase Canvas;
	
	public PasteCommand (IApplicationState AppState, PaintCanvasBase Canvas) {
		this.shapes = AppState.getShapes();
		this.copyList = new LinkedList <Entity> ();
		
		for (Entity i: AppState.getCopyList()) {
			copyList.add(i.clone());
		}
		
		this.Canvas = Canvas;
	}

	@Override
	public boolean run() {
		//Add a copy of shapes from copy list to shapes
		for (Entity i: copyList) {
			shapes.add(i.clone());
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

		Iterator<Entity> i = copyList.iterator();
		
		while (i.hasNext()) {
			shapes.removeLast();
			i.next();
		}
		
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		
		for (Entity j: shapes) {
			j.draw(Canvas);
		}
		
	}

}
