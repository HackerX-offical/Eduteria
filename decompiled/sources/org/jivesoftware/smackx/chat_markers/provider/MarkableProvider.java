package org.jivesoftware.smackx.chat_markers.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

/* JADX INFO: loaded from: classes10.dex */
public class MarkableProvider extends ExtensionElementProvider<ChatMarkersElements.MarkableExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public ChatMarkersElements.MarkableExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return ChatMarkersElements.MarkableExtension.INSTANCE;
    }
}
