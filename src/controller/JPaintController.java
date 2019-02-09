package controller;

import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ICommandManager Manager;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ICommandManager Manager) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.Manager = Manager;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> Manager.copy());
        uiModule.addEvent(EventName.PASTE, () -> Manager.paste());
        uiModule.addEvent(EventName.DELETE, () -> Manager.delete());
        uiModule.addEvent(EventName.REDO, () -> Manager.redo());
        uiModule.addEvent(EventName.UNDO, () -> Manager.undo());
        uiModule.addEvent(EventName.GROUP, () -> Manager.group());
        uiModule.addEvent(EventName.UNGROUP, () -> Manager.ungroup());
    }
}
