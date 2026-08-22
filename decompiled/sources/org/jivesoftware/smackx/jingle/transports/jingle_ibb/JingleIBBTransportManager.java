package org.jivesoftware.smackx.jingle.transports.jingle_ibb;

import java.util.WeakHashMap;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.jingle.JingleSession;
import org.jivesoftware.smackx.jingle.provider.JingleContentProviderManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportManager;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.provider.JingleIBBTransportProvider;

/* JADX INFO: loaded from: classes10.dex */
public final class JingleIBBTransportManager extends JingleTransportManager<JingleIBBTransport> {
    private static final WeakHashMap<XMPPConnection, JingleIBBTransportManager> INSTANCES = new WeakHashMap<>();

    @Override // org.jivesoftware.smack.ConnectionListener
    public void authenticated(XMPPConnection xMPPConnection, boolean z) {
    }

    private JingleIBBTransportManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        JingleContentProviderManager.addJingleContentTransportProvider(getNamespace(), new JingleIBBTransportProvider());
    }

    public static synchronized JingleIBBTransportManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleIBBTransportManager jingleIBBTransportManager;
        WeakHashMap<XMPPConnection, JingleIBBTransportManager> weakHashMap = INSTANCES;
        jingleIBBTransportManager = weakHashMap.get(xMPPConnection);
        if (jingleIBBTransportManager == null) {
            jingleIBBTransportManager = new JingleIBBTransportManager(xMPPConnection);
            weakHashMap.put(xMPPConnection, jingleIBBTransportManager);
        }
        return jingleIBBTransportManager;
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportManager
    public String getNamespace() {
        return JingleIBBTransport.NAMESPACE_V1;
    }

    @Override // org.jivesoftware.smackx.jingle.transports.JingleTransportManager
    public JingleTransportSession<JingleIBBTransport> transportSession(JingleSession jingleSession) {
        return new JingleIBBTransportSession(jingleSession);
    }
}
