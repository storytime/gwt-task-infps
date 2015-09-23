package org.example.bus.event;

import com.google.gwt.event.shared.GwtEvent;
import org.example.bus.handler.HeaderCheckBoxEventHandler;

public class HeaderCheckBoxEvent extends GwtEvent<HeaderCheckBoxEventHandler> {

    public final static Type<HeaderCheckBoxEventHandler> TYPE = new Type<HeaderCheckBoxEventHandler>();
    private boolean isSelected = false;

    @Override
    public Type<HeaderCheckBoxEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(HeaderCheckBoxEventHandler handler) {
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
