package org.jivesoftware.smackx.stanza_content_encryption.element;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class PayloadElement implements NamedElement {
    public static final String ELEMENT = "payload";
    private final List<ExtensionElement> payloadElements;

    public PayloadElement(List<ExtensionElement> list) {
        this.payloadElements = Collections.unmodifiableList(list);
    }

    public List<ExtensionElement> getItems() {
        return this.payloadElements;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "payload";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilderRightAngleBracket = new XmlStringBuilder(this).rightAngleBracket();
        xmlStringBuilderRightAngleBracket.append(this.payloadElements);
        return xmlStringBuilderRightAngleBracket.closeElement(this);
    }
}
