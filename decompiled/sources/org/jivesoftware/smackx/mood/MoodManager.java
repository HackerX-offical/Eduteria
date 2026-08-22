package org.jivesoftware.smackx.mood;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.mood.element.MoodConcretisation;
import org.jivesoftware.smackx.mood.element.MoodElement;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;

/* JADX INFO: loaded from: classes10.dex */
public final class MoodManager extends Manager {
    private static final Map<XMPPConnection, MoodManager> INSTANCES = new WeakHashMap();
    public static final String MOOD_NODE = "http://jabber.org/protocol/mood";
    private final PepManager pepManager;

    private MoodManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pepManager = PepManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized MoodManager getInstanceFor(XMPPConnection xMPPConnection) {
        MoodManager moodManager;
        Map<XMPPConnection, MoodManager> map = INSTANCES;
        moodManager = map.get(xMPPConnection);
        if (moodManager == null) {
            moodManager = new MoodManager(xMPPConnection);
            map.put(xMPPConnection, moodManager);
        }
        return moodManager;
    }

    public void setMood(Mood mood) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        setMood(mood, null, null);
    }

    public void setMood(Mood mood, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        setMood(mood, null, str);
    }

    public void setMood(Mood mood, MoodConcretisation moodConcretisation) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        setMood(mood, moodConcretisation, null);
    }

    public void setMood(Mood mood, MoodConcretisation moodConcretisation, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        publishMood(buildMood(mood, moodConcretisation, str));
    }

    public void clearMood() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        publishMood(buildMood(null, null, null));
    }

    private void publishMood(MoodElement moodElement) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        this.pepManager.publish("http://jabber.org/protocol/mood", new PayloadItem(moodElement));
    }

    private static MoodElement buildMood(Mood mood, MoodConcretisation moodConcretisation, String str) {
        return new MoodElement(new MoodElement.MoodSubjectElement(mood, moodConcretisation), str);
    }

    public static void addMoodToMessage(Message message, Mood mood) {
        addMoodToMessage(message, mood, null);
    }

    public static void addMoodToMessage(Message message, Mood mood, MoodConcretisation moodConcretisation) {
        message.addExtension(buildMood(mood, moodConcretisation, null));
    }

    public boolean addMoodListener(PepEventListener<MoodElement> pepEventListener) {
        return this.pepManager.addPepEventListener("http://jabber.org/protocol/mood", MoodElement.class, pepEventListener);
    }

    public boolean removeMoodListener(PepEventListener<MoodElement> pepEventListener) {
        return this.pepManager.removePepEventListener(pepEventListener);
    }
}
