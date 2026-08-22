package org.jivesoftware.smackx.bob;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.SHA1;
import org.jivesoftware.smackx.bob.element.BoBIQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public final class BoBManager extends Manager {
    private static final LruCache<ContentId, BoBData> BOB_CACHE;
    private static final Map<XMPPConnection, BoBManager> INSTANCES;
    public static final String NAMESPACE = "urn:xmpp:bob";
    private final Map<ContentId, BoBInfo> bobs;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.bob.BoBManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                BoBManager.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
        BOB_CACHE = new LruCache<>(128);
    }

    public static synchronized BoBManager getInstanceFor(XMPPConnection xMPPConnection) {
        BoBManager boBManager;
        Map<XMPPConnection, BoBManager> map = INSTANCES;
        boBManager = map.get(xMPPConnection);
        if (boBManager == null) {
            boBManager = new BoBManager(xMPPConnection);
            map.put(xMPPConnection, boBManager);
        }
        return boBManager;
    }

    private BoBManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.bobs = new ConcurrentHashMap();
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:bob");
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("data", "urn:xmpp:bob", IQ.Type.get, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.bob.BoBManager.2
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                BoBIQ boBIQ = (BoBIQ) iq;
                ContentId contentId = boBIQ.getContentId();
                BoBInfo boBInfo = (BoBInfo) BoBManager.this.bobs.get(contentId);
                if (boBInfo == null) {
                    return null;
                }
                BoBIQ boBIQ2 = new BoBIQ(contentId, boBInfo.getData());
                boBIQ2.setType(IQ.Type.result);
                boBIQ2.setTo(boBIQ.getFrom());
                return boBIQ2;
            }
        });
    }

    public boolean isSupportedByServer() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("urn:xmpp:bob");
    }

    public BoBData requestBoB(Jid jid, ContentId contentId) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        LruCache<ContentId, BoBData> lruCache = BOB_CACHE;
        BoBData boBDataLookup = lruCache.lookup(contentId);
        if (boBDataLookup != null) {
            return boBDataLookup;
        }
        BoBIQ boBIQ = new BoBIQ(contentId);
        boBIQ.setType(IQ.Type.get);
        boBIQ.setTo(jid);
        BoBData boBData = ((BoBIQ) getAuthenticatedConnectionOrThrow().createStanzaCollectorAndSend(boBIQ).nextResultOrThrow()).getBoBData();
        lruCache.put(contentId, boBData);
        return boBData;
    }

    public BoBInfo addBoB(BoBData boBData) {
        ContentId contentId = new ContentId(SHA1.hex(boBData.getContent()), "sha1");
        BoBInfo boBInfo = new BoBInfo(Collections.unmodifiableSet(Collections.singleton(contentId)), boBData);
        this.bobs.put(contentId, boBInfo);
        return boBInfo;
    }

    public BoBInfo removeBoB(ContentId contentId) {
        BoBInfo boBInfoRemove = this.bobs.remove(contentId);
        if (boBInfoRemove == null) {
            return null;
        }
        Iterator<ContentId> it = boBInfoRemove.getHashes().iterator();
        while (it.hasNext()) {
            this.bobs.remove(it.next());
        }
        return boBInfoRemove;
    }
}
