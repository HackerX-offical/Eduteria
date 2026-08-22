package org.jivesoftware.smackx.xdata;

import java.util.Iterator;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes10.dex */
public class TextMultiFormField extends AbstractMultiFormField {
    protected TextMultiFormField(Builder builder) {
        super(builder);
    }

    public void addValuesWithNewlines(StringBuilder sb) {
        Iterator<? extends CharSequence> it = getValues().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
    }

    public StringBuilder getValueswithNewlines() {
        StringBuilder sb = new StringBuilder();
        addValuesWithNewlines(sb);
        return sb;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public static final class Builder extends AbstractMultiFormField.Builder<TextMultiFormField, Builder> {
        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public Builder getThis() {
            return this;
        }

        private Builder(TextMultiFormField textMultiFormField) {
            super(textMultiFormField);
        }

        Builder(String str) {
            super(str, FormField.Type.text_multi);
        }

        @Override // org.jivesoftware.smackx.xdata.AbstractMultiFormField.Builder
        public Builder addValue(CharSequence charSequence) {
            return addValues(StringUtils.splitLinesPortable(charSequence.toString()));
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public TextMultiFormField build() {
            return new TextMultiFormField(this);
        }
    }
}
