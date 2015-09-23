package org.example.bus.handler;
import com.google.gwt.event.shared.EventHandler;
import org.example.bus.event.RowSelectionEvent;

public interface RowSelectionEvenHandler extends EventHandler {
    void select(RowSelectionEvent event);
}
