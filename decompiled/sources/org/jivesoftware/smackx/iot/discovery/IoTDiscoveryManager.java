package org.jivesoftware.smackx.iot.discovery;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
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
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iot.IoTManager;
import org.jivesoftware.smackx.iot.Thing;
import org.jivesoftware.smackx.iot.control.IoTControlManager;
import org.jivesoftware.smackx.iot.data.IoTDataManager;
import org.jivesoftware.smackx.iot.discovery.element.IoTClaimed;
import org.jivesoftware.smackx.iot.discovery.element.IoTDisown;
import org.jivesoftware.smackx.iot.discovery.element.IoTDisowned;
import org.jivesoftware.smackx.iot.discovery.element.IoTMine;
import org.jivesoftware.smackx.iot.discovery.element.IoTRegister;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemove;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemoved;
import org.jivesoftware.smackx.iot.discovery.element.IoTUnregister;
import org.jivesoftware.smackx.iot.discovery.element.Tag;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class IoTDiscoveryManager extends Manager {
    private Jid preconfiguredRegistry;
    private final Map<NodeInfo, ThingState> things;
    private final Set<Jid> usedRegistries;
    private static final Logger LOGGER = Logger.getLogger(IoTDiscoveryManager.class.getName());
    private static final Map<XMPPConnection, IoTDiscoveryManager> INSTANCES = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.iot.discovery.IoTDiscoveryManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (IoTManager.isAutoEnableActive()) {
                    IoTDiscoveryManager.getInstanceFor(xMPPConnection);
                }
            }
        });
    }

    public static synchronized IoTDiscoveryManager getInstanceFor(XMPPConnection xMPPConnection) {
        IoTDiscoveryManager ioTDiscoveryManager;
        Map<XMPPConnection, IoTDiscoveryManager> map = INSTANCES;
        ioTDiscoveryManager = map.get(xMPPConnection);
        if (ioTDiscoveryManager == null) {
            ioTDiscoveryManager = new IoTDiscoveryManager(xMPPConnection);
            map.put(xMPPConnection, ioTDiscoveryManager);
        }
        return ioTDiscoveryManager;
    }

    private IoTDiscoveryManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.usedRegistries = new HashSet();
        this.things = new HashMap();
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(IoTClaimed.ELEMENT, "urn:xmpp:iot:discovery", IQ.Type.set, IQRequestHandler.Mode.sync) { // from class: org.jivesoftware.smackx.iot.discovery.IoTDiscoveryManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                if (!IoTDiscoveryManager.this.isRegistry(iq.getFrom())) {
                    IoTDiscoveryManager.LOGGER.log(Level.SEVERE, "Received control stanza from non-registry entity: " + iq);
                    return null;
                }
                IoTClaimed ioTClaimed = (IoTClaimed) iq;
                Jid jid = ioTClaimed.getJid();
                IoTDiscoveryManager.this.getStateFor(ioTClaimed.getNodeInfo()).setOwner(jid.asBareJid());
                IoTDiscoveryManager.LOGGER.info("Our thing got claimed by " + ((Object) jid) + ". " + ioTClaimed);
                try {
                    IoTProvisioningManager.getInstanceFor(IoTDiscoveryManager.this.connection()).sendFriendshipRequest(jid.asBareJid());
                } catch (InterruptedException | SmackException.NotConnectedException e2) {
                    IoTDiscoveryManager.LOGGER.log(Level.WARNING, "Could not friendship owner", e2);
                }
                return IQ.createResultIQ(iq);
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("disown", "urn:xmpp:iot:discovery", IQ.Type.set, IQRequestHandler.Mode.sync) { // from class: org.jivesoftware.smackx.iot.discovery.IoTDiscoveryManager.3
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                if (!IoTDiscoveryManager.this.isRegistry(iq.getFrom())) {
                    IoTDiscoveryManager.LOGGER.log(Level.SEVERE, "Received control stanza from non-registry entity: " + iq);
                    return null;
                }
                Jid from = iq.getFrom();
                NodeInfo nodeInfo = ((IoTDisowned) iq).getNodeInfo();
                ThingState stateFor = IoTDiscoveryManager.this.getStateFor(nodeInfo);
                if (!from.equals((CharSequence) stateFor.getRegistry())) {
                    IoTDiscoveryManager.LOGGER.severe("Received <disowned/> for " + nodeInfo + " from " + ((Object) from) + " but this is not the registry " + ((Object) stateFor.getRegistry()) + " of the thing.");
                    return null;
                }
                if (!stateFor.isOwned()) {
                    IoTDiscoveryManager.LOGGER.fine("Received <disowned/> for " + nodeInfo + " but thing was not owned.");
                } else {
                    stateFor.setUnowned();
                }
                return IQ.createResultIQ(iq);
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(IoTRemoved.ELEMENT, "urn:xmpp:iot:discovery", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.iot.discovery.IoTDiscoveryManager.4
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                if (!IoTDiscoveryManager.this.isRegistry(iq.getFrom())) {
                    IoTDiscoveryManager.LOGGER.log(Level.SEVERE, "Received control stanza from non-registry entity: " + iq);
                    return null;
                }
                IoTRemoved ioTRemoved = (IoTRemoved) iq;
                IoTDiscoveryManager.this.getStateFor(ioTRemoved.getNodeInfo()).setRemoved();
                try {
                    IoTProvisioningManager.getInstanceFor(IoTDiscoveryManager.this.connection()).unfriend(ioTRemoved.getFrom());
                } catch (InterruptedException | SmackException.NotConnectedException e2) {
                    IoTDiscoveryManager.LOGGER.log(Level.SEVERE, "Could not unfriend registry after <removed/>", e2);
                }
                return IQ.createResultIQ(iq);
            }
        });
    }

    public Jid findRegistry() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        Jid jid = this.preconfiguredRegistry;
        if (jid != null) {
            return jid;
        }
        List<DiscoverInfo> listFindServicesDiscoverInfo = ServiceDiscoveryManager.getInstanceFor(connection()).findServicesDiscoverInfo("urn:xmpp:iot:discovery", true, true);
        if (listFindServicesDiscoverInfo.isEmpty()) {
            return null;
        }
        return listFindServicesDiscoverInfo.get(0).getFrom();
    }

    public ThingState registerThing(Thing thing) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, IoTClaimedException, XMPPException.XMPPErrorException {
        return registerThing(findRegistry(), thing);
    }

    public ThingState registerThing(Jid jid, Thing thing) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, IoTClaimedException, XMPPException.XMPPErrorException {
        XMPPConnection xMPPConnectionConnection = connection();
        IoTRegister ioTRegister = new IoTRegister(thing.getMetaTags(), thing.getNodeInfo(), thing.isSelfOwened());
        ioTRegister.setTo(jid);
        IQ iq = (IQ) xMPPConnectionConnection.createStanzaCollectorAndSend(ioTRegister).nextResultOrThrow();
        if (iq instanceof IoTClaimed) {
            throw new IoTClaimedException((IoTClaimed) iq);
        }
        ThingState stateFor = getStateFor(thing.getNodeInfo());
        stateFor.setRegistry(jid.asBareJid());
        interactWithRegistry(jid);
        IoTDataManager.getInstanceFor(xMPPConnectionConnection).installThing(thing);
        IoTControlManager.getInstanceFor(xMPPConnectionConnection).installThing(thing);
        return stateFor;
    }

    public IoTClaimed claimThing(Collection<Tag> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return claimThing(collection, true);
    }

    public IoTClaimed claimThing(Collection<Tag> collection, boolean z) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return claimThing(findRegistry(), collection, z);
    }

    public IoTClaimed claimThing(Jid jid, Collection<Tag> collection, boolean z) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        interactWithRegistry(jid);
        IoTMine ioTMine = new IoTMine(collection, z);
        ioTMine.setTo(jid);
        IoTClaimed ioTClaimed = (IoTClaimed) connection().createStanzaCollectorAndSend(ioTMine).nextResultOrThrow();
        IoTProvisioningManager.getInstanceFor(connection()).sendFriendshipRequest(ioTClaimed.getJid().asBareJid());
        return ioTClaimed;
    }

    public void removeThing(BareJid bareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        removeThing(bareJid, NodeInfo.EMPTY);
    }

    public void removeThing(BareJid bareJid, NodeInfo nodeInfo) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        removeThing(findRegistry(), bareJid, nodeInfo);
    }

    public void removeThing(Jid jid, BareJid bareJid, NodeInfo nodeInfo) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        interactWithRegistry(jid);
        IoTRemove ioTRemove = new IoTRemove(bareJid, nodeInfo);
        ioTRemove.setTo(jid);
        connection().createStanzaCollectorAndSend(ioTRemove).nextResultOrThrow();
    }

    public void unregister() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        unregister(NodeInfo.EMPTY);
    }

    public void unregister(NodeInfo nodeInfo) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        unregister(findRegistry(), nodeInfo);
    }

    public void unregister(Jid jid, NodeInfo nodeInfo) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        interactWithRegistry(jid);
        IoTUnregister ioTUnregister = new IoTUnregister(nodeInfo);
        ioTUnregister.setTo(jid);
        connection().createStanzaCollectorAndSend(ioTUnregister).nextResultOrThrow();
        getStateFor(nodeInfo).setUnregistered();
        XMPPConnection xMPPConnectionConnection = connection();
        IoTDataManager.getInstanceFor(xMPPConnectionConnection).uninstallThing(nodeInfo);
        IoTControlManager.getInstanceFor(xMPPConnectionConnection).uninstallThing(nodeInfo);
    }

    public void disownThing(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        disownThing(jid, NodeInfo.EMPTY);
    }

    public void disownThing(Jid jid, NodeInfo nodeInfo) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        disownThing(findRegistry(), jid, nodeInfo);
    }

    public void disownThing(Jid jid, Jid jid2, NodeInfo nodeInfo) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        interactWithRegistry(jid);
        IoTDisown ioTDisown = new IoTDisown(jid2, nodeInfo);
        ioTDisown.setTo(jid);
        connection().createStanzaCollectorAndSend(ioTDisown).nextResultOrThrow();
    }

    public boolean isRegistry(BareJid bareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        Objects.requireNonNull(bareJid, "JID argument must not be null");
        return bareJid.equals((CharSequence) findRegistry()) || this.usedRegistries.contains(bareJid);
    }

    public boolean isRegistry(Jid jid) {
        try {
            return isRegistry(jid.asBareJid());
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
            LOGGER.log(Level.WARNING, "Could not determine if " + ((Object) jid) + " is a registry", e2);
            return false;
        }
    }

    private void interactWithRegistry(Jid jid) throws SmackException.NotConnectedException, InterruptedException {
        if (this.usedRegistries.add(jid)) {
            IoTProvisioningManager.getInstanceFor(connection()).sendFriendshipRequestIfRequired(jid.asBareJid());
        }
    }

    public ThingState getStateFor(Thing thing) {
        return this.things.get(thing.getNodeInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThingState getStateFor(NodeInfo nodeInfo) {
        ThingState thingState = this.things.get(nodeInfo);
        if (thingState != null) {
            return thingState;
        }
        ThingState thingState2 = new ThingState(nodeInfo);
        this.things.put(nodeInfo, thingState2);
        return thingState2;
    }
}
