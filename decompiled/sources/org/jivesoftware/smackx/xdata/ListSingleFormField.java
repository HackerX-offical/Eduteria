package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldWithOptions;

/* JADX INFO: loaded from: classes10.dex */
public class ListSingleFormField extends AbstractSingleStringValueFormField implements FormFieldWithOptions {
    private final List<FormField.Option> options;

    protected ListSingleFormField(Builder builder) {
        super(builder);
        this.options = CollectionUtil.cloneAndSeal(builder.options);
    }

    @Override // org.jivesoftware.smackx.xdata.FormFieldWithOptions
    public List<FormField.Option> getOptions() {
        return this.options;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    @Override // org.jivesoftware.smackx.xdata.SingleValueFormField, org.jivesoftware.smackx.xdata.FormField
    protected void populateExtraXmlChildElements() {
        this.extraXmlChildElements = new ArrayList(this.options.size() + 1);
        String value = getValue();
        if (value != null) {
            this.extraXmlChildElements.add(new FormField.Value(value));
        }
        this.extraXmlChildElements.addAll(this.options);
    }

    public static final class Builder extends AbstractSingleStringValueFormField.Builder<ListSingleFormField, Builder> implements FormFieldWithOptions.Builder<Builder> {
        private List<FormField.Option> options;

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public Builder getThis() {
            return this;
        }

        private Builder(ListSingleFormField listSingleFormField) {
            super(listSingleFormField);
        }

        Builder(String str) {
            super(str, FormField.Type.list_single);
        }

        @Override // org.jivesoftware.smackx.xdata.FormFieldWithOptions.Builder
        public Builder addOption(FormField.Option option) {
            if (this.options == null) {
                this.options = new ArrayList();
            }
            this.options.add(option);
            return this;
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public ListSingleFormField build() {
            return new ListSingleFormField(this);
        }
    }
}
