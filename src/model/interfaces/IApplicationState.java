package model.interfaces;

import java.util.LinkedList;
import java.util.Queue;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;

public interface IApplicationState {
	
	public void setShapes(LinkedList<Entity> shapes);
	
	void setCopyList(LinkedList<Entity> copyList);
	
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();
    
    LinkedList<Entity> getShapes();

    LinkedList<Entity> getCopyList();
    
    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();
}
