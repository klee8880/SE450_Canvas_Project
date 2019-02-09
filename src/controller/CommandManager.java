package controller;
//TEST TEST
import controller.commands.*;
import model.Point;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class CommandManager implements ICommandManager{
	private IApplicationState AppState;
	private PaintCanvasBase Canvas;
	private IShapeList selectedShapes;

	public CommandManager(IApplicationState appState, PaintCanvasBase canvas) {
		super();
		this.AppState = appState;
		this.Canvas = canvas;
	}

	@Override
	public void draw(Point start, Point end) {
		Command command = new DrawShapeCommand(AppState, Canvas, start, end);
		if (command.run()) {
			CommandHistory.add(command);
		}
	}

	@Override
	public void moveShape(Point start, Point end) {
		// Movement Math
		int xMove = end.x - start.x;
		int yMove = end.y - start.y;
		
		//Shape Commands
		Command command = new MoveCommand(xMove, yMove, AppState.getShapes(), Canvas);
		
		if (command.run()) {
			CommandHistory.add(command);
		}

	}

	@Override
	public void copy() {
		new CopyCommand(AppState).run();
	}

	@Override
	public void paste() {
		
		Command command = new PasteCommand(AppState, Canvas);
		
		if (command.run()) {
			CommandHistory.add(command);
		}
	}

	@Override
	public void delete() {
		Command command = new DeleteCommand(AppState, Canvas);
		
		if (command.run()) {
			CommandHistory.add(command);
		}
	}

	@Override
	public void select(Point begin, Point end) {
			new SelectCommand(AppState, Canvas, begin, end).run();
	}

	@Override
	public void group() {
		Command command = new GroupCommand(AppState, Canvas);
		
		if (command.run()) {
			CommandHistory.add(command);
		}
	}

	@Override
	public void ungroup() {
		Command command = new UngroupCommand(AppState, Canvas);
		
		if (command.run()) {
			CommandHistory.add(command);
		}
	}

	@Override
	public void redo() {
		CommandHistory.redo();
	}

	@Override
	public void undo() {
		CommandHistory.undo();
	}

}
