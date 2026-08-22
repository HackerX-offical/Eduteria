package org.jivesoftware.smack.compress.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public final class Compressed implements Nonza {
    public static final String NAMESPACE = "http://jabber.org/protocol/compress";
    public static final String ELEMENT = "compressed";
    public static final QName QNAME = new QName("http://jabber.org/protocol/compress", ELEMENT);
    public static final Compressed INSTANCE = new Compressed();

    private Compressed() {
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/compress";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<compressed xmlns='http://jabber.org/protocol/compress'/>";
    }
}
