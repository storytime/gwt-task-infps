package org.example.event.impl;


import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.SelectionModelCheckBoxEventHandler;

public class SelectionModelCheckBoxEvent extends GwtEvent<SelectionModelCheckBoxEventHandler> {

    public final static Type<SelectionModelCheckBoxEventHandler> TYPE = new Type<SelectionModelCheckBoxEventHandler>();
    private boolean status;

    @Override
    public Type<SelectionModelCheckBoxEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(SelectionModelCheckBoxEventHandler handler) {
        handler.handle(this);
    }

    public boolean isStatus() {
        return status;
    }

    public SelectionModelCheckBoxEvent setStatus(boolean status) {
        this.status = status;
        return this;
    }
}
