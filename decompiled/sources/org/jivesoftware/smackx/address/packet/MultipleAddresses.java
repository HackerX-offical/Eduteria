package org.jivesoftware.smackx.address.packet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MultipleAddresses implements ExtensionElement {
    private final List<Address> addresses = new ArrayList();
    public static final String NAMESPACE = "http://jabber.org/protocol/address";
    public static final String ELEMENT = "addresses";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);

    public enum Type {
        bcc,
        cc,
        noreply,
        replyroom,
        replyto,
        to,
        ofrom
    }

    public void addAddress(Type type, Jid jid, String str, String str2, boolean z, String str3) {
        Address address = new Address(type);
        address.setJid(jid);
        address.setNode(str);
        address.setDescription(str2);
        address.setDelivered(z);
        address.setUri(str3);
        this.addresses.add(address);
    }

    public void setNoReply() {
        this.addresses.add(new Address(Type.noreply));
    }

    public List<Address> getAddressesOfType(Type type) {
        ArrayList arrayList = new ArrayList(this.addresses.size());
        for (Address address : this.addresses) {
            if (address.getType().equals(type)) {
                arrayList.add(address);
            }
        }
        return arrayList;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        Iterator<Address> it = this.addresses.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next().toXML());
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static final class Address implements ExtensionElement {
        public static final String ELEMENT = "address";
        private boolean delivered;
        private String description;
        private Jid jid;
        private String node;
        private final Type type;
        private String uri;

        private Address(Type type) {
            this.type = type;
        }

        public Type getType() {
            return this.type;
        }

        public Jid getJid() {
            return this.jid;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setJid(Jid jid) {
            this.jid = jid;
        }

        public String getNode() {
            return this.node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNode(String str) {
            this.node = str;
        }

        public String getDescription() {
            return this.description;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescription(String str) {
            this.description = str;
        }

        public boolean isDelivered() {
            return this.delivered;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDelivered(boolean z) {
            this.delivered = z;
        }

        public String getUri() {
            return this.uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUri(String str) {
            this.uri = str;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "address";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return MultipleAddresses.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("type", this.type);
            xmlStringBuilder.optAttribute("jid", this.jid);
            xmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
            xmlStringBuilder.optAttribute("desc", this.description);
            String str = this.description;
            if (str != null && str.trim().length() > 0) {
                xmlStringBuilder.append((CharSequence) " desc=\"");
                xmlStringBuilder.append((CharSequence) this.description).append('\"');
            }
            xmlStringBuilder.optBooleanAttribute("delivered", this.delivered);
            xmlStringBuilder.optAttribute("uri", this.uri);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }
}
