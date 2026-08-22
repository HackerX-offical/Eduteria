package org.jivesoftware.smack.c2s.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.fsm.LoginContext;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;
import org.jivesoftware.smack.fsm.StateTransitionResult;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.Objects;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public final class WalkStateGraphContext {
    private final Class<? extends StateDescriptor> finalStateClass;
    private final Class<? extends StateDescriptor> initialStateClass;
    private final LoginContext loginContext;
    private final Class<? extends StateDescriptor> mandatoryIntermediateState;
    boolean mandatoryIntermediateStateHandled;
    private final List<State> walkedStateGraphPath = new ArrayList();
    final Map<State, StateTransitionResult> failedStates = new LinkedHashMap();

    WalkStateGraphContext(Builder builder) {
        this.initialStateClass = builder.initialStateClass;
        this.finalStateClass = builder.finalStateClass;
        this.mandatoryIntermediateState = builder.mandatoryIntermediateState;
        this.loginContext = builder.loginContext;
    }

    public void recordWalkTo(State state) {
        this.walkedStateGraphPath.add(state);
    }

    public boolean isWalksFinalState(StateDescriptor stateDescriptor) {
        return stateDescriptor.getClass() == this.finalStateClass;
    }

    public boolean isFinalStateAuthenticatedAndResourceBound() {
        return this.finalStateClass == ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class;
    }

    public StateDescriptorGraph.GraphVertex<State> maybeReturnMandatoryImmediateState(List<StateDescriptorGraph.GraphVertex<State>> list) {
        for (StateDescriptorGraph.GraphVertex<State> graphVertex : list) {
            if (graphVertex.getElement().getStateDescriptor().getClass() == this.mandatoryIntermediateState) {
                this.mandatoryIntermediateStateHandled = true;
                return graphVertex;
            }
        }
        return null;
    }

    public List<State> getWalk() {
        return CollectionUtil.newListWith(this.walkedStateGraphPath);
    }

    public int getWalkLength() {
        return this.walkedStateGraphPath.size();
    }

    public void appendWalkTo(List<State> list) {
        list.addAll(this.walkedStateGraphPath);
    }

    public LoginContext getLoginContext() {
        return this.loginContext;
    }

    public boolean stateAlreadyVisited(State state) {
        return this.walkedStateGraphPath.contains(state);
    }

    public void recordFailedState(State state, StateTransitionResult stateTransitionResult) {
        this.failedStates.put(state, stateTransitionResult);
    }

    public Map<State, StateTransitionResult> getFailedStates() {
        return new HashMap(this.failedStates);
    }

    public boolean wouldCauseCycle(StateDescriptorGraph.GraphVertex<State> graphVertex) {
        return wouldCycleRecursive(graphVertex, new HashSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean wouldCycleRecursive(StateDescriptorGraph.GraphVertex<State> graphVertex, Set<Class<? extends StateDescriptor>> set) {
        Class<?> cls = graphVertex.getElement().getStateDescriptor().getClass();
        if (cls == this.initialStateClass) {
            return true;
        }
        if (this.finalStateClass != cls && !set.contains(cls)) {
            set.add(cls);
            Iterator<StateDescriptorGraph.GraphVertex<State>> it = graphVertex.getOutgoingEdges().iterator();
            while (it.hasNext()) {
                if (wouldCycleRecursive(it.next(), set)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Builder builder(Class<? extends StateDescriptor> cls, Class<? extends StateDescriptor> cls2) {
        return new Builder(cls, cls2);
    }

    public static final class Builder {
        private final Class<? extends StateDescriptor> finalStateClass;
        private final Class<? extends StateDescriptor> initialStateClass;
        private LoginContext loginContext;
        private Class<? extends StateDescriptor> mandatoryIntermediateState;

        private Builder(Class<? extends StateDescriptor> cls, Class<? extends StateDescriptor> cls2) {
            this.initialStateClass = (Class) Objects.requireNonNull(cls);
            this.finalStateClass = (Class) Objects.requireNonNull(cls2);
        }

        public Builder withMandatoryIntermediateState(Class<? extends StateDescriptor> cls) {
            this.mandatoryIntermediateState = cls;
            return this;
        }

        public Builder withLoginContext(String str, String str2, Resourcepart resourcepart) {
            return withLoginContext(new LoginContext(str, str2, resourcepart));
        }

        public Builder withLoginContext(LoginContext loginContext) {
            this.loginContext = loginContext;
            return this;
        }

        public WalkStateGraphContext build() {
            return new WalkStateGraphContext(this);
        }
    }
}
