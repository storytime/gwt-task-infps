package org.example.web.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import org.example.web.presenter.Presenter;
import org.example.web.presenter.ShotInfoPresenter;
import org.example.web.view.ShotInfoView;


/**
 * Created by Bogdan.Fedorchenko on 10/5/2015.
 */
public class ShotInfoViewImpl extends Composite implements ShotInfoView {

    private ShotInfoPresenter presenter;

    @UiField
    public TextBox email;

    @UiField
    public TextBox surname;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (ShotInfoPresenter) presenter;
    }

    interface ShotInfoUiBinder extends UiBinder<HTMLPanel, ShotInfoViewImpl> {
    }

    private static ShotInfoUiBinder ourUiBinder = GWT.create(ShotInfoUiBinder.class);

    public ShotInfoViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }


}