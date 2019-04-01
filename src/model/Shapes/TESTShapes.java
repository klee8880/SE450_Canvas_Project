package model.Shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import model.Point;
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
		Shape shape1 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		Shape shape2 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		Shape shape3 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		Shape shape4 = ShapeFactory.makeTriangle(appState, new Point(4,4), new Point(10,10));
		
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
		Shape shape1 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		Shape shape2 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		Shape shape3 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		Shape shape4 = ShapeFactory.makeRectangle(appState, new Point(4,4), new Point(10,10));
		
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
		Shape shape1 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		Shape shape2 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		Shape shape3 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		Shape shape4 = ShapeFactory.makeEllipse(appState, new Point(4,4), new Point(10,10));
		
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
	}
	
	@Test
	public void rectangeTest() {
	}
	
	@Test
	public void ovalTest() {
	}
	
	@Test
	public void shapeFactoryFunctional() {
		
		Shape shape1 = null;
		Shape shape2 = null;
		Shape shape3 = null;

		shape1 = ShapeFactory.makeTriangle(appState,  new Point(1,1), new Point(7,7));
		shape2 = ShapeFactory.makeRectangle(appState,  new Point(1,1), new Point(7,7));
		shape3 = ShapeFactory.makeEllipse(appState,  new Point(1,1), new Point(7,7));
		
		if (shape1 == null) fail("No Triangle created");
		if (shape2 == null) fail("No Rectangle created");
		if (shape3 == null) fail("No Ellipse created");
		
	}
	
}
