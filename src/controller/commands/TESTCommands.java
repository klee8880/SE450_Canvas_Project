package controller.commands;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Point;

public class TESTCommands {

	@Test
	public void OnePointCollision() {
		
		//bounding box A (1,1), (3,1), (3,3), (1,3)
		Point [] A = new Point[4];
		A[0] = new Point(1,1);
		A[1] = new Point(3,1);
		A[2] = new Point(3,3);
		A[3] = new Point(1,3);
		
		//bounding box B (2,2), (4,2), (4,4), (2,4)
		Point [] B = new Point[4];
		B[0] = new Point(2,2);
		B[1] = new Point(4,2);
		B[2] = new Point(4,4);
		B[3] = new Point(2,4);
		
		assertTrue("No collision when expected", SelectCommand.collision(A, B));
		assertTrue("No collision when expected", SelectCommand.collision(B, A));
	}
	
	@Test
	public void TwoPointCollision() {
		
		//bounding box A (1,1), (4,1), (4,3), (1,3)
		Point [] A = new Point[4];
		A[0] = new Point(1,1);
		A[1] = new Point(3,1);
		A[2] = new Point(3,3);
		A[3] = new Point(1,3);
		
		//bounding box B (2,2), (3,2), (3,4), (2,4)
		Point [] B = new Point[4];
		B[0] = new Point(2,2);
		B[1] = new Point(3,2);
		B[2] = new Point(3,4);
		B[3] = new Point(2,4);
		
		assertTrue("No collision when expected", SelectCommand.collision(A, B));
		assertTrue("No collision when expected", SelectCommand.collision(B, A));
	}
	
	
	@Test
	public void OverLappingFieldsCollision() {
		
		//bounding box A (2,1), (3,1), (3,4), (2,4)
		Point [] A = new Point[4];
		A[0] = new Point(2,1);
		A[1] = new Point(3,1);
		A[2] = new Point(3,4);
		A[3] = new Point(2,4);
		
		//bounding box B (1,2), (4,2), (4,3), (1,3)
		Point [] B = new Point[4];
		B[0] = new Point(1,2);
		B[1] = new Point(4,2);
		B[2] = new Point(4,3);
		B[3] = new Point(1,3);
		
		assertTrue("No collision when expected", SelectCommand.collision(A, B));
		assertTrue("No collision when expected", SelectCommand.collision(B, A));
	}
	
	
}
