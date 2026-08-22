package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class BodyElementProvider extends ExtensionElementProvider<Message.Body> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Message.Body parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new Message.Body(ParserUtils.getXmlLang(xmlPullParser), PacketParserUtils.parseElementText(xmlPullParser));
    }
}
