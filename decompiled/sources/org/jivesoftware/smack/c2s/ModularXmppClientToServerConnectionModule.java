package org.jivesoftware.smack.c2s;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ModularXmppClientToServerConnectionModule<MD extends ModularXmppClientToServerConnectionModuleDescriptor> {
    protected final ModularXmppClientToServerConnectionInternal connectionInternal;
    protected final MD moduleDescriptor;

    protected XmppClientToServerTransport getTransport() {
        return null;
    }

    protected ModularXmppClientToServerConnectionModule(MD md, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        this.moduleDescriptor = md;
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
    }

    public MD getModuleDescriptor() {
        return this.moduleDescriptor;
    }
}
