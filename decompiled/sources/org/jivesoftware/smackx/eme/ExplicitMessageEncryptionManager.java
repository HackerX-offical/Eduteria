package org.jivesoftware.smackx.eme;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplicitMessageEncryptionManager {
    private static final Map<XMPPConnection, ExplicitMessageEncryptionManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE_V0 = "urn:xmpp:eme:0";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.eme.ExplicitMessageEncryptionManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ExplicitMessageEncryptionManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    public static synchronized ExplicitMessageEncryptionManager getInstanceFor(XMPPConnection xMPPConnection) {
        ExplicitMessageEncryptionManager explicitMessageEncryptionManager;
        Map<XMPPConnection, ExplicitMessageEncryptionManager> map = INSTANCES;
        explicitMessageEncryptionManager = map.get(xMPPConnection);
        if (explicitMessageEncryptionManager == null) {
            explicitMessageEncryptionManager = new ExplicitMessageEncryptionManager(xMPPConnection);
            map.put(xMPPConnection, explicitMessageEncryptionManager);
        }
        return explicitMessageEncryptionManager;
    }

    private ExplicitMessageEncryptionManager(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:eme:0");
    }
}
