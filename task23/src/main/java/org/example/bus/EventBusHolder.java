package org.example.bus;

import com.google.gwt.event.shared.SimpleEventBus;

public class EventBusHolder {

    private static SimpleEventBus ourInstance = new SimpleEventBus();

    public static SimpleEventBus getInstance() {
        return ourInstance;
    }

    private EventBusHolder() {
    }


}



