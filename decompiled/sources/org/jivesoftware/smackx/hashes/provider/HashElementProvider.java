package org.jivesoftware.smackx.hashes.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hashes.HashManager;
import org.jivesoftware.smackx.hashes.element.HashElement;

/* JADX INFO: loaded from: classes10.dex */
public class HashElementProvider extends ExtensionElementProvider<HashElement> {
    public static final HashElementProvider INSTANCE = new HashElementProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public HashElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, HashElement.ATTR_ALGO);
        return new HashElement(HashManager.ALGORITHM.valueOfName(attributeValue), xmlPullParser.nextText());
    }
}
