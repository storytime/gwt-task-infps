package org.example.event.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.event.impl.GoButtonEvent;

public interface GoButtonEventHandler extends EventHandler {
    void handle(GoButtonEvent event);
}
