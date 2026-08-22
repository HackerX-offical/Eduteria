package org.jivesoftware.smackx.push_notifications.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class PushNotificationsElements {
    public static final String NAMESPACE = "urn:xmpp:push:0";

    public static class RemoteDisablingExtension implements ExtensionElement {
        public static final String ELEMENT = "pubsub";
        public static final String NAMESPACE = "http://jabber.org/protocol/pubsub";
        public static final QName QNAME = new QName("http://jabber.org/protocol/pubsub", "pubsub");
        private final String node;
        private final Jid userJid;

        public RemoteDisablingExtension(String str, Jid jid) {
            this.node = str;
            this.userJid = jid;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "pubsub";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "http://jabber.org/protocol/pubsub";
        }

        public String getNode() {
            return this.node;
        }

        public Jid getUserJid() {
            return this.userJid;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.attribute(NodeElement.ELEMENT, this.node);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.halfOpenElement("affiliation");
            xmlStringBuilder.attribute("jid", this.userJid);
            xmlStringBuilder.attribute("affiliation", "none");
            xmlStringBuilder.closeEmptyElement();
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public static RemoteDisablingExtension from(Message message) {
            return (RemoteDisablingExtension) message.getExtension(RemoteDisablingExtension.class);
        }
    }
}
