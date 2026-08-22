package org.jivesoftware.smackx.iot.provisioning.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public class Friend implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";
    private final BareJid friend;
    public static final String ELEMENT = "friend";
    public static final QName QNAME = new QName("urn:xmpp:iot:provisioning", ELEMENT);

    public Friend(BareJid bareJid) {
        this.friend = (BareJid) Objects.requireNonNull(bareJid, "Friend must not be null");
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
        xmlStringBuilder.attribute("jid", this.friend);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public BareJid getFriend() {
        return this.friend;
    }

    public static Friend from(Message message) {
        return (Friend) message.getExtension(Friend.class);
    }
}
