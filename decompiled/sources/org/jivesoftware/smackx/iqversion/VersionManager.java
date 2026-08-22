package org.jivesoftware.smackx.iqversion;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.Smack;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.iqversion.packet.Version;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class VersionManager extends Manager {
    private static final Map<XMPPConnection, VersionManager> INSTANCES = new WeakHashMap();
    private static boolean autoAppendSmackVersion = true;
    private static Version defaultVersion;
    private Version ourVersion;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.iqversion.VersionManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                VersionManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    public static void setDefaultVersion(String str, String str2) {
        setDefaultVersion(str, str2, null);
    }

    public static void setDefaultVersion(String str, String str2, String str3) {
        defaultVersion = generateVersionFrom(str, str2, str3);
    }

    private VersionManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.ourVersion = defaultVersion;
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(Version.NAMESPACE);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", Version.NAMESPACE, IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.iqversion.VersionManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                if (VersionManager.this.ourVersion != null) {
                    return Version.createResultFor(iq, VersionManager.this.ourVersion);
                }
                return IQ.createErrorResponse(iq, StanzaError.Condition.not_acceptable);
            }
        });
    }

    public static synchronized VersionManager getInstanceFor(XMPPConnection xMPPConnection) {
        VersionManager versionManager;
        Map<XMPPConnection, VersionManager> map = INSTANCES;
        versionManager = map.get(xMPPConnection);
        if (versionManager == null) {
            versionManager = new VersionManager(xMPPConnection);
            map.put(xMPPConnection, versionManager);
        }
        return versionManager;
    }

    public static void setAutoAppendSmackVersion(boolean z) {
        autoAppendSmackVersion = z;
    }

    public void setVersion(String str, String str2) {
        setVersion(str, str2, null);
    }

    public void setVersion(String str, String str2, String str3) {
        this.ourVersion = generateVersionFrom(str, str2, str3);
    }

    public void unsetVersion() {
        this.ourVersion = null;
    }

    public boolean isSupported(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, Version.NAMESPACE);
    }

    public Version getVersion(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (isSupported(jid)) {
            return (Version) connection().createStanzaCollectorAndSend(new Version(jid)).nextResultOrThrow();
        }
        return null;
    }

    private static Version generateVersionFrom(String str, String str2, String str3) {
        if (autoAppendSmackVersion) {
            str = str + " (Smack " + Smack.getVersion() + ')';
        }
        return new Version(str, str2, str3);
    }
}
