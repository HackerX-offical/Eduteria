package org.jivesoftware.smackx.message_retraction.provider;

import java.io.IOException;
import java.util.Date;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.message_retraction.element.RetractedElement;
import org.jivesoftware.smackx.sid.element.OriginIdElement;
import org.jivesoftware.smackx.sid.provider.OriginIdProvider;

/* JADX INFO: loaded from: classes10.dex */
public class RetractedElementProvider extends ExtensionElementProvider<RetractedElement> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.Provider
    public RetractedElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Date dateFromXep82String = ParserUtils.getDateFromXep82String(xmlPullParser.getAttributeValue("", "stamp"));
        OriginIdElement originIdElement = null;
        while (originIdElement == null) {
            if (xmlPullParser.nextTag() == XmlPullParser.TagEvent.START_ELEMENT && OriginIdElement.ELEMENT.equals(xmlPullParser.getName()) && "urn:xmpp:sid:0".equals(xmlPullParser.getNamespace())) {
                originIdElement = (OriginIdElement) OriginIdProvider.INSTANCE.parse(xmlPullParser);
            }
        }
        return new RetractedElement(dateFromXep82String, originIdElement);
    }
}
