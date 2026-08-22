package org.jivesoftware.smackx.iot.provisioning.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public class Unfriend implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";
    private final BareJid jid;
    public static final String ELEMENT = "UNFRIEND";
    public static final QName QNAME = new QName("urn:xmpp:iot:provisioning", ELEMENT);

    public Unfriend(BareJid bareJid) {
        this.jid = bareJid;
    }

    public BareJid getJid() {
        return this.jid;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:iot:provisioning";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("jid", this.jid);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public static Unfriend from(Message message) {
        return (Unfriend) message.getExtension(Unfriend.class);
    }
}
