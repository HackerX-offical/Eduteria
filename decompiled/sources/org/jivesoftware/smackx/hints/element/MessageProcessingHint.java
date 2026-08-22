package org.jivesoftware.smackx.hints.element;

import org.jivesoftware.smack.packet.ExtensionElement;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MessageProcessingHint implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:hints";

    public abstract MessageProcessingHintType getHintType();

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public final String getNamespace() {
        return NAMESPACE;
    }
}
