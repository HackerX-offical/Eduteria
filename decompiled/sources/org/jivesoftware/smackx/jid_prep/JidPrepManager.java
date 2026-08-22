package org.jivesoftware.smackx.jid_prep;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.jid_prep.element.JidPrepIq;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class JidPrepManager extends Manager {
    private static final Map<XMPPConnection, JidPrepManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "urn:xmpp:jidprep:0";
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    public static synchronized JidPrepManager getInstanceFor(XMPPConnection xMPPConnection) {
        JidPrepManager jidPrepManager;
        Map<XMPPConnection, JidPrepManager> map = INSTANCES;
        jidPrepManager = map.get(xMPPConnection);
        if (jidPrepManager == null) {
            jidPrepManager = new JidPrepManager(xMPPConnection);
            map.put(xMPPConnection, jidPrepManager);
        }
        return jidPrepManager;
    }

    public JidPrepManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public String requestJidPrep(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return requestJidPrep(this.serviceDiscoveryManager.findService("urn:xmpp:jidprep:0", true), str);
    }

    public String requestJidPrep(Jid jid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        JidPrepIq jidPrepIq = new JidPrepIq(str);
        jidPrepIq.setTo(jid);
        try {
            return ((JidPrepIq) connection().sendIqRequestAndWaitForResponse(jidPrepIq)).getJid();
        } catch (XMPPException.XMPPErrorException e2) {
            if (e2.getStanzaError().getCondition() == StanzaError.Condition.jid_malformed) {
                return null;
            }
            throw e2;
        }
    }

    public boolean isSupported(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.serviceDiscoveryManager.supportsFeature(jid, "urn:xmpp:jidprep:0");
    }
}
