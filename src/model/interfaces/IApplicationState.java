package model.interfaces;

import java.util.LinkedList;

import controller.IShapeList;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.Shapes.Shape;

public interface IApplicationState {
	
	public void setShapes(IShapeList shapes);
	
	void setCopyList(LinkedList<Shape> copyList);
	
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();
    
    IShapeList getShapes();

    LinkedList<Shape> getCopyList();
    
    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();
}
