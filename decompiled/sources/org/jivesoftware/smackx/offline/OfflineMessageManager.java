package org.jivesoftware.smackx.offline;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.offline.packet.OfflineMessageInfo;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public final class OfflineMessageManager extends Manager {
    public static final String NAMESPACE = "http://jabber.org/protocol/offline";
    private ServiceDiscoveryManager serviceDiscoveryManager;
    private static final Logger LOGGER = Logger.getLogger(OfflineMessageManager.class.getName());
    private static final Map<XMPPConnection, OfflineMessageManager> INSTANCES = new WeakHashMap();
    private static final StanzaFilter PACKET_FILTER = new AndFilter(new StanzaExtensionFilter(new OfflineMessageInfo()), StanzaTypeFilter.MESSAGE);

    private OfflineMessageManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized OfflineMessageManager getInstanceFor(XMPPConnection xMPPConnection) {
        OfflineMessageManager offlineMessageManager;
        Map<XMPPConnection, OfflineMessageManager> map = INSTANCES;
        offlineMessageManager = map.get(xMPPConnection);
        if (offlineMessageManager == null) {
            offlineMessageManager = new OfflineMessageManager(xMPPConnection);
            map.put(xMPPConnection, offlineMessageManager);
        }
        return offlineMessageManager;
    }

    public boolean supportsFlexibleRetrieval() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.serviceDiscoveryManager.serverSupportsFeature("http://jabber.org/protocol/offline");
    }

    public int getMessageCount() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DataForm dataFormFrom = DataForm.from(this.serviceDiscoveryManager.discoverInfo(null, "http://jabber.org/protocol/offline"), "http://jabber.org/protocol/offline");
        if (dataFormFrom == null) {
            return 0;
        }
        return Integer.parseInt(dataFormFrom.getField("number_of_messages").getFirstValue());
    }

    public List<OfflineMessageHeader> getHeaders() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList();
        Iterator<DiscoverItems.Item> it = this.serviceDiscoveryManager.discoverItems(null, "http://jabber.org/protocol/offline").getItems().iterator();
        while (it.hasNext()) {
            arrayList.add(new OfflineMessageHeader(it.next()));
        }
        return arrayList;
    }

    public List<Message> getMessages(final List<String> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList(list.size());
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            OfflineMessageRequest.Item item = new OfflineMessageRequest.Item(it.next());
            item.setAction(ViewHierarchyConstants.VIEW_KEY);
            offlineMessageRequest.addItem(item);
        }
        AndFilter andFilter = new AndFilter(PACKET_FILTER, new StanzaFilter() { // from class: org.jivesoftware.smackx.offline.OfflineMessageManager.1
            @Override // org.jivesoftware.smack.filter.StanzaFilter
            public boolean accept(Stanza stanza) {
                return list.contains(((OfflineMessageInfo) stanza.getExtension(OfflineMessageInfo.class)).getNode());
            }
        });
        int size = list.size();
        StanzaCollector stanzaCollectorCreateStanzaCollector = connection().createStanzaCollector(andFilter);
        try {
            connection().createStanzaCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
            do {
                Message message = (Message) stanzaCollectorCreateStanzaCollector.nextResult();
                if (message != null) {
                    arrayList.add(message);
                    size--;
                } else if (message == null && size > 0) {
                    LOGGER.log(Level.WARNING, "Did not receive all expected offline messages. " + size + " are missing.");
                }
                if (message == null) {
                    break;
                }
            } while (size > 0);
            if (stanzaCollectorCreateStanzaCollector != null) {
                stanzaCollectorCreateStanzaCollector.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (stanzaCollectorCreateStanzaCollector != null) {
                try {
                    stanzaCollectorCreateStanzaCollector.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public List<Message> getMessages() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setFetch(true);
        StanzaCollector stanzaCollectorCreateStanzaCollectorAndSend = connection().createStanzaCollectorAndSend(offlineMessageRequest);
        StanzaCollector stanzaCollectorCreateStanzaCollector = connection().createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(PACKET_FILTER).setCollectorToReset(stanzaCollectorCreateStanzaCollectorAndSend));
        try {
            stanzaCollectorCreateStanzaCollectorAndSend.nextResultOrThrow();
            stanzaCollectorCreateStanzaCollector.cancel();
            ArrayList arrayList = new ArrayList(stanzaCollectorCreateStanzaCollector.getCollectedCount());
            while (true) {
                Message message = (Message) stanzaCollectorCreateStanzaCollector.pollResult();
                if (message == null) {
                    break;
                }
                arrayList.add(message);
            }
            if (stanzaCollectorCreateStanzaCollector != null) {
                stanzaCollectorCreateStanzaCollector.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (stanzaCollectorCreateStanzaCollector != null) {
                try {
                    stanzaCollectorCreateStanzaCollector.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void deleteMessages(List<String> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setType(IQ.Type.set);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            OfflineMessageRequest.Item item = new OfflineMessageRequest.Item(it.next());
            item.setAction("remove");
            offlineMessageRequest.addItem(item);
        }
        connection().createStanzaCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
    }

    public void deleteMessages() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        OfflineMessageRequest offlineMessageRequest = new OfflineMessageRequest();
        offlineMessageRequest.setType(IQ.Type.set);
        offlineMessageRequest.setPurge(true);
        connection().createStanzaCollectorAndSend(offlineMessageRequest).nextResultOrThrow();
    }
}
