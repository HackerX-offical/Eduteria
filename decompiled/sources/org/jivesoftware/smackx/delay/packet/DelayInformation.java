package org.jivesoftware.smackx.delay.packet;

import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class DelayInformation implements ExtensionElement {
    public static final String ELEMENT = "delay";
    public static final String NAMESPACE = "urn:xmpp:delay";
    public static final QName QNAME = new QName(NAMESPACE, "delay");
    private final String from;
    private final String reason;
    private final Date stamp;

    public DelayInformation(Date date, String str, String str2) {
        this.stamp = date;
        this.from = str;
        this.reason = str2;
    }

    public DelayInformation(Date date) {
        this(date, null, null);
    }

    public String getFrom() {
        return this.from;
    }

    public Date getStamp() {
        return this.stamp;
    }

    public String getReason() {
        return this.reason;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "delay";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("stamp", XmppDateTime.formatXEP0082Date(this.stamp));
        xmlStringBuilder.optAttribute("from", this.from);
        xmlStringBuilder.optTextChild(this.reason, this);
        return xmlStringBuilder;
    }

    @Deprecated
    public static DelayInformation getFrom(Stanza stanza) {
        return from(stanza);
    }

    public static DelayInformation from(Stanza stanza) {
        return (DelayInformation) stanza.getExtension(DelayInformation.class);
    }
}
