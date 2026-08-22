package org.jivesoftware.smack.compression;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.XmppInputOutputFilter;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModule;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.c2s.internal.WalkStateGraphContext;
import org.jivesoftware.smack.compress.packet.Compress;
import org.jivesoftware.smack.compress.packet.Compressed;
import org.jivesoftware.smack.compress.packet.Failure;
import org.jivesoftware.smack.fsm.State;
import org.jivesoftware.smack.fsm.StateDescriptor;
import org.jivesoftware.smack.fsm.StateTransitionResult;

/* JADX INFO: loaded from: classes10.dex */
public class CompressionModule extends ModularXmppClientToServerConnectionModule<CompressionModuleDescriptor> {
    protected CompressionModule(CompressionModuleDescriptor compressionModuleDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        super(compressionModuleDescriptor, modularXmppClientToServerConnectionInternal);
    }

    public static final class CompressionStateDescriptor extends StateDescriptor {
        private CompressionStateDescriptor() {
            super((Class<? extends State>) CompressionState.class, 138);
            addPredeccessor(ModularXmppClientToServerConnection.AuthenticatedButUnboundStateDescriptor.class);
            addSuccessor(ModularXmppClientToServerConnection.AuthenticatedButUnboundStateDescriptor.class);
            declarePrecedenceOver(ModularXmppClientToServerConnection.ResourceBindingStateDescriptor.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jivesoftware.smack.fsm.StateDescriptor
        public CompressionState constructState(ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            return ((CompressionModule) modularXmppClientToServerConnectionInternal.connection.getConnectionModuleFor(CompressionModuleDescriptor.class)).constructCompressionState(this, modularXmppClientToServerConnectionInternal);
        }
    }

    private static final class CompressionState extends State {
        private XmppCompressionFactory selectedCompressionFactory;
        private XmppInputOutputFilter usedXmppInputOutputCompressionFitler;

        private CompressionState(StateDescriptor stateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
            super(stateDescriptor, modularXmppClientToServerConnectionInternal);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.TransitionImpossible isTransitionToPossible(WalkStateGraphContext walkStateGraphContext) {
            ModularXmppClientToServerConnectionConfiguration configuration = this.connectionInternal.connection.getConfiguration();
            if (!configuration.isCompressionEnabled()) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream compression disabled by connection configuration");
            }
            Compress.Feature feature = (Compress.Feature) this.connectionInternal.connection.getFeature(Compress.Feature.class);
            if (feature == null) {
                return new StateTransitionResult.TransitionImpossibleReason("Stream compression not supported or enabled by service");
            }
            XmppCompressionFactory bestFactory = XmppCompressionManager.getBestFactory(feature);
            this.selectedCompressionFactory = bestFactory;
            if (bestFactory == null) {
                return new StateTransitionResult.TransitionImpossibleReason("No matching compression factory for " + feature.getMethods());
            }
            this.usedXmppInputOutputCompressionFitler = bestFactory.fabricate(configuration);
            return null;
        }

        @Override // org.jivesoftware.smack.fsm.State
        public StateTransitionResult.AttemptResult transitionInto(WalkStateGraphContext walkStateGraphContext) throws SmackException, InterruptedException, XMPPException {
            String compressionMethod = this.selectedCompressionFactory.getCompressionMethod();
            this.connectionInternal.sendAndWaitForResponse(new Compress(compressionMethod), Compressed.class, Failure.class);
            this.connectionInternal.addXmppInputOutputFilter(this.usedXmppInputOutputCompressionFitler);
            this.connectionInternal.newStreamOpenWaitForFeaturesSequence("server stream features after compression enabled");
            this.connectionInternal.setCompressionEnabled(true);
            return new CompressionTransitionSuccessResult(compressionMethod);
        }

        @Override // org.jivesoftware.smack.fsm.State
        public void resetState() {
            this.selectedCompressionFactory = null;
            this.usedXmppInputOutputCompressionFitler = null;
            this.connectionInternal.setCompressionEnabled(false);
        }
    }

    public static final class CompressionTransitionSuccessResult extends StateTransitionResult.Success {
        private final String compressionMethod;

        private CompressionTransitionSuccessResult(String str) {
            super(str + " compression enabled");
            this.compressionMethod = str;
        }

        public String getCompressionMethod() {
            return this.compressionMethod;
        }
    }

    public CompressionState constructCompressionState(CompressionStateDescriptor compressionStateDescriptor, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return new CompressionState(compressionStateDescriptor, modularXmppClientToServerConnectionInternal);
    }
}
