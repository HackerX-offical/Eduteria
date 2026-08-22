package org.jivesoftware.smackx.last_interaction.provider;

import java.text.ParseException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.last_interaction.element.IdleElement;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class IdleProvider extends ExtensionElementProvider<IdleElement> {
    public static final IdleProvider TEST_INSTANCE = new IdleProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public IdleElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws SmackParsingException.SmackTextParseException {
        try {
            return new IdleElement(XmppDateTime.parseXEP0082Date(xmlPullParser.getAttributeValue(null, IdleElement.ATTR_SINCE)));
        } catch (ParseException e2) {
            throw new SmackParsingException.SmackTextParseException(e2);
        }
    }
}
