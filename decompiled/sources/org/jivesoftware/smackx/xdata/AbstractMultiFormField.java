package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class AbstractMultiFormField extends FormField {
    private final List<FormField.Value> values;

    protected AbstractMultiFormField(Builder<?, ?> builder) {
        super(builder);
        this.values = CollectionUtil.cloneAndSeal(((Builder) builder).values);
    }

    @Override // org.jivesoftware.smackx.xdata.FormField
    public final List<FormField.Value> getRawValues() {
        return this.values;
    }

    public static abstract class Builder<F extends AbstractMultiFormField, B extends FormField.Builder<F, B>> extends FormField.Builder<F, B> {
        private List<FormField.Value> values;

        public abstract B addValue(CharSequence charSequence);

        protected Builder(AbstractMultiFormField abstractMultiFormField) {
            super(abstractMultiFormField);
            this.values = CollectionUtil.newListWith(abstractMultiFormField.getRawValues());
        }

        protected Builder(String str, FormField.Type type) {
            super(str, type);
        }

        private void ensureValuesAreInitialized() {
            if (this.values == null) {
                this.values = new ArrayList();
            }
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        protected void resetInternal() {
            this.values = null;
        }

        public B addValueVerbatim(CharSequence charSequence) {
            return (B) addValueVerbatim(new FormField.Value(charSequence));
        }

        public B addValueVerbatim(FormField.Value value) {
            ensureValuesAreInitialized();
            this.values.add(value);
            return getThis();
        }

        public final B addValue(Date date) {
            return (B) addValueVerbatim(XmppDateTime.formatXEP0082Date(date));
        }

        public final B addValues(Collection<? extends CharSequence> collection) {
            ensureValuesAreInitialized();
            Iterator<? extends CharSequence> it = collection.iterator();
            while (it.hasNext()) {
                addValueVerbatim(it.next());
            }
            return getThis();
        }
    }
}
