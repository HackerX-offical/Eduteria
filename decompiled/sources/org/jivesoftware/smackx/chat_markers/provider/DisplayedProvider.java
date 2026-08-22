package org.jivesoftware.smackx.chat_markers.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

/* JADX INFO: loaded from: classes10.dex */
public class DisplayedProvider extends ExtensionElementProvider<ChatMarkersElements.DisplayedExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public ChatMarkersElements.DisplayedExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new ChatMarkersElements.DisplayedExtension(xmlPullParser.getAttributeValue("", "id"));
    }
}
