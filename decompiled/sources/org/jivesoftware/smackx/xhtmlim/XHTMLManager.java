package org.jivesoftware.smackx.xhtmlim;

import java.util.List;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class XHTMLManager {
    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.xhtmlim.XHTMLManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                XHTMLManager.setServiceEnabled(xMPPConnection, true);
            }
        });
    }

    public static List<CharSequence> getBodies(MessageView messageView) {
        XHTMLExtension xHTMLExtensionFrom = XHTMLExtension.from(messageView);
        if (xHTMLExtensionFrom != null) {
            return xHTMLExtensionFrom.getBodies();
        }
        return null;
    }

    public static void addBody(MessageBuilder messageBuilder, XHTMLText xHTMLText) {
        XHTMLExtension xHTMLExtensionFrom = XHTMLExtension.from(messageBuilder);
        if (xHTMLExtensionFrom == null) {
            xHTMLExtensionFrom = new XHTMLExtension();
            messageBuilder.addExtension(xHTMLExtensionFrom);
        }
        xHTMLExtensionFrom.addBody(xHTMLText.toXML());
    }

    @Deprecated
    public static void addBody(Message message, XHTMLText xHTMLText) {
        XHTMLExtension xHTMLExtensionFrom = XHTMLExtension.from(message);
        if (xHTMLExtensionFrom == null) {
            xHTMLExtensionFrom = new XHTMLExtension();
            message.addExtension(xHTMLExtensionFrom);
        }
        xHTMLExtensionFrom.addBody(xHTMLText.toXML());
    }

    public static boolean isXHTMLMessage(Message message) {
        return message.getExtensionElement("html", XHTMLExtension.NAMESPACE) != null;
    }

    public static synchronized void setServiceEnabled(XMPPConnection xMPPConnection, boolean z) {
        if (isServiceEnabled(xMPPConnection) == z) {
            return;
        }
        if (z) {
            ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(XHTMLExtension.NAMESPACE);
        } else {
            ServiceDiscoveryManager.getInstanceFor(xMPPConnection).removeFeature(XHTMLExtension.NAMESPACE);
        }
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection) {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).includesFeature(XHTMLExtension.NAMESPACE);
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection, Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).supportsFeature(jid, XHTMLExtension.NAMESPACE);
    }
}
