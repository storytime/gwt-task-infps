package org.example.web.presenter;

import org.example.model.User;
import org.fusesource.restygwt.client.MethodCallback;

public interface ShotInfoPresenter extends Presenter {
    void loadUserData(Integer id, MethodCallback<User> callback);
}
