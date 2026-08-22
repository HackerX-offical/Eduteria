package org.jivesoftware.smack.fsm;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.StateTransitionResult;

/* JADX INFO: loaded from: classes10.dex */
public abstract class State {
    protected final ModularXmppClientToServerConnectionInternal connectionInternal;
    protected final StateDescriptor stateDescriptor;

    public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) throws SmackException {
        return null;
    }

    public void resetState() {
    }

    public abstract StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, IOException, XMPPException;

    protected State(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        this.stateDescriptor = stateDescriptor;
        this.connectionInternal = modularXmppClientToServerConnectionInternal;
    }

    public StateDescriptor getStateDescriptor() {
        return this.stateDescriptor;
    }

    public String toString() {
        return "State " + this.stateDescriptor + ' ' + this.connectionInternal.connection;
    }

    protected final void ensureNotOnOurWayToAuthenticatedAndResourceBound(WalkStateGraphContext walkStateGraphContext) {
        if (walkStateGraphContext.isFinalStateAuthenticatedAndResourceBound()) {
            throw new IllegalStateException("Smack should never attempt to reach the authenticated and resource bound state over " + this + ". This is probably a programming error within Smack, please report it to the develoeprs.");
        }
    }
}
