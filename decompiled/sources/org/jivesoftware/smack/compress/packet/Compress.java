package org.jivesoftware.smack.compress.packet;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Compress implements Nonza {
    public static final String ELEMENT = "compress";
    public static final String NAMESPACE = "http://jabber.org/protocol/compress";
    public final String method;

    public Compress(String str) {
        this.method = str;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/compress";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.element(FirebaseAnalytics.Param.METHOD, this.method);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static class Feature implements ExtensionElement {
        public static final String ELEMENT = "compression";
        public static final QName QNAME = new QName("http://jabber.org/protocol/compress", ELEMENT);
        public final List<String> methods;

        public Feature(List<String> list) {
            this.methods = list;
        }

        public List<String> getMethods() {
            return Collections.unmodifiableList(this.methods);
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "http://jabber.org/protocol/compress";
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.rightAngleBracket();
            Iterator<String> it = this.methods.iterator();
            while (it.hasNext()) {
                xmlStringBuilder.element(FirebaseAnalytics.Param.METHOD, it.next());
            }
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }
}
