package org.jivesoftware.smackx.pubsub;

import com.clevertap.android.sdk.Constants;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

/* JADX INFO: loaded from: classes10.dex */
public class NodeExtension implements ExtensionElement {
    private final PubSubElementType element;
    private final String node;

    public NodeExtension(PubSubElementType pubSubElementType, String str) {
        this.element = pubSubElementType;
        this.node = str;
    }

    public NodeExtension(PubSubElementType pubSubElementType) {
        this(pubSubElementType, null);
    }

    public String getNode() {
        return this.node;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.element.getElementName();
    }

    public PubSubNamespace getPubSubNamespace() {
        return this.element.getNamespace();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public final String getNamespace() {
        return getPubSubNamespace().getXmlns();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        addXml(xmlStringBuilder);
        return xmlStringBuilder;
    }

    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.closeEmptyElement();
    }

    public String toString() {
        return getClass().getName() + " - content [" + ((Object) toXML()) + Constants.AES_SUFFIX;
    }
}
