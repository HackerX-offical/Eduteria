package org.jivesoftware.smackx.dox;

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.RandomUtil;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.dox.element.DnsIq;
import org.jxmpp.jid.Jid;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsmessage.Question;

/* JADX INFO: loaded from: classes10.dex */
public final class DnsOverXmppManager extends Manager {
    private static final String NAMESPACE = "urn:xmpp:dox:0";
    private static DnsOverXmppResolver defaultResolver;
    private final AbstractIqRequestHandler dnsIqRequestHandler;
    private boolean enabled;
    private DnsOverXmppResolver resolver;
    private final ServiceDiscoveryManager serviceDiscoveryManager;
    private static final Logger LOGGER = Logger.getLogger(DnsOverXmppManager.class.getName());
    private static final Map<XMPPConnection, DnsOverXmppManager> INSTANCES = new WeakHashMap();

    public static synchronized DnsOverXmppManager getInstanceFor(XMPPConnection xMPPConnection) {
        DnsOverXmppManager dnsOverXmppManager;
        Map<XMPPConnection, DnsOverXmppManager> map = INSTANCES;
        dnsOverXmppManager = map.get(xMPPConnection);
        if (dnsOverXmppManager == null) {
            dnsOverXmppManager = new DnsOverXmppManager(xMPPConnection);
            map.put(xMPPConnection, dnsOverXmppManager);
        }
        return dnsOverXmppManager;
    }

    public static void setDefaultDnsOverXmppResolver(DnsOverXmppResolver dnsOverXmppResolver) {
        defaultResolver = dnsOverXmppResolver;
    }

    private DnsOverXmppManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.resolver = defaultResolver;
        this.dnsIqRequestHandler = new AbstractIqRequestHandler(DnsIq.ELEMENT, "urn:xmpp:dox:0", IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.dox.DnsOverXmppManager.1
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                DnsOverXmppResolver dnsOverXmppResolver = DnsOverXmppManager.this.resolver;
                if (dnsOverXmppResolver == null) {
                    DnsOverXmppManager.LOGGER.info("Resolver was null while attempting to handle " + iq);
                    return null;
                }
                DnsMessage dnsMessage = ((DnsIq) iq).getDnsMessage();
                try {
                    DnsMessage dnsMessageResolve = dnsOverXmppResolver.resolve(dnsMessage);
                    if (dnsMessage.id != dnsMessageResolve.id) {
                        dnsMessageResolve = dnsMessageResolve.asBuilder().setId(dnsMessage.id).build();
                    }
                    DnsIq dnsIq = new DnsIq(dnsMessageResolve);
                    dnsIq.setType(IQ.Type.result);
                    return dnsIq;
                } catch (IOException e2) {
                    return IQ.createErrorResponse(iq, StanzaError.getBuilder().setType(StanzaError.Type.CANCEL).setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText("Exception while resolving your DNS query", e2).build());
                }
            }
        };
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public synchronized void setDnsOverXmppResolver(DnsOverXmppResolver dnsOverXmppResolver) {
        this.resolver = dnsOverXmppResolver;
        if (dnsOverXmppResolver == null) {
            disable();
        }
    }

    public synchronized void enable() {
        if (this.enabled) {
            return;
        }
        if (this.resolver == null) {
            throw new IllegalStateException("No DnsOverXmppResolver configured");
        }
        XMPPConnection xMPPConnectionConnection = connection();
        if (xMPPConnectionConnection == null) {
            return;
        }
        xMPPConnectionConnection.registerIQRequestHandler(this.dnsIqRequestHandler);
        this.serviceDiscoveryManager.addFeature("urn:xmpp:dox:0");
    }

    public synchronized void disable() {
        if (this.enabled) {
            XMPPConnection xMPPConnectionConnection = connection();
            if (xMPPConnectionConnection == null) {
                return;
            }
            this.serviceDiscoveryManager.removeFeature("urn:xmpp:dox:0");
            xMPPConnectionConnection.unregisterIQRequestHandler(this.dnsIqRequestHandler);
        }
    }

    public boolean isSupported(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.serviceDiscoveryManager.supportsFeature(jid, "urn:xmpp:dox:0");
    }

    public DnsMessage query(Jid jid, Question question) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return query(jid, DnsMessage.builder().addQuestion(question).setId(RandomUtil.nextSecureRandomInt()).setRecursionDesired(true).build());
    }

    public DnsMessage query(Jid jid, DnsMessage dnsMessage) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ((DnsIq) connection().sendIqRequestAndWaitForResponse(new DnsIq(dnsMessage, jid))).getDnsMessage();
    }
}
