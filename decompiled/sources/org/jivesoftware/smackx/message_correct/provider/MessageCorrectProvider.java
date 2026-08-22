package org.jivesoftware.smackx.message_correct.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.message_correct.element.MessageCorrectExtension;

/* JADX INFO: loaded from: classes10.dex */
public class MessageCorrectProvider extends ExtensionElementProvider<MessageCorrectExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MessageCorrectExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new MessageCorrectExtension(xmlPullParser.getAttributeValue("", "id"));
    }
}
