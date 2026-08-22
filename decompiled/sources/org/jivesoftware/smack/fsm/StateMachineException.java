package org.jivesoftware.smack.fsm;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.StateDescriptorGraph;

/* JADX INFO: loaded from: classes10.dex */
public abstract class StateMachineException extends SmackException {
    private static final long serialVersionUID = 1;

    protected StateMachineException(String str) {
        super(str);
    }

    protected StateMachineException() {
    }

    public static class SmackMandatoryStateFailedException extends StateMachineException {
        private static final long serialVersionUID = 1;

        public SmackMandatoryStateFailedException(State state, StateTransitionResult stateTransitionResult) {
        }
    }

    public static final class SmackStateGraphDeadEndException extends StateMachineException {
        private static final long serialVersionUID = 1;
        private final StateDescriptor deadEndState;
        private final Map<State, StateTransitionResult> failedStates;
        private final List<State> walkedStateGraphPath;

        private SmackStateGraphDeadEndException(String str, WalkStateGraphContext walkStateGraphContext, StateDescriptorGraph.GraphVertex<State> graphVertex) {
            super(str);
            this.walkedStateGraphPath = Collections.unmodifiableList(walkStateGraphContext.getWalk());
            this.failedStates = Collections.unmodifiableMap(walkStateGraphContext.getFailedStates());
            this.deadEndState = graphVertex.getElement().getStateDescriptor();
        }

        public List<State> getWalkedStateGraph() {
            return this.walkedStateGraphPath;
        }

        public Map<State, StateTransitionResult> getFailedStates() {
            return this.failedStates;
        }

        public StateDescriptor getDeadEndState() {
            return this.deadEndState;
        }

        public static SmackStateGraphDeadEndException from(WalkStateGraphContext walkStateGraphContext, StateDescriptorGraph.GraphVertex<State> graphVertex) {
            return new SmackStateGraphDeadEndException(graphVertex + " has no successor vertexes", walkStateGraphContext, graphVertex);
        }
    }
}
