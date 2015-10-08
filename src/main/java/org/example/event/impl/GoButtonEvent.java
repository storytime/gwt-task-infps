package org.example.event.impl;


import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.GoButtonEventHandler;

public class GoButtonEvent extends GwtEvent<GoButtonEventHandler> {

    public final static Type<GoButtonEventHandler> TYPE = new Type<GoButtonEventHandler>();
    private boolean status;

    @Override
    public Type<GoButtonEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(GoButtonEventHandler handler) {
        handler.handle(this);
    }

    public boolean isStatus() {
        return status;
    }

    public GoButtonEvent setStatus(boolean status) {
        this.status = status;
        return this;
    }
}
