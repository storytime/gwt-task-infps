package org.example.web.presenter.impl;

import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import org.example.model.User;
import org.example.util.UserHelper;
import org.example.web.presenter.UserListPresenter;
import org.example.web.view.UserListView;

import java.util.List;

public class UserListPresenterImpl implements UserListPresenter {

    private static final int USER_GENERATED_COUNT = 10;

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
    public List<User> getUserData() {
        return UserHelper.generateUserList(USER_GENERATED_COUNT);
    }
}
