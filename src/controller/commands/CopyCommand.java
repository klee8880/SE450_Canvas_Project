package controller.commands;

import java.util.LinkedList;

import model.interfaces.Entity;
import model.interfaces.IApplicationState;

public class CopyCommand implements Command {
	
    private LinkedList <Entity> shapes;
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
		for (Entity i: shapes) {
			if (i.isSelected()) { copyList.add(i.clone());}
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
