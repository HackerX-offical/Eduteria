package org.jivesoftware.smackx.chatstates.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;

/* JADX INFO: loaded from: classes10.dex */
public class ChatStateExtensionProvider extends ExtensionElementProvider<ChatStateExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public ChatStateExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new ChatStateExtension(ChatState.valueOf(xmlPullParser.getName()));
    }
}
