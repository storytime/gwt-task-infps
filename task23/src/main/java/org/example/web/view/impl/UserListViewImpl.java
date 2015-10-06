package org.example.web.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.example.model.User;
import org.example.web.presenter.Presenter;
import org.example.web.presenter.UserListPresenter;
import org.example.web.view.UserListView;

/**
 * Created by Bogdan.Fedorchenko on 10/6/2015.
 */
public class UserListViewImpl extends Composite implements UserListView {

    private UserListPresenter presenter;

    @UiField
    public CellTable<User> cellTable;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (UserListPresenter) presenter;
    }

    interface UserListUiBinder extends UiBinder<HTMLPanel, UserListViewImpl> {
    }

    private static UserListUiBinder ourUiBinder = GWT.create(UserListUiBinder.class);

    public UserListViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}