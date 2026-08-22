package org.jivesoftware.smackx.muc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PresenceListener;
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
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.MessageWithSubjectFilter;
import org.jivesoftware.smack.filter.MessageWithThreadFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.PossibleFromTypeFilter;
import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.filter.ToMatchesFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.PresenceBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iqregister.packet.Registration;
import org.jivesoftware.smackx.muc.MucEnterConfiguration;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.muc.filter.MUCUserStatusCodeFilter;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCAdmin;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.muc.packet.MUCOwner;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.form.Form;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public class MultiUserChat {
    private final XMPPConnection connection;
    private final StanzaListener declinesListener;
    private final StanzaFilter fromRoomFilter;
    private final StanzaFilter fromRoomGroupchatFilter;
    private StanzaCollector messageCollector;
    private final StanzaListener messageListener;
    private DiscoverInfo mucServiceDiscoInfo;
    private final MultiUserChatManager multiUserChatManager;
    private EntityFullJid myRoomJid;
    private final StanzaListener presenceInterceptor;
    private final StanzaListener presenceListener;
    private volatile boolean processedReflectedSelfPresence;
    private final EntityBareJid room;
    private String subject;
    private final StanzaListener subjectListener;
    private static final Logger LOGGER = Logger.getLogger(MultiUserChat.class.getName());
    private static final StanzaFilter DECLINE_FILTER = new AndFilter(MessageTypeFilter.NORMAL, new StanzaExtensionFilter("x", MUCUser.NAMESPACE));
    private final Map<EntityFullJid, Presence> occupantsMap = new ConcurrentHashMap();
    private final Set<InvitationRejectionListener> invitationRejectionListeners = new CopyOnWriteArraySet();
    private final Set<SubjectUpdatedListener> subjectUpdatedListeners = new CopyOnWriteArraySet();
    private final Set<UserStatusListener> userStatusListeners = new CopyOnWriteArraySet();
    private final Set<ParticipantStatusListener> participantStatusListeners = new CopyOnWriteArraySet();
    private final Set<MessageListener> messageListeners = new CopyOnWriteArraySet();
    private final Set<PresenceListener> presenceListeners = new CopyOnWriteArraySet();
    private final Set<PresenceListener> presenceInterceptors = new CopyOnWriteArraySet();
    private CopyOnWriteArrayList<MucMessageInterceptor> messageInterceptors = MultiUserChatManager.getMessageInterceptors();

    MultiUserChat(XMPPConnection xMPPConnection, EntityBareJid entityBareJid, final MultiUserChatManager multiUserChatManager) {
        this.connection = xMPPConnection;
        this.room = entityBareJid;
        this.multiUserChatManager = multiUserChatManager;
        FromMatchesFilter fromMatchesFilterCreate = FromMatchesFilter.create(entityBareJid);
        this.fromRoomFilter = fromMatchesFilterCreate;
        this.fromRoomGroupchatFilter = new AndFilter(fromMatchesFilterCreate, MessageTypeFilter.GROUPCHAT);
        this.messageListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.1
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                Message message = (Message) stanza;
                Iterator it = MultiUserChat.this.messageListeners.iterator();
                while (it.hasNext()) {
                    ((MessageListener) it.next()).processMessage(message);
                }
            }
        };
        this.subjectListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.2
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                Message message = (Message) stanza;
                EntityFullJid entityFullJidAsEntityFullJidIfPossible = message.getFrom().asEntityFullJidIfPossible();
                MultiUserChat.this.subject = message.getSubject();
                Iterator it = MultiUserChat.this.subjectUpdatedListeners.iterator();
                while (it.hasNext()) {
                    ((SubjectUpdatedListener) it.next()).subjectUpdated(message.getSubject(), entityFullJidAsEntityFullJidIfPossible);
                }
            }
        };
        this.presenceListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.3
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                Presence presence = (Presence) stanza;
                EntityFullJid entityFullJidAsEntityFullJidIfPossible = presence.getFrom().asEntityFullJidIfPossible();
                if (entityFullJidAsEntityFullJidIfPossible == null) {
                    return;
                }
                boolean zEquals = presence.getFrom().equals((CharSequence) MultiUserChat.this.myRoomJid);
                MUCUser mUCUserFrom = MUCUser.from(stanza);
                int i = AnonymousClass7.$SwitchMap$org$jivesoftware$smack$packet$Presence$Type[presence.getType().ordinal()];
                if (i == 1) {
                    Presence presence2 = (Presence) MultiUserChat.this.occupantsMap.put(entityFullJidAsEntityFullJidIfPossible, presence);
                    if (mUCUserFrom.getStatus().contains(MUCUser.Status.PRESENCE_TO_SELF_110)) {
                        MultiUserChat.this.processedReflectedSelfPresence = true;
                        synchronized (this) {
                            notify();
                        }
                    } else if (presence2 == null) {
                        Iterator it = MultiUserChat.this.participantStatusListeners.iterator();
                        while (it.hasNext()) {
                            ((ParticipantStatusListener) it.next()).joined(entityFullJidAsEntityFullJidIfPossible);
                        }
                    } else {
                        MUCUser mUCUserFrom2 = MUCUser.from(presence2);
                        MUCAffiliation affiliation = mUCUserFrom2.getItem().getAffiliation();
                        MUCRole role = mUCUserFrom2.getItem().getRole();
                        MUCAffiliation affiliation2 = mUCUserFrom.getItem().getAffiliation();
                        MultiUserChat.this.checkRoleModifications(role, mUCUserFrom.getItem().getRole(), zEquals, entityFullJidAsEntityFullJidIfPossible);
                        MultiUserChat.this.checkAffiliationModifications(affiliation, affiliation2, zEquals, entityFullJidAsEntityFullJidIfPossible);
                    }
                } else if (i == 2) {
                    MultiUserChat.this.occupantsMap.remove(entityFullJidAsEntityFullJidIfPossible);
                    if (mUCUserFrom != null && mUCUserFrom.hasStatus()) {
                        if (zEquals) {
                            MultiUserChat.this.userHasLeft();
                        }
                        MultiUserChat.this.checkPresenceCode(mUCUserFrom.getStatus(), zEquals, mUCUserFrom, entityFullJidAsEntityFullJidIfPossible);
                    } else if (!zEquals) {
                        Iterator it2 = MultiUserChat.this.participantStatusListeners.iterator();
                        while (it2.hasNext()) {
                            ((ParticipantStatusListener) it2.next()).left(entityFullJidAsEntityFullJidIfPossible);
                        }
                    }
                    Destroy destroy = mUCUserFrom.getDestroy();
                    if (destroy != null) {
                        EntityBareJid jid = destroy.getJid();
                        MultiUserChat multiUserChat = jid == null ? null : multiUserChatManager.getMultiUserChat(jid);
                        Iterator it3 = MultiUserChat.this.userStatusListeners.iterator();
                        while (it3.hasNext()) {
                            ((UserStatusListener) it3.next()).roomDestroyed(multiUserChat, destroy.getReason());
                        }
                    }
                    if (zEquals) {
                        Iterator it4 = MultiUserChat.this.userStatusListeners.iterator();
                        while (it4.hasNext()) {
                            ((UserStatusListener) it4.next()).removed(mUCUserFrom, presence);
                        }
                    } else {
                        Iterator it5 = MultiUserChat.this.participantStatusListeners.iterator();
                        while (it5.hasNext()) {
                            ((ParticipantStatusListener) it5.next()).parted(entityFullJidAsEntityFullJidIfPossible);
                        }
                    }
                }
                Iterator it6 = MultiUserChat.this.presenceListeners.iterator();
                while (it6.hasNext()) {
                    ((PresenceListener) it6.next()).processPresence(presence);
                }
            }
        };
        this.declinesListener = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.4
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                Message message = (Message) stanza;
                MUCUser.Decline decline = MUCUser.from(stanza).getDecline();
                if (decline == null) {
                    return;
                }
                MultiUserChat.this.fireInvitationRejectionListeners(message, decline);
            }
        };
        this.presenceInterceptor = new StanzaListener() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.5
            @Override // org.jivesoftware.smack.StanzaListener
            public void processStanza(Stanza stanza) {
                Presence presence = (Presence) stanza;
                Iterator it = MultiUserChat.this.presenceInterceptors.iterator();
                while (it.hasNext()) {
                    ((PresenceListener) it.next()).processPresence(presence);
                }
            }
        };
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.muc.MultiUserChat$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$Presence$Type;

        static {
            int[] iArr = new int[Presence.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$Presence$Type = iArr;
            try {
                iArr[Presence.Type.available.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$Presence$Type[Presence.Type.unavailable.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public EntityBareJid getRoom() {
        return this.room;
    }

    private Presence enter(MucEnterConfiguration mucEnterConfiguration) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, XMPPException.XMPPErrorException {
        DiscoverInfo mucServiceDiscoInfo = this.multiUserChatManager.getMucServiceDiscoInfo(this.room.asDomainBareJid());
        this.mucServiceDiscoInfo = mucServiceDiscoInfo;
        if (mucServiceDiscoInfo == null) {
            throw new MultiUserChatException.NotAMucServiceException(this);
        }
        Presence joinPresence = mucEnterConfiguration.getJoinPresence(this);
        this.connection.addStanzaListener(this.messageListener, this.fromRoomGroupchatFilter);
        AndFilter andFilter = new AndFilter(this.fromRoomFilter, StanzaTypeFilter.PRESENCE, PossibleFromTypeFilter.ENTITY_FULL_JID);
        this.connection.addStanzaListener(this.presenceListener, andFilter);
        this.connection.addStanzaListener(this.subjectListener, new AndFilter(this.fromRoomFilter, MessageWithSubjectFilter.INSTANCE, new NotFilter(MessageTypeFilter.ERROR), new NotFilter(MessageWithBodiesFilter.INSTANCE), new NotFilter(MessageWithThreadFilter.INSTANCE)));
        this.connection.addStanzaListener(this.declinesListener, new AndFilter(this.fromRoomFilter, DECLINE_FILTER));
        this.connection.addStanzaSendingListener(this.presenceInterceptor, new AndFilter(ToMatchesFilter.create(this.room), StanzaTypeFilter.PRESENCE));
        this.messageCollector = this.connection.createStanzaCollector(this.fromRoomGroupchatFilter);
        AndFilter andFilter2 = new AndFilter(StanzaTypeFilter.PRESENCE, new OrFilter(new AndFilter(FromMatchesFilter.createBare(getRoom()), MUCUserStatusCodeFilter.STATUS_110_PRESENCE_TO_SELF), new AndFilter(FromMatchesFilter.createFull(joinPresence.getTo()), new StanzaIdFilter(joinPresence), PresenceTypeFilter.ERROR)));
        this.processedReflectedSelfPresence = false;
        StanzaCollector stanzaCollector = null;
        try {
            try {
                StanzaCollector stanzaCollectorCreateStanzaCollectorAndSend = this.connection.createStanzaCollectorAndSend(andFilter2, joinPresence);
                StanzaCollector stanzaCollectorCreateStanzaCollector = this.connection.createStanzaCollector(StanzaCollector.newConfiguration().setCollectorToReset(stanzaCollectorCreateStanzaCollectorAndSend).setStanzaFilter(andFilter));
                Presence presence = (Presence) stanzaCollectorCreateStanzaCollectorAndSend.nextResultOrThrow(mucEnterConfiguration.getTimeout());
                if (stanzaCollectorCreateStanzaCollector != null) {
                    stanzaCollectorCreateStanzaCollector.cancel();
                }
                synchronized (this.presenceListener) {
                    while (!this.processedReflectedSelfPresence) {
                        this.presenceListener.wait();
                    }
                }
                setNickname(presence.getFrom().getResourceOrThrow());
                this.multiUserChatManager.addJoinedRoom(this.room);
                return presence;
            } catch (Throwable th) {
                if (0 != 0) {
                    stanzaCollector.cancel();
                }
                throw th;
            }
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
            removeConnectionCallbacks();
            throw e2;
        }
    }

    private void setNickname(Resourcepart resourcepart) {
        this.myRoomJid = JidCreate.entityFullFrom(this.room, resourcepart);
    }

    public MucEnterConfiguration.Builder getEnterConfigurationBuilder(Resourcepart resourcepart) {
        return new MucEnterConfiguration.Builder(resourcepart, this.connection);
    }

    public synchronized MucCreateConfigFormHandle create(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, MultiUserChatException.MissingMucCreationAcknowledgeException, MultiUserChatException.MucAlreadyJoinedException, XMPPException.XMPPErrorException {
        MucCreateConfigFormHandle mucCreateConfigFormHandleCreateOrJoin;
        if (isJoined()) {
            throw new MultiUserChatException.MucAlreadyJoinedException();
        }
        mucCreateConfigFormHandleCreateOrJoin = createOrJoin(resourcepart);
        if (mucCreateConfigFormHandleCreateOrJoin == null) {
            try {
                leave();
            } catch (MultiUserChatException.MucNotJoinedException e2) {
                LOGGER.log(Level.INFO, "Unexpected MucNotJoinedException", (Throwable) e2);
            }
            throw new MultiUserChatException.MissingMucCreationAcknowledgeException();
        }
        return mucCreateConfigFormHandleCreateOrJoin;
    }

    public synchronized MucCreateConfigFormHandle createOrJoin(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, MultiUserChatException.MucAlreadyJoinedException, XMPPException.XMPPErrorException {
        return createOrJoin(getEnterConfigurationBuilder(resourcepart).build());
    }

    public synchronized MucCreateConfigFormHandle createOrJoin(MucEnterConfiguration mucEnterConfiguration) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, MultiUserChatException.MucAlreadyJoinedException, XMPPException.XMPPErrorException {
        if (isJoined()) {
            throw new MultiUserChatException.MucAlreadyJoinedException();
        }
        MUCUser mUCUserFrom = MUCUser.from(enter(mucEnterConfiguration));
        if (mUCUserFrom == null || !mUCUserFrom.getStatus().contains(MUCUser.Status.ROOM_CREATED_201)) {
            return null;
        }
        return new MucCreateConfigFormHandle();
    }

    public class MucCreateConfigFormHandle {
        public MucCreateConfigFormHandle() {
        }

        public void makeInstant() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
            MultiUserChat.this.sendConfigurationForm(null);
        }

        public MucConfigFormManager getConfigFormManager() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
            return MultiUserChat.this.getConfigFormManager();
        }
    }

    public MucCreateConfigFormHandle createOrJoinIfNecessary(Resourcepart resourcepart, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, XMPPException.XMPPErrorException {
        if (isJoined()) {
            return null;
        }
        try {
            return createOrJoin(getEnterConfigurationBuilder(resourcepart).withPassword(str).build());
        } catch (MultiUserChatException.MucAlreadyJoinedException unused) {
            return null;
        }
    }

    public void join(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, XMPPException.XMPPErrorException {
        join(getEnterConfigurationBuilder(resourcepart).build());
    }

    public void join(Resourcepart resourcepart, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, XMPPException.XMPPErrorException {
        join(getEnterConfigurationBuilder(resourcepart).withPassword(str).build());
    }

    public synchronized void join(MucEnterConfiguration mucEnterConfiguration) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.NotAMucServiceException, XMPPException.XMPPErrorException {
        if (isJoined()) {
            try {
                leaveSync();
            } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException | MultiUserChatException.MucNotJoinedException e2) {
                LOGGER.log(Level.WARNING, "Could not leave MUC prior joining, assuming we are not joined", e2);
            }
        }
        enter(mucEnterConfiguration);
    }

    public boolean isJoined() {
        return this.myRoomJid != null;
    }

    @Deprecated
    public synchronized Presence leaveSync() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.MucNotJoinedException, XMPPException.XMPPErrorException {
        return leave();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Presence leave() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.MucNotJoinedException, XMPPException.XMPPErrorException {
        Presence presenceBuild;
        ArrayList arrayList;
        EntityFullJid entityFullJid = this.myRoomJid;
        if (entityFullJid == null) {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
        presenceBuild = ((PresenceBuilder) this.connection.getStanzaFactory().buildPresenceStanza().ofType(Presence.Type.unavailable).to((Jid) entityFullJid)).build();
        arrayList = new ArrayList(3);
        arrayList.add(StanzaTypeFilter.PRESENCE);
        arrayList.add(new OrFilter(new AndFilter(FromMatchesFilter.createFull(entityFullJid), PresenceTypeFilter.UNAVAILABLE, MUCUserStatusCodeFilter.STATUS_110_PRESENCE_TO_SELF), new AndFilter(this.fromRoomFilter, PresenceTypeFilter.ERROR)));
        if (serviceSupportsStableIds()) {
            arrayList.add(new StanzaIdFilter(presenceBuild));
        }
        try {
        } finally {
            userHasLeft();
        }
        return (Presence) this.connection.createStanzaCollectorAndSend(new AndFilter(arrayList), presenceBuild).nextResultOrThrow();
    }

    public MucConfigFormManager getConfigFormManager() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return new MucConfigFormManager(this);
    }

    public Form getConfigurationForm() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.get);
        return new Form(DataForm.from((IQ) this.connection.createStanzaCollectorAndSend(mUCOwner).nextResultOrThrow(), MucConfigFormManager.FORM_TYPE));
    }

    public void sendConfigurationForm(FillableForm fillableForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DataForm dataFormBuild;
        if (fillableForm != null) {
            dataFormBuild = fillableForm.getDataFormToSubmit();
        } else {
            dataFormBuild = DataForm.builder().build();
        }
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.set);
        mUCOwner.addExtension(dataFormBuild);
        this.connection.createStanzaCollectorAndSend(mUCOwner).nextResultOrThrow();
    }

    public Form getRegistrationForm() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        Registration registration = new Registration();
        registration.setType(IQ.Type.get);
        registration.setTo(this.room);
        return new Form(DataForm.from((IQ) this.connection.createStanzaCollectorAndSend(registration).nextResultOrThrow()));
    }

    public void sendRegistrationForm(FillableForm fillableForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        Registration registration = new Registration();
        registration.setType(IQ.Type.set);
        registration.setTo(this.room);
        registration.addExtension(fillableForm.getDataFormToSubmit());
        this.connection.createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    public void destroy(String str, EntityBareJid entityBareJid) throws Throwable {
        MUCOwner mUCOwner = new MUCOwner();
        mUCOwner.setTo(this.room);
        mUCOwner.setType(IQ.Type.set);
        mUCOwner.setDestroy(new Destroy(entityBareJid, str));
        try {
            this.connection.createStanzaCollectorAndSend(mUCOwner).nextResultOrThrow();
            userHasLeft();
        } catch (InterruptedException e2) {
            e = e2;
            userHasLeft();
            throw e;
        } catch (SmackException.NoResponseException e3) {
            e = e3;
            userHasLeft();
            throw e;
        } catch (SmackException.NotConnectedException e4) {
            e = e4;
            userHasLeft();
            throw e;
        } catch (XMPPException.XMPPErrorException e5) {
            throw e5;
        }
    }

    public void invite(EntityBareJid entityBareJid, String str) throws SmackException.NotConnectedException, InterruptedException {
        invite(this.connection.getStanzaFactory().buildMessageStanza(), entityBareJid, str);
    }

    @Deprecated
    public void invite(Message message, EntityBareJid entityBareJid, String str) throws SmackException.NotConnectedException, InterruptedException {
        message.setTo(this.room);
        MUCUser mUCUser = new MUCUser();
        mUCUser.setInvite(new MUCUser.Invite(str, entityBareJid));
        message.addExtension(mUCUser);
        this.connection.sendStanza(message);
    }

    public void invite(MessageBuilder messageBuilder, EntityBareJid entityBareJid, String str) throws SmackException.NotConnectedException, InterruptedException {
        messageBuilder.to(this.room);
        MUCUser mUCUser = new MUCUser();
        mUCUser.setInvite(new MUCUser.Invite(str, entityBareJid));
        messageBuilder.addExtension(mUCUser);
        this.connection.sendStanza(messageBuilder.build());
    }

    public boolean addInvitationRejectionListener(InvitationRejectionListener invitationRejectionListener) {
        return this.invitationRejectionListeners.add(invitationRejectionListener);
    }

    public boolean removeInvitationRejectionListener(InvitationRejectionListener invitationRejectionListener) {
        return this.invitationRejectionListeners.remove(invitationRejectionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireInvitationRejectionListeners(Message message, MUCUser.Decline decline) {
        int size;
        InvitationRejectionListener[] invitationRejectionListenerArr;
        EntityBareJid from = decline.getFrom();
        String reason = decline.getReason();
        synchronized (this.invitationRejectionListeners) {
            size = this.invitationRejectionListeners.size();
            invitationRejectionListenerArr = new InvitationRejectionListener[size];
            this.invitationRejectionListeners.toArray(invitationRejectionListenerArr);
        }
        for (int i = 0; i < size; i++) {
            invitationRejectionListenerArr[i].invitationDeclined(from, reason, message, decline);
        }
    }

    public boolean addSubjectUpdatedListener(SubjectUpdatedListener subjectUpdatedListener) {
        return this.subjectUpdatedListeners.add(subjectUpdatedListener);
    }

    public boolean removeSubjectUpdatedListener(SubjectUpdatedListener subjectUpdatedListener) {
        return this.subjectUpdatedListeners.remove(subjectUpdatedListener);
    }

    public void addPresenceInterceptor(PresenceListener presenceListener) {
        this.presenceInterceptors.add(presenceListener);
    }

    public void removePresenceInterceptor(PresenceListener presenceListener) {
        this.presenceInterceptors.remove(presenceListener);
    }

    public String getSubject() {
        return this.subject;
    }

    public String getReservedNickname() throws SmackException, InterruptedException {
        try {
            Iterator<DiscoverInfo.Identity> it = ServiceDiscoveryManager.getInstanceFor(this.connection).discoverInfo(this.room, "x-roomuser-item").getIdentities().iterator();
            if (it.hasNext()) {
                return it.next().getName();
            }
            return null;
        } catch (XMPPException e2) {
            LOGGER.log(Level.SEVERE, "Error retrieving room nickname", (Throwable) e2);
            return null;
        }
    }

    public Resourcepart getNickname() {
        EntityFullJid entityFullJid = this.myRoomJid;
        if (entityFullJid == null) {
            return null;
        }
        return entityFullJid.getResourcepart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void changeNickname(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, MultiUserChatException.MucNotJoinedException, XMPPException.XMPPErrorException {
        Objects.requireNonNull(resourcepart, "Nickname must not be null or blank.");
        if (!isJoined()) {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
        EntityFullJid entityFullJidEntityFullFrom = JidCreate.entityFullFrom(this.room, resourcepart);
        this.connection.createStanzaCollectorAndSend(new AndFilter(FromMatchesFilter.createFull(entityFullJidEntityFullFrom), new StanzaTypeFilter(Presence.class)), ((PresenceBuilder) this.connection.getStanzaFactory().buildPresenceStanza().to((Jid) entityFullJidEntityFullFrom)).ofType(Presence.Type.available).build()).nextResultOrThrow();
        setNickname(resourcepart);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void changeAvailabilityStatus(String str, Presence.Mode mode) throws SmackException.NotConnectedException, InterruptedException, MultiUserChatException.MucNotJoinedException {
        EntityFullJid entityFullJid = this.myRoomJid;
        if (entityFullJid == null) {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
        this.connection.sendStanza(((PresenceBuilder) this.connection.getStanzaFactory().buildPresenceStanza().to((Jid) entityFullJid)).ofType(Presence.Type.available).setStatus(str).setMode(mode).build());
    }

    public void kickParticipant(Resourcepart resourcepart, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(resourcepart, MUCRole.none, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void requestVoice() throws SmackException.NotConnectedException, InterruptedException {
        DataForm.Builder formType = DataForm.builder().setFormType("http://jabber.org/protocol/muc#request");
        TextSingleFormField.Builder builderTextSingleBuilder = FormField.textSingleBuilder("muc#role");
        builderTextSingleBuilder.setLabel("Requested role");
        builderTextSingleBuilder.setValue("participant");
        formType.addField(builderTextSingleBuilder.build());
        this.connection.sendStanza(((MessageBuilder) ((MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().to((Jid) this.room)).addExtension(formType.build())).build());
    }

    public void grantVoice(Collection<Resourcepart> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.participant);
    }

    public void grantVoice(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(resourcepart, MUCRole.participant, null);
    }

    public void revokeVoice(Collection<Resourcepart> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.visitor);
    }

    public void revokeVoice(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(resourcepart, MUCRole.visitor, null);
    }

    public void banUsers(Collection<? extends Jid> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.outcast);
    }

    public void banUser(Jid jid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(jid, MUCAffiliation.outcast, str);
    }

    public void grantMembership(Collection<? extends Jid> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.member);
    }

    public void grantMembership(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(jid, MUCAffiliation.member, null);
    }

    public void revokeMembership(Collection<? extends Jid> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.none);
    }

    public void revokeMembership(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(jid, MUCAffiliation.none, null);
    }

    public void grantModerator(Collection<Resourcepart> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.moderator);
    }

    public void grantModerator(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(resourcepart, MUCRole.moderator, null);
    }

    public void revokeModerator(Collection<Resourcepart> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(collection, MUCRole.participant);
    }

    public void revokeModerator(Resourcepart resourcepart) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeRole(resourcepart, MUCRole.participant, null);
    }

    public void grantOwnership(Collection<? extends Jid> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.owner);
    }

    public void grantOwnership(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(jid, MUCAffiliation.owner, null);
    }

    public void revokeOwnership(Collection<? extends Jid> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void revokeOwnership(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(jid, MUCAffiliation.admin, null);
    }

    public void grantAdmin(Collection<? extends Jid> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void grantAdmin(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(jid, MUCAffiliation.admin);
    }

    public void revokeAdmin(Collection<? extends Jid> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(collection, MUCAffiliation.admin);
    }

    public void revokeAdmin(EntityJid entityJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(entityJid, MUCAffiliation.member);
    }

    private void changeAffiliationByAdmin(Jid jid, MUCAffiliation mUCAffiliation) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        changeAffiliationByAdmin(jid, mUCAffiliation, null);
    }

    private void changeAffiliationByAdmin(Jid jid, MUCAffiliation mUCAffiliation, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        mUCAdmin.addItem(new MUCItem(mUCAffiliation, jid, str));
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    private void changeAffiliationByAdmin(Collection<? extends Jid> collection, MUCAffiliation mUCAffiliation) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        Iterator<? extends Jid> it = collection.iterator();
        while (it.hasNext()) {
            mUCAdmin.addItem(new MUCItem(mUCAffiliation, it.next()));
        }
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    private void changeRole(Resourcepart resourcepart, MUCRole mUCRole, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        mUCAdmin.addItem(new MUCItem(mUCRole, resourcepart, str));
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    private void changeRole(Collection<Resourcepart> collection, MUCRole mUCRole) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.set);
        Iterator<Resourcepart> it = collection.iterator();
        while (it.hasNext()) {
            mUCAdmin.addItem(new MUCItem(mUCRole, it.next()));
        }
        this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
    }

    public int getOccupantsCount() {
        return this.occupantsMap.size();
    }

    public List<EntityFullJid> getOccupants() {
        return new ArrayList(this.occupantsMap.keySet());
    }

    public Presence getOccupantPresence(EntityFullJid entityFullJid) {
        return this.occupantsMap.get(entityFullJid);
    }

    public Occupant getOccupant(EntityFullJid entityFullJid) {
        Presence occupantPresence = getOccupantPresence(entityFullJid);
        if (occupantPresence != null) {
            return new Occupant(occupantPresence);
        }
        return null;
    }

    public boolean addParticipantListener(PresenceListener presenceListener) {
        return this.presenceListeners.add(presenceListener);
    }

    public boolean removeParticipantListener(PresenceListener presenceListener) {
        return this.presenceListeners.remove(presenceListener);
    }

    public List<Affiliate> getOwners() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.owner);
    }

    public List<Affiliate> getAdmins() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.admin);
    }

    public List<Affiliate> getMembers() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.member);
    }

    public List<Affiliate> getOutcasts() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getAffiliatesByAdmin(MUCAffiliation.outcast);
    }

    private List<Affiliate> getAffiliatesByAdmin(MUCAffiliation mUCAffiliation) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.get);
        mUCAdmin.addItem(new MUCItem(mUCAffiliation));
        MUCAdmin mUCAdmin2 = (MUCAdmin) this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
        ArrayList arrayList = new ArrayList();
        Iterator<MUCItem> it = mUCAdmin2.getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(new Affiliate(it.next()));
        }
        return arrayList;
    }

    public List<Occupant> getModerators() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getOccupants(MUCRole.moderator);
    }

    public List<Occupant> getParticipants() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getOccupants(MUCRole.participant);
    }

    private List<Occupant> getOccupants(MUCRole mUCRole) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        mUCAdmin.setTo(this.room);
        mUCAdmin.setType(IQ.Type.get);
        mUCAdmin.addItem(new MUCItem(mUCRole));
        MUCAdmin mUCAdmin2 = (MUCAdmin) this.connection.createStanzaCollectorAndSend(mUCAdmin).nextResultOrThrow();
        ArrayList arrayList = new ArrayList();
        Iterator<MUCItem> it = mUCAdmin2.getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(new Occupant(it.next()));
        }
        return arrayList;
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(buildMessage().setBody(str).build());
    }

    public Chat createPrivateChat(EntityFullJid entityFullJid, ChatMessageListener chatMessageListener) {
        return ChatManager.getInstanceFor(this.connection).createChat(entityFullJid, chatMessageListener);
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
    public MessageView sendMessage(MessageBuilder messageBuilder) throws SmackException.NotConnectedException, InterruptedException {
        Iterator<MucMessageInterceptor> it = this.messageInterceptors.iterator();
        while (it.hasNext()) {
            it.next().intercept(messageBuilder, this);
        }
        Message messageBuild = ((MessageBuilder) messageBuilder.to((Jid) this.room)).ofType(Message.Type.groupchat).build();
        this.connection.sendStanza(messageBuild);
        return messageBuild;
    }

    public Message pollMessage() throws MultiUserChatException.MucNotJoinedException {
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector == null) {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
        return (Message) stanzaCollector.pollResult();
    }

    public Message nextMessage() throws InterruptedException, MultiUserChatException.MucNotJoinedException {
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector == null) {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
        return (Message) stanzaCollector.nextResult();
    }

    public Message nextMessage(long j) throws InterruptedException, MultiUserChatException.MucNotJoinedException {
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector == null) {
            throw new MultiUserChatException.MucNotJoinedException(this);
        }
        return (Message) stanzaCollector.nextResult(j);
    }

    public boolean addMessageListener(MessageListener messageListener) {
        return this.messageListeners.add(messageListener);
    }

    public boolean removeMessageListener(MessageListener messageListener) {
        return this.messageListeners.remove(messageListener);
    }

    public boolean addMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        return this.messageInterceptors.add(mucMessageInterceptor);
    }

    public boolean removeMessageInterceptor(MucMessageInterceptor mucMessageInterceptor) {
        return this.messageInterceptors.remove(mucMessageInterceptor);
    }

    public void changeSubject(final String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MessageBuilder messageBuilderBuildMessage = buildMessage();
        messageBuilderBuildMessage.setSubject(str);
        this.connection.createStanzaCollectorAndSend(new AndFilter(this.fromRoomGroupchatFilter, new StanzaFilter() { // from class: org.jivesoftware.smackx.muc.MultiUserChat.6
            @Override // org.jivesoftware.smack.filter.StanzaFilter
            public boolean accept(Stanza stanza) {
                return str.equals(((Message) stanza).getSubject());
            }
        }), messageBuilderBuildMessage.build()).nextResultOrThrow();
    }

    private void removeConnectionCallbacks() {
        this.connection.removeStanzaListener(this.messageListener);
        this.connection.removeStanzaListener(this.presenceListener);
        this.connection.removeStanzaListener(this.subjectListener);
        this.connection.removeStanzaListener(this.declinesListener);
        this.connection.removeStanzaSendingListener(this.presenceInterceptor);
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector != null) {
            stanzaCollector.cancel();
            this.messageCollector = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void userHasLeft() {
        this.occupantsMap.clear();
        this.myRoomJid = null;
        this.multiUserChatManager.removeJoinedRoom(this.room);
        removeConnectionCallbacks();
    }

    public boolean addUserStatusListener(UserStatusListener userStatusListener) {
        return this.userStatusListeners.add(userStatusListener);
    }

    public boolean removeUserStatusListener(UserStatusListener userStatusListener) {
        return this.userStatusListeners.remove(userStatusListener);
    }

    public boolean addParticipantStatusListener(ParticipantStatusListener participantStatusListener) {
        return this.participantStatusListeners.add(participantStatusListener);
    }

    public boolean removeParticipantStatusListener(ParticipantStatusListener participantStatusListener) {
        return this.participantStatusListeners.remove(participantStatusListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRoleModifications(MUCRole mUCRole, MUCRole mUCRole2, boolean z, EntityFullJid entityFullJid) {
        if ((MUCRole.visitor.equals(mUCRole) || MUCRole.none.equals(mUCRole)) && MUCRole.participant.equals(mUCRole2)) {
            if (z) {
                Iterator<UserStatusListener> it = this.userStatusListeners.iterator();
                while (it.hasNext()) {
                    it.next().voiceGranted();
                }
            } else {
                Iterator<ParticipantStatusListener> it2 = this.participantStatusListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().voiceGranted(entityFullJid);
                }
            }
        } else if (MUCRole.participant.equals(mUCRole) && (MUCRole.visitor.equals(mUCRole2) || MUCRole.none.equals(mUCRole2))) {
            if (z) {
                Iterator<UserStatusListener> it3 = this.userStatusListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().voiceRevoked();
                }
            } else {
                Iterator<ParticipantStatusListener> it4 = this.participantStatusListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().voiceRevoked(entityFullJid);
                }
            }
        }
        if (!MUCRole.moderator.equals(mUCRole) && MUCRole.moderator.equals(mUCRole2)) {
            if (MUCRole.visitor.equals(mUCRole) || MUCRole.none.equals(mUCRole)) {
                if (z) {
                    Iterator<UserStatusListener> it5 = this.userStatusListeners.iterator();
                    while (it5.hasNext()) {
                        it5.next().voiceGranted();
                    }
                } else {
                    Iterator<ParticipantStatusListener> it6 = this.participantStatusListeners.iterator();
                    while (it6.hasNext()) {
                        it6.next().voiceGranted(entityFullJid);
                    }
                }
            }
            if (z) {
                Iterator<UserStatusListener> it7 = this.userStatusListeners.iterator();
                while (it7.hasNext()) {
                    it7.next().moderatorGranted();
                }
                return;
            } else {
                Iterator<ParticipantStatusListener> it8 = this.participantStatusListeners.iterator();
                while (it8.hasNext()) {
                    it8.next().moderatorGranted(entityFullJid);
                }
                return;
            }
        }
        if (!MUCRole.moderator.equals(mUCRole) || MUCRole.moderator.equals(mUCRole2)) {
            return;
        }
        if (MUCRole.visitor.equals(mUCRole2) || MUCRole.none.equals(mUCRole2)) {
            if (z) {
                Iterator<UserStatusListener> it9 = this.userStatusListeners.iterator();
                while (it9.hasNext()) {
                    it9.next().voiceRevoked();
                }
            } else {
                Iterator<ParticipantStatusListener> it10 = this.participantStatusListeners.iterator();
                while (it10.hasNext()) {
                    it10.next().voiceRevoked(entityFullJid);
                }
            }
        }
        if (z) {
            Iterator<UserStatusListener> it11 = this.userStatusListeners.iterator();
            while (it11.hasNext()) {
                it11.next().moderatorRevoked();
            }
        } else {
            Iterator<ParticipantStatusListener> it12 = this.participantStatusListeners.iterator();
            while (it12.hasNext()) {
                it12.next().moderatorRevoked(entityFullJid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAffiliationModifications(MUCAffiliation mUCAffiliation, MUCAffiliation mUCAffiliation2, boolean z, EntityFullJid entityFullJid) {
        if (!MUCAffiliation.owner.equals(mUCAffiliation) || MUCAffiliation.owner.equals(mUCAffiliation2)) {
            if (!MUCAffiliation.admin.equals(mUCAffiliation) || MUCAffiliation.admin.equals(mUCAffiliation2)) {
                if (MUCAffiliation.member.equals(mUCAffiliation) && !MUCAffiliation.member.equals(mUCAffiliation2)) {
                    if (z) {
                        Iterator<UserStatusListener> it = this.userStatusListeners.iterator();
                        while (it.hasNext()) {
                            it.next().membershipRevoked();
                        }
                    } else {
                        Iterator<ParticipantStatusListener> it2 = this.participantStatusListeners.iterator();
                        while (it2.hasNext()) {
                            it2.next().membershipRevoked(entityFullJid);
                        }
                    }
                }
            } else if (z) {
                Iterator<UserStatusListener> it3 = this.userStatusListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().adminRevoked();
                }
            } else {
                Iterator<ParticipantStatusListener> it4 = this.participantStatusListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().adminRevoked(entityFullJid);
                }
            }
        } else if (z) {
            Iterator<UserStatusListener> it5 = this.userStatusListeners.iterator();
            while (it5.hasNext()) {
                it5.next().ownershipRevoked();
            }
        } else {
            Iterator<ParticipantStatusListener> it6 = this.participantStatusListeners.iterator();
            while (it6.hasNext()) {
                it6.next().ownershipRevoked(entityFullJid);
            }
        }
        if (!MUCAffiliation.owner.equals(mUCAffiliation) && MUCAffiliation.owner.equals(mUCAffiliation2)) {
            if (z) {
                Iterator<UserStatusListener> it7 = this.userStatusListeners.iterator();
                while (it7.hasNext()) {
                    it7.next().ownershipGranted();
                }
                return;
            } else {
                Iterator<ParticipantStatusListener> it8 = this.participantStatusListeners.iterator();
                while (it8.hasNext()) {
                    it8.next().ownershipGranted(entityFullJid);
                }
                return;
            }
        }
        if (!MUCAffiliation.admin.equals(mUCAffiliation) && MUCAffiliation.admin.equals(mUCAffiliation2)) {
            if (z) {
                Iterator<UserStatusListener> it9 = this.userStatusListeners.iterator();
                while (it9.hasNext()) {
                    it9.next().adminGranted();
                }
                return;
            } else {
                Iterator<ParticipantStatusListener> it10 = this.participantStatusListeners.iterator();
                while (it10.hasNext()) {
                    it10.next().adminGranted(entityFullJid);
                }
                return;
            }
        }
        if (MUCAffiliation.member.equals(mUCAffiliation) || !MUCAffiliation.member.equals(mUCAffiliation2)) {
            return;
        }
        if (z) {
            Iterator<UserStatusListener> it11 = this.userStatusListeners.iterator();
            while (it11.hasNext()) {
                it11.next().membershipGranted();
            }
        } else {
            Iterator<ParticipantStatusListener> it12 = this.participantStatusListeners.iterator();
            while (it12.hasNext()) {
                it12.next().membershipGranted(entityFullJid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPresenceCode(Set<MUCUser.Status> set, boolean z, MUCUser mUCUser, EntityFullJid entityFullJid) {
        if (set.contains(MUCUser.Status.KICKED_307)) {
            if (z) {
                Iterator<UserStatusListener> it = this.userStatusListeners.iterator();
                while (it.hasNext()) {
                    it.next().kicked(mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            } else {
                Iterator<ParticipantStatusListener> it2 = this.participantStatusListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().kicked(entityFullJid, mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            }
        }
        if (set.contains(MUCUser.Status.BANNED_301)) {
            if (z) {
                Iterator<UserStatusListener> it3 = this.userStatusListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().banned(mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            } else {
                Iterator<ParticipantStatusListener> it4 = this.participantStatusListeners.iterator();
                while (it4.hasNext()) {
                    it4.next().banned(entityFullJid, mUCUser.getItem().getActor(), mUCUser.getItem().getReason());
                }
            }
        }
        if (set.contains(MUCUser.Status.REMOVED_AFFIL_CHANGE_321) && z) {
            Iterator<UserStatusListener> it5 = this.userStatusListeners.iterator();
            while (it5.hasNext()) {
                it5.next().membershipRevoked();
            }
        }
        if (set.contains(MUCUser.Status.NEW_NICKNAME_303)) {
            Iterator<ParticipantStatusListener> it6 = this.participantStatusListeners.iterator();
            while (it6.hasNext()) {
                it6.next().nicknameChanged(entityFullJid, mUCUser.getItem().getNick());
            }
        }
    }

    public XMPPConnection getXmppConnection() {
        return this.connection;
    }

    public boolean serviceSupportsStableIds() {
        return DiscoverInfo.nullSafeContainsFeature(this.mucServiceDiscoInfo, MultiUserChatConstants.STABLE_ID_FEATURE);
    }

    public String toString() {
        return "MUC: " + ((Object) this.room) + "(" + ((Object) this.connection.getUser()) + ")";
    }
}
