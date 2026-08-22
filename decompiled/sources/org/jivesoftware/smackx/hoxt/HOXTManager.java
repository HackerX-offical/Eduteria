package org.jivesoftware.smackx.hoxt;

import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class HOXTManager {
    public static final String NAMESPACE = "urn:xmpp:http";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.hoxt.HOXTManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:http");
            }
        });
    }

    public static boolean isSupported(Jid jid, XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).supportsFeature(jid, "urn:xmpp:http");
    }
}
