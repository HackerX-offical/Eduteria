package org.jivesoftware.smackx.iqregister.packet;

import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public class Registration extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:register";
    private final Map<String, String> attributes;
    private final String instructions;

    public Registration() {
        this(null);
    }

    public Registration(Map<String, String> map) {
        this(null, map);
    }

    public Registration(String str, Map<String, String> map) {
        super("query", NAMESPACE);
        this.instructions = str;
        this.attributes = map;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("instructions", this.instructions);
        Map<String, String> map = this.attributes;
        if (map != null && map.size() > 0) {
            for (String str : this.attributes.keySet()) {
                iQChildElementXmlStringBuilder.element(str, this.attributes.get(str));
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public static final class Feature implements ExtensionElement {
        public static final String ELEMENT = "register";
        public static final String NAMESPACE = "http://jabber.org/features/iq-register";
        public static final QName QNAME = new QName(NAMESPACE, "register");
        public static final Feature INSTANCE = new Feature();

        private Feature() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "register";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return "<register xmlns='http://jabber.org/features/iq-register'/>";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return NAMESPACE;
        }
    }
}
