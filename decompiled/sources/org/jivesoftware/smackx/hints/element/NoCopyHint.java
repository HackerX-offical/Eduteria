package org.jivesoftware.smackx.hints.element;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public final class NoCopyHint extends MessageProcessingHint {
    public static final String ELEMENT = "no-copy";
    public static final NoCopyHint INSTANCE = new NoCopyHint();

    private NoCopyHint() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<no-copy xmlns='urn:xmpp:hints'/>";
    }

    @Override // org.jivesoftware.smackx.hints.element.MessageProcessingHint
    public MessageProcessingHintType getHintType() {
        return MessageProcessingHintType.no_copy;
    }

    public static NoCopyHint from(Message message) {
        return (NoCopyHint) message.getExtensionElement(ELEMENT, MessageProcessingHint.NAMESPACE);
    }

    public static boolean hasHint(Message message) {
        return from(message) != null;
    }

    public static void set(Message message) {
        message.overrideExtension(INSTANCE);
    }
}
