package org.jivesoftware.smackx.vcardtemp;

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
import org.jivesoftware.smackx.vcardtemp.packet.VCard;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class VCardManager extends Manager {
    public static final String ELEMENT = "vCard";
    private static final Map<XMPPConnection, VCardManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "vcard-temp";

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.vcardtemp.VCardManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                VCardManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    public static synchronized VCardManager getInstanceFor(XMPPConnection xMPPConnection) {
        VCardManager vCardManager;
        Map<XMPPConnection, VCardManager> map = INSTANCES;
        vCardManager = map.get(xMPPConnection);
        if (vCardManager == null) {
            vCardManager = new VCardManager(xMPPConnection);
            map.put(xMPPConnection, vCardManager);
        }
        return vCardManager;
    }

    @Deprecated
    public static boolean isSupported(Jid jid, XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getInstanceFor(xMPPConnection).isSupported(jid);
    }

    private VCardManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("vcard-temp");
    }

    public void saveVCard(VCard vCard) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        vCard.setTo(null);
        vCard.setType(IQ.Type.set);
        vCard.setStanzaId();
        connection().createStanzaCollectorAndSend(vCard).nextResultOrThrow();
    }

    public VCard loadVCard() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return loadVCard(null);
    }

    public VCard loadVCard(EntityBareJid entityBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        VCard vCard = new VCard();
        vCard.setTo(entityBareJid);
        return (VCard) connection().createStanzaCollectorAndSend(vCard).nextResultOrThrow();
    }

    public boolean isSupported(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, "vcard-temp");
    }
}
