package org.example.bus.event;


import com.google.gwt.event.shared.GwtEvent;
import org.example.bus.handler.DisableSelectionEventHandler;

public class DisableSelectionEvent extends GwtEvent<DisableSelectionEventHandler> {

    public final static Type<DisableSelectionEventHandler> TYPE = new Type<DisableSelectionEventHandler>();

    @Override
    public Type<DisableSelectionEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DisableSelectionEventHandler handler) {
        handler.disableSelection(this);
    }
}
