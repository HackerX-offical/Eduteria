package org.jivesoftware.smackx.chat_markers.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.chat_markers.ChatMarkersState;

/* JADX INFO: loaded from: classes10.dex */
public class ChatMarkersElements {
    public static final String NAMESPACE = "urn:xmpp:chat-markers:0";

    public static final class MarkableExtension implements ExtensionElement {
        public static final String ELEMENT;
        public static final MarkableExtension INSTANCE = new MarkableExtension();
        public static final QName QNAME;

        static {
            String string = ChatMarkersState.markable.toString();
            ELEMENT = string;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, string);
        }

        private MarkableExtension() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public static MarkableExtension from(Message message) {
            return (MarkableExtension) message.getExtension(MarkableExtension.class);
        }
    }

    protected static abstract class ChatMarkerExtensionWithId implements ExtensionElement {
        protected final String id;

        protected ChatMarkerExtensionWithId(String str) {
            this.id = (String) StringUtils.requireNotNullNorEmpty(str, "Message ID must not be null");
        }

        public final String getId() {
            return this.id;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.attribute("id", this.id);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class ReceivedExtension extends ChatMarkerExtensionWithId {
        public static final String ELEMENT;
        public static final QName QNAME;

        static {
            String string = ChatMarkersState.received.toString();
            ELEMENT = string;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, string);
        }

        public ReceivedExtension(String str) {
            super(str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }

        public static ReceivedExtension from(Message message) {
            return (ReceivedExtension) message.getExtension(ReceivedExtension.class);
        }
    }

    public static class DisplayedExtension extends ChatMarkerExtensionWithId {
        public static final String ELEMENT;
        public static final QName QNAME;

        static {
            String string = ChatMarkersState.displayed.toString();
            ELEMENT = string;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, string);
        }

        public DisplayedExtension(String str) {
            super(str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }

        public static DisplayedExtension from(Message message) {
            return (DisplayedExtension) message.getExtension(DisplayedExtension.class);
        }
    }

    public static class AcknowledgedExtension extends ChatMarkerExtensionWithId {
        public static final String ELEMENT;
        public static final QName QNAME;

        static {
            String string = ChatMarkersState.acknowledged.toString();
            ELEMENT = string;
            QNAME = new QName(ChatMarkersElements.NAMESPACE, string);
        }

        public AcknowledgedExtension(String str) {
            super(str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ChatMarkersElements.NAMESPACE;
        }

        public static AcknowledgedExtension from(Message message) {
            return (AcknowledgedExtension) message.getExtension(AcknowledgedExtension.class);
        }
    }
}
