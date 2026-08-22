package org.jivesoftware.smack.xml;

import java.io.Reader;
import java.util.Iterator;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes10.dex */
public class SmackXmlParser {
    private static XmlPullParserFactory xmlPullParserFactory;
    private static final ServiceLoader<XmlPullParserFactory> xmlPullParserFactoryServiceLoader = ServiceLoader.load(XmlPullParserFactory.class);

    public static XmlPullParserFactory getXmlPullParserFactory() {
        XmlPullParserFactory xmlPullParserFactory2 = xmlPullParserFactory;
        if (xmlPullParserFactory2 != null) {
            return xmlPullParserFactory2;
        }
        Iterator<XmlPullParserFactory> it = xmlPullParserFactoryServiceLoader.iterator();
        if (!it.hasNext()) {
            throw new IllegalStateException("No XmlPullParserFactory registered with Service Provider Interface (SPI). Is smack-xmlparser-xpp3 or smack-xmlparser-stax in classpath?");
        }
        return it.next();
    }

    public static void setXmlPullParserFactory(XmlPullParserFactory xmlPullParserFactory2) {
        xmlPullParserFactory = xmlPullParserFactory2;
    }

    public static XmlPullParser newXmlParser(Reader reader) throws XmlPullParserException {
        return getXmlPullParserFactory().newXmlPullParser(reader);
    }
}
