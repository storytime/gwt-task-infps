package org.example.event.handler;

import com.google.gwt.event.shared.EventHandler;
import org.example.event.impl.ShowDialogEvent;

public interface ShowDialogEvenHandler extends EventHandler {
    void show(ShowDialogEvent event);
}
