package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes10.dex */
public class TextSingleFormField extends AbstractSingleStringValueFormField {
    protected TextSingleFormField(Builder builder) {
        super(builder);
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public static final class Builder extends AbstractSingleStringValueFormField.Builder<TextSingleFormField, Builder> {
        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public Builder getThis() {
            return this;
        }

        private Builder(TextSingleFormField textSingleFormField) {
            super(textSingleFormField);
        }

        Builder(String str, FormField.Type type) {
            super(str, type);
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public TextSingleFormField build() {
            return new TextSingleFormField(this);
        }
    }
}
