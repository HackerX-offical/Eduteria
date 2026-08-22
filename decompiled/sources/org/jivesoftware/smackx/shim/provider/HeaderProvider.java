package org.jivesoftware.smackx.shim.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.shim.packet.Header;

/* JADX INFO: loaded from: classes10.dex */
public class HeaderProvider extends ExtensionElementProvider<Header> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Header parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        xmlPullParser.next();
        String text = xmlPullParser.getEventType() == XmlPullParser.Event.TEXT_CHARACTERS ? xmlPullParser.getText() : null;
        while (xmlPullParser.getEventType() != XmlPullParser.Event.END_ELEMENT) {
            xmlPullParser.next();
        }
        return new Header(attributeValue, text);
    }
}
