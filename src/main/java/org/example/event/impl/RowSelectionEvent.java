package org.example.event.impl;

import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.RowSelectionEvenHandler;

public class RowSelectionEvent extends GwtEvent<RowSelectionEvenHandler> {

    public final static Type<RowSelectionEvenHandler> TYPE = new Type<RowSelectionEvenHandler>();
    private Integer userId;

    @Override
    public Type<RowSelectionEvenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RowSelectionEvenHandler handler) {
        handler.select(this);
    }

    public Integer getUserId() {
        return userId;
    }

    public RowSelectionEvent setUserId(Integer id) {
        this.userId = id;
        return this;
    }
}
