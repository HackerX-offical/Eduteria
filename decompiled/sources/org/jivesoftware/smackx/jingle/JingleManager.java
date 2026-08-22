package org.jivesoftware.smackx.jingle;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleAction;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.JingleIBBTransportManager;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.JingleS5BTransportManager;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.FullJid;

/* JADX INFO: loaded from: classes10.dex */
public final class JingleManager extends Manager {
    private final Map<String, JingleHandler> descriptionHandlers;
    private final Map<FullJidAndSessionId, JingleSessionHandler> jingleSessionHandlers;
    private final JingleUtil jutil;
    private static final Logger LOGGER = Logger.getLogger(JingleManager.class.getName());
    private static final Map<XMPPConnection, JingleManager> INSTANCES = new WeakHashMap();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static ExecutorService getThreadPool() {
        return threadPool;
    }

    public static synchronized JingleManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleManager jingleManager;
        Map<XMPPConnection, JingleManager> map = INSTANCES;
        jingleManager = map.get(xMPPConnection);
        if (jingleManager == null) {
            jingleManager = new JingleManager(xMPPConnection);
            map.put(xMPPConnection, jingleManager);
        }
        return jingleManager;
    }

    private JingleManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.descriptionHandlers = new ConcurrentHashMap();
        this.jingleSessionHandlers = new ConcurrentHashMap();
        this.jutil = new JingleUtil(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(Jingle.ELEMENT, "urn:xmpp:jingle:1", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.jingle.JingleManager.1
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                Jingle jingle = (Jingle) iq;
                EntityFullJid entityFullJidAsFullJidOrThrow = jingle.getFrom().asFullJidOrThrow();
                String sid = jingle.getSid();
                JingleSessionHandler jingleSessionHandler = (JingleSessionHandler) JingleManager.this.jingleSessionHandlers.get(new FullJidAndSessionId(entityFullJidAsFullJidOrThrow, sid));
                if (jingleSessionHandler != null) {
                    return jingleSessionHandler.handleJingleSessionRequest(jingle);
                }
                if (jingle.getAction() != JingleAction.session_initiate) {
                    JingleManager.LOGGER.log(Level.WARNING, "Unknown session.");
                    return JingleManager.this.jutil.createErrorUnknownSession(jingle);
                }
                JingleHandler jingleHandler = (JingleHandler) JingleManager.this.descriptionHandlers.get(jingle.getContents().get(0).getDescription().getNamespace());
                if (jingleHandler == null) {
                    JingleManager.LOGGER.log(Level.WARNING, "Unsupported Jingle application.");
                    return JingleManager.this.jutil.createSessionTerminateUnsupportedApplications(entityFullJidAsFullJidOrThrow, sid);
                }
                return jingleHandler.handleJingleRequest(jingle);
            }
        });
        JingleTransportMethodManager instanceFor = JingleTransportMethodManager.getInstanceFor(xMPPConnection);
        instanceFor.registerTransportManager(JingleIBBTransportManager.getInstanceFor(xMPPConnection));
        instanceFor.registerTransportManager(JingleS5BTransportManager.getInstanceFor(xMPPConnection));
    }

    public JingleHandler registerDescriptionHandler(String str, JingleHandler jingleHandler) {
        return this.descriptionHandlers.put(str, jingleHandler);
    }

    public JingleSessionHandler registerJingleSessionHandler(FullJid fullJid, String str, JingleSessionHandler jingleSessionHandler) {
        return this.jingleSessionHandlers.put(new FullJidAndSessionId(fullJid, str), jingleSessionHandler);
    }

    public JingleSessionHandler unregisterJingleSessionHandler(FullJid fullJid, String str, JingleSessionHandler jingleSessionHandler) {
        return this.jingleSessionHandlers.remove(new FullJidAndSessionId(fullJid, str));
    }

    public static String randomId() {
        return StringUtils.randomString(24);
    }
}
