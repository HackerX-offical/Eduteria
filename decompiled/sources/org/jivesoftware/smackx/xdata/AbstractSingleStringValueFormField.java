package org.jivesoftware.smackx.xdata;

import java.net.URL;
import java.util.Date;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.SingleValueFormField;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class AbstractSingleStringValueFormField extends SingleValueFormField {
    private final String value;

    protected AbstractSingleStringValueFormField(Builder<?, ?> builder) {
        super(builder);
        this.value = ((Builder) builder).value;
    }

    @Override // org.jivesoftware.smackx.xdata.SingleValueFormField
    public final String getValue() {
        return this.value;
    }

    public final Integer getValueAsInt() {
        String str = this.value;
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str);
    }

    public static abstract class Builder<F extends SingleValueFormField, B extends SingleValueFormField.Builder<F, B>> extends SingleValueFormField.Builder<F, B> {
        private String value;

        protected Builder(AbstractSingleStringValueFormField abstractSingleStringValueFormField) {
            super(abstractSingleStringValueFormField);
            this.value = abstractSingleStringValueFormField.getValue();
        }

        protected Builder(String str, FormField.Type type) {
            super(str, type);
        }

        @Override // org.jivesoftware.smackx.xdata.SingleValueFormField.Builder, org.jivesoftware.smackx.xdata.FormField.Builder
        protected void resetInternal() {
            this.value = null;
        }

        @Deprecated
        public B addValue(CharSequence charSequence) {
            return (B) setValue(charSequence);
        }

        public B setValue(FormField.Value value) {
            this.value = value.getValue().toString();
            this.rawValue = value;
            return getThis();
        }

        public B setValue(CharSequence charSequence) {
            this.value = charSequence.toString();
            this.rawValue = new FormField.Value(this.value);
            return getThis();
        }

        public B setValue(Enum<?> r1) {
            return (B) setValue(r1.toString());
        }

        public B setValue(int i) {
            return (B) setValue(Integer.toString(i));
        }

        public B setValue(URL url) {
            return (B) setValue(url.toString());
        }

        public B setValue(Date date) {
            return (B) setValue(XmppDateTime.formatXEP0082Date(date));
        }
    }
}
