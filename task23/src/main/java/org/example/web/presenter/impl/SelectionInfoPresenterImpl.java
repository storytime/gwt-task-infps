package org.example.web.presenter.impl;

import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import org.example.web.presenter.SelectionInfoPresenter;
import org.example.web.view.SelectionInfoView;

public class SelectionInfoPresenterImpl implements SelectionInfoPresenter {

    private SelectionInfoView selectionInfoView;

    public SelectionInfoPresenterImpl(SelectionInfoView selectionInfoView) {
        this.selectionInfoView = selectionInfoView;
        bind();
    }

    @Override
    public void go(Widget splitLayoutPanel) {
        ((SplitLayoutPanel) splitLayoutPanel).addEast(selectionInfoView.asWidget(), 700);
    }

    @Override
    public void bind() {
        selectionInfoView.setPresenter(this);
    }
}
