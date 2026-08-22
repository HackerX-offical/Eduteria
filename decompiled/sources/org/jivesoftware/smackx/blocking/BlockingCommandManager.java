package org.jivesoftware.smackx.blocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.blocking.element.BlockListIQ;
import org.jivesoftware.smackx.blocking.element.UnblockContactsIQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class BlockingCommandManager extends Manager {
    private static final Map<XMPPConnection, BlockingCommandManager> INSTANCES;
    public static final String NAMESPACE = "urn:xmpp:blocking";
    private final Set<AllJidsUnblockedListener> allJidsUnblockedListeners;
    private volatile List<Jid> blockListCached;
    private final Set<JidsBlockedListener> jidsBlockedListeners;
    private final Set<JidsUnblockedListener> jidsUnblockedListeners;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.blocking.BlockingCommandManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                BlockingCommandManager.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
    }

    public static synchronized BlockingCommandManager getInstanceFor(XMPPConnection xMPPConnection) {
        BlockingCommandManager blockingCommandManager;
        Map<XMPPConnection, BlockingCommandManager> map = INSTANCES;
        blockingCommandManager = map.get(xMPPConnection);
        if (blockingCommandManager == null) {
            blockingCommandManager = new BlockingCommandManager(xMPPConnection);
            map.put(xMPPConnection, blockingCommandManager);
        }
        return blockingCommandManager;
    }

    private BlockingCommandManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.allJidsUnblockedListeners = new CopyOnWriteArraySet();
        this.jidsBlockedListeners = new CopyOnWriteArraySet();
        this.jidsUnblockedListeners = new CopyOnWriteArraySet();
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(BlockContactsIQ.ELEMENT, "urn:xmpp:blocking", IQ.Type.set, IQRequestHandler.Mode.sync) { // from class: org.jivesoftware.smackx.blocking.BlockingCommandManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                BlockContactsIQ blockContactsIQ = (BlockContactsIQ) iq;
                if (BlockingCommandManager.this.blockListCached == null) {
                    BlockingCommandManager.this.blockListCached = new ArrayList();
                }
                List<Jid> jids = blockContactsIQ.getJids();
                BlockingCommandManager.this.blockListCached.addAll(jids);
                Iterator it = BlockingCommandManager.this.jidsBlockedListeners.iterator();
                while (it.hasNext()) {
                    ((JidsBlockedListener) it.next()).onJidsBlocked(jids);
                }
                return IQ.createResultIQ(blockContactsIQ);
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(UnblockContactsIQ.ELEMENT, "urn:xmpp:blocking", IQ.Type.set, IQRequestHandler.Mode.sync) { // from class: org.jivesoftware.smackx.blocking.BlockingCommandManager.3
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                UnblockContactsIQ unblockContactsIQ = (UnblockContactsIQ) iq;
                if (BlockingCommandManager.this.blockListCached == null) {
                    BlockingCommandManager.this.blockListCached = new ArrayList();
                }
                List<Jid> jids = unblockContactsIQ.getJids();
                if (jids == null) {
                    BlockingCommandManager.this.blockListCached.clear();
                    Iterator it = BlockingCommandManager.this.allJidsUnblockedListeners.iterator();
                    while (it.hasNext()) {
                        ((AllJidsUnblockedListener) it.next()).onAllJidsUnblocked();
                    }
                } else {
                    BlockingCommandManager.this.blockListCached.removeAll(jids);
                    Iterator it2 = BlockingCommandManager.this.jidsUnblockedListeners.iterator();
                    while (it2.hasNext()) {
                        ((JidsUnblockedListener) it2.next()).onJidsUnblocked(jids);
                    }
                }
                return IQ.createResultIQ(unblockContactsIQ);
            }
        });
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smackx.blocking.BlockingCommandManager.4
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (z) {
                    return;
                }
                BlockingCommandManager.this.blockListCached = null;
            }
        });
    }

    public boolean isSupportedByServer() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("urn:xmpp:blocking");
    }

    public List<Jid> getBlockList() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.blockListCached == null) {
            this.blockListCached = ((BlockListIQ) connection().createStanzaCollectorAndSend(new BlockListIQ()).nextResultOrThrow()).getBlockedJidsCopy();
        }
        return Collections.unmodifiableList(this.blockListCached);
    }

    public void blockContacts(List<Jid> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        connection().createStanzaCollectorAndSend(new BlockContactsIQ(list)).nextResultOrThrow();
    }

    public void unblockContacts(List<Jid> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        connection().createStanzaCollectorAndSend(new UnblockContactsIQ(list)).nextResultOrThrow();
    }

    public void unblockAll() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        connection().createStanzaCollectorAndSend(new UnblockContactsIQ()).nextResultOrThrow();
    }

    public void addJidsBlockedListener(JidsBlockedListener jidsBlockedListener) {
        this.jidsBlockedListeners.add(jidsBlockedListener);
    }

    public void removeJidsBlockedListener(JidsBlockedListener jidsBlockedListener) {
        this.jidsBlockedListeners.remove(jidsBlockedListener);
    }

    public void addJidsUnblockedListener(JidsUnblockedListener jidsUnblockedListener) {
        this.jidsUnblockedListeners.add(jidsUnblockedListener);
    }

    public void removeJidsUnblockedListener(JidsUnblockedListener jidsUnblockedListener) {
        this.jidsUnblockedListeners.remove(jidsUnblockedListener);
    }

    public void addAllJidsUnblockedListener(AllJidsUnblockedListener allJidsUnblockedListener) {
        this.allJidsUnblockedListeners.add(allJidsUnblockedListener);
    }

    public void removeAllJidsUnblockedListener(AllJidsUnblockedListener allJidsUnblockedListener) {
        this.allJidsUnblockedListeners.remove(allJidsUnblockedListener);
    }
}
