package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.SingleValueFormField;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class JidSingleFormField extends SingleValueFormField {
    private final Jid value;

    protected JidSingleFormField(Builder builder) {
        super(builder);
        this.value = builder.value;
    }

    @Override // org.jivesoftware.smackx.xdata.SingleValueFormField
    public Jid getValue() {
        return this.value;
    }

    public Builder asBuilder() {
        return new Builder();
    }

    public static final class Builder extends SingleValueFormField.Builder<JidSingleFormField, Builder> {
        private Jid value;

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public Builder getThis() {
            return this;
        }

        private Builder(JidSingleFormField jidSingleFormField) {
            super(jidSingleFormField);
            this.value = jidSingleFormField.getValue();
        }

        Builder(String str) {
            super(str, FormField.Type.jid_single);
        }

        @Override // org.jivesoftware.smackx.xdata.SingleValueFormField.Builder, org.jivesoftware.smackx.xdata.FormField.Builder
        protected void resetInternal() {
            super.resetInternal();
            this.value = null;
        }

        public Builder setValue(Jid jid) {
            this.value = jid;
            this.rawValue = new FormField.Value(jid);
            return getThis();
        }

        public Builder setValue(FormField.Value value) throws XmppStringprepException {
            this.value = JidCreate.from(value.getValue());
            this.rawValue = value;
            return this;
        }

        @Override // org.jivesoftware.smackx.xdata.FormField.Builder
        public JidSingleFormField build() {
            return new JidSingleFormField(this);
        }
    }
}
