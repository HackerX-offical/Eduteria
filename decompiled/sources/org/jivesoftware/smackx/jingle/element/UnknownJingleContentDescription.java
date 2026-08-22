package org.jivesoftware.smackx.jingle.element;

import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public final class UnknownJingleContentDescription extends JingleContentDescription {
    private final StandardExtensionElement standardExtensionElement;

    public UnknownJingleContentDescription(StandardExtensionElement standardExtensionElement) {
        super(standardExtensionElement.getElements());
        this.standardExtensionElement = standardExtensionElement;
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentDescription, org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.standardExtensionElement.getElementName();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return this.standardExtensionElement.getNamespace();
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentDescription, org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return this.standardExtensionElement.toXML(xmlEnvironment);
    }

    public StandardExtensionElement getStandardExtensionElement() {
        return this.standardExtensionElement;
    }
}
