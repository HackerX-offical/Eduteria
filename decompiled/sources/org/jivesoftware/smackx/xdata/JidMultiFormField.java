package org.jivesoftware.smackx.xdata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public final class JidMultiFormField extends FormField {
    private final List<FormField.Value> rawValues;
    private final List<Jid> values;

    protected JidMultiFormField(Builder builder) {
        super(builder);
        this.values = CollectionUtil.cloneAndSeal(builder.values);
        this.rawValues = CollectionUtil.cloneAndSeal(builder.rawValues);
    }

    @Override // org.jivesoftware.smackx.xdata.FormField
    public List<Jid> getValues() {
        return this.values;
    }

    @Override // org.jivesoftware.smackx.xdata.FormField
    public List<FormField.Value> getRawValues() {
        return this.rawValues;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public static final class Builder extends FormField.Builder<JidMultiFormField, Builder> {
        private List<FormField.Value> rawValues;
        private List<Jid> values;

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public Builder getThis() {
            return this;
        }

        private Builder(JidMultiFormField jidMultiFormField) {
            super(jidMultiFormField);
            this.values = CollectionUtil.newListWith(jidMultiFormField.getValues());
        }

        Builder(String str) {
            super(str, FormField.Type.jid_multi);
        }

        private void ensureValuesAreInitialized() {
            if (this.values == null) {
                this.values = new ArrayList();
                this.rawValues = new ArrayList();
            }
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        protected void resetInternal() {
            this.values = null;
            this.rawValues = null;
        }

        public Builder addValue(Jid jid) {
            FormField.Value value = new FormField.Value(jid);
            ensureValuesAreInitialized();
            this.values.add(jid);
            this.rawValues.add(value);
            return getThis();
        }

        public Builder addValue(FormField.Value value) throws XmppStringprepException {
            Jid jidFrom = JidCreate.from(value.getValue());
            ensureValuesAreInitialized();
            this.values.add(jidFrom);
            this.rawValues.add(value);
            return this;
        }

        public Builder addValues(Collection<? extends Jid> collection) {
            Iterator<? extends Jid> it = collection.iterator();
            while (it.hasNext()) {
                addValue(it.next());
            }
            return this;
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public JidMultiFormField build() {
            return new JidMultiFormField(this);
        }
    }
}
