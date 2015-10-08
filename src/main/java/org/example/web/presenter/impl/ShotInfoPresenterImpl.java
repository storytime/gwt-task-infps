package org.example.web.presenter.impl;

import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import org.example.model.User;
import org.example.web.ObjectsHolder;
import org.example.web.presenter.ShotInfoPresenter;
import org.example.web.view.ShotInfoView;
import org.fusesource.restygwt.client.MethodCallback;

public class ShotInfoPresenterImpl implements ShotInfoPresenter {

    private ShotInfoView shotInfoView;


    public ShotInfoPresenterImpl(ShotInfoView userListView) {
        this.shotInfoView = userListView;
        bind();
    }

    @Override
    public void go(Widget splitLayoutPanel) {
        ((SplitLayoutPanel) splitLayoutPanel).add(shotInfoView.asWidget());
    }

    @Override
    public void bind() {
        shotInfoView.setPresenter(this);
    }

    @Override
    public void loadUserData(Integer id, MethodCallback<User> callback) {
        ObjectsHolder.getUserClient().getUser(id, callback);
    }
}
