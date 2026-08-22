package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes10.dex */
public final class TlsFailure implements Nonza {
    public static final String ELEMENT = "failure";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-tls";
    public static final TlsFailure INSTANCE = new TlsFailure();
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-tls", "failure");

    private TlsFailure() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "failure";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-tls";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<failure xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>";
    }
}
