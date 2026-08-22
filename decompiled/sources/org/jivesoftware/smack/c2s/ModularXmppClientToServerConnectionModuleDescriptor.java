package org.jivesoftware.smack.c2s;

import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ModularXmppClientToServerConnectionModuleDescriptor {
    protected abstract ModularXmppClientToServerConnectionModule<? extends ModularXmppClientToServerConnectionModuleDescriptor> constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal);

    protected abstract Set<Class<? extends StateDescriptor>> getStateDescriptors();

    public static abstract class Builder {
        private final ModularXmppClientToServerConnectionConfiguration.Builder connectionConfigurationBuilder;

        protected abstract ModularXmppClientToServerConnectionModuleDescriptor build();

        protected Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            this.connectionConfigurationBuilder = builder;
        }

        public ModularXmppClientToServerConnectionConfiguration.Builder buildModule() {
            this.connectionConfigurationBuilder.addModule(build());
            return this.connectionConfigurationBuilder;
        }
    }
}
