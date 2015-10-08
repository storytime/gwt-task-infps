package org.example.event.handler;
import com.google.gwt.event.shared.EventHandler;
import org.example.event.impl.RowSelectionEvent;

public interface RowSelectionEvenHandler extends EventHandler {
    void select(RowSelectionEvent event);
}
