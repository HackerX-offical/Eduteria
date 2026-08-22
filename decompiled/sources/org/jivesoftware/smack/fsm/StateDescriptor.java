package org.jivesoftware.smack.fsm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;

/* JADX INFO: loaded from: classes10.dex */
public abstract class StateDescriptor {
    private static final Logger LOGGER = Logger.getLogger(StateDescriptor.class.getName());
    private final Set<Class<? extends StateDescriptor>> inferiorTo;
    private final Set<Class<? extends StateDescriptor>> precedenceOver;
    private final Set<Class<? extends StateDescriptor>> predecessors;
    private final Set<Property> properties;
    private transient String referenceCache;
    private final String rfcSection;
    private final Class<? extends State> stateClass;
    private final Constructor<? extends State> stateClassConstructor;
    private final String stateName;
    private final Set<Class<? extends StateDescriptor>> successors;
    private final int xepNum;

    public enum Property {
        multiVisitState,
        finalState,
        notImplemented
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    protected StateDescriptor() {
        this((Class<? extends State>) NoOpState.class, null);
    }

    protected StateDescriptor(Property... propertyArr) {
        this((Class<? extends State>) NoOpState.class, propertyArr);
    }

    protected StateDescriptor(Class<? extends State> cls) {
        this(cls, -1, null, Collections.emptySet());
    }

    protected StateDescriptor(Class<? extends State> cls, Property... propertyArr) {
        this(cls, -1, null, new HashSet(Arrays.asList(propertyArr)));
    }

    protected StateDescriptor(Class<? extends State> cls, int i) {
        this(cls, i, null, Collections.emptySet());
    }

    protected StateDescriptor(Class<? extends State> cls, int i, Property... propertyArr) {
        this(cls, i, null, new HashSet(Arrays.asList(propertyArr)));
    }

    protected StateDescriptor(Class<? extends State> cls, String str) {
        this(cls, -1, str, Collections.emptySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StateDescriptor(Class<? extends State> cls, int i, String str, Set<Property> set) {
        Constructor<? extends State> constructor;
        this.successors = new HashSet();
        this.predecessors = new HashSet();
        this.precedenceOver = new HashSet();
        this.inferiorTo = new HashSet();
        this.stateClass = cls;
        if (str != null && i > 0) {
            throw new IllegalArgumentException("Must specify either RFC or XEP");
        }
        this.xepNum = i;
        this.rfcSection = str;
        this.properties = set;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                constructor = 0;
                break;
            }
            constructor = declaredConstructors[i2];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 3 && ModularXmppClientToServerConnection.class.isAssignableFrom(parameterTypes[0]) && StateDescriptor.class.isAssignableFrom(parameterTypes[1]) && ModularXmppClientToServerConnectionInternal.class.isAssignableFrom(parameterTypes[2])) {
                break;
            } else {
                i2++;
            }
        }
        this.stateClassConstructor = constructor;
        if (constructor != 0) {
            constructor.setAccessible(true);
        }
        this.stateName = getClass().getSimpleName().replaceFirst("StateDescriptor", "");
    }

    protected void addSuccessor(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.successors, cls);
    }

    public void addPredeccessor(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.predecessors, cls);
    }

    protected void declarePrecedenceOver(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.precedenceOver, cls);
    }

    protected void declarePrecedenceOver(String str) {
        addAndCheckNonExistent(this.precedenceOver, str);
    }

    protected void declareInferiorityTo(Class<? extends StateDescriptor> cls) {
        addAndCheckNonExistent(this.inferiorTo, cls);
    }

    protected void declareInferiorityTo(String str) {
        addAndCheckNonExistent(this.inferiorTo, str);
    }

    private static void addAndCheckNonExistent(Set<Class<? extends StateDescriptor>> set, String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (!StateDescriptor.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " is no state descriptor class");
            }
            addAndCheckNonExistent(set, cls.asSubclass(StateDescriptor.class));
        } catch (ClassNotFoundException e2) {
            LOGGER.log(Level.FINEST, "Ignoring unknown state descriptor '" + str + "'", (Throwable) e2);
        }
    }

    private static <E> void addAndCheckNonExistent(Set<E> set, E e2) {
        if (!set.add(e2)) {
            throw new IllegalArgumentException("Element already exists in set");
        }
    }

    public Set<Class<? extends StateDescriptor>> getSuccessors() {
        return Collections.unmodifiableSet(this.successors);
    }

    public Set<Class<? extends StateDescriptor>> getPredeccessors() {
        return Collections.unmodifiableSet(this.predecessors);
    }

    public Set<Class<? extends StateDescriptor>> getSubordinates() {
        return Collections.unmodifiableSet(this.precedenceOver);
    }

    public Set<Class<? extends StateDescriptor>> getSuperiors() {
        return Collections.unmodifiableSet(this.inferiorTo);
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getFullStateName(boolean z) {
        String reference = getReference();
        if (reference != null) {
            return getStateName() + (z ? '\n' : ' ') + '(' + reference + ')';
        }
        return getStateName();
    }

    public String getReference() {
        if (this.referenceCache == null) {
            if (this.xepNum > 0) {
                this.referenceCache = "XEP-" + String.format("%04d", Integer.valueOf(this.xepNum));
            } else {
                String str = this.rfcSection;
                if (str != null) {
                    this.referenceCache = str;
                }
            }
        }
        return this.referenceCache;
    }

    public Class<? extends State> getStateClass() {
        return this.stateClass;
    }

    public boolean isMultiVisitState() {
        return this.properties.contains(Property.multiVisitState);
    }

    public boolean isNotImplemented() {
        return this.properties.contains(Property.notImplemented);
    }

    public boolean isFinalState() {
        return this.properties.contains(Property.finalState);
    }

    protected State constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        try {
            return this.stateClassConstructor.newInstance(modularXmppClientToServerConnectionInternal.connection, this, modularXmppClientToServerConnectionInternal);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public String toString() {
        return "StateDescriptor " + this.stateName;
    }
}
