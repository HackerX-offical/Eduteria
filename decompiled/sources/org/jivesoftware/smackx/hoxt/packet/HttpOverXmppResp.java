package org.jivesoftware.smackx.hoxt.packet;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;

/* JADX INFO: loaded from: classes10.dex */
public final class HttpOverXmppResp extends AbstractHttpOverXmpp {
    public static final String ELEMENT = "resp";
    private final int statusCode;
    private final String statusMessage;

    private HttpOverXmppResp(Builder builder) {
        super(ELEMENT, builder);
        this.statusCode = ((Integer) Objects.requireNonNull(Integer.valueOf(builder.statusCode), "statusCode must not be null")).intValue();
        this.statusMessage = builder.statusMessage;
    }

    @Override // org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp
    protected IQ.IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("version", getVersion());
        iQChildElementXmlStringBuilder.attribute("statusCode", this.statusCode);
        iQChildElementXmlStringBuilder.optAttribute("statusMessage", this.statusMessage);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractHttpOverXmpp.Builder<Builder, HttpOverXmppResp> {
        private int statusCode;
        private String statusMessage;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp.Builder
        public Builder getThis() {
            return this;
        }

        private Builder() {
            this.statusCode = 200;
            this.statusMessage = null;
        }

        public Builder setStatusCode(int i) {
            this.statusCode = i;
            return this;
        }

        public Builder setStatusMessage(String str) {
            this.statusMessage = str;
            return this;
        }

        @Override // org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp.Builder
        public HttpOverXmppResp build() {
            return new HttpOverXmppResp(this);
        }
    }
}
