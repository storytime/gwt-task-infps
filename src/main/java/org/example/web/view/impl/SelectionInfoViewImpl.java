package org.example.web.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.example.event.handler.GoButtonEventHandler;
import org.example.event.impl.DisableCheckBoxesEvent;
import org.example.event.impl.GoButtonEvent;
import org.example.event.impl.SelectionModelCheckBoxEvent;
import org.example.event.impl.ShowDialogEvent;
import org.example.web.ObjectsHolder;
import org.example.web.presenter.Presenter;
import org.example.web.presenter.SelectionInfoPresenter;
import org.example.web.view.SelectionInfoView;

public class SelectionInfoViewImpl extends Composite implements SelectionInfoView {

    private SelectionInfoPresenter presenter;

    @UiField(provided = true)
    public CheckBox disableCb;

    @UiField(provided = true)
    public CheckBox selectionCb;

    @UiField(provided = true)
    public Button goButton;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (SelectionInfoPresenter) presenter;
    }

    interface SelectionInfoUiBinder extends UiBinder<HTMLPanel, SelectionInfoViewImpl> {
    }

    private static SelectionInfoUiBinder ourUiBinder = GWT.create(SelectionInfoUiBinder.class);

    public SelectionInfoViewImpl() {
        initGoButton();
        initSelectionCheckBox();
        initDisableCbCheckBox();
        addEventBusHandlers();
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    private void initGoButton() {
        goButton = new Button();
        goButton.setEnabled(false);

        goButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ObjectsHolder.getEventBus().fireEvent(new ShowDialogEvent());
            }
        });
    }

    private void addEventBusHandlers() {
        ObjectsHolder.getEventBus().addHandler(GoButtonEvent.TYPE, new GoButtonEventHandler() {
            @Override
            public void handle(GoButtonEvent event) {
                goButton.setEnabled(event.isStatus());
            }
        });
    }

    private void initDisableCbCheckBox() {
        disableCb = new CheckBox();

        disableCb.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                ObjectsHolder.getEventBus().fireEvent(new DisableCheckBoxesEvent().setSelected(event.getValue()));
            }
        });

    }

    private void initSelectionCheckBox() {
        selectionCb = new CheckBox();
        selectionCb.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                ObjectsHolder.getEventBus().fireEvent(new SelectionModelCheckBoxEvent().setStatus(event.getValue()));
            }
        });
    }

}