package org.example.presenter;

import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.view.client.ListDataProvider;
import org.example.model.User;
import org.example.util.UserHelper;

import java.util.List;

public class PersonPresenter implements Presenter {

    private static final int USER_GENERATED_COUNT = 10;

    Display view;


    public PersonPresenter(Display view) {
        this.view = view;
        bind();
    }

    @Override
    public void bind() {
        view.setPresenter(this);
        view.setCellTableDate();
    }

    @Override
    public void go(Panel panel) {
        panel.add(view.asWidget());
    }

    public ListDataProvider<User> getFullDataSource() {

        ListDataProvider<User> dataProvider = new ListDataProvider<User>();
        List<User> list = dataProvider.getList();

        final List<User> userList = UserHelper.generateUserList(USER_GENERATED_COUNT);

        for (User u : userList) {
            list.add(u);
        }

        return dataProvider;
    }
}
