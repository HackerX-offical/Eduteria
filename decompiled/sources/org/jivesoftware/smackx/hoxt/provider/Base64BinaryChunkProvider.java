package org.jivesoftware.smackx.hoxt.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk;

/* JADX INFO: loaded from: classes10.dex */
public class Base64BinaryChunkProvider extends ExtensionElementProvider<Base64BinaryChunk> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Base64BinaryChunk parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", Base64BinaryChunk.ATTRIBUTE_STREAM_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue("", Base64BinaryChunk.ATTRIBUTE_NR);
        String attributeValue3 = xmlPullParser.getAttributeValue("", "last");
        int i2 = Integer.parseInt(attributeValue2);
        boolean z = false;
        boolean z2 = attributeValue3 != null ? Boolean.parseBoolean(attributeValue3) : false;
        String text = null;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.END_ELEMENT) {
                if (!xmlPullParser.getName().equals(Base64BinaryChunk.ELEMENT_CHUNK)) {
                    throw new IllegalArgumentException("unexpected end tag of: " + xmlPullParser.getName());
                }
                z = true;
            } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                text = xmlPullParser.getText();
            } else {
                throw new IllegalArgumentException("unexpected eventType: " + next);
            }
        }
        return new Base64BinaryChunk(text, attributeValue, i2, z2);
    }
}
