package org.jivesoftware.smack.compression;

import java.util.Collections;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.compression.CompressionModule;
import org.jivesoftware.smack.fsm.StateDescriptor;

/* JADX INFO: loaded from: classes10.dex */
public class CompressionModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    private static final CompressionModuleDescriptor INSTANCE = new CompressionModuleDescriptor();

    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    protected Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        return Collections.singleton(CompressionModule.CompressionStateDescriptor.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    public CompressionModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new CompressionModule(this, modularXmppClientToServerConnectionInternal);
    }

    public static final class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        private Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor.Builder
        protected ModularXmppClientToServerConnectionModuleDescriptor build() {
            return CompressionModuleDescriptor.INSTANCE;
        }
    }
}
