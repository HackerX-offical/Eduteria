package org.jivesoftware.smackx.jingle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.transports.JingleTransportManager;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;

/* JADX INFO: loaded from: classes10.dex */
public final class JingleTransportMethodManager extends Manager {
    private static final WeakHashMap<XMPPConnection, JingleTransportMethodManager> INSTANCES = new WeakHashMap<>();
    private static final String[] transportPreference = {"urn:xmpp:jingle:transports:s5b:1", JingleIBBTransport.NAMESPACE_V1};
    private final HashMap<String, JingleTransportManager<?>> transportManagers;

    private JingleTransportMethodManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.transportManagers = new HashMap<>();
    }

    public static synchronized JingleTransportMethodManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleTransportMethodManager jingleTransportMethodManager;
        WeakHashMap<XMPPConnection, JingleTransportMethodManager> weakHashMap = INSTANCES;
        jingleTransportMethodManager = weakHashMap.get(xMPPConnection);
        if (jingleTransportMethodManager == null) {
            jingleTransportMethodManager = new JingleTransportMethodManager(xMPPConnection);
            weakHashMap.put(xMPPConnection, jingleTransportMethodManager);
        }
        return jingleTransportMethodManager;
    }

    public void registerTransportManager(JingleTransportManager<?> jingleTransportManager) {
        this.transportManagers.put(jingleTransportManager.getNamespace(), jingleTransportManager);
    }

    public static JingleTransportManager<?> getTransportManager(XMPPConnection xMPPConnection, String str) {
        return getInstanceFor(xMPPConnection).getTransportManager(str);
    }

    public JingleTransportManager<?> getTransportManager(String str) {
        return this.transportManagers.get(str);
    }

    public static JingleTransportManager<?> getTransportManager(XMPPConnection xMPPConnection, Jingle jingle) {
        return getInstanceFor(xMPPConnection).getTransportManager(jingle);
    }

    public JingleTransportManager<?> getTransportManager(Jingle jingle) {
        JingleContentTransport transport;
        JingleContent jingleContent = jingle.getContents().get(0);
        if (jingleContent == null || (transport = jingleContent.getTransport()) == null) {
            return null;
        }
        return getTransportManager(transport.getNamespace());
    }

    public static JingleTransportManager<?> getBestAvailableTransportManager(XMPPConnection xMPPConnection) {
        return getInstanceFor(xMPPConnection).getBestAvailableTransportManager();
    }

    public JingleTransportManager<?> getBestAvailableTransportManager() {
        for (String str : transportPreference) {
            JingleTransportManager<?> transportManager = getTransportManager(str);
            if (transportManager != null) {
                return transportManager;
            }
        }
        Iterator<String> it = this.transportManagers.keySet().iterator();
        if (it.hasNext()) {
            return getTransportManager(it.next());
        }
        return null;
    }

    public JingleTransportManager<?> getBestAvailableTransportManager(Set<String> set) {
        for (String str : transportPreference) {
            JingleTransportManager<?> transportManager = getTransportManager(str);
            if (transportManager != null && !set.contains(transportManager.getNamespace())) {
                return transportManager;
            }
        }
        for (String str2 : this.transportManagers.keySet()) {
            if (!set.contains(str2)) {
                return getTransportManager(str2);
            }
        }
        return null;
    }
}
