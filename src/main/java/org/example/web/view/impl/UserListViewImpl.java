package org.example.web.view.impl;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import org.example.event.handler.DisableCheckBoxesEventHandler;
import org.example.event.handler.SelectionModelCheckBoxEventHandler;
import org.example.event.handler.ShowDialogEvenHandler;
import org.example.event.impl.*;
import org.example.model.User;
import org.example.util.UserHelper;
import org.example.web.CheckBoxHeader;
import org.example.web.ObjectsHolder;
import org.example.web.presenter.Presenter;
import org.example.web.presenter.UserListPresenter;
import org.example.web.view.UserListView;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.*;

public class UserListViewImpl extends Composite implements UserListView {

    private UserListPresenter presenter;
    private static final String CLOSE = "Close";
    private static final String BR = "</br>";
    private static final String ID = "ID";
    private static final String NAME = "Name";
    private static final String ROLE = "Role";
    private static final String USER_INFO = "User info";
    private static final String USERS_SEPARATOR = "    ";
    private static final String WIDTH = "100%";


    private CheckBoxHeader headerCheckbox;
    private List<User> selectedUsers = new ArrayList<User>();
    private boolean isCheckboxesDisabled = false;
    private SingleSelectionModel<User> selectionModel;


    @UiField(provided = true)
    public CellTable<User> cellTable;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (UserListPresenter) presenter;
    }

    interface UserListUiBinder extends UiBinder<HTMLPanel, UserListViewImpl> {
    }

    private static UserListUiBinder ourUiBinder = GWT.create(UserListUiBinder.class);

    public UserListViewImpl() {
        initCellTable();
        initCellTableMainColumns();
        initSelectionModel();
        initHeaderCheckbox();
        initTableCheckBoxes();
        addEventBusHandlers();
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    private void initCellTable() {
        cellTable = new CellTable<User>();
        cellTable.setWidth(WIDTH, true);
        cellTable.setAutoHeaderRefreshDisabled(true);
    }

    private void initTableCheckBoxes() {
        cellTable.insertColumn(0, new CustomColumn(), headerCheckbox);
    }

    private void initCellTableMainColumns() {

        TextColumn<User> idColumn = new TextColumn<User>() {
            @Override
            public String getValue(User contact) {
                return contact.getId().toString();
            }
        };

        TextColumn<User> nameColumn = new TextColumn<User>() {
            @Override
            public String getValue(User contact) {
                return contact.getName();
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

    private void initSelectionModel() {

        //if we put sel. checkbox, we need to know what item were selected
        Set<User> selectedItemInOldSelectionModel = new HashSet<User>(1);
        if (selectionModel != null && selectionModel.getSelectedSet().size() > 0) {
            selectedItemInOldSelectionModel = selectionModel.getSelectedSet();
        }

        selectionModel = new SingleSelectionModel<User>();

        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
                Set<User> selectedSet = selectionModel.getSelectedSet();
                for (User user : selectedSet) {
                    ObjectsHolder.getEventBus().fireEvent(new RowSelectionEvent().setUserId(user.getId()));
                }
            }
        });

        //add CB col. to BL
        cellTable.setSelectionModel(selectionModel, getBlackListSelectionManager(0));

        //select element from prev. selection model
        if (selectedItemInOldSelectionModel.size() > 0)
            selectItemAfterSelectionModelReplacing(selectedItemInOldSelectionModel);
    }


    public void initDataSource() {
        ListDataProvider<User> dataProvider = new ListDataProvider<User>();
        final List<User> list = dataProvider.getList();

        presenter.loadUsersData(new MethodCallback<List<User>>() {
            @Override
            public void onFailure(Method method, Throwable throwable) {
            }

            @Override
            public void onSuccess(Method method, List<User> users) {
                list.clear();
                list.addAll(users);

            }
        });
        dataProvider.addDataDisplay(cellTable);
    }

    private void initHeaderCheckbox() {
        headerCheckbox = new CheckBoxHeader();
        headerCheckbox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                selectedUsers.clear();

                if (event.getValue()) {
                    selectedUsers.addAll(cellTable.getVisibleItems());
                    headerCheckbox.setValue(true);
                    ObjectsHolder.getEventBus().fireEvent(new GoButtonEvent().setStatus(true));
                } else {
                    ObjectsHolder.getEventBus().fireEvent(new GoButtonEvent().setStatus(false));
                    headerCheckbox.setValue(false);
                }

                cellTable.redraw();
                cellTable.redrawHeaders();
            }
        });
    }

    private class CustomColumn extends Column<User, Boolean> {

        public CustomColumn() {
            super(new CustomCell());
        }

        @Override
        public Boolean getValue(User user) {
            return selectedUsers.contains(user);
        }

        @Override
        public void onBrowserEvent(Cell.Context context, Element elem, User user, NativeEvent event) {
            super.onBrowserEvent(context, elem, user, event);

            Element target = event.getEventTarget().cast();
            final InputElement input = target.cast();

            //select user
            if (input.isChecked()) {
                selectedUsers.add(user);
            } else {
                selectedUsers.remove(user);
            }

            //set go button status
            if (selectedUsers.size() > 0) {
                ObjectsHolder.getEventBus().fireEvent(new GoButtonEvent().setStatus(true));
            } else {
                ObjectsHolder.getEventBus().fireEvent(new GoButtonEvent().setStatus(false));
            }

            //set header status
            if (selectedUsers.size() == cellTable.getVisibleItemCount()) {
                headerCheckbox.setValue(true);
            } else {
                headerCheckbox.setValue(false);
            }

            cellTable.redrawHeaders();
            cellTable.redraw();
        }
    }

    private DefaultSelectionEventManager<User> getBlackListSelectionManager(int... col) {
        return DefaultSelectionEventManager
                .createCustomManager(new DefaultSelectionEventManager.BlacklistEventTranslator<User>(col));
    }

    private class CustomCell extends CheckboxCell {

        private final SafeHtml INPUT_CHECKED_DISABLED = SafeHtmlUtils.fromSafeConstant("<input type=\"checkbox\" tabindex=\"-1\" checked disabled=\"disabled\"/>");
        private final SafeHtml INPUT_UNCHECKED_DISABLED = SafeHtmlUtils.fromSafeConstant("<input type=\"checkbox\" tabindex=\"-1\" disabled=\"disabled\"/>");

        @Override
        public void render(Context context, Boolean isCurrentCellChecked, SafeHtmlBuilder sb) {

            //if cb dis not sel.  typical rendering
            if (!isCheckboxesDisabled) {
                super.render(context, isCurrentCellChecked, sb);
                return;
            }

            if (isCurrentCellChecked) {
                sb.append(INPUT_CHECKED_DISABLED);
            } else {
                sb.append(INPUT_UNCHECKED_DISABLED);
            }
        }
    }

    private void selectItemAfterSelectionModelReplacing(Collection<User> selectedSet) {
        for (User user : selectedSet) {
            selectionModel.setSelected(user, true);
        }
    }


    private void addEventBusHandlers() {
        ObjectsHolder.getEventBus().addHandler(ShowDialogEvent.TYPE, new ShowDialogEvenHandler() {
            @Override
            public void show(ShowDialogEvent event) {
                StringBuilder res = new StringBuilder();
                for (User item : selectedUsers) {
                    res.append(item.getId()).append(USERS_SEPARATOR).append(item.getEmail()).append(BR);
                }
                showDialogBox(res);

            }
        });

        ObjectsHolder.getEventBus().addHandler(SelectionModelCheckBoxEvent.TYPE, new SelectionModelCheckBoxEventHandler() {
            @Override
            public void handle(SelectionModelCheckBoxEvent event) {
                if (event.isStatus()) {
                    Set<User> selectedItemInOldSelectionModel = selectionModel.getSelectedSet();
                    selectionModel = new SingleSelectionModel<User>();
                    cellTable.setSelectionModel(selectionModel, getBlackListSelectionManager(0, 1, 2, 3));
                    selectItemAfterSelectionModelReplacing(selectedItemInOldSelectionModel);
                } else {
                    initSelectionModel();
                }

            }
        });

        ObjectsHolder.getEventBus().addHandler(DisableCheckBoxesEvent.TYPE, new DisableCheckBoxesEventHandler() {
            @Override
            public void handle(DisableCheckBoxesEvent event) {
                isCheckboxesDisabled = event.isSelected();
                headerCheckbox.setEnabled(!isCheckboxesDisabled);
                cellTable.redrawHeaders();
                cellTable.redraw();
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

    private DialogBox createDialogBox(final DialogBox dialogBox, final String text) {

        // set main text
        dialogBox.setText(USER_INFO);

        // create header
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