package controller.commands;

import java.util.LinkedList;
import controller.IShapeList;
import model.Shapes.Entity;
import model.interfaces.IApplicationState;

public class CopyCommand implements Command {
	
    private IShapeList selected;
    private LinkedList <Entity> copyList;
	
	public CopyCommand (IApplicationState AppState, IShapeList selected) {
		this.selected = selected;
		this.copyList = AppState.getCopyList();
		
	}

	@Override
	public boolean run() {
		//Clear copy list
		copyList.clear();
		
		//Get copy of all shapes
		for (Entity i: selected.getShapes()) {
			copyList.add(i.clone());
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
