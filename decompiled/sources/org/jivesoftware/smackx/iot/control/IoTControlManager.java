package org.jivesoftware.smackx.iot.control;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.Thing;
import org.jivesoftware.smackx.iot.control.element.IoTSetRequest;
import org.jivesoftware.smackx.iot.control.element.IoTSetResponse;
import org.jivesoftware.smackx.iot.control.element.SetData;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jxmpp.jid.FullJid;

/* JADX INFO: loaded from: classes10.dex */
public final class IoTControlManager extends IoTManager {
    private static final Map<XMPPConnection, IoTControlManager> INSTANCES = new WeakHashMap();
    private final Map<NodeInfo, Thing> things;

    public static synchronized IoTControlManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTControlManager ioTControlManager;
        Map<XMPPConnection, IoTControlManager> map = INSTANCES;
        ioTControlManager = map.get(xMPPConnection);
        if (ioTControlManager == null) {
            ioTControlManager = new IoTControlManager(xMPPConnection);
            map.put(xMPPConnection, ioTControlManager);
        }
        return ioTControlManager;
    }

    private IoTControlManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.things = new ConcurrentHashMap();
        xMPPConnection.registerIQRequestHandler(new IoTManager.IoTIqRequestHandler("set", "urn:xmpp:iot:control", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.iot.control.IoTControlManager.1
            @Override // org.jivesoftware.smackx.iot.IoTManager.IoTIqRequestHandler
            public IQ handleIoTIqRequest(IQ iq) {
                ThingControlRequest controlRequestHandler;
                IoTSetRequest ioTSetRequest = (IoTSetRequest) iq;
                Thing thing = (Thing) IoTControlManager.this.things.get(NodeInfo.EMPTY);
                if (thing == null || (controlRequestHandler = thing.getControlRequestHandler()) == null) {
                    return null;
                }
                try {
                    controlRequestHandler.processRequest(ioTSetRequest.getFrom(), ioTSetRequest.getSetData());
                    return new IoTSetResponse(ioTSetRequest);
                } catch (XMPPException.XMPPErrorException e2) {
                    return IQ.createErrorResponse(ioTSetRequest, e2.getStanzaError());
                }
            }
        });
    }

    public IoTSetResponse setUsingIq(FullJid fullJid, SetData setData) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return setUsingIq(fullJid, Collections.singleton(setData));
    }

    public IoTSetResponse setUsingIq(FullJid fullJid, Collection<? extends SetData> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        IoTSetRequest ioTSetRequest = new IoTSetRequest(collection);
        ioTSetRequest.setTo(fullJid);
        return (IoTSetResponse) connection().createStanzaCollectorAndSend(ioTSetRequest).nextResultOrThrow();
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
}
