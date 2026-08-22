package org.jivesoftware.smackx.bytestreams.ibb;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smack.AbstractConnectionClosedListener;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.bytestreams.BytestreamListener;
import org.jivesoftware.smackx.bytestreams.BytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class InBandBytestreamManager extends Manager implements BytestreamManager {
    public static final int MAXIMUM_BLOCK_SIZE = 65535;
    private static final String SESSION_ID_PREFIX = "jibb_";
    private static final Map<XMPPConnection, InBandBytestreamManager> managers;
    private final List<BytestreamListener> allRequestListeners;
    private final CloseListener closeListener;
    private final DataListener dataListener;
    private int defaultBlockSize;
    private final List<String> ignoredBytestreamRequests;
    private final InitiationListener initiationListener;
    private int maximumBlockSize;
    private final Map<String, InBandBytestreamSession> sessions;
    private StanzaType stanza;
    private final Map<Jid, BytestreamListener> userListeners;

    public enum StanzaType {
        IQ,
        MESSAGE
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                InBandBytestreamManager.getByteStreamManager(xMPPConnection);
            }
        });
        managers = new WeakHashMap();
    }

    public static synchronized InBandBytestreamManager getByteStreamManager(XMPPConnection xMPPConnection) {
        if (xMPPConnection == null) {
            return null;
        }
        Map<XMPPConnection, InBandBytestreamManager> map = managers;
        InBandBytestreamManager inBandBytestreamManager = map.get(xMPPConnection);
        if (inBandBytestreamManager == null) {
            inBandBytestreamManager = new InBandBytestreamManager(xMPPConnection);
            map.put(xMPPConnection, inBandBytestreamManager);
        }
        return inBandBytestreamManager;
    }

    private InBandBytestreamManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.userListeners = new ConcurrentHashMap();
        this.allRequestListeners = Collections.synchronizedList(new LinkedList());
        this.sessions = new ConcurrentHashMap();
        this.defaultBlockSize = 4096;
        this.maximumBlockSize = 65535;
        this.stanza = StanzaType.IQ;
        this.ignoredBytestreamRequests = Collections.synchronizedList(new LinkedList());
        xMPPConnection.addConnectionListener(new AbstractConnectionClosedListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.2
            @Override // org.jivesoftware.smack.AbstractConnectionClosedListener
            public void connectionTerminated() {
                InBandBytestreamManager.this.sessions.clear();
                InBandBytestreamManager.this.ignoredBytestreamRequests.clear();
            }
        });
        InitiationListener initiationListener = new InitiationListener(this);
        this.initiationListener = initiationListener;
        xMPPConnection.registerIQRequestHandler(initiationListener);
        DataListener dataListener = new DataListener(this);
        this.dataListener = dataListener;
        xMPPConnection.registerIQRequestHandler(dataListener);
        CloseListener closeListener = new CloseListener(this);
        this.closeListener = closeListener;
        xMPPConnection.registerIQRequestHandler(closeListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.add(bytestreamListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void removeIncomingBytestreamListener(BytestreamListener bytestreamListener) {
        this.allRequestListeners.remove(bytestreamListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void addIncomingBytestreamListener(BytestreamListener bytestreamListener, Jid jid) {
        this.userListeners.put(jid, bytestreamListener);
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public void removeIncomingBytestreamListener(Jid jid) {
        this.userListeners.remove(jid);
    }

    public void ignoreBytestreamRequestOnce(String str) {
        this.ignoredBytestreamRequests.add(str);
    }

    public int getDefaultBlockSize() {
        return this.defaultBlockSize;
    }

    public void setDefaultBlockSize(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("Default block size must be between 1 and 65535");
        }
        this.defaultBlockSize = i;
    }

    public int getMaximumBlockSize() {
        return this.maximumBlockSize;
    }

    public void setMaximumBlockSize(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("Maximum block size must be between 1 and 65535");
        }
        this.maximumBlockSize = i;
    }

    public StanzaType getStanza() {
        return this.stanza;
    }

    public void setStanza(StanzaType stanzaType) {
        this.stanza = stanzaType;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public InBandBytestreamSession establishSession(Jid jid) throws SmackException, InterruptedException, XMPPException {
        return establishSession(jid, getNextSessionID());
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamManager
    public InBandBytestreamSession establishSession(Jid jid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        Open open = new Open(str, this.defaultBlockSize, this.stanza);
        open.setTo(jid);
        XMPPConnection xMPPConnectionConnection = connection();
        xMPPConnectionConnection.createStanzaCollectorAndSend(open).nextResultOrThrow();
        InBandBytestreamSession inBandBytestreamSession = new InBandBytestreamSession(xMPPConnectionConnection, open, jid);
        this.sessions.put(str, inBandBytestreamSession);
        return inBandBytestreamSession;
    }

    protected void replyRejectPacket(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse(iq, StanzaError.Condition.not_acceptable));
    }

    protected void replyItemNotFoundPacket(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse(iq, StanzaError.Condition.item_not_found));
    }

    private static String getNextSessionID() {
        return SESSION_ID_PREFIX + StringUtils.secureOnlineAttackSafeRandomString();
    }

    protected XMPPConnection getConnection() {
        return connection();
    }

    protected BytestreamListener getUserListener(Jid jid) {
        return this.userListeners.get(jid);
    }

    protected List<BytestreamListener> getAllRequestListeners() {
        return this.allRequestListeners;
    }

    protected Map<String, InBandBytestreamSession> getSessions() {
        return this.sessions;
    }

    protected List<String> getIgnoredBytestreamRequests() {
        return this.ignoredBytestreamRequests;
    }
}
