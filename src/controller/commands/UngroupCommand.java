package controller.commands;

import model.interfaces.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class UngroupCommand extends GroupCommand{

	public UngroupCommand(IApplicationState appState, PaintCanvasBase Canvas) {
		super(appState, Canvas);
	}
	
	@Override
	public boolean run() {
		
		if (super.selectShapes.isEmpty()) {return false;}
		
		for (Entity i: super.selectShapes) {
			i.setGroup(0);
		}
		
		return true;
		
	}

}
