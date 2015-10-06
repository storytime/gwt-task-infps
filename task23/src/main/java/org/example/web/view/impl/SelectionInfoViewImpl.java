package org.example.web.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.example.web.presenter.Presenter;
import org.example.web.presenter.SelectionInfoPresenter;
import org.example.web.view.SelectionInfoView;

/**
 * Created by Bogdan.Fedorchenko on 10/6/2015.
 */
public class SelectionInfoViewImpl extends Composite implements SelectionInfoView {

    private SelectionInfoPresenter presenter;

    @UiField
    public CheckBox disableCb;

    @UiField
    public CheckBox selectionCb;

    @UiField
    public Button goButton;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (SelectionInfoPresenter) presenter;
    }

    interface SelectionInfoUiBinder extends UiBinder<HTMLPanel, SelectionInfoViewImpl> {
    }

    private static SelectionInfoUiBinder ourUiBinder = GWT.create(SelectionInfoUiBinder.class);

    public SelectionInfoViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}