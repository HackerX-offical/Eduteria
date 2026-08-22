package org.jivesoftware.smackx.muclight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.muclight.element.MUCLightAffiliationsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightChangeAffiliationsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightConfigurationIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightCreateIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightDestroyIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightGetAffiliationsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightGetConfigsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightGetInfoIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightInfoIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightSetConfigsIQ;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MultiUserChatLight {
    public static final String AFFILIATIONS = "#affiliations";
    public static final String BLOCKING = "#blocking";
    public static final String CONFIGURATION = "#configuration";
    public static final String CREATE = "#create";
    public static final String DESTROY = "#destroy";
    public static final String INFO = "#info";
    public static final String NAMESPACE = "urn:xmpp:muclight:0";
    private final XMPPConnection connection;
    private final StanzaFilter fromRoomFilter;
    private final StanzaFilter fromRoomGroupChatFilter;
    private StanzaCollector messageCollector;
    private final StanzaListener messageListener;
    private final Set<MessageListener> messageListeners = new CopyOnWriteArraySet();
    private final EntityJid room;

    MultiUserChatLight(XMPPConnection xMPPConnection, EntityJid entityJid) {
        this.connection = xMPPConnection;
        this.room = entityJid;
        FromMatchesFilter fromMatchesFilterCreate = FromMatchesFilter.create(entityJid);
        this.fromRoomFilter = fromMatchesFilterCreate;
        AndFilter andFilter = new AndFilter(fromMatchesFilterCreate, MessageTypeFilter.GROUPCHAT);
        this.fromRoomGroupChatFilter = andFilter;
        StanzaListener stanzaListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muclight.MultiUserChatLight.1
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                Message message = (Message) stanza;
                Iterator it = MultiUserChatLight.this.messageListeners.iterator();
                while (it.hasNext()) {
                    ((MessageListener) it.next()).processMessage(message);
                }
            }
        };
        this.messageListener = stanzaListener;
        xMPPConnection.addSyncStanzaListener(stanzaListener, andFilter);
    }

    public EntityJid getRoom() {
        return this.room;
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException, InterruptedException {
        MessageBuilder messageBuilderBuildMessage = buildMessage();
        messageBuilderBuildMessage.setBody(str);
        this.connection.sendStanza(messageBuilderBuildMessage.build());
    }

    @Deprecated
    public Chat createPrivateChat(EntityJid entityJid, ChatMessageListener chatMessageListener) {
        return ChatManager.getInstanceFor(this.connection).createChat(entityJid, chatMessageListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Message createMessage() {
        return ((MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().ofType(Message.Type.groupchat).to((Jid) this.room)).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageBuilder buildMessage() {
        return (MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().ofType(Message.Type.groupchat).to((Jid) this.room);
    }

    @Deprecated
    public void sendMessage(Message message) throws SmackException.NotConnectedException, InterruptedException {
        sendMessage(message.asBuilder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sendMessage(MessageBuilder messageBuilder) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(((MessageBuilder) messageBuilder.to((Jid) this.room)).ofType(Message.Type.groupchat).build());
    }

    public Message pollMessage() {
        return (Message) this.messageCollector.pollResult();
    }

    public Message nextMessage() throws InterruptedException {
        return (Message) this.messageCollector.nextResult();
    }

    public Message nextMessage(long j) throws InterruptedException {
        return (Message) this.messageCollector.nextResult(j);
    }

    public boolean addMessageListener(MessageListener messageListener) {
        return this.messageListeners.add(messageListener);
    }

    public boolean removeMessageListener(MessageListener messageListener) {
        return this.messageListeners.remove(messageListener);
    }

    private void removeConnectionCallbacks() {
        this.connection.removeSyncStanzaListener(this.messageListener);
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector != null) {
            stanzaCollector.cancel();
            this.messageCollector = null;
        }
    }

    public String toString() {
        return "MUC Light: " + ((Object) this.room) + "(" + ((Object) this.connection.getUser()) + ")";
    }

    public void create(String str, String str2, HashMap<String, String> map, List<Jid> list) throws Exception {
        MUCLightCreateIQ mUCLightCreateIQ = new MUCLightCreateIQ(this.room, str, list);
        this.messageCollector = this.connection.createStanzaCollector(this.fromRoomGroupChatFilter);
        try {
            this.connection.createStanzaCollectorAndSend(mUCLightCreateIQ).nextResultOrThrow();
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
            removeConnectionCallbacks();
            throw e2;
        }
    }

    public void create(String str, List<Jid> list) throws Exception {
        create(str, null, null, list);
    }

    public void leave() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap map = new HashMap();
        map.put(this.connection.getUser(), MUCLightAffiliation.none);
        if (((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightChangeAffiliationsIQ(this.room, map)).nextResultOrThrow()).getType().equals(IQ.Type.result)) {
            removeConnectionCallbacks();
        }
    }

    public MUCLightRoomInfo getFullInfo(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightInfoIQ mUCLightInfoIQ = (MUCLightInfoIQ) ((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightGetInfoIQ(this.room, str)).nextResultOrThrow());
        return new MUCLightRoomInfo(mUCLightInfoIQ.getVersion(), this.room, mUCLightInfoIQ.getConfiguration(), mUCLightInfoIQ.getOccupants());
    }

    public MUCLightRoomInfo getFullInfo() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getFullInfo(null);
    }

    public MUCLightRoomConfiguration getConfiguration(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ((MUCLightConfigurationIQ) ((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightGetConfigsIQ(this.room, str)).nextResultOrThrow())).getConfiguration();
    }

    public MUCLightRoomConfiguration getConfiguration() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getConfiguration(null);
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ((MUCLightAffiliationsIQ) ((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightGetAffiliationsIQ(this.room, str)).nextResultOrThrow())).getAffiliations();
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliations(null);
    }

    public void changeAffiliations(HashMap<Jid, MUCLightAffiliation> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.connection.createStanzaCollectorAndSend(new MUCLightChangeAffiliationsIQ(this.room, map)).nextResultOrThrow();
    }

    public void destroy() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightDestroyIQ(this.room)).nextResultOrThrow()).getType().equals(IQ.Type.result)) {
            removeConnectionCallbacks();
        }
    }

    public void changeSubject(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.connection.createStanzaCollectorAndSend(new MUCLightSetConfigsIQ(this.room, null, str, null)).nextResultOrThrow();
    }

    public void changeRoomName(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.connection.createStanzaCollectorAndSend(new MUCLightSetConfigsIQ(this.room, str, null)).nextResultOrThrow();
    }

    public void setRoomConfigs(HashMap<String, String> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        setRoomConfigs(null, map);
    }

    public void setRoomConfigs(String str, HashMap<String, String> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.connection.createStanzaCollectorAndSend(new MUCLightSetConfigsIQ(this.room, str, map)).nextResultOrThrow();
    }
}
