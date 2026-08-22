package org.jivesoftware.smackx.reference.provider;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: loaded from: classes10.dex */
public class ReferenceProvider extends ExtensionElementProvider<ReferenceElement> {
    public static final ReferenceProvider TEST_PROVIDER = new ReferenceProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public ReferenceElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        URI uri;
        Integer integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, ReferenceElement.ATTR_BEGIN);
        Integer integerAttribute2 = ParserUtils.getIntegerAttribute(xmlPullParser, "end");
        ReferenceElement.Type typeValueOf = ReferenceElement.Type.valueOf(xmlPullParser.getAttributeValue(null, "type"));
        String attributeValue = xmlPullParser.getAttributeValue(null, ReferenceElement.ATTR_ANCHOR);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "uri");
        if (attributeValue2 != null) {
            try {
                uri = new URI(attributeValue2);
            } catch (URISyntaxException e2) {
                throw new IOException(e2);
            }
        } else {
            uri = null;
        }
        ExtensionElement extensionElement = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(xmlPullParser.getName(), xmlPullParser.getNamespace());
                if (extensionProvider != null) {
                    extensionElement = extensionProvider.parse(xmlPullParser);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT) {
                return new ReferenceElement(integerAttribute, integerAttribute2, typeValueOf, attributeValue, uri, extensionElement);
            }
        }
    }
}
