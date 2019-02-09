package controller.commands;

import java.util.LinkedList;
import model.interfaces.Entity;
import view.interfaces.PaintCanvasBase;

public class MoveCommand implements Command{
	
	private LinkedList <Entity> selected = new LinkedList <Entity> ();
	private LinkedList <Entity> shapeList;
	private int x;
	private int y;
	private PaintCanvasBase Canvas;
	
	public MoveCommand(int x, int y, LinkedList <Entity> shapeList, PaintCanvasBase Canvas) {
		
		this.x = x;
		this.y = y;
		this.Canvas = Canvas;
		this.shapeList = shapeList;
		
		//Add all shapes that are selected
		for (Entity i: shapeList) {
			if (i.isSelected()) {selected.add(i);}
		}
		
	}

	@Override
	public boolean run() {
		
		if (selected.isEmpty()) {return false;}
		
		//Move shapes
		for (Entity i: selected) {
			i.move(x, y);
		}
		
		//Redraw screen and shapes
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		
		for (Entity i: shapeList) {
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
		for (Entity i: selected) {
			i.move(-x, -y);
		}
		
		//Redraw screen and shapes
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		
		for (Entity i: shapeList) {
			i.draw(Canvas);
		}
	}
	
	

}
