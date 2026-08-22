package org.jivesoftware.smackx.reference;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

/* JADX INFO: loaded from: classes10.dex */
public final class ReferenceManager extends Manager {
    private static final Map<XMPPConnection, ReferenceManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "urn:xmpp:reference:0";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.reference.ReferenceManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ReferenceManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private ReferenceManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(NAMESPACE);
    }

    public static synchronized ReferenceManager getInstanceFor(XMPPConnection xMPPConnection) {
        ReferenceManager referenceManager;
        Map<XMPPConnection, ReferenceManager> map = INSTANCES;
        referenceManager = map.get(xMPPConnection);
        if (referenceManager == null) {
            referenceManager = new ReferenceManager(xMPPConnection);
            map.put(xMPPConnection, referenceManager);
        }
        return referenceManager;
    }
}
