package org.example.bus.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.bus.event.DisableCheckBoxesEvent;

public interface DisableCheckBoxesEventHandler extends EventHandler {
    void disable(DisableCheckBoxesEvent event);
}
