package org.example.web;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import org.example.api.UserClient;
import org.example.web.view.SelectionInfoView;
import org.example.web.view.impl.SelectionInfoViewImpl;
import org.example.web.view.impl.ShotInfoViewImpl;
import org.example.web.view.impl.UserListViewImpl;

/**
 * Created by Bogdan.Fedorchenko on 10/6/2015.
 */
public class ObjectsHolder {

    private static EventBus eventBus;
    private static SelectionInfoViewImpl selectionInfoView;
    private static ShotInfoViewImpl shotInfoView;
    private static UserListViewImpl userListView;
    private static UserClient userClient;

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

    public static ShotInfoViewImpl getShotInfoView() {
        if (shotInfoView == null)
            shotInfoView = new ShotInfoViewImpl();

        return shotInfoView;
    }

    public static UserListViewImpl getUserListView() {
        if (userListView == null)
            userListView = new UserListViewImpl();

        return userListView;
    }

    public static UserClient getUserClient() {
        if (userClient == null)
            userClient = GWT.create(UserClient.class);

        return userClient;
    }
}
