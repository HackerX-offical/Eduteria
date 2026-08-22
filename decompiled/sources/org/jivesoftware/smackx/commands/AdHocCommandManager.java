package org.jivesoftware.smackx.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class AdHocCommandManager extends Manager {
    public static final String NAMESPACE = "http://jabber.org/protocol/commands";
    private static final int SESSION_TIMEOUT = 120;
    private final Map<String, AdHocCommandInfo> commands;
    private final Map<String, LocalCommand> executingCommands;
    private final ServiceDiscoveryManager serviceDiscoveryManager;
    private boolean sessionSweeperScheduled;
    private static final Logger LOGGER = Logger.getLogger(AdHocCommandManager.class.getName());
    private static final Map<XMPPConnection, AdHocCommandManager> instances = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                AdHocCommandManager.getAddHocCommandsManager(xMPPConnection);
            }
        });
    }

    public static synchronized AdHocCommandManager getAddHocCommandsManager(XMPPConnection xMPPConnection) {
        AdHocCommandManager adHocCommandManager;
        Map<XMPPConnection, AdHocCommandManager> map = instances;
        adHocCommandManager = map.get(xMPPConnection);
        if (adHocCommandManager == null) {
            adHocCommandManager = new AdHocCommandManager(xMPPConnection);
            map.put(xMPPConnection, adHocCommandManager);
        }
        return adHocCommandManager;
    }

    private AdHocCommandManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.commands = new ConcurrentHashMap();
        this.executingCommands = new ConcurrentHashMap();
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("http://jabber.org/protocol/commands");
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).setNodeInformationProvider("http://jabber.org/protocol/commands", new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.2
            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<DiscoverItems.Item> getNodeItems() {
                ArrayList arrayList = new ArrayList();
                for (AdHocCommandInfo adHocCommandInfo : AdHocCommandManager.this.getRegisteredCommands()) {
                    DiscoverItems.Item item = new DiscoverItems.Item(adHocCommandInfo.getOwnerJID());
                    item.setName(adHocCommandInfo.getName());
                    item.setNode(adHocCommandInfo.getNode());
                    arrayList.add(item);
                }
                return arrayList;
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(AdHocCommandData.ELEMENT, "http://jabber.org/protocol/commands", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.3
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                try {
                    return AdHocCommandManager.this.processAdHocCommand((AdHocCommandData) iq);
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException e2) {
                    AdHocCommandManager.LOGGER.log(Level.INFO, "processAdHocCommand threw exception", e2);
                    return null;
                }
            }
        });
    }

    public void registerCommand(String str, String str2, final Class<? extends LocalCommand> cls) {
        registerCommand(str, str2, new LocalCommandFactory() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.4
            @Override // org.jivesoftware.smackx.commands.LocalCommandFactory
            public LocalCommand getInstance() throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
                return (LocalCommand) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        });
    }

    public void registerCommand(String str, final String str2, LocalCommandFactory localCommandFactory) {
        this.commands.put(str, new AdHocCommandInfo(str, str2, connection().getUser(), localCommandFactory));
        this.serviceDiscoveryManager.setNodeInformationProvider(str, new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.5
            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<String> getNodeFeatures() {
                ArrayList arrayList = new ArrayList();
                arrayList.add("http://jabber.org/protocol/commands");
                arrayList.add("jabber:x:data");
                return arrayList;
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<DiscoverInfo.Identity> getNodeIdentities() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new DiscoverInfo.Identity("automation", str2, "command-node"));
                return arrayList;
            }
        });
    }

    public DiscoverItems discoverCommands(Jid jid) throws SmackException, InterruptedException, XMPPException {
        return this.serviceDiscoveryManager.discoverItems(jid, "http://jabber.org/protocol/commands");
    }

    public RemoteCommand getRemoteCommand(Jid jid, String str) {
        return new RemoteCommand(connection(), str, jid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IQ processAdHocCommand(AdHocCommandData adHocCommandData) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException {
        AdHocCommandData adHocCommandData2 = new AdHocCommandData();
        adHocCommandData2.setTo(adHocCommandData.getFrom());
        adHocCommandData2.setStanzaId(adHocCommandData.getStanzaId());
        adHocCommandData2.setNode(adHocCommandData.getNode());
        adHocCommandData2.setId(adHocCommandData.getTo());
        String sessionID = adHocCommandData.getSessionID();
        String node = adHocCommandData.getNode();
        if (sessionID == null) {
            if (!this.commands.containsKey(node)) {
                return respondError(adHocCommandData2, StanzaError.Condition.item_not_found);
            }
            String strRandomString = StringUtils.randomString(15);
            try {
                try {
                    LocalCommand localCommandNewInstanceOfCmd = newInstanceOfCmd(node, strRandomString);
                    adHocCommandData2.setType(IQ.Type.result);
                    localCommandNewInstanceOfCmd.setData(adHocCommandData2);
                    if (!localCommandNewInstanceOfCmd.hasPermission(adHocCommandData.getFrom())) {
                        return respondError(adHocCommandData2, StanzaError.Condition.forbidden);
                    }
                    AdHocCommand.Action action = adHocCommandData.getAction();
                    if (action != null && action.equals(AdHocCommand.Action.unknown)) {
                        return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.malformedAction);
                    }
                    if (action != null && !action.equals(AdHocCommand.Action.execute)) {
                        return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badAction);
                    }
                    localCommandNewInstanceOfCmd.incrementStage();
                    localCommandNewInstanceOfCmd.execute();
                    if (localCommandNewInstanceOfCmd.isLastStage()) {
                        adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                        return adHocCommandData2;
                    }
                    adHocCommandData2.setStatus(AdHocCommand.Status.executing);
                    this.executingCommands.put(strRandomString, localCommandNewInstanceOfCmd);
                    maybeWindUpSessionSweeper();
                    return adHocCommandData2;
                } catch (XMPPException.XMPPErrorException e2) {
                    StanzaError stanzaError = e2.getStanzaError();
                    if (StanzaError.Type.CANCEL.equals(stanzaError.getType())) {
                        adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                        this.executingCommands.remove(strRandomString);
                    }
                    return respondError(adHocCommandData2, stanzaError);
                }
            } catch (IllegalAccessException e3) {
                e = e3;
                return respondError(adHocCommandData2, StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage()).build());
            } catch (IllegalArgumentException e4) {
                e = e4;
                return respondError(adHocCommandData2, StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage()).build());
            } catch (InstantiationException e5) {
                e = e5;
                return respondError(adHocCommandData2, StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage()).build());
            } catch (NoSuchMethodException e6) {
                e = e6;
                return respondError(adHocCommandData2, StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage()).build());
            } catch (SecurityException e7) {
                e = e7;
                return respondError(adHocCommandData2, StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage()).build());
            } catch (InvocationTargetException e8) {
                e = e8;
                return respondError(adHocCommandData2, StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage()).build());
            }
        }
        LocalCommand localCommand = this.executingCommands.get(sessionID);
        if (localCommand == null) {
            return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badSessionid);
        }
        if (System.currentTimeMillis() - localCommand.getCreationDate() > 120000) {
            this.executingCommands.remove(sessionID);
            return respondError(adHocCommandData2, StanzaError.Condition.not_allowed, AdHocCommand.SpecificErrorCondition.sessionExpired);
        }
        synchronized (localCommand) {
            AdHocCommand.Action action2 = adHocCommandData.getAction();
            if (action2 != null && action2.equals(AdHocCommand.Action.unknown)) {
                return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.malformedAction);
            }
            if (action2 == null || AdHocCommand.Action.execute.equals(action2)) {
                action2 = localCommand.getExecuteAction();
            }
            if (!localCommand.isValidAction(action2)) {
                return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badAction);
            }
            try {
                adHocCommandData2.setType(IQ.Type.result);
                localCommand.setData(adHocCommandData2);
                if (AdHocCommand.Action.next.equals(action2)) {
                    localCommand.incrementStage();
                    localCommand.next(new FillableForm(adHocCommandData.getForm()));
                    if (localCommand.isLastStage()) {
                        adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                    } else {
                        adHocCommandData2.setStatus(AdHocCommand.Status.executing);
                    }
                } else if (AdHocCommand.Action.complete.equals(action2)) {
                    localCommand.incrementStage();
                    localCommand.complete(new FillableForm(adHocCommandData.getForm()));
                    adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                    this.executingCommands.remove(sessionID);
                } else if (AdHocCommand.Action.prev.equals(action2)) {
                    localCommand.decrementStage();
                    localCommand.prev();
                } else if (AdHocCommand.Action.cancel.equals(action2)) {
                    localCommand.cancel();
                    adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                    this.executingCommands.remove(sessionID);
                }
                return adHocCommandData2;
            } catch (XMPPException.XMPPErrorException e9) {
                StanzaError stanzaError2 = e9.getStanzaError();
                if (StanzaError.Type.CANCEL.equals(stanzaError2.getType())) {
                    adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                    this.executingCommands.remove(sessionID);
                }
                return respondError(adHocCommandData2, stanzaError2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sessionSweeper() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, LocalCommand>> it = this.executingCommands.entrySet().iterator();
            while (it.hasNext()) {
                if (jCurrentTimeMillis - it.next().getValue().getCreationDate() > 240000) {
                    it.remove();
                }
            }
            this.sessionSweeperScheduled = false;
        }
        if (this.executingCommands.isEmpty()) {
            return;
        }
        maybeWindUpSessionSweeper();
    }

    private synchronized void maybeWindUpSessionSweeper() {
        if (this.sessionSweeperScheduled) {
            return;
        }
        this.sessionSweeperScheduled = true;
        schedule(new Runnable() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.sessionSweeper();
            }
        }, 10L, TimeUnit.SECONDS);
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, StanzaError.Condition condition) {
        return respondError(adHocCommandData, StanzaError.getBuilder(condition).build());
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, StanzaError.Condition condition, AdHocCommand.SpecificErrorCondition specificErrorCondition) {
        return respondError(adHocCommandData, StanzaError.getBuilder(condition).addExtension(new AdHocCommandData.SpecificError(specificErrorCondition)).build());
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, StanzaError stanzaError) {
        adHocCommandData.setType(IQ.Type.error);
        adHocCommandData.setError(stanzaError);
        return adHocCommandData;
    }

    private LocalCommand newInstanceOfCmd(String str, String str2) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, XMPPException.XMPPErrorException, InvocationTargetException {
        AdHocCommandInfo adHocCommandInfo = this.commands.get(str);
        LocalCommand commandInstance = adHocCommandInfo.getCommandInstance();
        commandInstance.setSessionID(str2);
        commandInstance.setName(adHocCommandInfo.getName());
        commandInstance.setNode(adHocCommandInfo.getNode());
        return commandInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<AdHocCommandInfo> getRegisteredCommands() {
        return this.commands.values();
    }

    private static final class AdHocCommandInfo {
        private LocalCommandFactory factory;
        private String name;
        private String node;
        private final Jid ownerJID;

        private AdHocCommandInfo(String str, String str2, Jid jid, LocalCommandFactory localCommandFactory) {
            this.node = str;
            this.name = str2;
            this.ownerJID = jid;
            this.factory = localCommandFactory;
        }

        public LocalCommand getCommandInstance() throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
            return this.factory.getInstance();
        }

        public String getName() {
            return this.name;
        }

        public String getNode() {
            return this.node;
        }

        public Jid getOwnerJID() {
            return this.ownerJID;
        }
    }
}
