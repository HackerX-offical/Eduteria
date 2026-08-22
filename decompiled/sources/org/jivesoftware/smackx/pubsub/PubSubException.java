package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PubSubException extends SmackException {
    private static final long serialVersionUID = 1;
    private final String nodeId;

    protected PubSubException(String str) {
        this.nodeId = str;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public static class NotALeafNodeException extends PubSubException {
        private static final long serialVersionUID = 1;
        private final BareJid pubSubService;

        NotALeafNodeException(String str, BareJid bareJid) {
            super(str);
            this.pubSubService = bareJid;
        }

        public BareJid getPubSubService() {
            return this.pubSubService;
        }
    }

    public static class NotAPubSubNodeException extends PubSubException {
        private static final long serialVersionUID = 1;
        private final DiscoverInfo discoverInfo;

        NotAPubSubNodeException(String str, DiscoverInfo discoverInfo) {
            super(str);
            this.discoverInfo = discoverInfo;
        }

        public DiscoverInfo getDiscoverInfo() {
            return this.discoverInfo;
        }
    }
}
