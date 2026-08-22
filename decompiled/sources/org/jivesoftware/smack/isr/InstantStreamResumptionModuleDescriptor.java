package org.jivesoftware.smack.isr;

import java.util.Collections;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.isr.InstantStreamResumptionModule;

/* JADX INFO: loaded from: classes10.dex */
public class InstantStreamResumptionModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    private static final InstantStreamResumptionModuleDescriptor INSTANCE = new InstantStreamResumptionModuleDescriptor();

    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    protected Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        return Collections.singleton(InstantStreamResumptionModule.InstantStreamResumptionStateDescriptor.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    public InstantStreamResumptionModule constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new InstantStreamResumptionModule(this, modularXmppClientToServerConnectionInternal);
    }

    public static final class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        private Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor.Builder
        protected ModularXmppClientToServerConnectionModuleDescriptor build() {
            return InstantStreamResumptionModuleDescriptor.INSTANCE;
        }
    }
}
