package org.example.web.presenter.impl;

import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import org.example.model.User;
import org.example.web.ObjectsHolder;
import org.example.web.presenter.UserListPresenter;
import org.example.web.view.UserListView;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class UserListPresenterImpl implements UserListPresenter {

    private UserListView userListView;

    public UserListPresenterImpl(UserListView userListView) {
        this.userListView = userListView;
        bind();
    }

    @Override
    public void go(final Widget splitLayoutPanel) {
        ((SplitLayoutPanel) splitLayoutPanel).clear();
        ((SplitLayoutPanel) splitLayoutPanel).addNorth(userListView.asWidget(), 500);
    }

    @Override
    public void bind() {
        userListView.setPresenter(this);
    }

    @Override
    public void loadUsersData(MethodCallback<List<User>> callback) {
        ObjectsHolder.getUserClient().getUsers(callback);
    }
}
