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
	public void triangleTest(){
		int [] xArray = {1,1,7};
		int [] yArray = {1,7,7};
		
		ETriangle shape = (ETriangle) ShapeFactory.makeTriangle(appState, new Point(1,1), new Point(7,7));
		
		assertEquals("Unexpected Height",6 ,shape.getHeight());
		assertEquals("Unexpected Width",6 ,shape.getWidth());
		assertTrue("Unexpeced Starting Point", new Point(1,1).equals(shape.getStartPoint()));
		
		for (int i = 0; i < 3; i++) {
			assertEquals("Unexpect X point [" + i + "]in triangle", xArray[i], shape.getXArray()[i]);
			assertEquals("Unexpect Y point [" + i + "]in triangle", yArray[i], shape.getYArray()[i]);
		}
	}
	
	@Test
	public void rectangeTest() {
		fail("Not implimented");
		
	}
	
	@Test
	public void ovalTest() {
		fail("Not implimented");
	}
	
	@Test
	public void shapeFactoryFunctional() {
		fail("Not implimented");
	}
	
}
