package model.Shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import model.Point;
import model.interfaces.Entity;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

public class TESTShapes {
	
    PaintCanvasBase paintCanvas = new PaintCanvas();
    IGuiWindow guiWindow = new GuiWindow(paintCanvas);
    IUiModule uiModule = new Gui(guiWindow);
    ApplicationState appState = new ApplicationState(uiModule);

    @Test
	public void moveTriangle() {
		Entity shape1 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		Entity shape2 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		Entity shape3 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		Entity shape4 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		
		shape1.move(-3, 0);
		shape2.move(3, 0);
		shape3.move(0, -3);
		shape4.move(0, 3);
		
		//start points change
		assertEquals("Negative x movement failed",1,shape1.getStartPoint().x);
		assertEquals("Positive x movement failed",7,shape2.getStartPoint().x);
		assertEquals("Negative y movement failed",1,shape3.getStartPoint().y);
		assertEquals("Positive y movement failed",7,shape4.getStartPoint().y);
		
		//Dimensions do not change
		assertEquals("Height altered",6,shape1.getHeight());
		assertEquals("Height altered",6,shape2.getHeight());
		assertEquals("Height altered",6,shape3.getHeight());
		assertEquals("Height altered",6,shape4.getHeight());
		
		assertEquals("Width altered",6,shape1.getWidth());
		assertEquals("Width altered",6,shape2.getWidth());
		assertEquals("Width altered",6,shape3.getWidth());
		assertEquals("Width altered",6,shape4.getWidth());
		
	}
    
    @Test
	public void moveRectangle() {
		Entity shape1 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		Entity shape2 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		Entity shape3 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		Entity shape4 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		
		shape1.move(-3, 0);
		shape2.move(3, 0);
		shape3.move(0, -3);
		shape4.move(0, 3);
		
		//start points change
		assertEquals("Negative x movement failed",1,shape1.getStartPoint().x);
		assertEquals("Positive x movement failed",7,shape2.getStartPoint().x);
		assertEquals("Negative y movement failed",1,shape3.getStartPoint().y);
		assertEquals("Positive y movement failed",7,shape4.getStartPoint().y);
		
		//Dimensions do not change
		assertEquals("Height altered",6,shape1.getHeight());
		assertEquals("Height altered",6,shape2.getHeight());
		assertEquals("Height altered",6,shape3.getHeight());
		assertEquals("Height altered",6,shape4.getHeight());
		
		assertEquals("Width altered",6,shape1.getWidth());
		assertEquals("Width altered",6,shape2.getWidth());
		assertEquals("Width altered",6,shape3.getWidth());
		assertEquals("Width altered",6,shape4.getWidth());
	}
    
    @Test
	public void moveOval() {
		Entity shape1 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		Entity shape2 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		Entity shape3 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		Entity shape4 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		
		shape1.move(-3, 0);
		shape2.move(3, 0);
		shape3.move(0, -3);
		shape4.move(0, 3);
		
		//start points change
		assertEquals("Negative x movement failed",1,shape1.getStartPoint().x);
		assertEquals("Positive x movement failed",7,shape2.getStartPoint().x);
		assertEquals("Negative y movement failed",1,shape3.getStartPoint().y);
		assertEquals("Positive y movement failed",7,shape4.getStartPoint().y);
		
		//Dimensions do not change
		assertEquals("Height altered",6,shape1.getHeight());
		assertEquals("Height altered",6,shape2.getHeight());
		assertEquals("Height altered",6,shape3.getHeight());
		assertEquals("Height altered",6,shape4.getHeight());
		
		assertEquals("Width altered",6,shape1.getWidth());
		assertEquals("Width altered",6,shape2.getWidth());
		assertEquals("Width altered",6,shape3.getWidth());
		assertEquals("Width altered",6,shape4.getWidth());
	}
    
	@Test
	public void triangleTest(){
		
		ETriangle shape = (ETriangle) ShapeFactory.makeTriangle(appState, new Point(1,1), new Point(7,7));
		
		assertEquals("Unexpected Height",6 ,shape.getHeight());
		assertEquals("Unexpected Width",6 ,shape.getWidth());
		assertTrue("Unexpeced Starting Point", new Point(1,1).equals(shape.getStartPoint()));
		
		int [] xArray = {1,1,7};
		int [] yArray = {1,7,7};
		
		for (int i = 0; i < 3; i++) {
			assertEquals("Unexpect X point [" + i + "]in triangle", xArray[i], shape.getXArray()[i]);
			assertEquals("Unexpect Y point [" + i + "]in triangle", yArray[i], shape.getYArray()[i]);
		}
	}
	
	@Test
	public void rectangeTest() {
		
		ERectangle shape = (ERectangle) ShapeFactory.makeRectangle(appState, new Point(1,1), new Point(7,7));
		
		assertEquals("Unexpected Height",6 ,shape.getHeight());
		assertEquals("Unexpected Width",6 ,shape.getWidth());
		assertTrue("Unexpeced Starting Point", new Point(1,1).equals(shape.getStartPoint()));
		
	}
	
	@Test
	public void ovalTest() {
		
		EEllipse shape = (EEllipse) ShapeFactory.makeEllipse(appState, new Point(1,1), new Point(7,7));
		
		assertEquals("Unexpected Height",6 ,shape.getHeight());
		assertEquals("Unexpected Width",6 ,shape.getWidth());
		assertTrue("Unexpeced Starting Point", new Point(1,1).equals(shape.getStartPoint()));
	}
	
	@Test
	public void shapeFactoryFunctional() {
		
		Entity shape1 = null;
		Entity shape2 = null;
		Entity shape3 = null;

		shape1 = ShapeFactory.makeTriangle(appState,  new Point(1,1), new Point(7,7));
		shape2 = ShapeFactory.makeRectangle(appState,  new Point(1,1), new Point(7,7));
		shape3 = ShapeFactory.makeEllipse(appState,  new Point(1,1), new Point(7,7));
		
		if (shape1 == null) fail("No Triangle created");
		if (shape2 == null) fail("No Rectangle created");
		if (shape3 == null) fail("No Ellipse created");
		
	}
	
}
