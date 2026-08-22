package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.ConnectionConfiguration;

/* JADX INFO: loaded from: classes10.dex */
public final class XMPPTCPConnectionConfiguration extends ConnectionConfiguration {
    public static int DEFAULT_CONNECT_TIMEOUT = 30000;
    private final int connectTimeout;

    private XMPPTCPConnectionConfiguration(Builder builder) {
        super(builder);
        this.connectTimeout = builder.connectTimeout;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ConnectionConfiguration.Builder<Builder, XMPPTCPConnectionConfiguration> {
        private int connectTimeout;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.ConnectionConfiguration.Builder
        public Builder getThis() {
            return this;
        }

        private Builder() {
            this.connectTimeout = XMPPTCPConnectionConfiguration.DEFAULT_CONNECT_TIMEOUT;
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        @Override // org.jivesoftware.smack.ConnectionConfiguration.Builder
        public XMPPTCPConnectionConfiguration build() {
            return new XMPPTCPConnectionConfiguration(this);
        }
    }
}
