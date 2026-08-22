package org.jivesoftware.smack.bind2;

import java.util.Collections;
import java.util.Set;
import org.jivesoftware.smack.bind2.Bind2Module;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.fsm.StateDescriptor;

/* JADX INFO: loaded from: classes10.dex */
public class Bind2ModuleDescriptor extends ModularXmppClientToServerConnectionModuleDescriptor {
    private static final Bind2ModuleDescriptor INSTANCE = new Bind2ModuleDescriptor();

    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    protected Set<Class<? extends StateDescriptor>> getStateDescriptors() {
        return Collections.singleton(Bind2Module.Bind2StateDescriptor.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor
    public Bind2Module constructXmppConnectionModule(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new Bind2Module(this, modularXmppClientToServerConnectionInternal);
    }

    public static class Builder extends ModularXmppClientToServerConnectionModuleDescriptor.Builder {
        protected Builder(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
            super(builder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor.Builder
        public Bind2ModuleDescriptor build() {
            return Bind2ModuleDescriptor.INSTANCE;
        }
    }
}
