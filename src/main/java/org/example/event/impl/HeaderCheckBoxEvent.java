package org.example.event.impl;

import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.DisableCheckBoxEventHandler;

public class HeaderCheckBoxEvent extends GwtEvent<DisableCheckBoxEventHandler> {

    public final static Type<DisableCheckBoxEventHandler> TYPE = new Type<DisableCheckBoxEventHandler>();
    private boolean isSelected = false;

    @Override
    public Type<DisableCheckBoxEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DisableCheckBoxEventHandler handler) {
        handler.handle(this);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public HeaderCheckBoxEvent setSelected(boolean selected) {
        this.isSelected = selected;
        return this;
    }
}
