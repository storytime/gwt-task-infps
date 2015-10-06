package org.example.web;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import org.example.web.view.UserListView;
import org.example.web.view.impl.SelectionInfoViewImpl;
import org.example.web.view.impl.ShotInfoViewImpl;
import org.example.web.view.impl.UserListViewImpl;

public class TestApp implements EntryPoint {

    public void onModuleLoad() {

        final RootLayoutPanel widgets = RootLayoutPanel.get();
        SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();

        UserListView userListView = new UserListViewImpl();
        SelectionInfoViewImpl selectionInfoView = new SelectionInfoViewImpl();
        ShotInfoViewImpl shotInfoView = new ShotInfoViewImpl();

        splitLayoutPanel.addNorth(userListView, 500);
        splitLayoutPanel.addEast(selectionInfoView, 1000);
        splitLayoutPanel.add(shotInfoView);

        widgets.add(splitLayoutPanel);
    }

}
