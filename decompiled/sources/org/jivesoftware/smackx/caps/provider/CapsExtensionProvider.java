package org.jivesoftware.smackx.caps.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.caps.packet.CapsExtension;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: loaded from: classes10.dex */
public class CapsExtensionProvider extends ExtensionElementProvider<CapsExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public CapsExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equalsIgnoreCase("c")) {
            String attributeValue = xmlPullParser.getAttributeValue(null, HashElement.ELEMENT);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, RosterVer.ELEMENT);
            String attributeValue3 = xmlPullParser.getAttributeValue(null, NodeElement.ELEMENT);
            xmlPullParser.next();
            if (xmlPullParser.getEventType() != XmlPullParser.Event.END_ELEMENT || !xmlPullParser.getName().equalsIgnoreCase("c")) {
                throw new IOException("Malformed nested Caps element");
            }
            if (attributeValue != null && attributeValue2 != null && attributeValue3 != null) {
                return new CapsExtension(attributeValue3, attributeValue2, attributeValue);
            }
            throw new IOException("Caps element with missing attributes. Attributes: hash=" + attributeValue + " version=" + attributeValue2 + " node=" + attributeValue3);
        }
        throw new IOException("Malformed Caps element");
    }
}
