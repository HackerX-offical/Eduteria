package org.jivesoftware.smackx.mam.element;

import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MamElements {
    public static final String NAMESPACE = "urn:xmpp:mam:2";

    public static class MamResultExtension implements ExtensionElement {
        public static final String ELEMENT = "result";
        public static final QName QNAME = new QName("urn:xmpp:mam:2", "result");
        private final Forwarded<Message> forwarded;
        private final String id;
        private String queryId;

        public MamResultExtension(String str, String str2, Forwarded<Message> forwarded) {
            if (StringUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("id must not be null or empty");
            }
            if (forwarded == null) {
                throw new IllegalArgumentException("forwarded must no be null");
            }
            this.id = str2;
            this.forwarded = forwarded;
            this.queryId = str;
        }

        public String getId() {
            return this.id;
        }

        public Forwarded<Message> getForwarded() {
            return this.forwarded;
        }

        public final String getQueryId() {
            return this.queryId;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "result";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public final String getNamespace() {
            return "urn:xmpp:mam:2";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute("queryid", getQueryId());
            xmlStringBuilder.optAttribute("id", getId());
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append(getForwarded());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public static MamResultExtension from(MessageView messageView) {
            return (MamResultExtension) messageView.getExtension(MamResultExtension.class);
        }
    }

    public static class AlwaysJidListElement implements Element {
        private final List<Jid> alwaysJids;

        AlwaysJidListElement(List<Jid> list) {
            this.alwaysJids = list;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("always");
            Iterator<Jid> it = this.alwaysJids.iterator();
            while (it.hasNext()) {
                xmlStringBuilder.element("jid", it.next());
            }
            xmlStringBuilder.closeElement("always");
            return xmlStringBuilder;
        }
    }

    public static class NeverJidListElement implements Element {
        private List<Jid> neverJids;

        public NeverJidListElement(List<Jid> list) {
            this.neverJids = list;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("never");
            Iterator<Jid> it = this.neverJids.iterator();
            while (it.hasNext()) {
                xmlStringBuilder.element("jid", it.next());
            }
            xmlStringBuilder.closeElement("never");
            return xmlStringBuilder;
        }
    }
}
