package org.jivesoftware.smackx.message_fastening.element;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class ExternalElement implements NamedElement {
    public static final String ATTR_ELEMENT_NAMESPACE = "element-namespace";
    public static final String ATTR_NAME = "name";
    public static final String ELEMENT = "external";
    private final String elementNamespace;
    private final String name;

    public ExternalElement(String str) {
        this(str, null);
    }

    public ExternalElement(String str, String str2) {
        this.name = str;
        this.elementNamespace = str2;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
        xmlStringBuilder.attribute("name", getName());
        xmlStringBuilder.optAttribute(ATTR_ELEMENT_NAMESPACE, getElementNamespace());
        return xmlStringBuilder.closeEmptyElement();
    }

    public String getName() {
        return this.name;
    }

    public String getElementNamespace() {
        return this.elementNamespace;
    }
}
