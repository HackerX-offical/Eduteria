package org.jivesoftware.smackx.fallback_indication;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public final class FallbackIndicationManager extends Manager {
    private static final Map<XMPPConnection, FallbackIndicationManager> INSTANCES = new WeakHashMap();
    private final AsyncButOrdered<BareJid> asyncButOrdered;
    private final StanzaFilter fallbackIndicationElementFilter;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final Set<FallbackIndicationListener> f1495listeners;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.fallback_indication.FallbackIndicationManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                FallbackIndicationManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fallbackIndicationElementListener(Stanza stanza) {
        final Message message = (Message) stanza;
        final FallbackIndicationElement fallbackIndicationElementFromMessage = FallbackIndicationElement.fromMessage(message);
        final String body = message.getBody();
        this.asyncButOrdered.performAsyncButOrdered(message.getFrom().asBareJid(), new Runnable() { // from class: org.jivesoftware.smackx.fallback_indication.FallbackIndicationManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14243xcd2d1d23(message, fallbackIndicationElementFromMessage, body);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$fallbackIndicationElementListener$0$org-jivesoftware-smackx-fallback_indication-FallbackIndicationManager, reason: not valid java name */
    /* synthetic */ void m14243xcd2d1d23(Message message, FallbackIndicationElement fallbackIndicationElement, String str) {
        Iterator<FallbackIndicationListener> it = this.f1495listeners.iterator();
        while (it.hasNext()) {
            it.next().onFallbackIndicationReceived(message, fallbackIndicationElement, str);
        }
    }

    private FallbackIndicationManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.f1495listeners = new CopyOnWriteArraySet();
        this.asyncButOrdered = new AsyncButOrdered<>();
        AndFilter andFilter = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(FallbackIndicationElement.ELEMENT, FallbackIndicationElement.NAMESPACE));
        this.fallbackIndicationElementFilter = andFilter;
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() { // from class: org.jivesoftware.smackx.fallback_indication.FallbackIndicationManager$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.StanzaListener
            public final void processStanza(Stanza stanza) {
                this.f$0.fallbackIndicationElementListener(stanza);
            }
        }, andFilter);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(FallbackIndicationElement.NAMESPACE);
    }

    public static synchronized FallbackIndicationManager getInstanceFor(XMPPConnection xMPPConnection) {
        FallbackIndicationManager fallbackIndicationManager;
        Map<XMPPConnection, FallbackIndicationManager> map = INSTANCES;
        fallbackIndicationManager = map.get(xMPPConnection);
        if (fallbackIndicationManager == null) {
            fallbackIndicationManager = new FallbackIndicationManager(xMPPConnection);
            map.put(xMPPConnection, fallbackIndicationManager);
        }
        return fallbackIndicationManager;
    }

    public boolean userSupportsFallbackIndications(EntityBareJid entityBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(entityBareJid, FallbackIndicationElement.NAMESPACE);
    }

    public boolean serverSupportsFallbackIndications() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature(FallbackIndicationElement.NAMESPACE);
    }

    public static MessageBuilder addFallbackIndicationWithBody(MessageBuilder messageBuilder, String str) {
        return addFallbackIndication(messageBuilder).setBody(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MessageBuilder addFallbackIndication(MessageBuilder messageBuilder) {
        return (MessageBuilder) messageBuilder.addExtension(new FallbackIndicationElement());
    }

    public synchronized void addFallbackIndicationListener(FallbackIndicationListener fallbackIndicationListener) {
        this.f1495listeners.add(fallbackIndicationListener);
    }

    public synchronized void removeFallbackIndicationListener(FallbackIndicationListener fallbackIndicationListener) {
        this.f1495listeners.remove(fallbackIndicationListener);
    }
}
