package org.jivesoftware.smack.sm;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.compression.CompressionModule;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: loaded from: classes10.dex */
public class StreamManagementModule extends ModularXmppClientToServerConnectionModule<StreamManagementModuleDescriptor> {
    private boolean useSm;
    private boolean useSmResumption;

    protected StreamManagementModule(StreamManagementModuleDescriptor streamManagementModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(streamManagementModuleDescriptor, modularXmppClientToServerConnectionInternal);
        this.useSm = true;
        this.useSmResumption = true;
    }

    public static final class EnableStreamManagementStateDescriptor extends StateDescriptor {
        private EnableStreamManagementStateDescriptor() {
            super(EnableStreamManagementState.class, ByteCode.IFNULL, StateDescriptor.Property.notImplemented);
            addPredeccessor(ModularXmppClientToServerConnection.ResourceBindingStateDescriptor.class);
            addSuccessor(ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class);
            declarePrecedenceOver(ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.fsm.StateDescriptor
        public EnableStreamManagementState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((StreamManagementModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(StreamManagementModuleDescriptor.class)).constructEnableStreamMangementState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EnableStreamManagementState constructEnableStreamMangementState(EnableStreamManagementStateDescriptor enableStreamManagementStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new EnableStreamManagementState(enableStreamManagementStateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    private final class EnableStreamManagementState extends State {
        private EnableStreamManagementState(EnableStreamManagementStateDescriptor enableStreamManagementStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(enableStreamManagementStateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            if (!StreamManagementModule.this.useSm) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream management not enabled");
            }
            return new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(this.stateDescriptor);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            throw new IllegalStateException("SM not implemented");
        }
    }

    public static final class ResumeStreamStateDescriptor extends StateDescriptor {
        private ResumeStreamStateDescriptor() {
            super(ResumeStreamState.class, ByteCode.IFNULL, StateDescriptor.Property.notImplemented);
            addPredeccessor(ModularXmppClientToServerConnection.AuthenticatedButUnboundStateDescriptor.class);
            addSuccessor(ModularXmppClientToServerConnection.AuthenticatedAndResourceBoundStateDescriptor.class);
            declarePrecedenceOver(ModularXmppClientToServerConnection.ResourceBindingStateDescriptor.class);
            declareInferiorityTo(CompressionModule.CompressionStateDescriptor.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.fsm.StateDescriptor
        public ResumeStreamState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((StreamManagementModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(StreamManagementModuleDescriptor.class)).constructResumeStreamState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResumeStreamState constructResumeStreamState(ResumeStreamStateDescriptor resumeStreamStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new ResumeStreamState(resumeStreamStateDescriptor, modularXmppClientToServerConnectionInternal);
    }

    private final class ResumeStreamState extends State {
        private ResumeStreamState(ResumeStreamStateDescriptor resumeStreamStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(resumeStreamStateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            if (!StreamManagementModule.this.useSmResumption) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream resumption not enabled");
            }
            return new StateTransitionResult.TransitionImpossibleBecauseNotImplemented(this.stateDescriptor);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) {
            throw new IllegalStateException("Stream resumption not implemented");
        }
    }

    public void setStreamManagementEnabled(boolean z) {
        this.useSm = z;
    }

    public void setStreamResumptionEnabled(boolean z) {
        this.useSmResumption = z;
    }
}
