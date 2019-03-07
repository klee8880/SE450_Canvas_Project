package controller.commands;

import java.util.ArrayList;
import java.util.Iterator;
import controller.IShapeList;
import model.Shapes.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class GroupCommand implements Command {
	
	protected IShapeList shapes;
	protected ArrayList <Integer> oldGroups;
	protected PaintCanvasBase Canvas;
	protected IApplicationState appState;
	
	public GroupCommand(IShapeList shapes, IApplicationState appState) {
		
		this.shapes = shapes;
		this.oldGroups = new ArrayList <Integer> ();
		this.appState = appState;
		
		//Pick out selected shapes and record old group numbers
		for (Entity i: shapes.getShapes()) {
			oldGroups.add(i.getGroup());
		}
		
	}

	@Override
	public boolean run() {
		
		if (shapes.isEmpty()) {return false;}
		int group = 1;
		
		//find next group number
		for (Entity i: appState.getShapes().getShapes()) {
			if (group <= i.getGroup()) {
				group = i.getGroup() + 1;
			}
		}
		
		//Set group number
		shapes.groupAll(group);
		
		return true;
	}

	@Override
	public void redo() {
		run();
		
	}

	@Override
	public void undo() {
		Iterator<Integer> i = oldGroups.iterator();
		Iterator<Entity> j = shapes.getShapes().iterator();
		
		while (i.hasNext()) {
			j.next().setGroup(i.next());
		}
	}

}
