package org.jivesoftware.smackx.jingle.element;

import java.util.List;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public final class UnknownJingleContentTransport extends JingleContentTransport {
    private final StandardExtensionElement standardExtensionElement;

    public UnknownJingleContentTransport(StandardExtensionElement standardExtensionElement) {
        super(null, null);
        this.standardExtensionElement = standardExtensionElement;
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentTransport, org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.standardExtensionElement.getElementName();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return this.standardExtensionElement.getNamespace();
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentTransport, org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return this.standardExtensionElement.toXML(xmlEnvironment);
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentTransport
    public List<JingleContentTransportCandidate> getCandidates() {
        throw new UnsupportedOperationException();
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentTransport
    public JingleContentTransportInfo getInfo() {
        throw new UnsupportedOperationException();
    }

    public StandardExtensionElement getStandardExtensionElement() {
        return this.standardExtensionElement;
    }
}
