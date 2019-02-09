package controller.commands;

public interface Command {
	
	public boolean run();
	public void redo();
	public void undo();
	
}
