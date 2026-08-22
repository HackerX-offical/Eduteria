package org.jivesoftware.smackx.blocking.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class BlockedErrorExtension implements ExtensionElement {
    public static final String ELEMENT = "blocked";
    public static final String NAMESPACE = "urn:xmpp:blocking:errors";

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public static BlockedErrorExtension from(Message message) {
        StanzaError error = message.getError();
        if (error == null) {
            return null;
        }
        return (BlockedErrorExtension) error.getExtension(ELEMENT, NAMESPACE);
    }

    public static boolean isInside(Message message) {
        return from(message) != null;
    }
}
