package org.jivesoftware.smackx.blocking.element;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class BlockContactsIQ extends IQ {
    public static final String ELEMENT = "block";
    public static final String NAMESPACE = "urn:xmpp:blocking";
    private final List<Jid> jids;

    public BlockContactsIQ(List<Jid> list) {
        super(ELEMENT, "urn:xmpp:blocking");
        setType(IQ.Type.set);
        this.jids = Collections.unmodifiableList(list);
    }

    public List<Jid> getJids() {
        return this.jids;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        List<Jid> list = this.jids;
        if (list != null) {
            for (Jid jid : list) {
                iQChildElementXmlStringBuilder.halfOpenElement("item");
                iQChildElementXmlStringBuilder.attribute("jid", jid);
                iQChildElementXmlStringBuilder.closeEmptyElement();
            }
        }
        return iQChildElementXmlStringBuilder;
    }
}
