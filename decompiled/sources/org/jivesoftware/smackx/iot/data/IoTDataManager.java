package org.jivesoftware.smackx.iot.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.Thing;
import org.jivesoftware.smackx.iot.data.element.IoTDataField;
import org.jivesoftware.smackx.iot.data.element.IoTDataReadOutAccepted;
import org.jivesoftware.smackx.iot.data.element.IoTDataRequest;
import org.jivesoftware.smackx.iot.data.element.IoTFieldsExtension;
import org.jivesoftware.smackx.iot.data.filter.IoTFieldsExtensionFilter;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.EntityFullJid;

/* JADX INFO: loaded from: classes10.dex */
public final class IoTDataManager extends IoTManager {
    private final AtomicInteger nextSeqNr;
    private final Map<NodeInfo, Thing> things;
    private static final Logger LOGGER = Logger.getLogger(IoTDataManager.class.getName());
    private static final Map<XMPPConnection, IoTDataManager> INSTANCES = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.iot.data.IoTDataManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (IoTManager.isAutoEnableActive()) {
                    IoTDataManager.getInstanceFor(xMPPConnection);
                }
            }
        });
    }

    public static synchronized IoTDataManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTDataManager ioTDataManager;
        Map<XMPPConnection, IoTDataManager> map = INSTANCES;
        ioTDataManager = map.get(xMPPConnection);
        if (ioTDataManager == null) {
            ioTDataManager = new IoTDataManager(xMPPConnection);
            map.put(xMPPConnection, ioTDataManager);
        }
        return ioTDataManager;
    }

    private IoTDataManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.nextSeqNr = new AtomicInteger();
        this.things = new ConcurrentHashMap();
        xMPPConnection.registerIQRequestHandler(new IoTManager.IoTIqRequestHandler("req", "urn:xmpp:iot:sensordata", IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.iot.data.IoTDataManager.2
            @Override // org.jivesoftware.smackx.iot.IoTManager.IoTIqRequestHandler
            public IQ handleIoTIqRequest(IQ iq) {
                final Thing thing;
                ThingMomentaryReadOutRequest momentaryReadOutRequestHandler;
                final IoTDataRequest ioTDataRequest = (IoTDataRequest) iq;
                if (!ioTDataRequest.isMomentary() || (thing = (Thing) IoTDataManager.this.things.get(NodeInfo.EMPTY)) == null || (momentaryReadOutRequestHandler = thing.getMomentaryReadOutRequestHandler()) == null) {
                    return null;
                }
                momentaryReadOutRequestHandler.momentaryReadOutRequest(new ThingMomentaryReadOutResult() { // from class: org.jivesoftware.smackx.iot.data.IoTDataManager.2.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // org.jivesoftware.smackx.iot.data.ThingMomentaryReadOutResult
                    public void momentaryReadOut(List<? extends IoTDataField> list) {
                        IoTFieldsExtension ioTFieldsExtensionBuildFor = IoTFieldsExtension.buildFor(ioTDataRequest.getSequenceNr(), true, thing.getNodeInfo(), list);
                        XMPPConnection xMPPConnectionConnection = IoTDataManager.this.connection();
                        Message messageBuild = ((MessageBuilder) ((MessageBuilder) xMPPConnectionConnection.getStanzaFactory().buildMessageStanza().to(ioTDataRequest.getFrom())).addExtension(ioTFieldsExtensionBuildFor)).build();
                        try {
                            xMPPConnectionConnection.sendStanza(messageBuild);
                        } catch (InterruptedException | SmackException.NotConnectedException e2) {
                            IoTDataManager.LOGGER.log(Level.SEVERE, "Could not send read-out response " + messageBuild, e2);
                        }
                    }
                });
                return new IoTDataReadOutAccepted(ioTDataRequest);
            }
        });
    }

    public void installThing(Thing thing) {
        this.things.put(thing.getNodeInfo(), thing);
    }

    public Thing uninstallThing(Thing thing) {
        return uninstallThing(thing.getNodeInfo());
    }

    public Thing uninstallThing(NodeInfo nodeInfo) {
        return this.things.remove(nodeInfo);
    }

    public List<IoTFieldsExtension> requestMomentaryValuesReadOut(EntityFullJid entityFullJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        XMPPConnection xMPPConnectionConnection = connection();
        int iIncrementAndGet = this.nextSeqNr.incrementAndGet();
        IoTDataRequest ioTDataRequest = new IoTDataRequest(iIncrementAndGet, true);
        ioTDataRequest.setTo(entityFullJid);
        IoTFieldsExtensionFilter ioTFieldsExtensionFilter = new IoTFieldsExtensionFilter(iIncrementAndGet, true);
        IoTFieldsExtensionFilter ioTFieldsExtensionFilter2 = new IoTFieldsExtensionFilter(iIncrementAndGet, false);
        StanzaCollector stanzaCollectorCreateStanzaCollector = xMPPConnectionConnection.createStanzaCollector(ioTFieldsExtensionFilter);
        StanzaCollector stanzaCollectorCreateStanzaCollector2 = xMPPConnectionConnection.createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(ioTFieldsExtensionFilter2).setCollectorToReset(stanzaCollectorCreateStanzaCollector));
        try {
            xMPPConnectionConnection.createStanzaCollectorAndSend(ioTDataRequest).nextResultOrThrow();
            stanzaCollectorCreateStanzaCollector.nextResult();
            stanzaCollectorCreateStanzaCollector2.cancel();
            int collectedCount = stanzaCollectorCreateStanzaCollector2.getCollectedCount();
            ArrayList arrayList = new ArrayList(collectedCount);
            for (int i = 0; i < collectedCount; i++) {
                arrayList.add(IoTFieldsExtension.from((Message) stanzaCollectorCreateStanzaCollector2.pollResult()));
            }
            return arrayList;
        } catch (Throwable th) {
            stanzaCollectorCreateStanzaCollector2.cancel();
            throw th;
        }
    }
}
