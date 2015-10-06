package org.example.web;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import org.example.web.presenter.impl.ShotInfoPresenterImpl;
import org.example.web.presenter.impl.UserListPresenterImpl;
import org.example.web.view.impl.SelectionInfoViewImpl;
import org.example.web.view.impl.ShotInfoViewImpl;
import org.example.web.view.impl.UserListViewImpl;

public class TestApp implements EntryPoint {

    public void onModuleLoad() {
        SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();

        UserListViewImpl userListViewImpl = ObjectsHolder.getUserListView();
        UserListPresenterImpl userListPresenter = new UserListPresenterImpl(userListViewImpl);
        userListViewImpl.initDataSource();
        userListPresenter.go(splitLayoutPanel);

        ShotInfoViewImpl shotInfoViewImpl = ObjectsHolder.getShotInfoView();
        ShotInfoPresenterImpl shotInfoPresenter = new ShotInfoPresenterImpl(shotInfoViewImpl);
        shotInfoPresenter.go(splitLayoutPanel);

//        SelectionInfoViewImpl selectionInfoView = new SelectionInfoViewImpl();
//        splitLayoutPanel.addEast(selectionInfoView, 1000);

        RootLayoutPanel.get().add(splitLayoutPanel);
    }

}
