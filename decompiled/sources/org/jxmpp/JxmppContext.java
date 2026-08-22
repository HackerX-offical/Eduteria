package org.jxmpp;

import org.jxmpp.stringprep.XmppStringprep;
import org.jxmpp.stringprep.simple.SimpleXmppStringprep;
import org.jxmpp.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public final class JxmppContext {
    private static JxmppContext defaultContext;
    private static XmppStringprep defaultXmppStringprep;
    private final boolean cachingEnabled;
    public final XmppStringprep xmppStringprep;

    public static JxmppContext getDefaultContext() {
        return defaultContext;
    }

    static {
        SimpleXmppStringprep.setup();
    }

    public static void setDefaultXmppStringprep(XmppStringprep xmppStringprep) {
        defaultXmppStringprep = (XmppStringprep) Objects.requireNonNull(xmppStringprep, "defaultXmppStringprep");
        updateDefaultContext();
    }

    private static void updateDefaultContext() {
        defaultContext = builder().enableCaching().withXmppStringprep(defaultXmppStringprep).build();
    }

    private JxmppContext(Builder builder) {
        this.cachingEnabled = builder.cachingEnabled;
        this.xmppStringprep = (XmppStringprep) Objects.requireNonNull(builder.xmppStringprep, "xmppStringprep");
    }

    public boolean isCachingEnabled() {
        return this.cachingEnabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean cachingEnabled;
        private XmppStringprep xmppStringprep;

        public Builder enableCaching() {
            this.cachingEnabled = true;
            return this;
        }

        public Builder withXmppStringprep(XmppStringprep xmppStringprep) {
            this.xmppStringprep = (XmppStringprep) Objects.requireNonNull(xmppStringprep, "xmppStringprep");
            return this;
        }

        public JxmppContext build() {
            return new JxmppContext(this);
        }
    }
}
