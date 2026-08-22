package org.jivesoftware.smackx.shim.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Header implements ExtensionElement {
    public static final String ELEMENT = "header";
    private final String name;
    private final String value;

    public Header(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "header";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return HeadersExtension.NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
        xmlStringBuilder.attribute("name", this.name);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.escape(this.value);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
