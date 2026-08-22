package org.jivesoftware.smackx.carbons.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.forward.packet.Forwarded;

/* JADX INFO: loaded from: classes10.dex */
public class CarbonExtension implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:carbons:2";
    private final Direction dir;
    private final Forwarded<Message> fwd;

    public enum Direction {
        received,
        sent
    }

    public CarbonExtension(Direction direction, Forwarded<Message> forwarded) {
        this.dir = direction;
        this.fwd = forwarded;
    }

    public Direction getDirection() {
        return this.dir;
    }

    public Forwarded<Message> getForwarded() {
        return this.fwd;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.dir.name();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:carbons:2";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.fwd.toXML());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    @Deprecated
    public static CarbonExtension getFrom(Message message) {
        return from(message);
    }

    public static CarbonExtension from(Message message) {
        CarbonExtension carbonExtension = (CarbonExtension) message.getExtensionElement(Direction.received.name(), "urn:xmpp:carbons:2");
        return carbonExtension == null ? (CarbonExtension) message.getExtensionElement(Direction.sent.name(), "urn:xmpp:carbons:2") : carbonExtension;
    }

    public static final class Private implements ExtensionElement {
        public static final String ELEMENT = "private";
        public static final Private INSTANCE = new Private();

        private Private() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "private";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "urn:xmpp:carbons:2";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<private xmlns='urn:xmpp:carbons:2'/>";
        }

        public static void addTo(MessageBuilder messageBuilder) {
            messageBuilder.addExtension(INSTANCE);
        }

        @Deprecated
        public static void addTo(Message message) {
            message.addExtension(INSTANCE);
        }
    }
}
