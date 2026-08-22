package org.jivesoftware.smackx.chat_markers.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

/* JADX INFO: loaded from: classes10.dex */
public class AcknowledgedProvider extends ExtensionElementProvider<ChatMarkersElements.AcknowledgedExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public ChatMarkersElements.AcknowledgedExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new ChatMarkersElements.AcknowledgedExtension(xmlPullParser.getAttributeValue("", "id"));
    }
}
