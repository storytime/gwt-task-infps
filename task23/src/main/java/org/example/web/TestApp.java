package org.example.web;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import org.example.web.presenter.impl.SelectionInfoPresenterImpl;
import org.example.web.presenter.impl.ShotInfoPresenterImpl;
import org.example.web.presenter.impl.UserListPresenterImpl;
import org.example.web.view.SelectionInfoView;
import org.example.web.view.impl.ShotInfoViewImpl;
import org.example.web.view.impl.UserListViewImpl;
import org.fusesource.restygwt.client.Defaults;

public class TestApp implements EntryPoint {

    public void onModuleLoad() {

        Defaults.setServiceRoot("/");

        SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();

        UserListViewImpl userListViewImpl = ObjectsHolder.getUserListView();
        UserListPresenterImpl userListPresenter = new UserListPresenterImpl(userListViewImpl);
        userListViewImpl.initDataSource();
        userListPresenter.go(splitLayoutPanel);

        SelectionInfoView selectionInfoView = ObjectsHolder.getSelectionInfoView();
        SelectionInfoPresenterImpl selectionInfoPresenter = new SelectionInfoPresenterImpl(selectionInfoView);
        selectionInfoPresenter.go(splitLayoutPanel);

        ShotInfoViewImpl shotInfoViewImpl = ObjectsHolder.getShotInfoView();
        ShotInfoPresenterImpl shotInfoPresenter = new ShotInfoPresenterImpl(shotInfoViewImpl);
        shotInfoPresenter.go(splitLayoutPanel);

        RootLayoutPanel.get().add(splitLayoutPanel);
    }

}
