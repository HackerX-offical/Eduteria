package org.jivesoftware.smackx.attention.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public class AttentionExtension implements ExtensionElement {
    public static final String ELEMENT_NAME = "attention";
    public static final String NAMESPACE = "urn:xmpp:attention:0";

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT_NAME;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).closeEmptyElement();
    }

    public static class Provider extends ExtensionElementProvider<AttentionExtension> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AttentionExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
            return new AttentionExtension();
        }
    }
}
