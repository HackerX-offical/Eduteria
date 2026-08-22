package org.jivesoftware.smack.c2s;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.util.CollectionUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class ModularXmppClientToServerConnectionConfiguration extends ConnectionConfiguration {
    final StateDescriptorGraph.GraphVertex<StateDescriptor> initialStateDescriptorVertex;
    final Set<ModularXmppClientToServerConnectionModuleDescriptor> moduleDescriptors;

    private ModularXmppClientToServerConnectionConfiguration(Builder builder) {
        super(builder);
        Set<ModularXmppClientToServerConnectionModuleDescriptor> setUnmodifiableSet = Collections.unmodifiableSet(CollectionUtil.newSetWith(builder.modulesDescriptors.values()));
        this.moduleDescriptors = setUnmodifiableSet;
        HashSet hashSet = new HashSet();
        Iterator<ModularXmppClientToServerConnectionModuleDescriptor> it = setUnmodifiableSet.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getStateDescriptors());
        }
        try {
            this.initialStateDescriptorVertex = StateDescriptorGraph.constructStateDescriptorGraph(hashSet);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void printStateGraphInDotFormat(PrintWriter printWriter, boolean z) {
        StateDescriptorGraph.stateDescriptorGraphToDot(Collections.singleton(this.initialStateDescriptorVertex), printWriter, z);
    }

    public String getStateGraphInDotFormat() {
        StringWriter stringWriter = new StringWriter();
        printStateGraphInDotFormat(new PrintWriter(stringWriter), true);
        return stringWriter.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder extends ConnectionConfiguration.Builder<Builder, ModularXmppClientToServerConnectionConfiguration> {
        private final Map<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>, ModularXmppClientToServerConnectionModuleDescriptor> modulesDescriptors;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.ConnectionConfiguration.Builder
        public Builder getThis() {
            return this;
        }

        private Builder() {
            this.modulesDescriptors = new HashMap();
            SmackConfiguration.addAllKnownModulesTo(this);
        }

        @Override // org.jivesoftware.smack.ConnectionConfiguration.Builder
        public ModularXmppClientToServerConnectionConfiguration build() {
            return new ModularXmppClientToServerConnectionConfiguration(this);
        }

        void addModule(ModularXmppClientToServerConnectionModuleDescriptor modularXmppClientToServerConnectionModuleDescriptor) {
            Class<?> cls = modularXmppClientToServerConnectionModuleDescriptor.getClass();
            if (this.modulesDescriptors.containsKey(cls)) {
                throw new IllegalArgumentException("A connection module for " + cls + " is already configured");
            }
            this.modulesDescriptors.put((Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>) cls, modularXmppClientToServerConnectionModuleDescriptor);
        }

        public Builder addModule(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
            Class<?> cls2;
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            int length = declaredClasses.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    cls2 = null;
                    break;
                }
                cls2 = declaredClasses[i];
                if (ModularXmppClientToServerConnectionModuleDescriptor.Builder.class.isAssignableFrom(cls2)) {
                    break;
                }
                i++;
            }
            if (cls2 == null) {
                throw new IllegalArgumentException("Found no builder for " + cls + ". Delcared classes: " + Arrays.toString(declaredClasses));
            }
            return with(cls2).buildModule();
        }

        public <B extends ModularXmppClientToServerConnectionModuleDescriptor.Builder> B with(Class<? extends B> cls) {
            try {
                Constructor<? extends B> declaredConstructor = cls.getDeclaredConstructor(Builder.class);
                declaredConstructor.setAccessible(true);
                try {
                    return declaredConstructor.newInstance(this);
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (NoSuchMethodException | SecurityException e3) {
                throw new IllegalArgumentException(e3);
            }
        }

        public Builder removeModule(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
            this.modulesDescriptors.remove(cls);
            return getThis();
        }

        public Builder removeAllModules() {
            this.modulesDescriptors.clear();
            return getThis();
        }
    }
}
