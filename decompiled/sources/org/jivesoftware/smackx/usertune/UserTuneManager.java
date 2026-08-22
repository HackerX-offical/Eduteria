package org.jivesoftware.smackx.usertune;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.usertune.element.UserTuneElement;

/* JADX INFO: loaded from: classes10.dex */
public final class UserTuneManager extends Manager {
    private static final Map<XMPPConnection, UserTuneManager> INSTANCES = new WeakHashMap();
    public static final String USERTUNE_NODE = "http://jabber.org/protocol/tune";
    private final PepManager pepManager;

    public static synchronized UserTuneManager getInstanceFor(XMPPConnection xMPPConnection) throws SmackException.NotLoggedInException {
        UserTuneManager userTuneManager;
        Map<XMPPConnection, UserTuneManager> map = INSTANCES;
        userTuneManager = map.get(xMPPConnection);
        if (userTuneManager == null) {
            userTuneManager = new UserTuneManager(xMPPConnection);
            map.put(xMPPConnection, userTuneManager);
        }
        return userTuneManager;
    }

    private UserTuneManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pepManager = PepManager.getInstanceFor(xMPPConnection);
    }

    public void clearUserTune() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        publishUserTune(UserTuneElement.EMPTY_USER_TUNE);
    }

    public void publishUserTune(UserTuneElement userTuneElement) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        this.pepManager.publish("http://jabber.org/protocol/tune", new PayloadItem(userTuneElement));
    }

    public boolean addUserTuneListener(PepEventListener<UserTuneElement> pepEventListener) {
        return this.pepManager.addPepEventListener("http://jabber.org/protocol/tune", UserTuneElement.class, pepEventListener);
    }

    public boolean removeUserTuneListener(PepEventListener<UserTuneElement> pepEventListener) {
        return this.pepManager.removePepEventListener(pepEventListener);
    }
}
