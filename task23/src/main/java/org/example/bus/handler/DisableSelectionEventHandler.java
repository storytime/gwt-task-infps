package org.example.bus.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.bus.event.DisableSelectionEvent;

public interface DisableSelectionEventHandler extends EventHandler {
    void disableSelection(DisableSelectionEvent event);
}
