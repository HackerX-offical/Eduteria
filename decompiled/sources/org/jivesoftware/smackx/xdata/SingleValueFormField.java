package org.jivesoftware.smackx.xdata;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SingleValueFormField extends FormField {
    private final FormField.Value rawValue;

    public abstract CharSequence getValue();

    protected SingleValueFormField(Builder<?, ?> builder) {
        super(builder);
        this.rawValue = builder.rawValue;
    }

    @Override // org.jivesoftware.smackx.xdata.FormField
    public final List<CharSequence> getValues() {
        return CollectionUtil.emptyOrSingletonListFrom(getValue());
    }

    public final FormField.Value getRawValue() {
        return this.rawValue;
    }

    @Override // org.jivesoftware.smackx.xdata.FormField
    public final List<FormField.Value> getRawValues() {
        return CollectionUtil.emptyOrSingletonListFrom(getRawValue());
    }

    @Override // org.jivesoftware.smackx.xdata.FormField
    protected void populateExtraXmlChildElements() {
        FormField.Value value = this.rawValue;
        if (value == null) {
            return;
        }
        this.extraXmlChildElements = Collections.singletonList(value);
    }

    public static abstract class Builder<F extends SingleValueFormField, B extends Builder<F, B>> extends FormField.Builder<F, B> {
        protected FormField.Value rawValue;

        protected Builder(String str, FormField.Type type) {
            super(str, type);
        }

        protected Builder(SingleValueFormField singleValueFormField) {
            super(singleValueFormField);
            this.rawValue = singleValueFormField.getRawValue();
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        protected void resetInternal() {
            this.rawValue = null;
        }
    }
}
