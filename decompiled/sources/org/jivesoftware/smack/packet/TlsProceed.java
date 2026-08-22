package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes10.dex */
public final class TlsProceed implements Nonza {
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-tls";
    public static final TlsProceed INSTANCE = new TlsProceed();
    public static final String ELEMENT = "proceed";
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-tls", ELEMENT);

    private TlsProceed() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-tls";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<proceed xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>";
    }
}
