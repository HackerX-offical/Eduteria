package org.jivesoftware.smack.isr;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;

/* JADX INFO: loaded from: classes10.dex */
public class InstantStreamResumptionModule extends ModularXmppClientToServerConnectionModule<InstantStreamResumptionModuleDescriptor> {
    private boolean useIsr;

    protected InstantStreamResumptionModule(InstantStreamResumptionModuleDescriptor instantStreamResumptionModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(instantStreamResumptionModuleDescriptor, modularXmppClientToServerConnectionInternal);
        this.useIsr = true;
    }

    public static final class InstantStreamResumptionStateDescriptor extends StateDescriptor {
        private InstantStreamResumptionStateDescriptor() {
            super(InstantStreamResumptionState.class, 397, StateDescriptor.Property.notImplemented);
            addSuccessor(ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class);
            addPredeccessor(ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class);
            declarePrecedenceOver(ModularXmppClientToServerConnection.SaslAuthenticationStateDescriptor.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.fsm.StateDescriptor
        public InstantStreamResumptionState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((InstantStreamResumptionModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(InstantStreamResumptionModuleDescriptor.class)).constructInstantStreamResumptionState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    private final class InstantStreamResumptionState extends State {
        private InstantStreamResumptionState(InstantStreamResumptionStateDescriptor instantStreamResumptionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(instantStreamResumptionStateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            if (!InstantStreamResumptionModule.this.useIsr) {
                return new StateTransitionResult.TransitionImpossibleReason("Instant stream resumption not enabled nor implemented");
            }
            return new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(this.stateDescriptor);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            throw new IllegalStateException("Instant stream resumption not implemented");
        }
    }

    public void setInstantStreamResumptionEnabled(boolean z) {
        this.useIsr = z;
    }

    public InstantStreamResumptionState constructInstantStreamResumptionState(InstantStreamResumptionStateDescriptor instantStreamResumptionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new InstantStreamResumptionState(instantStreamResumptionStateDescriptor, modularXmppClientToServerConnectionInternal);
    }
}
