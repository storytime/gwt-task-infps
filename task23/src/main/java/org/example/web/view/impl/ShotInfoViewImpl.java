package org.example.web.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import org.example.event.handler.RowSelectionEvenHandler;
import org.example.event.impl.RowSelectionEvent;
import org.example.model.User;
import org.example.web.ObjectsHolder;
import org.example.web.presenter.Presenter;
import org.example.web.presenter.ShotInfoPresenter;
import org.example.web.view.ShotInfoView;

import java.util.Set;


/**
 * Created by Bogdan.Fedorchenko on 10/5/2015.
 */
public class ShotInfoViewImpl extends Composite implements ShotInfoView {

    private ShotInfoPresenter presenter;

    private static final String EMPTY_STRING = "";

    @UiField(provided = true)
    public TextBox email;

    @UiField(provided = true)
    public TextBox surname;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (ShotInfoPresenter) presenter;
    }

    interface ShotInfoUiBinder extends UiBinder<HTMLPanel, ShotInfoViewImpl> {
    }

    private static ShotInfoUiBinder ourUiBinder = GWT.create(ShotInfoUiBinder.class);

    public ShotInfoViewImpl() {
        initTextBoxes();
        addEventBusHandlers();
        initWidget(ourUiBinder.createAndBindUi(this));
    }


    private void initTextBoxes() {
        email = new TextBox();
        surname = new TextBox();
    }
    private void addEventBusHandlers() {
        ObjectsHolder.getEventBus().addHandler(RowSelectionEvent.TYPE, new RowSelectionEvenHandler() {
            @Override
            public void select(RowSelectionEvent event) {
                //fillDataFields
                User user = event.getUser();
                if (user == null) {
                    email.setValue(EMPTY_STRING);
                    surname.setValue(EMPTY_STRING);
                    return;
                } else {
                    email.setValue(user.getEmail());
                    surname.setValue(user.getSurName());
                }
            }
        });
    }


}