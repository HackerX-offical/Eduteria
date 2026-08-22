package org.jivesoftware.smackx.mam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.commands.AdHocCommandManager;
import org.jivesoftware.smackx.commands.RemoteCommand;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jivesoftware.smackx.mam.element.MamFinIQ;
import org.jivesoftware.smackx.mam.element.MamPrefsIQ;
import org.jivesoftware.smackx.mam.element.MamQueryIQ;
import org.jivesoftware.smackx.mam.filter.MamResultFilter;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.rsm.packet.RSMSet;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class MamManager extends Manager {
    private static final String ADVANCED_CONFIG_NODE = "urn:xmpp:mam#configure";
    private static final String FORM_FIELD_END = "end";
    private static final String FORM_FIELD_START = "start";
    private static final String FORM_FIELD_WITH = "with";
    private static final Map<XMPPConnection, Map<Jid, MamManager>> INSTANCES;
    private final AdHocCommandManager adHocCommandManager;
    private final Jid archiveAddress;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.mam.MamManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                MamManager.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
    }

    public static MamManager getInstanceFor(XMPPConnection xMPPConnection) {
        return getInstanceFor(xMPPConnection, null);
    }

    public static MamManager getInstanceFor(MultiUserChat multiUserChat) {
        return getInstanceFor(multiUserChat.getXmppConnection(), multiUserChat.getRoom());
    }

    public static synchronized MamManager getInstanceFor(XMPPConnection xMPPConnection, Jid jid) {
        MamManager mamManager;
        Map<XMPPConnection, Map<Jid, MamManager>> map = INSTANCES;
        Map<Jid, MamManager> map2 = map.get(xMPPConnection);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(xMPPConnection, map2);
        }
        mamManager = map2.get(jid);
        if (mamManager == null) {
            mamManager = new MamManager(xMPPConnection, jid);
            map2.put(jid, mamManager);
        }
        return mamManager;
    }

    private MamManager(XMPPConnection xMPPConnection, Jid jid) {
        super(xMPPConnection);
        this.archiveAddress = jid;
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        this.adHocCommandManager = AdHocCommandManager.getAddHocCommandsManager(xMPPConnection);
    }

    public Jid getArchiveAddress() {
        Jid jid = this.archiveAddress;
        if (jid != null) {
            return jid;
        }
        EntityFullJid user = connection().getUser();
        if (user == null) {
            return null;
        }
        return user.asBareJid();
    }

    public static final class MamQueryArgs {
        private final String afterUid;
        private final String beforeUid;
        private DataForm dataForm;
        private final Map<String, FormField> formFields;
        private final Integer maxResults;
        private final String node;

        private MamQueryArgs(Builder builder) {
            this.node = builder.node;
            this.formFields = builder.formFields;
            if (builder.maxResults <= 0) {
                this.maxResults = null;
            } else {
                this.maxResults = Integer.valueOf(builder.maxResults);
            }
            this.afterUid = builder.afterUid;
            this.beforeUid = builder.beforeUid;
        }

        DataForm getDataForm() {
            DataForm dataForm = this.dataForm;
            if (dataForm != null) {
                return dataForm;
            }
            DataForm.Builder newMamForm = MamManager.getNewMamForm();
            newMamForm.addFields(this.formFields.values());
            DataForm dataFormBuild = newMamForm.build();
            this.dataForm = dataFormBuild;
            return dataFormBuild;
        }

        void maybeAddRsmSet(MamQueryIQ mamQueryIQ) {
            Integer num = this.maxResults;
            if (num == null && this.afterUid == null && this.beforeUid == null) {
                return;
            }
            mamQueryIQ.addExtension(new RSMSet(this.afterUid, this.beforeUid, -1, -1, null, num != null ? num.intValue() : -1, null, -1));
        }

        public static Builder builder() {
            return new Builder();
        }

        public static final class Builder {
            private String afterUid;
            private String beforeUid;
            private final Map<String, FormField> formFields = new LinkedHashMap(8);
            private int maxResults = -1;
            private String node;

            public Builder queryNode(String str) {
                if (str == null) {
                    return this;
                }
                this.node = str;
                return this;
            }

            public Builder limitResultsToJid(Jid jid) {
                if (jid == null) {
                    return this;
                }
                FormField withFormField = MamManager.getWithFormField(jid);
                this.formFields.put(withFormField.getFieldName(), withFormField);
                return this;
            }

            public Builder limitResultsSince(Date date) {
                if (date != null) {
                    TextSingleFormField textSingleFormFieldBuild = FormField.builder("start").setValue(date).build();
                    this.formFields.put(textSingleFormFieldBuild.getFieldName(), textSingleFormFieldBuild);
                    FormField formField = this.formFields.get("end");
                    if (formField != null) {
                        try {
                            Date firstValueAsDate = formField.getFirstValueAsDate();
                            if (firstValueAsDate.getTime() <= date.getTime()) {
                                throw new IllegalArgumentException("Given start date (" + date + ") is after the existing end date (" + firstValueAsDate + ')');
                            }
                        } catch (ParseException e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                }
                return this;
            }

            public Builder limitResultsBefore(Date date) {
                if (date != null) {
                    TextSingleFormField textSingleFormFieldBuild = FormField.builder("end").setValue(date).build();
                    this.formFields.put(textSingleFormFieldBuild.getFieldName(), textSingleFormFieldBuild);
                    FormField formField = this.formFields.get("start");
                    if (formField != null) {
                        try {
                            Date firstValueAsDate = formField.getFirstValueAsDate();
                            if (date.getTime() <= firstValueAsDate.getTime()) {
                                throw new IllegalArgumentException("Given end date (" + date + ") is before the existing start date (" + firstValueAsDate + ')');
                            }
                        } catch (ParseException e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                }
                return this;
            }

            public Builder setResultPageSize(Integer num) {
                if (num == null) {
                    this.maxResults = -1;
                    return this;
                }
                return setResultPageSizeTo(num.intValue());
            }

            public Builder setResultPageSizeTo(int i) {
                if (i < 0) {
                    throw new IllegalArgumentException();
                }
                this.maxResults = i;
                return this;
            }

            public Builder onlyReturnMessageCount() {
                return setResultPageSizeTo(0);
            }

            public Builder withAdditionalFormField(FormField formField) {
                this.formFields.put(formField.getFieldName(), formField);
                return this;
            }

            public Builder withAdditionalFormFields(List<FormField> list) {
                Iterator<FormField> it = list.iterator();
                while (it.hasNext()) {
                    withAdditionalFormField(it.next());
                }
                return this;
            }

            public Builder afterUid(String str) {
                this.afterUid = (String) StringUtils.requireNullOrNotEmpty(str, "afterUid must not be empty");
                return this;
            }

            public Builder beforeUid(String str) {
                this.beforeUid = str;
                return this;
            }

            public Builder queryLastPage() {
                return beforeUid("");
            }

            public MamQueryArgs build() {
                return new MamQueryArgs(this);
            }
        }
    }

    public MamQuery queryArchive(MamQueryArgs mamQueryArgs) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        MamQueryIQ mamQueryIQ = new MamQueryIQ(StringUtils.secureUniqueRandomString(), mamQueryArgs.node, mamQueryArgs.getDataForm());
        mamQueryIQ.setType(IQ.Type.set);
        mamQueryIQ.setTo(this.archiveAddress);
        mamQueryArgs.maybeAddRsmSet(mamQueryIQ);
        return queryArchive(mamQueryIQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FormField getWithFormField(Jid jid) {
        return FormField.builder(FORM_FIELD_WITH).setValue(jid.toString()).build();
    }

    public MamQuery queryMostRecentPage(Jid jid, int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return queryArchive(MamQueryArgs.builder().queryLastPage().limitResultsToJid(jid).setResultPageSize(Integer.valueOf(i)).build());
    }

    public List<FormField> retrieveFormFields() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return retrieveFormFields(null);
    }

    public List<FormField> retrieveFormFields(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        MamQueryIQ mamQueryIQ = new MamQueryIQ(StringUtils.secureUniqueRandomString(), str, null);
        mamQueryIQ.setTo(this.archiveAddress);
        return ((MamQueryIQ) connection().createStanzaCollectorAndSend(mamQueryIQ).nextResultOrThrow()).getDataForm().getFields();
    }

    private MamQuery queryArchive(MamQueryIQ mamQueryIQ) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return new MamQuery(queryArchivePage(mamQueryIQ), mamQueryIQ.getNode(), DataForm.from(mamQueryIQ));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MamQueryPage queryArchivePage(MamQueryIQ mamQueryIQ) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        StanzaCollector stanzaCollectorCreateStanzaCollector = authenticatedConnectionOrThrow.createStanzaCollector(new IQReplyFilter(mamQueryIQ, authenticatedConnectionOrThrow));
        StanzaCollector stanzaCollectorCreateStanzaCollector2 = authenticatedConnectionOrThrow.createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(new MamResultFilter(mamQueryIQ)).setCollectorToReset(stanzaCollectorCreateStanzaCollector));
        try {
            authenticatedConnectionOrThrow.sendStanza(mamQueryIQ);
            MamFinIQ mamFinIQ = (MamFinIQ) stanzaCollectorCreateStanzaCollector.nextResultOrThrow();
            if (stanzaCollectorCreateStanzaCollector2 != null) {
                stanzaCollectorCreateStanzaCollector2.close();
            }
            return new MamQueryPage(stanzaCollectorCreateStanzaCollector2, mamFinIQ);
        } catch (Throwable th) {
            if (stanzaCollectorCreateStanzaCollector2 != null) {
                try {
                    stanzaCollectorCreateStanzaCollector2.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final class MamQuery {
        private final DataForm form;
        private MamQueryPage mamQueryPage;
        private final String node;

        private MamQuery(MamQueryPage mamQueryPage, String str, DataForm dataForm) {
            this.node = str;
            this.form = dataForm;
            this.mamQueryPage = mamQueryPage;
        }

        public boolean isComplete() {
            return this.mamQueryPage.getMamFinIq().isComplete();
        }

        public List<Message> getMessages() {
            return this.mamQueryPage.messages;
        }

        public List<MamElements.MamResultExtension> getMamResultExtensions() {
            return this.mamQueryPage.mamResultExtensions;
        }

        private List<Message> page(RSMSet rSMSet) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
            MamQueryIQ mamQueryIQ = new MamQueryIQ(StringUtils.secureUniqueRandomString(), this.node, this.form);
            mamQueryIQ.setType(IQ.Type.set);
            mamQueryIQ.setTo(MamManager.this.archiveAddress);
            mamQueryIQ.addExtension(rSMSet);
            MamQueryPage mamQueryPageQueryArchivePage = MamManager.this.queryArchivePage(mamQueryIQ);
            this.mamQueryPage = mamQueryPageQueryArchivePage;
            return mamQueryPageQueryArchivePage.messages;
        }

        private RSMSet getPreviousRsmSet() {
            return this.mamQueryPage.getMamFinIq().getRSMSet();
        }

        public List<Message> pageNext(int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
            return page(new RSMSet(i, getPreviousRsmSet().getLast(), RSMSet.PageDirection.after));
        }

        public List<Message> pagePrevious(int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
            return page(new RSMSet(i, getPreviousRsmSet().getFirst(), RSMSet.PageDirection.before));
        }

        public int getMessageCount() {
            return getMessages().size();
        }

        public MamQueryPage getPage() {
            return this.mamQueryPage;
        }
    }

    public static final class MamQueryPage {
        private final List<Forwarded<Message>> forwardedMessages;
        private final MamFinIQ mamFin;
        private final List<Message> mamResultCarrierMessages;
        private final List<MamElements.MamResultExtension> mamResultExtensions;
        private final List<Message> messages;

        private MamQueryPage(StanzaCollector stanzaCollector, MamFinIQ mamFinIQ) {
            this.mamFin = mamFinIQ;
            List<Stanza> collectedStanzasAfterCancelled = stanzaCollector.getCollectedStanzasAfterCancelled();
            ArrayList arrayList = new ArrayList(collectedStanzasAfterCancelled.size());
            ArrayList arrayList2 = new ArrayList(collectedStanzasAfterCancelled.size());
            ArrayList arrayList3 = new ArrayList(collectedStanzasAfterCancelled.size());
            Iterator<Stanza> it = collectedStanzasAfterCancelled.iterator();
            while (it.hasNext()) {
                Message message = (Message) it.next();
                arrayList.add(message);
                MamElements.MamResultExtension mamResultExtensionFrom = MamElements.MamResultExtension.from(message);
                arrayList2.add(mamResultExtensionFrom);
                arrayList3.add(mamResultExtensionFrom.getForwarded());
            }
            this.mamResultCarrierMessages = Collections.unmodifiableList(arrayList);
            this.mamResultExtensions = Collections.unmodifiableList(arrayList2);
            this.forwardedMessages = Collections.unmodifiableList(arrayList3);
            this.messages = Collections.unmodifiableList(Forwarded.extractMessagesFrom(arrayList3));
        }

        public List<Message> getMessages() {
            return this.messages;
        }

        public List<Forwarded<Message>> getForwarded() {
            return this.forwardedMessages;
        }

        public List<MamElements.MamResultExtension> getMamResultExtensions() {
            return this.mamResultExtensions;
        }

        public List<Message> getMamResultCarrierMessages() {
            return this.mamResultCarrierMessages;
        }

        public MamFinIQ getMamFinIq() {
            return this.mamFin;
        }
    }

    public boolean isSupported() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.serviceDiscoveryManager.supportsFeature(getArchiveAddress(), "urn:xmpp:mam:2");
    }

    public boolean isAdvancedConfigurationSupported() throws SmackException, InterruptedException, XMPPException {
        Iterator<DiscoverItems.Item> it = this.adHocCommandManager.discoverCommands(this.archiveAddress).getItems().iterator();
        while (it.hasNext()) {
            if (it.next().getNode().equals(ADVANCED_CONFIG_NODE)) {
                return true;
            }
        }
        return false;
    }

    public RemoteCommand getAdvancedConfigurationCommand() throws SmackException, InterruptedException, XMPPException {
        for (DiscoverItems.Item item : this.adHocCommandManager.discoverCommands(this.archiveAddress).getItems()) {
            if (item.getNode().equals(ADVANCED_CONFIG_NODE)) {
                return this.adHocCommandManager.getRemoteCommand(this.archiveAddress, item.getNode());
            }
        }
        throw new SmackException.FeatureNotSupportedException(ADVANCED_CONFIG_NODE, this.archiveAddress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DataForm.Builder getNewMamForm() {
        TextSingleFormField textSingleFormFieldBuildHiddenFormType = FormField.buildHiddenFormType("urn:xmpp:mam:2");
        DataForm.Builder builder = DataForm.builder();
        builder.addField(textSingleFormFieldBuildHiddenFormType);
        return builder;
    }

    public String getMessageUidOfLatestMessage() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        MamQuery mamQueryQueryArchive = queryArchive(MamQueryArgs.builder().setResultPageSize(1).queryLastPage().build());
        if (mamQueryQueryArchive.getMessages().isEmpty()) {
            return null;
        }
        return mamQueryQueryArchive.getMamResultExtensions().get(0).getId();
    }

    public MamPrefsResult retrieveArchivingPreferences() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return queryMamPrefs(new MamPrefsIQ());
    }

    public MamPrefsResult updateArchivingPreferences(MamPrefs mamPrefs) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return queryMamPrefs(mamPrefs.constructMamPrefsIq());
    }

    public MamPrefsResult enableMamForAllMessages() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return setDefaultBehavior(MamPrefsIQ.DefaultBehavior.always);
    }

    public MamPrefsResult enableMamForRosterMessages() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return setDefaultBehavior(MamPrefsIQ.DefaultBehavior.roster);
    }

    public MamPrefsResult setDefaultBehavior(MamPrefsIQ.DefaultBehavior defaultBehavior) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        MamPrefsResult mamPrefsResultRetrieveArchivingPreferences = retrieveArchivingPreferences();
        if (mamPrefsResultRetrieveArchivingPreferences.mamPrefs.getDefault() == defaultBehavior) {
            return mamPrefsResultRetrieveArchivingPreferences;
        }
        MamPrefs mamPrefsAsMamPrefs = mamPrefsResultRetrieveArchivingPreferences.asMamPrefs();
        mamPrefsAsMamPrefs.setDefaultBehavior(defaultBehavior);
        return updateArchivingPreferences(mamPrefsAsMamPrefs);
    }

    public static final class MamPrefsResult {
        public final DataForm form;
        public final MamPrefsIQ mamPrefs;

        private MamPrefsResult(MamPrefsIQ mamPrefsIQ, DataForm dataForm) {
            this.mamPrefs = mamPrefsIQ;
            this.form = dataForm;
        }

        public MamPrefs asMamPrefs() {
            return new MamPrefs(this);
        }
    }

    public static final class MamPrefs {
        private final List<Jid> alwaysJids;
        private MamPrefsIQ.DefaultBehavior defaultBehavior;
        private final List<Jid> neverJids;

        private MamPrefs(MamPrefsResult mamPrefsResult) {
            MamPrefsIQ mamPrefsIQ = mamPrefsResult.mamPrefs;
            this.alwaysJids = new ArrayList(mamPrefsIQ.getAlwaysJids());
            this.neverJids = new ArrayList(mamPrefsIQ.getNeverJids());
            this.defaultBehavior = mamPrefsIQ.getDefault();
        }

        public void setDefaultBehavior(MamPrefsIQ.DefaultBehavior defaultBehavior) {
            this.defaultBehavior = (MamPrefsIQ.DefaultBehavior) Objects.requireNonNull(defaultBehavior, "defaultBehavior must not be null");
        }

        public MamPrefsIQ.DefaultBehavior getDefaultBehavior() {
            return this.defaultBehavior;
        }

        public List<Jid> getAlwaysJids() {
            return this.alwaysJids;
        }

        public List<Jid> getNeverJids() {
            return this.neverJids;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MamPrefsIQ constructMamPrefsIq() {
            return new MamPrefsIQ(this.alwaysJids, this.neverJids, this.defaultBehavior);
        }
    }

    private MamPrefsResult queryMamPrefs(MamPrefsIQ mamPrefsIQ) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        return new MamPrefsResult((MamPrefsIQ) getAuthenticatedConnectionOrThrow().createStanzaCollectorAndSend(mamPrefsIQ).nextResultOrThrow(), DataForm.from(mamPrefsIQ));
    }
}
