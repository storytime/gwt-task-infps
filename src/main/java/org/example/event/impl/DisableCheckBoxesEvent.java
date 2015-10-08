package org.example.event.impl;


import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.DisableCheckBoxesEventHandler;

public class DisableCheckBoxesEvent extends GwtEvent<DisableCheckBoxesEventHandler> {

    public final static Type<DisableCheckBoxesEventHandler> TYPE = new Type<DisableCheckBoxesEventHandler>();
    private boolean selected;

    @Override
    public Type<DisableCheckBoxesEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DisableCheckBoxesEventHandler handler) {
        handler.handle(this);
    }

    public boolean isSelected() {
        return selected;
    }

    public DisableCheckBoxesEvent setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }
}
