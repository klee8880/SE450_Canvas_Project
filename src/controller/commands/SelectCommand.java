package controller.commands;
import controller.IShapeList;
import model.Point;
import model.Shapes.Entity;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class SelectCommand implements Command{
	
	private Point [] selectBoundary; //Boundary points 1-4 clockwise beginning in the top left corner
	private IShapeList Shapes, selected;
	private PaintCanvasBase Canvas;

	public SelectCommand(IApplicationState state, IShapeList selection, PaintCanvasBase Canvas, Point begin, Point end) {
		
		//Set dimensions
		int height = Math.abs(begin.y - end.y);
		int width = Math.abs(begin.x - end.x);
		
		//Find top-left point of the boundary
		Point StartPoint = new Point();
		
		if (begin.x > end.x) StartPoint.x = end.x;
		else StartPoint.x = begin.x;
		if (begin.y > end.y) StartPoint.y = end.y;
		else StartPoint.y = begin.y;
		
		//Set other properties
		selectBoundary = getBoundary(StartPoint, height, width);
		this.Shapes = state.getShapes();
		this.selected = selection;
		this.Canvas = Canvas;
		
	}
	
	@Override
	public boolean run() {
		
		//mark select on all shapes that intersect the bounding box.
		for (Entity i : Shapes.getShapes()) {
			
			//mark new selections
			Point [] shapeBoundary = getBoundary(i.getStartPoint(), i.getHeight(), i.getWidth());
			
			if (collision(selectBoundary, shapeBoundary)) {
				selected.add(i);
				//check and handle if this is a grouped shape
				if (i.getGroup() > 0) {
					selectGroup(i.getGroup());
				}
			}				
		}
		if (selected.isEmpty()) {
			return false;
		}
		else {
			
			Canvas.paintImmediately(0, 0, Canvas.getWidth(), Canvas.getHeight());
			Shapes.drawAll(Canvas);
			selected.selectDrawAll(Canvas);
			
			return true;
		}
	}

	@Override
	public void redo() {
		run();
	}

	@Override
	public void undo() {
		
	}
	
	//TODO: These should probably be in the entity class
	private Point[] getBoundary(Point start, int height, int width) {
		
		Point [] bounds = new Point[4];
		for (int i = 0; i < 4; i++) {
			bounds[i] = new Point();
		}
		
		bounds[0] = new Point(start);
		
		//Point 1
		bounds[1].x = bounds[0].x + width;
		bounds[1].y = bounds[0].y;
		
		//Point 3
		bounds[2].x = bounds[1].x;
		bounds[2].y = bounds[0].y + height;
		
		//Point 4
		bounds[3].x = bounds[0].x;
		bounds[3].y = bounds[2].y;
		
		return bounds;
		
	}

	//TODO: These should probably be in the entity class
	static boolean collision(Point [] A, Point [] B) {
		
		//Any Point from shape within selection
		for (Point i : B) {
			if (	i.x >= A[0].x 
					&& i.x <= A[1].x
					&& i.y >= A[0].y 
					&& i.y <= A[3].y) 
			{return true;}
		}
		
		//Any Point from boundary within shape
		for (Point i : A) {
			if (	i.x >= B[0].x
					&& i.x <= B[1].x 
					&& i.y >= B[0].y 
					&& i.y <= B[3].y) 
			{return true;}
		}
		
		//A intersects B
		int xPoint = A[0].x;
		int yPoint = B[0].y;
		if (	(xPoint > B[0].x && xPoint < B[1].x) &&
				(yPoint > A[0].y && yPoint < A[3].y)) {
			return true;
		}
		
		//B intersects A
		xPoint = B[0].x;
		yPoint = A[0].y;
		if (	(xPoint > A[0].x && xPoint < A[1].x) &&
				(yPoint > B[0].y && yPoint < B[3].y)) {
			return true;
		}
		
		return false;
		
	}
	
	private void selectGroup (int groupNum) {
		for (Entity i: Shapes.getShapes()) {
			if (i.getGroup() == groupNum) {
				selected.add(i);
			}
		}
	}
	
}
