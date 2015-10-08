package org.example.web.presenter;

import org.example.model.User;
import org.fusesource.restygwt.client.MethodCallback;

/**
 * Created by Bogdan.Fedorchenko on 10/6/2015.
 */
public interface ShotInfoPresenter extends Presenter {
    void loadUserData(Integer id, MethodCallback<User> callback);
}
