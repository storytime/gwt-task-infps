package org.example.event.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.event.impl.HeaderCheckBoxEvent;

public interface DisableCheckBoxEventHandler extends EventHandler {
    void handle(HeaderCheckBoxEvent event);
}
