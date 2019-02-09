package controller.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import model.interfaces.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class GroupCommand implements Command {
	
	protected LinkedList <Entity> shapes;
	protected LinkedList <Entity> selectShapes;
	protected ArrayList <Integer> oldGroups;
	protected PaintCanvasBase Canvas;
	
	public GroupCommand(IApplicationState appState, PaintCanvasBase Canvas) {
		
		this.Canvas = Canvas;
		this.shapes = appState.getShapes();
		this.oldGroups = new ArrayList <Integer> ();
		this.selectShapes = new LinkedList <Entity> ();
		
		//Pick out selected shapes and record old group numbers
		for (Entity i: shapes) {
			oldGroups.add(i.getGroup());
			if (i.isSelected()) { 
				selectShapes.add(i);
			}
		}
		
	}

	@Override
	public boolean run() {
		
		if (selectShapes.isEmpty()) {return false;}
		int group = 1;
		
		//find next group number
		for (Entity i: shapes) {
			if (group <= i.getGroup()) {
				group = i.getGroup() + 1;
			}
		}
		
		//Set group number
		for (Entity i: selectShapes) {
			i.setGroup(group);
		}
		
		return true;
	}

	@Override
	public void redo() {
		run();
		
	}

	@Override
	public void undo() {
		Iterator<Integer> i = oldGroups.iterator();
		Iterator<Entity> j = shapes.iterator();
		
		while (i.hasNext()) {
			j.next().setGroup(i.next());
		}
	}

}
