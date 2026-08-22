package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public final class Bind extends IQ {
    public static final String ELEMENT = "bind";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-bind";
    private final EntityFullJid jid;
    private final Resourcepart resource;

    private Bind(Resourcepart resourcepart, EntityFullJid entityFullJid) {
        super(ELEMENT, NAMESPACE);
        this.resource = resourcepart;
        this.jid = entityFullJid;
    }

    public Resourcepart getResource() {
        return this.resource;
    }

    public EntityFullJid getJid() {
        return this.jid;
    }

    public static Bind newSet(Resourcepart resourcepart) {
        Bind bind = new Bind(resourcepart, null);
        bind.setType(IQ.Type.set);
        return bind;
    }

    public static Bind newResult(EntityFullJid entityFullJid) {
        return new Bind(null, entityFullJid);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("resource", (CharSequence) this.resource);
        iQChildElementXmlStringBuilder.optElement("jid", (CharSequence) this.jid);
        return iQChildElementXmlStringBuilder;
    }

    public static final class Feature implements ExtensionElement {
        public static final QName QNAME = new QName(Bind.NAMESPACE, Bind.ELEMENT);
        public static final Feature INSTANCE = new Feature();

        private Feature() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return Bind.ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return Bind.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<bind xmlns='urn:ietf:params:xml:ns:xmpp-bind'/>";
        }
    }
}
