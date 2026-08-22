package org.jivesoftware.smackx.receipts;

import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class DeliveryReceipt implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:receipts";
    private final String id;
    public static final String ELEMENT = "received";
    public static final QName QNAME = new QName("urn:xmpp:receipts", ELEMENT);

    public DeliveryReceipt(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:receipts";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute("id", this.id);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    @Deprecated
    public static DeliveryReceipt getFrom(Message message) {
        return from(message);
    }

    public static DeliveryReceipt from(Message message) {
        return (DeliveryReceipt) message.getExtension(DeliveryReceipt.class);
    }

    public static class Provider extends EmbeddedExtensionProvider<DeliveryReceipt> {
        @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
        protected /* bridge */ /* synthetic */ ExtensionElement createReturnExtension(String str, String str2, Map map, List list) {
            return createReturnExtension(str, str2, (Map<String, String>) map, (List<? extends ExtensionElement>) list);
        }

        @Override // org.jivesoftware.smack.provider.EmbeddedExtensionProvider
        protected DeliveryReceipt createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
            return new DeliveryReceipt(map.get("id"));
        }
    }
}
