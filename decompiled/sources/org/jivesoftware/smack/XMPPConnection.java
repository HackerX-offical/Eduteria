package org.jivesoftware.smack;

import java.util.concurrent.TimeUnit;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaFactory;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.Predicate;
import org.jivesoftware.smack.util.XmppElementUtil;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityFullJid;

/* JADX INFO: loaded from: classes10.dex */
public interface XMPPConnection {

    public enum FromMode {
        UNCHANGED,
        OMITTED,
        USER
    }

    void addAsyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter);

    void addConnectionListener(ConnectionListener connectionListener);

    void addMessageInterceptor(Consumer<MessageBuilder> consumer, Predicate<Message> predicate);

    void addOneTimeSyncCallback(StanzaListener stanzaListener, StanzaFilter stanzaFilter);

    void addPresenceInterceptor(Consumer<PresenceBuilder> consumer, Predicate<Presence> predicate);

    @Deprecated
    void addStanzaInterceptor(StanzaListener stanzaListener, StanzaFilter stanzaFilter);

    void addStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter);

    void addStanzaSendingListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter);

    void addSyncStanzaListener(StanzaListener stanzaListener, StanzaFilter stanzaFilter);

    StanzaCollector createStanzaCollector(StanzaCollector.Configuration configuration);

    StanzaCollector createStanzaCollector(StanzaFilter stanzaFilter);

    StanzaCollector createStanzaCollectorAndSend(StanzaFilter stanzaFilter, Stanza stanza) throws SmackException.NotConnectedException, InterruptedException;

    StanzaCollector createStanzaCollectorAndSend(IQ iq) throws SmackException.NotConnectedException, InterruptedException;

    int getConnectionCounter();

    <F extends FullyQualifiedElement> F getFeature(QName qName);

    FromMode getFromMode();

    String getHost();

    long getLastStanzaReceived();

    int getPort();

    long getReplyTimeout();

    StanzaFactory getStanzaFactory();

    String getStreamId();

    EntityFullJid getUser();

    DomainBareJid getXMPPServiceDomain();

    boolean hasFeature(QName qName);

    boolean isAnonymous();

    boolean isAuthenticated();

    boolean isConnected();

    boolean isSecureConnection();

    boolean isUsingCompression();

    IQRequestHandler registerIQRequestHandler(IQRequestHandler iQRequestHandler);

    boolean removeAsyncStanzaListener(StanzaListener stanzaListener);

    void removeConnectionListener(ConnectionListener connectionListener);

    void removeMessageInterceptor(Consumer<MessageBuilder> consumer);

    void removePresenceInterceptor(Consumer<PresenceBuilder> consumer);

    void removeStanzaCollector(StanzaCollector stanzaCollector);

    @Deprecated
    void removeStanzaInterceptor(StanzaListener stanzaListener);

    boolean removeStanzaListener(StanzaListener stanzaListener);

    void removeStanzaSendingListener(StanzaListener stanzaListener);

    boolean removeSyncStanzaListener(StanzaListener stanzaListener);

    <S extends Stanza> SmackFuture<S, Exception> sendAsync(S s, StanzaFilter stanzaFilter);

    <S extends Stanza> SmackFuture<S, Exception> sendAsync(S s, StanzaFilter stanzaFilter, long j);

    <I extends IQ> I sendIqRequestAndWaitForResponse(IQ iq) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException;

    SmackFuture<IQ, Exception> sendIqRequestAsync(IQ iq);

    SmackFuture<IQ, Exception> sendIqRequestAsync(IQ iq, long j);

    void sendNonza(Nonza nonza) throws SmackException.NotConnectedException, InterruptedException;

    void sendStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException;

    void setFromMode(FromMode fromMode);

    void setReplyTimeout(long j);

    boolean trySendStanza(Stanza stanza) throws SmackException.NotConnectedException;

    boolean trySendStanza(Stanza stanza, long j, TimeUnit timeUnit) throws SmackException.NotConnectedException, InterruptedException;

    IQRequestHandler unregisterIQRequestHandler(String str, String str2, IQ.Type type);

    IQRequestHandler unregisterIQRequestHandler(IQRequestHandler iQRequestHandler);

    @Deprecated
    default <F extends FullyQualifiedElement> F getFeature(String str, String str2) {
        return (F) getFeature(new QName(str2, str));
    }

    default <F extends FullyQualifiedElement> F getFeature(Class<F> cls) {
        return (F) getFeature(XmppElementUtil.getQNameFor(cls));
    }

    default boolean hasFeature(String str, String str2) {
        return hasFeature(new QName(str2, str));
    }
}
