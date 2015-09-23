package org.example.bus.event;

import com.google.gwt.event.shared.GwtEvent;
import org.example.bus.handler.RowSelectionEvenHandler;

public class RowSelectionEvent extends GwtEvent<RowSelectionEvenHandler> {

    public final static Type<RowSelectionEvenHandler> TYPE = new Type<RowSelectionEvenHandler>();

    @Override
    public Type<RowSelectionEvenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RowSelectionEvenHandler handler) {
        handler.select(this);
    }
}
