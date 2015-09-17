package org.example.web;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * @author by Bogdan.Fedorchenko on 9/15/2015.
 */
public class TestApp implements EntryPoint {

    public void onModuleLoad() {
        RootLayoutPanel.get().add(new MyDockLayoutPanel());
    }

}
