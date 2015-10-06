package org.example.web.presenter.impl;

import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import org.example.web.presenter.ShotInfoPresenter;
import org.example.web.view.ShotInfoView;

/**
 * Created by Bogdan.Fedorchenko on 10/6/2015.
 */
public class ShotInfoPresenterImpl implements ShotInfoPresenter {

    private ShotInfoView shotInfoView;


    public ShotInfoPresenterImpl(ShotInfoView userListView) {
        this.shotInfoView = userListView;
        bind();
    }

    @Override
    public void go(Widget splitLayoutPanel) {
//        ((SplitLayoutPanel) splitLayoutPanel).clear();
        ((SplitLayoutPanel) splitLayoutPanel).add(shotInfoView.asWidget());
    }

    @Override
    public void bind() {
        shotInfoView.setPresenter(this);
    }
}
