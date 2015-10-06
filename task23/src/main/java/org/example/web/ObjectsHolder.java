package org.example.web;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import org.example.web.view.SelectionInfoView;
import org.example.web.view.ShotInfoView;
import org.example.web.view.UserListView;
import org.example.web.view.impl.SelectionInfoViewImpl;
import org.example.web.view.impl.ShotInfoViewImpl;
import org.example.web.view.impl.UserListViewImpl;

/**
 * Created by Bogdan.Fedorchenko on 10/6/2015.
 */
public class ObjectsHolder {

    private static EventBus eventBus;
    private static SelectionInfoView selectionInfoView;
    private static ShotInfoView shotInfoView;
    private static UserListView userListView;

    private ObjectsHolder() {
    }

    public static EventBus getEventBus() {
        if (eventBus == null)
            eventBus = new SimpleEventBus();

        return eventBus;
    }

    public static SelectionInfoView getSelectionInfoView() {
        if (selectionInfoView == null)
            selectionInfoView = new SelectionInfoViewImpl();

        return selectionInfoView;
    }

    public static ShotInfoView getShotInfoView() {
        if (shotInfoView == null)
            shotInfoView = new ShotInfoViewImpl();

        return shotInfoView;
    }

    public static UserListView getUserListView() {
        if (userListView == null)
            userListView = new UserListViewImpl();

        return userListView;
    }
}
