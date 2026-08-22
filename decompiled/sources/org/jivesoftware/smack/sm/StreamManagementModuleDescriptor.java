package org.jivesoftware.smack.sm;

import java.util.HashSet;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.sm.StreamManagementModule;

/* JADX INFO: loaded from: classes10.dex */
public class StreamManagementModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    private static final StreamManagementModuleDescriptor INSTANCE = new StreamManagementModuleDescriptor();

    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    protected Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        HashSet hashSet = new HashSet();
        hashSet.add(StreamManagementModule.EnableStreamManagementStateDescriptor.class);
        hashSet.add(StreamManagementModule.ResumeStreamStateDescriptor.class);
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    public StreamManagementModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new StreamManagementModule(this, modularXmppClientToServerConnectionInternal);
    }

    public static class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        protected Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor.Builder
        public StreamManagementModuleDescriptor build() {
            return StreamManagementModuleDescriptor.INSTANCE;
        }
    }
}
