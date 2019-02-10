package controller;


import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import model.interfaces.IApplicationState;
import model.Point;

public class MouseHandler implements MouseInputListener {

	private Point begin;
	private Point end;
	private IApplicationState App;
	private ICommandManager Manager;
	
	public MouseHandler(IApplicationState App, ICommandManager Manager) {
		begin = new Point();
		end = new Point();
		this.App = App;
		this.Manager = Manager;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		begin = recordPoint(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		end = recordPoint(e);
		
		switch (App.getActiveStartAndEndPointMode()) {
		case DRAW:
			Manager.draw(begin, end);
			break;
		case MOVE:
			Manager.moveShape(begin, end);
			break;
		case SELECT:
			Manager.select(begin, end);
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	private Point recordPoint(MouseEvent e) {
		Point Point = new Point();
		Point.x = e.getX();
		Point.y = e.getY();
		return Point;
	}

		
}
