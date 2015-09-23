package org.example.web;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import org.example.presenter.Display;
import org.example.presenter.PersonPresenter;

public class TestApp implements EntryPoint {

    public void onModuleLoad() {
        Display view = new MyDockLayoutPanelView();
        PersonPresenter personPresenter = new PersonPresenter(view);
        personPresenter.go(RootLayoutPanel.get());
    }
}
