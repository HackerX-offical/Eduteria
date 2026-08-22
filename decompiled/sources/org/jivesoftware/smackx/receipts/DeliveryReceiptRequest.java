package org.jivesoftware.smackx.receipts;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class DeliveryReceiptRequest implements ExtensionElement {
    public static final String ELEMENT = "request";
    public static final String NAMESPACE = "urn:xmpp:receipts";
    public static final QName QNAME = new QName("urn:xmpp:receipts", "request");

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "request";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:receipts";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<request xmlns='urn:xmpp:receipts'/>";
    }

    @Deprecated
    public static DeliveryReceiptRequest getFrom(Stanza stanza) {
        return from(stanza);
    }

    public static DeliveryReceiptRequest from(Stanza stanza) {
        return (DeliveryReceiptRequest) stanza.getExtension(DeliveryReceiptRequest.class);
    }

    public static String addTo(Message message) {
        message.throwIfNoStanzaId();
        message.addExtension(new DeliveryReceiptRequest());
        return message.getStanzaId();
    }

    public static void addTo(MessageBuilder messageBuilder) {
        messageBuilder.throwIfNoStanzaId();
        messageBuilder.overrideExtension(new DeliveryReceiptRequest());
    }

    public static class Provider extends ExtensionElementProvider<DeliveryReceiptRequest> {
        @Override // org.jivesoftware.smack.provider.Provider
        public DeliveryReceiptRequest parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            return new DeliveryReceiptRequest();
        }
    }
}
