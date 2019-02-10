package controller.commands;

import controller.IShapeList;
import model.Shapes.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

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
