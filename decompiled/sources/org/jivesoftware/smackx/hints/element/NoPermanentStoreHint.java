package org.jivesoftware.smackx.hints.element;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public final class NoPermanentStoreHint extends MessageProcessingHint {
    public static final String ELEMENT = "no-permanent-store";
    public static final NoPermanentStoreHint INSTANCE = new NoPermanentStoreHint();

    private NoPermanentStoreHint() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<no-permanent-store xmlns='urn:xmpp:hints'/>";
    }

    @Override // org.jivesoftware.smackx.hints.element.MessageProcessingHint
    public MessageProcessingHintType getHintType() {
        return MessageProcessingHintType.no_permanent_store;
    }

    public static NoPermanentStoreHint from(Message message) {
        return (NoPermanentStoreHint) message.getExtensionElement(ELEMENT, MessageProcessingHint.NAMESPACE);
    }

    public static boolean hasHint(Message message) {
        return from(message) != null;
    }

    public static void set(Message message) {
        if (StoreHint.hasHint(message)) {
            return;
        }
        message.overrideExtension(INSTANCE);
    }

    public static void setExplicitly(Message message) {
        message.addExtension(INSTANCE);
    }
}
