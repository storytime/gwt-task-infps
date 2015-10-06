package org.example.event.impl;

import com.google.gwt.event.shared.GwtEvent;
import org.example.event.handler.RowSelectionEvenHandler;
import org.example.model.User;

public class RowSelectionEvent extends GwtEvent<RowSelectionEvenHandler> {

    public final static Type<RowSelectionEvenHandler> TYPE = new Type<RowSelectionEvenHandler>();
    private User user;

    @Override
    public Type<RowSelectionEvenHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(RowSelectionEvenHandler handler) {
        handler.select(this);
    }

    public User getUser() {
        return user;
    }

    public RowSelectionEvent setUser(User user) {
        this.user = user;
        return this;
    }
}
