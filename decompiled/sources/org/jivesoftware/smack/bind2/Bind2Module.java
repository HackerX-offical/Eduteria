package org.jivesoftware.smack.bind2;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;

/* JADX INFO: loaded from: classes10.dex */
public class Bind2Module extends ModularXmppClientToServerConnectionModule<Bind2ModuleDescriptor> {
    protected Bind2Module(Bind2ModuleDescriptor bind2ModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(bind2ModuleDescriptor, modularXmppClientToServerConnectionInternal);
    }

    public static final class Bind2StateDescriptor extends StateDescriptor {
        private Bind2StateDescriptor() {
            super(Bind2State.class, 386, StateDescriptor.Property.notImplemented);
            addPredeccessor(ModularXmppClientToServerConnection.ConnectedButUnauthenticatedStateDescriptor.class);
            addSuccessor(ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class);
            declarePrecedenceOver(ModularXmppClientToServerConnection.SaslAuthenticationStateDescriptor.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.fsm.StateDescriptor
        public Bind2State constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((Bind2Module) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(Bind2ModuleDescriptor.class)).constructBind2State(this, modularXmppClientToServerConnectionInternal);
        }
    }

    private static final class Bind2State extends State {
        private Bind2State(Bind2StateDescriptor bind2StateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(bind2StateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            return new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(this.stateDescriptor);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            throw new IllegalStateException("Bind2 not implemented");
        }
    }

    public Bind2State constructBind2State(Bind2StateDescriptor bind2StateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new Bind2State(bind2StateDescriptor, modularXmppClientToServerConnectionInternal);
    }
}
