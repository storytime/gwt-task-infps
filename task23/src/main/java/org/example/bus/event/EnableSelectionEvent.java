package org.example.bus.event;


import com.google.gwt.event.shared.GwtEvent;
import org.example.bus.handler.EnableSelectionEventHandler;

public class EnableSelectionEvent extends GwtEvent<EnableSelectionEventHandler> {

    public final static Type<EnableSelectionEventHandler> TYPE = new Type<EnableSelectionEventHandler>();

    @Override
    public Type<EnableSelectionEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EnableSelectionEventHandler handler) {
        handler.enableSelection(handler);
    }
}
