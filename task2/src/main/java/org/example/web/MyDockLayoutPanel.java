package org.example.web;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import org.example.model.User;
import org.example.util.UserHelper;

import java.util.List;

public class MyDockLayoutPanel extends Composite {

    private static final int USER_GENERATED_COUNT = 5;
    private static final String CLOSE = "Close";
    private static final String BR = "</br>";
    private static final String ID = "ID";
    private static final String SEPARATOR = ";     ";
    private static final String EMPTY_STRING = "";
    private static final String NAME = "Name";
    private static final String ROLE = "Role";
    private static final String DATA_GRID_EMPTY = "DataGridEmpty";
    private static final String USER_INFO = "User info";
    private static final String USERS_SEPARATOR = "    ";

    private static MyDockLayoutPanelUiBinder uiBinder = GWT.create(MyDockLayoutPanelUiBinder.class);

    interface MyDockLayoutPanelUiBinder extends UiBinder<Widget, MyDockLayoutPanel> {
    }

    @UiField(provided = true)
    public CellTable<User> cellTable;

    @UiField
    public TextBox email;

    @UiField
    public TextBox surname;

    @UiField(provided = true)
    public Button goButton;
    private CheckBoxHeader headerCheckbox;
    private MultiSelectionModel<User> selectionModel;

    public MyDockLayoutPanel() {
        initDataGrid();
        initGoButton();
        initWidget(uiBinder.createAndBindUi(this));
    }

    private void initDataGrid() {
        headerCheckbox = new CheckBoxHeader();
        cellTable = new CellTable<User>();
        cellTable.setAutoHeaderRefreshDisabled(true);
        cellTable.setEmptyTableWidget(new Label(DATA_GRID_EMPTY));

        initColumns();
        initDataSource();
        initSelectionModel();
        initCellTable();
        initTableCheckBoxes();
    }

    private void initGoButton() {
        goButton = new Button();
        goButton.setEnabled(false);
        goButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                StringBuilder res = new StringBuilder();
                for (User item : cellTable.getVisibleItems()) {
                    if (selectionModel.isSelected(item)) {
                        res.append(item.getId()).append(USERS_SEPARATOR).append(item.getEmail()).append(BR);
                    }
                }
                showDialogBox(res);
            }
        });
    }

    private void showDialogBox(StringBuilder res) {
        final DialogBox dialogBox = createDialogBox(new DialogBox(), res.toString());
        dialogBox.setGlassEnabled(true);
        dialogBox.setAnimationEnabled(true);
        dialogBox.center();
        dialogBox.show();
    }

    private void initDataSource() {
        ListDataProvider<User> dataProvider = new ListDataProvider<User>();
        List<User> list = dataProvider.getList();
        final List<User> userList = UserHelper.generateUserList(USER_GENERATED_COUNT);

        for (User u : userList) {
            list.add(u);
        }

        dataProvider.addDataDisplay(cellTable);
    }

    private void initCellTable() {
        cellTable.setWidth("100%", true);
        cellTable.setAutoHeaderRefreshDisabled(true);
        cellTable.setAutoFooterRefreshDisabled(true);
        cellTable.setSelectionModel(selectionModel, DefaultSelectionEventManager.<User>createCheckboxManager());
    }

    private void initSelectionModel() {
        selectionModel = new MultiSelectionModel<User>();
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

            public void onSelectionChange(SelectionChangeEvent event) {
                fillDataFields();
                boolean allRowsAreSelected = true;

                for (User item : cellTable.getVisibleItems()) {
                    if (!selectionModel.isSelected(item)) {
                        allRowsAreSelected = false;
                    }
                }

                if (selectionModel.getSelectedSet().size() > 0) {
                    goButton.setEnabled(true);
                } else {
                    goButton.setEnabled(false);
                }

                if (allRowsAreSelected) {
                    headerCheckbox.setValue(true);
                    cellTable.redrawHeaders();
                } else {
                    headerCheckbox.setValue(false);
                    cellTable.redrawHeaders();
                }
            }
        });
    }

    private void fillDataFields() {
        email.setValue(EMPTY_STRING);
        surname.setValue(EMPTY_STRING);
        for (User user : selectionModel.getSelectedSet()) {
            if (email.getValue().isEmpty()) {
                email.setValue(user.getEmail());
            } else {
                email.setValue(email.getValue() + SEPARATOR + user.getEmail());
            }

            if (surname.getValue().isEmpty()) {
                surname.setValue(user.getSurName());
            } else {
                surname.setValue(surname.getValue() + SEPARATOR + user.getSurName());
            }
        }
    }

    private void initTableCheckBoxes() {
        headerCheckbox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                for (User item : cellTable.getVisibleItems()) {
                    selectionModel.setSelected(item, event.getValue());
                }
            }
        });

        final Column<User, Boolean> checkColumn = new Column<User, Boolean>(new CheckboxCell()) {
            @Override
            public Boolean getValue(User object) {
                return selectionModel.isSelected(object);
            }
        };

        headerCheckbox.setValue(false);
        cellTable.insertColumn(0, checkColumn, headerCheckbox);
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
        Column<User, String> roleColumn = new Column<User, String>(new SelectionCell(UserHelper.getAcceptableValues())) {
            @Override
            public String getValue(User user) {
                return user.getRole().toString();
            }
        };
        cellTable.addColumn(idColumn, ID);
        cellTable.addColumn(nameColumn, NAME);
        cellTable.addColumn(roleColumn, ROLE);
    }

    private DialogBox createDialogBox(final DialogBox dialogBox, final String text) {

        //set main text
        dialogBox.setText(USER_INFO);

        //create header
        VerticalPanel dialogContents = new VerticalPanel();
        dialogContents.setSpacing(4);
        dialogBox.setWidget(dialogContents);
        HTML details = new HTML(text);
        dialogContents.add(details);
        dialogContents.setCellHorizontalAlignment(details, HasHorizontalAlignment.ALIGN_CENTER);

        Button closeButton = new Button(CLOSE);
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dialogBox.hide();
            }
        });

        dialogContents.add(closeButton);
        dialogContents.setCellHorizontalAlignment(closeButton, HasHorizontalAlignment.ALIGN_LEFT);
        return dialogBox;
    }
}