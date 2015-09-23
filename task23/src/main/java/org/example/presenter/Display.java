package org.example.presenter;

import com.google.gwt.user.client.ui.Widget;

public interface Display {
        void setCellTableDate();
        Widget asWidget();
        void setPresenter(PersonPresenter personPresenter);
}
