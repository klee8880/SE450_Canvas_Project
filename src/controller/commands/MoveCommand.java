package controller.commands;

import controller.IShapeList;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class MoveCommand implements Command{
	
	private IShapeList selected;
	private IShapeList shapeList;
	private int x;
	private int y;
	private PaintCanvasBase Canvas;
	
	public MoveCommand(int x, int y, IApplicationState appState, IShapeList selected ,PaintCanvasBase Canvas) {
		
		this.x = x;
		this.y = y;
		this.Canvas = Canvas;
		this.shapeList = appState.getShapes();
		this.selected = selected.clone();
	}

	@Override
	public boolean run() {
		
		//Check if shapes where selected
		if (selected.isEmpty()) {return false;}
		
		selected.moveAll(x, y);
		
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		shapeList.drawAll(Canvas);
		selected.selectDrawAll(Canvas);
		
		return true;
	}

	@Override
	public void redo() {
		run();
		
	}

	@Override
	public void undo() {
		selected.moveAll(-x, -y);
		
		//Redraw screen and shapes
		Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
		
		shapeList.drawAll(Canvas);
	}
	
	

}
