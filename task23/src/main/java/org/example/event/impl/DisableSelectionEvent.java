package org.example.event.impl;


import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.DisableSelectionEventHandler;

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
