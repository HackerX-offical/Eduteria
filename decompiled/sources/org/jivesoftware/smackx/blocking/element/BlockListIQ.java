package org.jivesoftware.smackx.blocking.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class BlockListIQ extends IQ {
    public static final String ELEMENT = "blocklist";
    public static final String NAMESPACE = "urn:xmpp:blocking";
    private final List<Jid> jids;

    public BlockListIQ(List<Jid> list) {
        super(ELEMENT, "urn:xmpp:blocking");
        if (list == null) {
            this.jids = Collections.emptyList();
        } else {
            this.jids = Collections.unmodifiableList(list);
        }
    }

    public BlockListIQ() {
        this(null);
    }

    public List<Jid> getBlockedJids() {
        return this.jids;
    }

    public List<Jid> getBlockedJidsCopy() {
        return new ArrayList(getBlockedJids());
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (this.jids.isEmpty()) {
            iQChildElementXmlStringBuilder.setEmptyElement();
            return iQChildElementXmlStringBuilder;
        }
        iQChildElementXmlStringBuilder.rightAngleBracket();
        for (Jid jid : this.jids) {
            iQChildElementXmlStringBuilder.halfOpenElement("item");
            iQChildElementXmlStringBuilder.attribute("jid", jid);
            iQChildElementXmlStringBuilder.closeEmptyElement();
        }
        return iQChildElementXmlStringBuilder;
    }
}
