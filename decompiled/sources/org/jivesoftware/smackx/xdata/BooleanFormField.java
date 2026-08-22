package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.SingleValueFormField;

/* JADX INFO: loaded from: classes10.dex */
public class BooleanFormField extends SingleValueFormField {
    private final Boolean value;

    protected BooleanFormField(Builder builder) {
        super(builder);
        this.value = builder.value;
    }

    @Override // org.jivesoftware.smackx.xdata.SingleValueFormField
    public String getValue() {
        Boolean bool = this.value;
        if (bool == null) {
            return null;
        }
        return bool.toString();
    }

    public Boolean getValueAsBoolean() {
        return this.value;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public static final class Builder extends SingleValueFormField.Builder<BooleanFormField, Builder> {
        private Boolean value;

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public Builder getThis() {
            return this;
        }

        private Builder(BooleanFormField booleanFormField) {
            super(booleanFormField);
            this.value = booleanFormField.value;
        }

        Builder(String str) {
            super(str, FormField.Type.bool);
        }

        @Override // org.jivesoftware.smackx.xdata.SingleValueFormField.Builder, org.jivesoftware.smackx.xdata.FormField.Builder
        protected void resetInternal() {
            super.resetInternal();
            this.value = null;
        }

        @Deprecated
        public Builder addValue(CharSequence charSequence) {
            return setValue(new FormField.Value(charSequence));
        }

        public Builder setValue(CharSequence charSequence) {
            return setValue(new FormField.Value(charSequence));
        }

        public Builder setValue(FormField.Value value) {
            this.value = Boolean.valueOf(ParserUtils.parseXmlBoolean(value.getValue().toString()));
            this.rawValue = value;
            return getThis();
        }

        public Builder setValue(boolean z) {
            this.rawValue = new FormField.Value(Boolean.toString(z));
            this.value = Boolean.valueOf(z);
            return this;
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public BooleanFormField build() {
            return new BooleanFormField(this);
        }
    }
}
