package org.jivesoftware.smack.xml.xpp3;

import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.xml.XmlPullParserFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class Xpp3XmlPullParserFactory implements XmlPullParserFactory {
    public static final String FEATURE_XML_ROUNDTRIP = "http://xmlpull.org/v1/doc/features.html#xml-roundtrip";
    private static final Logger LOGGER = Logger.getLogger(Xpp3XmlPullParserFactory.class.getName());
    public static final boolean XML_PULL_PARSER_SUPPORTS_ROUNDTRIP;
    private static final org.xmlpull.v1.XmlPullParserFactory XPP3_XML_PULL_PARSER_FACTORY;

    static {
        boolean z;
        try {
            org.xmlpull.v1.XmlPullParserFactory xmlPullParserFactoryNewInstance = org.xmlpull.v1.XmlPullParserFactory.newInstance();
            XPP3_XML_PULL_PARSER_FACTORY = xmlPullParserFactoryNewInstance;
            try {
                z = true;
                xmlPullParserFactoryNewInstance.newPullParser().setFeature(FEATURE_XML_ROUNDTRIP, true);
            } catch (XmlPullParserException e2) {
                LOGGER.log(Level.FINEST, "XmlPullParser does not support XML_ROUNDTRIP", (Throwable) e2);
                z = false;
            }
            XML_PULL_PARSER_SUPPORTS_ROUNDTRIP = z;
        } catch (XmlPullParserException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParserFactory
    public Xpp3XmlPullParser newXmlPullParser(Reader reader) throws org.jivesoftware.smack.xml.XmlPullParserException {
        try {
            XmlPullParser xmlPullParserNewPullParser = XPP3_XML_PULL_PARSER_FACTORY.newPullParser();
            xmlPullParserNewPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            xmlPullParserNewPullParser.setInput(reader);
            if (XML_PULL_PARSER_SUPPORTS_ROUNDTRIP) {
                try {
                    xmlPullParserNewPullParser.setFeature(FEATURE_XML_ROUNDTRIP, true);
                } catch (XmlPullParserException e2) {
                    LOGGER.log(Level.SEVERE, "XmlPullParser does not support XML_ROUNDTRIP, although it was first determined to be supported", (Throwable) e2);
                }
            }
            return new Xpp3XmlPullParser(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e3) {
            throw new org.jivesoftware.smack.xml.XmlPullParserException(e3);
        }
    }
}
