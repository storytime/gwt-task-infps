package org.example.event.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.event.impl.DisableSelectionEvent;

public interface DisableSelectionEventHandler extends EventHandler {
    void disableSelection(DisableSelectionEvent event);
}
