package org.example.web;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasValue;

public class CheckBoxHeader extends Header<Boolean> implements HasValue<Boolean> {

    private boolean checked;
    private HandlerManager handlerManager;
    private final SafeHtml INPUT_CHECKED = SafeHtmlUtils.fromSafeConstant("<input type=\"checkbox\" tabindex=\"-1\" checked/>");
    private final SafeHtml INPUT_UNCHECKED = SafeHtmlUtils.fromSafeConstant("<input type=\"checkbox\" tabindex=\"-1\"/>");

    @Override
    public void render(Context context, SafeHtmlBuilder sb) {
        if (Boolean.TRUE.equals(this.getValue())) {
            sb.append(INPUT_CHECKED);
        } else {
            sb.append(INPUT_UNCHECKED);
        }
    }

    public CheckBoxHeader() {
        super(new CheckboxCell());
        this.checked = false;
    }

    @Override
    public Boolean getValue() {
        return this.checked;
    }

    @Override
    public void onBrowserEvent(Context context, Element elem, NativeEvent nativeEvent) {
        int eventType = Event.as(nativeEvent).getTypeInt();

        if (eventType == Event.ONCHANGE) {
            nativeEvent.preventDefault();
            ValueChangeEvent.fire(this, !this.checked);
        }
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
        return ensureHandlerManager().addHandler(ValueChangeEvent.getType(), handler);
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        ensureHandlerManager().fireEvent(event);
    }

    @Override
    public void setValue(Boolean value) {
        this.checked = value;
    }

    @Override
    public void setValue(Boolean value, boolean fireEvents) {
        this.checked = value;
        if (fireEvents) {
            ValueChangeEvent.fire(this, value);
        }
    }

    private HandlerManager ensureHandlerManager() {
        if (handlerManager == null) {
            handlerManager = new HandlerManager(this);
        }
        return handlerManager;
    }
}