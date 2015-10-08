package org.example.event.impl;

import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.ShowDialogEvenHandler;

public class ShowDialogEvent extends GwtEvent<ShowDialogEvenHandler> {

    public final static Type<ShowDialogEvenHandler> TYPE = new Type<ShowDialogEvenHandler>();

    @Override
    public Type<ShowDialogEvenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ShowDialogEvenHandler handler) {
        handler.show(this);
    }
}