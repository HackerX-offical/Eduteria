package org.jivesoftware.smackx.chatstates.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.chatstates.ChatState;

/* JADX INFO: loaded from: classes10.dex */
public class ChatStateExtension implements ExtensionElement {
    public static final String NAMESPACE = "http://jabber.org/protocol/chatstates";
    private final ChatState state;

    public ChatStateExtension(ChatState chatState) {
        this.state = chatState;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.state.name();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/chatstates";
    }

    public ChatState getChatState() {
        return this.state;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
