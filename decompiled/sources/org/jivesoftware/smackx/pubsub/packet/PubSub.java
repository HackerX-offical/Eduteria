package org.jivesoftware.smackx.pubsub.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.pubsub.NodeExtension;
import org.jivesoftware.smackx.pubsub.PubSubElementType;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class PubSub extends IQ {
    public static final String ELEMENT = "pubsub";
    public static final String NAMESPACE = "http://jabber.org/protocol/pubsub";

    public PubSub() {
        super("pubsub", "http://jabber.org/protocol/pubsub");
    }

    public PubSub(PubSubNamespace pubSubNamespace) {
        super("pubsub", pubSubNamespace.getXmlns());
    }

    public PubSub(Jid jid, IQ.Type type, PubSubNamespace pubSubNamespace) {
        super("pubsub", (pubSubNamespace == null ? PubSubNamespace.basic : pubSubNamespace).getXmlns());
        setTo(jid);
        setType(type);
    }

    public <PE extends ExtensionElement> PE getExtension(PubSubElementType pubSubElementType) {
        return (PE) getExtensionElement(pubSubElementType.getElementName(), pubSubElementType.getNamespace().getXmlns());
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public static PubSub createPubsubPacket(Jid jid, IQ.Type type, NodeExtension nodeExtension) {
        PubSub pubSub = new PubSub(jid, type, nodeExtension.getPubSubNamespace());
        pubSub.addExtension(nodeExtension);
        return pubSub;
    }
}
