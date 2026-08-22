package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldWithOptions;

/* JADX INFO: loaded from: classes10.dex */
public class ListMultiFormField extends AbstractMultiFormField implements FormFieldWithOptions {
    private final List<FormField.Option> options;

    protected ListMultiFormField(Builder builder) {
        super(builder);
        this.options = CollectionUtil.cloneAndSeal(builder.options);
    }

    @Override // org.jivesoftware.smackx.xdata.FormFieldWithOptions
    public List<FormField.Option> getOptions() {
        return this.options;
    }

    @Override // org.jivesoftware.smackx.xdata.FormField
    protected void populateExtraXmlChildElements() {
        super.populateExtraXmlChildElements();
        this.extraXmlChildElements.addAll(this.options);
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public static final class Builder extends AbstractMultiFormField.Builder<ListMultiFormField, Builder> implements FormFieldWithOptions.Builder<Builder> {
        private List<FormField.Option> options;

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public Builder getThis() {
            return this;
        }

        private Builder(ListMultiFormField listMultiFormField) {
            super(listMultiFormField);
        }

        Builder(String str) {
            super(str, FormField.Type.list_multi);
        }

        @Override // org.jivesoftware.smackx.xdata.AbstractMultiFormField.Builder
        public Builder addValue(CharSequence charSequence) {
            return (Builder) super.addValueVerbatim(charSequence);
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
        public ListMultiFormField build() {
            return new ListMultiFormField(this);
        }
    }
}
