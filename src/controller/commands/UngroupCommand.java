package controller.commands;

import controller.IShapeList;
import model.interfaces.IApplicationState;
public class UngroupCommand extends GroupCommand{

	public UngroupCommand(IShapeList shapes, IApplicationState appState) {
		super(shapes, appState);
	}
	
	@Override
	public boolean run() {
		
		if (super.shapes.isEmpty()) {return false;}
		
		shapes.groupAll(0);
		
		return true;
		
	}

}
