package org.jivesoftware.smackx.xdata.form;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.BooleanFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public interface FormReader {
    FormField getField(String str);

    default String readFirstValue(String str) {
        FormField field = getField(str);
        if (field == null) {
            return null;
        }
        return field.getFirstValue();
    }

    default List<? extends CharSequence> readValues(String str) {
        FormField field = getField(str);
        if (field == null) {
            return Collections.emptyList();
        }
        return field.getValues();
    }

    default List<String> readStringValues(String str) {
        FormField field = getField(str);
        if (field == null) {
            return Collections.emptyList();
        }
        return StringUtils.toStrings(((AbstractMultiFormField) field.ifPossibleAs(AbstractMultiFormField.class)).getValues());
    }

    default Boolean readBoolean(String str) {
        FormField field = getField(str);
        if (field == null) {
            return null;
        }
        return ((BooleanFormField) field.ifPossibleAs(BooleanFormField.class)).getValueAsBoolean();
    }

    default Integer readInteger(String str) {
        FormField field = getField(str);
        if (field == null) {
            return null;
        }
        return ((AbstractSingleStringValueFormField) field.ifPossibleAs(AbstractSingleStringValueFormField.class)).getValueAsInt();
    }

    default Date readDate(String str) throws ParseException {
        String value;
        FormField field = getField(str);
        if (field == null || (value = ((AbstractSingleStringValueFormField) field.ifPossibleAs(AbstractSingleStringValueFormField.class)).getValue()) == null) {
            return null;
        }
        return XmppDateTime.parseDate(value);
    }
}
