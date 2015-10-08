package org.example.web.presenter;

import org.example.model.User;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

/**
 * Created by Bogdan.Fedorchenko on 10/6/2015.
 */
public interface UserListPresenter extends Presenter {
    void loadUsersData(MethodCallback<List<User>> callback);
}
