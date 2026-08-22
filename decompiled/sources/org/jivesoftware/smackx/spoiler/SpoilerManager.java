package org.jivesoftware.smackx.spoiler;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

/* JADX INFO: loaded from: classes10.dex */
public final class SpoilerManager extends Manager {
    private static final Map<XMPPConnection, SpoilerManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE_0 = "urn:xmpp:spoiler:0";
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    private SpoilerManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public void startAnnounceSupport() {
        this.serviceDiscoveryManager.addFeature("urn:xmpp:spoiler:0");
    }

    public void stopAnnounceSupport() {
        this.serviceDiscoveryManager.removeFeature("urn:xmpp:spoiler:0");
    }

    public static synchronized SpoilerManager getInstanceFor(XMPPConnection xMPPConnection) {
        SpoilerManager spoilerManager;
        Map<XMPPConnection, SpoilerManager> map = INSTANCES;
        spoilerManager = map.get(xMPPConnection);
        if (spoilerManager == null) {
            spoilerManager = new SpoilerManager(xMPPConnection);
            map.put(xMPPConnection, spoilerManager);
        }
        return spoilerManager;
    }
}
