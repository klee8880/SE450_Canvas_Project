 package controller.commands;

import java.util.LinkedList;
import controller.IShapeList;
import model.Shapes.Entity;
import model.interfaces.IApplicationState;

public class CopyCommand implements Command {
	
    private IShapeList shapes;
    private LinkedList <Entity> copyList;
	
	public CopyCommand (IApplicationState AppState) {
		this.shapes = AppState.getShapes();
		this.copyList = AppState.getCopyList();
		
	}

	@Override
	public boolean run() {
		//Clear copy list
		copyList.clear();
		
		//Get copy of all shapes
		for (Entity i: shapes.getShapes()) {
			copyList.add(i);
		}
		
		//Shift copy shape points
		for (Entity i: copyList) {
			i.move(-20, -20);
		}
		
		return true;
	}

	@Override
	public void redo() {
		
	}

	@Override
	public void undo() {
		
	}

}
