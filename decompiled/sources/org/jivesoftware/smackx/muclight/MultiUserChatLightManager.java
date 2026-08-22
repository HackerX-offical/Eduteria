package org.jivesoftware.smackx.muclight;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.muclight.element.MUCLightBlockingIQ;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class MultiUserChatLightManager extends Manager {
    private static final Map<XMPPConnection, MultiUserChatLightManager> INSTANCES = new WeakHashMap();
    private final Map<EntityBareJid, WeakReference<MultiUserChatLight>> multiUserChatLights;

    public static synchronized MultiUserChatLightManager getInstanceFor(XMPPConnection xMPPConnection) {
        MultiUserChatLightManager multiUserChatLightManager;
        Map<XMPPConnection, MultiUserChatLightManager> map = INSTANCES;
        multiUserChatLightManager = map.get(xMPPConnection);
        if (multiUserChatLightManager == null) {
            multiUserChatLightManager = new MultiUserChatLightManager(xMPPConnection);
            map.put(xMPPConnection, multiUserChatLightManager);
        }
        return multiUserChatLightManager;
    }

    private MultiUserChatLightManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.multiUserChatLights = new HashMap();
    }

    public synchronized MultiUserChatLight getMultiUserChatLight(EntityBareJid entityBareJid) {
        WeakReference<MultiUserChatLight> weakReference = this.multiUserChatLights.get(entityBareJid);
        if (weakReference == null) {
            return createNewMucLightAndAddToMap(entityBareJid);
        }
        MultiUserChatLight multiUserChatLight = weakReference.get();
        if (multiUserChatLight != null) {
            return multiUserChatLight;
        }
        return createNewMucLightAndAddToMap(entityBareJid);
    }

    private MultiUserChatLight createNewMucLightAndAddToMap(EntityBareJid entityBareJid) {
        MultiUserChatLight multiUserChatLight = new MultiUserChatLight(connection(), entityBareJid);
        this.multiUserChatLights.put(entityBareJid, new WeakReference<>(multiUserChatLight));
        return multiUserChatLight;
    }

    public boolean isFeatureSupported(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).discoverInfo(domainBareJid).containsFeature(MultiUserChatLight.NAMESPACE);
    }

    public List<Jid> getOccupiedRooms(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        List<DiscoverItems.Item> items = ServiceDiscoveryManager.getInstanceFor(connection()).discoverItems(domainBareJid).getItems();
        ArrayList arrayList = new ArrayList(items.size());
        Iterator<DiscoverItems.Item> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getEntityID());
        }
        return arrayList;
    }

    public List<DomainBareJid> getLocalServices() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).findServices(MultiUserChatLight.NAMESPACE, false, false);
    }

    public List<Jid> getUsersAndRoomsBlocked(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ blockingList = getBlockingList(domainBareJid);
        ArrayList arrayList = new ArrayList();
        if (blockingList.getRooms() != null) {
            arrayList.addAll(blockingList.getRooms().keySet());
        }
        if (blockingList.getUsers() != null) {
            arrayList.addAll(blockingList.getUsers().keySet());
        }
        return arrayList;
    }

    public List<Jid> getRoomsBlocked(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ blockingList = getBlockingList(domainBareJid);
        ArrayList arrayList = new ArrayList();
        if (blockingList.getRooms() != null) {
            arrayList.addAll(blockingList.getRooms().keySet());
        }
        return arrayList;
    }

    public List<Jid> getUsersBlocked(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ blockingList = getBlockingList(domainBareJid);
        ArrayList arrayList = new ArrayList();
        if (blockingList.getUsers() != null) {
            arrayList.addAll(blockingList.getUsers().keySet());
        }
        return arrayList;
    }

    private MUCLightBlockingIQ getBlockingList(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(null, null);
        mUCLightBlockingIQ.setType(IQ.Type.get);
        mUCLightBlockingIQ.setTo(domainBareJid);
        return (MUCLightBlockingIQ) ((IQ) connection().createStanzaCollectorAndSend(new IQReplyFilter(mUCLightBlockingIQ, connection()), mUCLightBlockingIQ).nextResultOrThrow());
    }

    public void blockRoom(DomainBareJid domainBareJid, Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        map.put(jid, false);
        sendBlockRooms(domainBareJid, map);
    }

    public void blockRooms(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        Iterator<Jid> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), false);
        }
        sendBlockRooms(domainBareJid, map);
    }

    private void sendBlockRooms(DomainBareJid domainBareJid, HashMap<Jid, Boolean> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(map, null);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }

    public void blockUser(DomainBareJid domainBareJid, Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        map.put(jid, false);
        sendBlockUsers(domainBareJid, map);
    }

    public void blockUsers(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        Iterator<Jid> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), false);
        }
        sendBlockUsers(domainBareJid, map);
    }

    private void sendBlockUsers(DomainBareJid domainBareJid, HashMap<Jid, Boolean> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(null, map);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }

    public void unblockRoom(DomainBareJid domainBareJid, Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        map.put(jid, true);
        sendUnblockRooms(domainBareJid, map);
    }

    public void unblockRooms(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        Iterator<Jid> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), true);
        }
        sendUnblockRooms(domainBareJid, map);
    }

    private void sendUnblockRooms(DomainBareJid domainBareJid, HashMap<Jid, Boolean> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(map, null);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }

    public void unblockUser(DomainBareJid domainBareJid, Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        map.put(jid, true);
        sendUnblockUsers(domainBareJid, map);
    }

    public void unblockUsers(DomainBareJid domainBareJid, List<Jid> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap<Jid, Boolean> map = new HashMap<>();
        Iterator<Jid> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), true);
        }
        sendUnblockUsers(domainBareJid, map);
    }

    private void sendUnblockUsers(DomainBareJid domainBareJid, HashMap<Jid, Boolean> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(null, map);
        mUCLightBlockingIQ.setType(IQ.Type.set);
        mUCLightBlockingIQ.setTo(domainBareJid);
        connection().createStanzaCollectorAndSend(mUCLightBlockingIQ).nextResultOrThrow();
    }
}
