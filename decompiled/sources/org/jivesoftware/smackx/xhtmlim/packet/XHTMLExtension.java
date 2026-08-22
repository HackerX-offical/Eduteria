package org.jivesoftware.smackx.xhtmlim.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public final class XHTMLExtension implements ExtensionElement {
    public static final String ELEMENT = "html";
    public static final String NAMESPACE = "http://jabber.org/protocol/xhtml-im";
    public static final QName QNAME = new QName(NAMESPACE, "html");
    private final List<CharSequence> bodies = new ArrayList();

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "html";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        Iterator<CharSequence> it = getBodies().iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next());
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public List<CharSequence> getBodies() {
        List<CharSequence> listUnmodifiableList;
        synchronized (this.bodies) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.bodies));
        }
        return listUnmodifiableList;
    }

    public void addBody(CharSequence charSequence) {
        synchronized (this.bodies) {
            this.bodies.add(charSequence);
        }
    }

    public int getBodiesCount() {
        int size;
        synchronized (this.bodies) {
            size = this.bodies.size();
        }
        return size;
    }

    public static XHTMLExtension from(MessageView messageView) {
        return (XHTMLExtension) messageView.getExtension(XHTMLExtension.class);
    }
}
