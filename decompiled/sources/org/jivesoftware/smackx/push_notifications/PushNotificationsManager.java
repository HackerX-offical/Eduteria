package org.jivesoftware.smackx.push_notifications;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.push_notifications.element.DisablePushNotificationsIQ;
import org.jivesoftware.smackx.push_notifications.element.EnablePushNotificationsIQ;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class PushNotificationsManager extends Manager {
    private static final Map<XMPPConnection, PushNotificationsManager> INSTANCES;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.push_notifications.PushNotificationsManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                PushNotificationsManager.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
    }

    public static synchronized PushNotificationsManager getInstanceFor(XMPPConnection xMPPConnection) {
        PushNotificationsManager pushNotificationsManager;
        Map<XMPPConnection, PushNotificationsManager> map = INSTANCES;
        pushNotificationsManager = map.get(xMPPConnection);
        if (pushNotificationsManager == null) {
            pushNotificationsManager = new PushNotificationsManager(xMPPConnection);
            map.put(xMPPConnection, pushNotificationsManager);
        }
        return pushNotificationsManager;
    }

    private PushNotificationsManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    public boolean isSupported() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).accountSupportsFeatures("urn:xmpp:push:0");
    }

    public boolean enable(Jid jid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return enable(jid, str, null);
    }

    public boolean enable(Jid jid, String str, HashMap<String, String> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return changePushNotificationsStatus(new EnablePushNotificationsIQ(jid, str, map));
    }

    public boolean disableAll(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return disable(jid, null);
    }

    public boolean disable(Jid jid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return changePushNotificationsStatus(new DisablePushNotificationsIQ(jid, str));
    }

    private boolean changePushNotificationsStatus(IQ iq) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ((IQ) connection().createStanzaCollectorAndSend(iq).nextResultOrThrow()).getType() != IQ.Type.error;
    }
}
