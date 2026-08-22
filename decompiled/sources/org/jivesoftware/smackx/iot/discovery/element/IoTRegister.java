package org.jivesoftware.smackx.iot.discovery.element;

import java.util.Collection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;

/* JADX INFO: loaded from: classes10.dex */
public class IoTRegister extends IQ {
    public static final String ELEMENT = "register";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final NodeInfo nodeInfo;
    private final boolean selfOwned;
    private final Collection<Tag> tags;

    public IoTRegister(Collection<Tag> collection, NodeInfo nodeInfo, boolean z) {
        super("register", "urn:xmpp:iot:discovery");
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.tags = collection;
        this.nodeInfo = nodeInfo;
        this.selfOwned = z;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        this.nodeInfo.appendTo(iQChildElementXmlStringBuilder);
        iQChildElementXmlStringBuilder.optBooleanAttribute("selfOwned", this.selfOwned);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append(this.tags);
        return iQChildElementXmlStringBuilder;
    }
}
