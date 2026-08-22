package org.jivesoftware.smack.tcp;

import java.util.HashSet;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.tcp.XmppTcpTransportModule;

/* JADX INFO: loaded from: classes10.dex */
public class XmppTcpTransportModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    private final boolean directTls;
    private final boolean startTls;

    public XmppTcpTransportModuleDescriptor(Builder builder) {
        this.startTls = builder.startTls;
        this.directTls = builder.directTls;
    }

    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    protected Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        HashSet hashSet = new HashSet();
        hashSet.add(XmppTcpTransportModule.EstablishingTcpConnectionStateDescriptor.class);
        if (this.startTls) {
            hashSet.add(XmppTcpTransportModule.EstablishTlsStateDescriptor.class);
        }
        if (this.directTls) {
            throw new IllegalArgumentException("DirectTLS is not implemented yet");
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    public XmppTcpTransportModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new XmppTcpTransportModule(this, modularXmppClientToServerConnectionInternal);
    }

    public boolean isStartTlsEnabled() {
        return this.startTls;
    }

    public boolean isDirectTlsEnabled() {
        return this.directTls;
    }

    public static final class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        private boolean directTls;
        private boolean startTls;

        private Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
            this.startTls = true;
            this.directTls = false;
        }

        public Builder disableDirectTls() {
            this.directTls = false;
            return this;
        }

        public Builder disableStartTls() {
            this.startTls = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor.Builder
        public XmppTcpTransportModuleDescriptor build() {
            return new XmppTcpTransportModuleDescriptor(this);
        }
    }
}
