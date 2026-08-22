package org.jivesoftware.smackx.pubsub;

import com.appnew.android.Utils.Const;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class Subscription extends NodeExtension {
    protected boolean configRequired;
    protected String id;
    protected Jid jid;
    protected State state;

    public enum State {
        subscribed,
        unconfigured,
        pending,
        none
    }

    public Subscription(Jid jid) {
        this(jid, null, null, null);
    }

    public Subscription(Jid jid, String str) {
        this(jid, str, null, null);
    }

    public Subscription(Jid jid, State state) {
        this(jid, null, null, state);
    }

    public Subscription(Jid jid, String str, String str2, State state) {
        super(PubSubElementType.SUBSCRIPTION, str);
        this.configRequired = false;
        this.jid = jid;
        this.id = str2;
        this.state = state;
    }

    public Subscription(Jid jid, String str, String str2, State state, boolean z) {
        super(PubSubElementType.SUBSCRIPTION, str);
        this.jid = jid;
        this.id = str2;
        this.state = state;
        this.configRequired = z;
    }

    public Jid getJid() {
        return this.jid;
    }

    public String getId() {
        return this.id;
    }

    public State getState() {
        return this.state;
    }

    public boolean isConfigRequired() {
        return this.configRequired;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute("jid", this.jid);
        xmlStringBuilder.optAttribute("subid", this.id);
        xmlStringBuilder.optAttribute(Const.SUBSCRIPTION, this.state);
        xmlStringBuilder.closeEmptyElement();
    }
}
