package org.jivesoftware.smackx.message_retraction.element;

import java.util.Date;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

/* JADX INFO: loaded from: classes10.dex */
public class RetractedElement implements ExtensionElement {
    public static final String ATTR_STAMP = "stamp";
    public static final String ELEMENT = "retracted";
    private final OriginIdElement originId;
    private final Date stamp;

    public RetractedElement(Date date, OriginIdElement originIdElement) {
        this.stamp = date;
        this.originId = originIdElement;
    }

    public Date getStamp() {
        return this.stamp;
    }

    public OriginIdElement getOriginId() {
        return this.originId;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return RetractElement.NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).attribute("stamp", getStamp()).rightAngleBracket().append(getOriginId()).closeElement(this);
    }
}
