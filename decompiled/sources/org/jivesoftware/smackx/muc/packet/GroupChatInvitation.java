package org.jivesoftware.smackx.muc.packet;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class GroupChatInvitation implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "jabber:x:conference";
    public static final QName QNAME = new QName(NAMESPACE, "x");
    private final String roomAddress;

    public GroupChatInvitation(String str) {
        this.roomAddress = str;
    }

    public String getRoomAddress() {
        return this.roomAddress;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("jid", getRoomAddress());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public static GroupChatInvitation from(Stanza stanza) {
        return (GroupChatInvitation) stanza.getExtension(GroupChatInvitation.class);
    }

    public static class Provider extends ExtensionElementProvider<GroupChatInvitation> {
        @Override // org.jivesoftware.smack.provider.Provider
        public GroupChatInvitation parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            String attributeValue = xmlPullParser.getAttributeValue("", "jid");
            xmlPullParser.next();
            return new GroupChatInvitation(attributeValue);
        }
    }
}
