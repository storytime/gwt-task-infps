package org.example.web.presenter;

import org.example.model.User;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public interface UserListPresenter extends Presenter {
    void loadUsersData(MethodCallback<List<User>> callback);
}
