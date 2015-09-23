package org.example.bus.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.bus.event.GoButtonEvent;

public interface GoButtonEventHandler extends EventHandler {
    void handle(GoButtonEvent event);
}
