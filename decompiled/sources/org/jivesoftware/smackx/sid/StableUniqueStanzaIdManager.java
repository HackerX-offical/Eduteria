package org.jivesoftware.smackx.sid;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ToTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.muc.MucMessageInterceptor;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.jivesoftware.smackx.sid.StableUniqueStanzaIdManager;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

/* JADX INFO: loaded from: classes10.dex */
public final class StableUniqueStanzaIdManager extends Manager {
    private static final StanzaFilter ADD_ORIGIN_ID_FILTER;
    public static final String NAMESPACE = "urn:xmpp:sid:0";
    private static final StanzaFilter ORIGIN_ID_FILTER;
    private static final StanzaFilter OUTGOING_FILTER;
    private static final Map<XMPPConnection, StableUniqueStanzaIdManager> INSTANCES = new WeakHashMap();
    private static boolean enabledByDefault = false;

    static {
        AndFilter andFilter = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT_OR_HEADLINE, ToTypeFilter.ENTITY_FULL_OR_BARE_JID);
        OUTGOING_FILTER = andFilter;
        StanzaExtensionFilter stanzaExtensionFilter = new StanzaExtensionFilter(OriginIdElement.ELEMENT, "urn:xmpp:sid:0");
        ORIGIN_ID_FILTER = stanzaExtensionFilter;
        ADD_ORIGIN_ID_FILTER = new AndFilter(andFilter, new NotFilter(stanzaExtensionFilter));
        XMPPConnectionRegistry.addConnectionCreationListener(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.sid.StableUniqueStanzaIdManager$1, reason: invalid class name */
    class AnonymousClass1 implements ConnectionCreationListener {
        AnonymousClass1() {
        }

        @Override // org.jivesoftware.smack.ConnectionCreationListener
        public void connectionCreated(XMPPConnection xMPPConnection) {
            if (StableUniqueStanzaIdManager.enabledByDefault) {
                StableUniqueStanzaIdManager.getInstanceFor(xMPPConnection).enable();
            }
            MultiUserChatManager.addDefaultMessageInterceptor(new MucMessageInterceptor() { // from class: org.jivesoftware.smackx.sid.StableUniqueStanzaIdManager$1$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smackx.muc.MucMessageInterceptor
                public final void intercept(MessageBuilder messageBuilder, MultiUserChat multiUserChat) {
                    StableUniqueStanzaIdManager.AnonymousClass1.lambda$connectionCreated$0(messageBuilder, multiUserChat);
                }
            });
        }

        static /* synthetic */ void lambda$connectionCreated$0(MessageBuilder messageBuilder, MultiUserChat multiUserChat) {
            if (multiUserChat.serviceSupportsStableIds()) {
                return;
            }
            OriginIdElement.addTo(messageBuilder);
        }
    }

    private StableUniqueStanzaIdManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    public static void setEnabledByDefault(boolean z) {
        enabledByDefault = z;
    }

    public static synchronized StableUniqueStanzaIdManager getInstanceFor(XMPPConnection xMPPConnection) {
        StableUniqueStanzaIdManager stableUniqueStanzaIdManager;
        Map<XMPPConnection, StableUniqueStanzaIdManager> map = INSTANCES;
        stableUniqueStanzaIdManager = map.get(xMPPConnection);
        if (stableUniqueStanzaIdManager == null) {
            stableUniqueStanzaIdManager = new StableUniqueStanzaIdManager(xMPPConnection);
            map.put(xMPPConnection, stableUniqueStanzaIdManager);
        }
        return stableUniqueStanzaIdManager;
    }

    public synchronized void enable() {
        XMPPConnection xMPPConnectionConnection = connection();
        StableUniqueStanzaIdManager$$ExternalSyntheticLambda0 stableUniqueStanzaIdManager$$ExternalSyntheticLambda0 = new StableUniqueStanzaIdManager$$ExternalSyntheticLambda0();
        final StanzaFilter stanzaFilter = ADD_ORIGIN_ID_FILTER;
        Objects.requireNonNull(stanzaFilter);
        xMPPConnectionConnection.addMessageInterceptor(stableUniqueStanzaIdManager$$ExternalSyntheticLambda0, new Predicate() { // from class: org.jivesoftware.smackx.sid.StableUniqueStanzaIdManager$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.Predicate
            public final boolean test(Object obj) {
                return stanzaFilter.accept((Message) obj);
            }
        });
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature("urn:xmpp:sid:0");
    }

    public synchronized void disable() {
        ServiceDiscoveryManager.getInstanceFor(connection()).removeFeature("urn:xmpp:sid:0");
        connection().removeMessageInterceptor(new StableUniqueStanzaIdManager$$ExternalSyntheticLambda0());
    }

    public synchronized boolean isEnabled() {
        return ServiceDiscoveryManager.getInstanceFor(connection()).includesFeature("urn:xmpp:sid:0");
    }
}
