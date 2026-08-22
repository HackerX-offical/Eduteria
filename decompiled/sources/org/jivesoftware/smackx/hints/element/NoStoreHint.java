package org.jivesoftware.smackx.hints.element;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public final class NoStoreHint extends MessageProcessingHint {
    public static final String ELEMENT = "no-store";
    public static final NoStoreHint INSTANCE = new NoStoreHint();

    private NoStoreHint() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "no-store";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<no-store xmlns='urn:xmpp:hints'/>";
    }

    @Override // org.jivesoftware.smackx.hints.element.MessageProcessingHint
    public MessageProcessingHintType getHintType() {
        return MessageProcessingHintType.no_store;
    }

    public static NoStoreHint from(Message message) {
        return (NoStoreHint) message.getExtensionElement("no-store", MessageProcessingHint.NAMESPACE);
    }

    public static boolean hasHint(Message message) {
        return from(message) != null;
    }

    public static void set(Message message) {
        message.overrideExtension(INSTANCE);
    }
}
