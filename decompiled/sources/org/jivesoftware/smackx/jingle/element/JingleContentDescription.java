package org.jivesoftware.smackx.jingle.element;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleContentDescription implements ExtensionElement {
    public static final String ELEMENT = "description";
    private final List<NamedElement> payloads;

    protected void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
    }

    protected JingleContentDescription(List<? extends NamedElement> list) {
        if (list != null) {
            this.payloads = Collections.unmodifiableList(list);
        } else {
            this.payloads = Collections.emptyList();
        }
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "description";
    }

    public List<NamedElement> getJingleContentDescriptionChildren() {
        return this.payloads;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        addExtraAttributes(xmlStringBuilder);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.payloads);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
