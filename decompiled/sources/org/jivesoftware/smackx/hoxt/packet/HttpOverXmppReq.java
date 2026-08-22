package org.jivesoftware.smackx.hoxt.packet;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.jingle.element.Jingle;

/* JADX INFO: loaded from: classes10.dex */
public final class HttpOverXmppReq extends AbstractHttpOverXmpp {
    public static final String ELEMENT = "req";
    private final boolean ibb;
    private final boolean jingle;
    private final int maxChunkSize;
    private final HttpMethod method;
    private final String resource;
    private final boolean sipub;

    private HttpOverXmppReq(Builder builder) {
        super("req", builder);
        this.method = builder.method;
        this.resource = builder.resource;
        this.maxChunkSize = builder.maxChunkSize;
        this.ibb = builder.ibb;
        this.jingle = builder.jingle;
        this.sipub = builder.sipub;
        setType(IQ.Type.set);
    }

    @Override // org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp
    protected IQ.IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute(FirebaseAnalytics.Param.METHOD, this.method);
        iQChildElementXmlStringBuilder.attribute("resource", this.resource);
        iQChildElementXmlStringBuilder.attribute("version", getVersion());
        iQChildElementXmlStringBuilder.optIntAttribute("maxChunkSize", this.maxChunkSize);
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue("sipub", this.sipub);
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue(AbstractHttpOverXmpp.Ibb.ELEMENT, this.ibb);
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue(Jingle.ELEMENT, this.jingle);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getResource() {
        return this.resource;
    }

    public int getMaxChunkSize() {
        return this.maxChunkSize;
    }

    public boolean isSipub() {
        return this.sipub;
    }

    public boolean isIbb() {
        return this.ibb;
    }

    public boolean isJingle() {
        return this.jingle;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends AbstractHttpOverXmpp.Builder<Builder, HttpOverXmppReq> {
        private boolean ibb;
        private boolean jingle;
        private int maxChunkSize;
        private HttpMethod method;
        private String resource;
        private boolean sipub;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp.Builder
        public Builder getThis() {
            return this;
        }

        private Builder() {
            this.maxChunkSize = -1;
            this.sipub = true;
            this.ibb = true;
            this.jingle = true;
        }

        public Builder setMethod(HttpMethod httpMethod) {
            this.method = httpMethod;
            return this;
        }

        public Builder setResource(String str) {
            this.resource = str;
            return this;
        }

        public Builder setJingle(boolean z) {
            this.jingle = z;
            return this;
        }

        public Builder setIbb(boolean z) {
            this.ibb = z;
            return this;
        }

        public Builder setSipub(boolean z) {
            this.sipub = z;
            return this;
        }

        public Builder setMaxChunkSize(int i) {
            if (i < 256 || i > 65536) {
                throw new IllegalArgumentException("maxChunkSize must be within [256, 65536]");
            }
            this.maxChunkSize = i;
            return this;
        }

        @Override // org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp.Builder
        public HttpOverXmppReq build() {
            if (this.method == null) {
                throw new IllegalArgumentException("Method cannot be null");
            }
            if (this.resource == null) {
                throw new IllegalArgumentException("Resource cannot be null");
            }
            return new HttpOverXmppReq(this);
        }
    }
}
