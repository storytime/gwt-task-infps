package org.example.bus.event;


import com.google.gwt.event.shared.GwtEvent;
import org.example.bus.handler.GoButtonEventHandler;

public class GoButtonEvent extends GwtEvent<GoButtonEventHandler> {

    public final static Type<GoButtonEventHandler> TYPE = new Type<GoButtonEventHandler>();

    @Override
    public Type<GoButtonEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(GoButtonEventHandler handler) {
        handler.handle(this);
    }
}
