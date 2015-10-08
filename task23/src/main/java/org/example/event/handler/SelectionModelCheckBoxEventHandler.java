package org.example.event.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.event.impl.SelectionModelCheckBoxEvent;

public interface SelectionModelCheckBoxEventHandler extends EventHandler {
    void handle(SelectionModelCheckBoxEvent event);
}
