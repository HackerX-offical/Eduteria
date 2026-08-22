package org.jivesoftware.smack.fsm;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.StateTransitionResult;

/* JADX INFO: loaded from: classes10.dex */
public class NoOpState extends State {
    protected NoOpState(ModularXmppClientToServerConnection modularXmppClientToServerConnection, StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(stateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    @Override // org.jivesoftware.smack.fsm.State
    public StateTransitionResult.Success transitionInto(WalkStateGraphContext walkStateGraphContext) {
        return StateTransitionResult.Success.EMPTY_INSTANCE;
    }
}
