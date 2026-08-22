package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Mechanisms implements ExtensionElement {
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-sasl";
    public final List<String> mechanisms;
    public static final String ELEMENT = "mechanisms";
    public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", ELEMENT);

    public Mechanisms(String str) {
        LinkedList linkedList = new LinkedList();
        this.mechanisms = linkedList;
        linkedList.add(str);
    }

    public Mechanisms(Collection<String> collection) {
        LinkedList linkedList = new LinkedList();
        this.mechanisms = linkedList;
        linkedList.addAll(collection);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-sasl";
    }

    public List<String> getMechanisms() {
        return Collections.unmodifiableList(this.mechanisms);
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        Iterator<String> it = this.mechanisms.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.element("mechanism", it.next());
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
