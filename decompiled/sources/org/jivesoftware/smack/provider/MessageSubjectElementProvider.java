package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class MessageSubjectElementProvider extends ExtensionElementProvider<Message.Subject> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Message.Subject parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return new Message.Subject(ParserUtils.getXmlLang(xmlPullParser), xmlPullParser.nextText());
    }
}
