package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

/* JADX INFO: loaded from: classes10.dex */
public class RetractItem implements ExtensionElement {
    private final String id;

    public RetractItem(String str) {
        if (str == null) {
            throw new IllegalArgumentException("itemId must not be 'null'");
        }
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return RetractElement.ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return PubSubNamespace.event.getXmlns();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<retract id='" + this.id + "'/>";
    }
}
