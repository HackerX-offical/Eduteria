package org.jivesoftware.smackx.message_retraction.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class RetractElement implements ExtensionElement {
    public static final String ELEMENT = "retract";
    public static final String NAMESPACE = "urn:xmpp:message-retract:0";
    private static final String NAMESPACE_0 = "urn:xmpp:message-retract:0";
    private static final String NAMESPACE_WITHOUT_VERSION = "urn:xmpp:message-retract";

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:message-retract:0";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).closeEmptyElement();
    }
}
