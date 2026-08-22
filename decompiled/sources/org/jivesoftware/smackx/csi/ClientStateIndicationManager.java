package org.jivesoftware.smackx.csi;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;

/* JADX INFO: loaded from: classes10.dex */
public class ClientStateIndicationManager {
    public static void active(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, InterruptedException {
        throwIaeIfNotSupported(xMPPConnection);
        xMPPConnection.sendNonza(ClientStateIndication.Active.INSTANCE);
    }

    public static void inactive(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, InterruptedException {
        throwIaeIfNotSupported(xMPPConnection);
        xMPPConnection.sendNonza(ClientStateIndication.Inactive.INSTANCE);
    }

    public static boolean isSupported(XMPPConnection xMPPConnection) {
        return xMPPConnection.hasFeature(ClientStateIndication.Feature.ELEMENT, ClientStateIndication.NAMESPACE);
    }

    private static void throwIaeIfNotSupported(XMPPConnection xMPPConnection) {
        if (!isSupported(xMPPConnection)) {
            throw new IllegalArgumentException("Client State Indication not supported by server");
        }
    }
}
