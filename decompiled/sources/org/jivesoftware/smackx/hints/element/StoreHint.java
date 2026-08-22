package org.jivesoftware.smackx.hints.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public final class StoreHint extends MessageProcessingHint {
    public static final StoreHint INSTANCE = new StoreHint();
    public static final String ELEMENT = "store";
    public static final QName QNAME = new QName(MessageProcessingHint.NAMESPACE, ELEMENT);

    private StoreHint() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<store xmlns='urn:xmpp:hints'/>";
    }

    @Override // org.jivesoftware.smackx.hints.element.MessageProcessingHint
    public MessageProcessingHintType getHintType() {
        return MessageProcessingHintType.store;
    }

    public static StoreHint from(MessageView messageView) {
        return (StoreHint) messageView.getExtension(StoreHint.class);
    }

    public static boolean hasHint(MessageView messageView) {
        return from(messageView) != null;
    }

    public static void set(MessageBuilder messageBuilder) {
        messageBuilder.overrideExtension(INSTANCE);
    }
}
