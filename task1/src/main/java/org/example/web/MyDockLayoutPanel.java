package org.example.web;


import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import org.example.model.User;
import org.example.util.UserHelper;

import java.util.List;

public class MyDockLayoutPanel extends Composite {
    public static final String ID = "ID";
    public static final String NAME = "Name";
    public static final String ROLE = "Role";

    private static MyDockLayoutPanelUiBinder uiBinder = GWT
            .create(MyDockLayoutPanelUiBinder.class);

    interface MyDockLayoutPanelUiBinder extends
            UiBinder<Widget, MyDockLayoutPanel> {
    }

    @UiField(provided = true)
    public CellTable<User> dataGrid;

    @UiField
    public TextBox email;

    @UiField
    public TextBox surname;


    public MyDockLayoutPanel() {
        initDataGrid();
        initWidget(uiBinder.createAndBindUi(this));
    }

    private void initDataGrid() {

        dataGrid = new CellTable<User>();
        dataGrid.setAutoHeaderRefreshDisabled(true);
        dataGrid.setEmptyTableWidget(new Label("DataGridEmpty"));

        initColumns();

        // Create a data provider.
        ListDataProvider<User> dataProvider = new ListDataProvider<User>();
        // Add the data to the data provider, which automatically pushes it to the widget.
        List<User> list = dataProvider.getList();
        for (User u : UserHelper.generateUserList(5)) {
            list.add(u);
        }
        // Connect the dataGrid to the data provider.
        dataProvider.addDataDisplay(dataGrid);

        initSelectionModel();
    }

    private void initSelectionModel() {
        final SingleSelectionModel<User> selectionModel = new SingleSelectionModel<User>();
        dataGrid.setSelectionModel(selectionModel);

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
                User selected = selectionModel.getSelectedObject();
                if (selected != null) {
                    email.setValue(selected.getEmail());
                    surname.setValue(selected.getSurName());
                }
            }
        });
    }

    private void initColumns() {
        TextColumn<User> nameColumn = new TextColumn<User>() {
            @Override
            public String getValue(User contact) {
                return contact.getName();
            }
        };
        TextColumn<User> idColumn = new TextColumn<User>() {
            @Override
            public String getValue(User contact) {
                return contact.getId().toString();
            }
        };
        Column<User, String> role = new Column<User, String>(new SelectionCell(UserHelper.getAcceptableValues())) {
            @Override
            public String getValue(User user) {
                return user.getRole().toString();
            }
        };

        dataGrid.addColumn(idColumn, ID);
        dataGrid.addColumn(nameColumn, NAME);
        dataGrid.addColumn(role, ROLE);
    }
}