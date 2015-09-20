package org.example.web;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class TestApp implements EntryPoint {

    public void onModuleLoad() {
        RootLayoutPanel.get().add(new MyDockLayoutPanel());
    }

}
