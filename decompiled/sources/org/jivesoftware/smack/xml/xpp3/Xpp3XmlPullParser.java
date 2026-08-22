package org.jivesoftware.smack.xml.xpp3;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class Xpp3XmlPullParser implements XmlPullParser {
    private final org.xmlpull.v1.XmlPullParser xpp3XmlPullParser;

    public Xpp3XmlPullParser(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        this.xpp3XmlPullParser = xmlPullParser;
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public Object getProperty(String str) {
        return this.xpp3XmlPullParser.getProperty(str);
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getInputEncoding() {
        return this.xpp3XmlPullParser.getInputEncoding();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public int getNamespaceCount() throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.getNamespaceCount(this.xpp3XmlPullParser.getDepth());
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getNamespacePrefix(int i) throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.getNamespacePrefix(i);
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getNamespaceUri(int i) throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.getNamespaceUri(i);
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getNamespace(String str) {
        return this.xpp3XmlPullParser.getNamespace(str);
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public int getDepth() {
        return this.xpp3XmlPullParser.getDepth();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getPositionDescription() {
        return this.xpp3XmlPullParser.getPositionDescription();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public int getLineNumber() {
        return this.xpp3XmlPullParser.getLineNumber();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public int getColumnNumber() {
        return this.xpp3XmlPullParser.getColumnNumber();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public boolean isWhiteSpace() throws XmlPullParserException {
        try {
            return this.xpp3XmlPullParser.isWhitespace();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getText() {
        return this.xpp3XmlPullParser.getText();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getNamespace() {
        return this.xpp3XmlPullParser.getNamespace();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getName() {
        return this.xpp3XmlPullParser.getName();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public QName getQName() {
        return new QName(this.xpp3XmlPullParser.getNamespace(), this.xpp3XmlPullParser.getName(), nullValueToDefaultPrefix(this.xpp3XmlPullParser.getPrefix()));
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getPrefix() {
        return this.xpp3XmlPullParser.getPrefix();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public int getAttributeCount() {
        return this.xpp3XmlPullParser.getAttributeCount();
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getAttributeNamespace(int i) {
        try {
            String attributeNamespace = this.xpp3XmlPullParser.getAttributeNamespace(i);
            if ("".equals(attributeNamespace)) {
                return null;
            }
            return attributeNamespace;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getAttributeName(int i) {
        try {
            return this.xpp3XmlPullParser.getAttributeName(i);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public QName getAttributeQName(int i) {
        String attributeName = getAttributeName(i);
        if (attributeName == null) {
            return null;
        }
        return new QName(getAttributeNamespace(i), attributeName, nullValueToDefaultPrefix(getAttributePrefix(i)));
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getAttributePrefix(int i) {
        try {
            return nullValueToDefaultPrefix(this.xpp3XmlPullParser.getAttributePrefix(i));
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getAttributeType(int i) {
        try {
            return this.xpp3XmlPullParser.getAttributeType(i);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getAttributeValue(int i) {
        return this.xpp3XmlPullParser.getAttributeValue(i);
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        return this.xpp3XmlPullParser.getAttributeValue(str, str2);
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public XmlPullParser.Event getEventType() throws XmlPullParserException {
        try {
            return xpp3EventIntegerToEvent(this.xpp3XmlPullParser.getEventType());
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public XmlPullParser.Event next() throws XmlPullParserException, IOException {
        try {
            return xpp3EventIntegerToEvent(this.xpp3XmlPullParser.next());
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public String nextText() throws XmlPullParserException, IOException {
        try {
            return this.xpp3XmlPullParser.nextText();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public XmlPullParser.TagEvent nextTag() throws XmlPullParserException, IOException {
        try {
            int iNextTag = this.xpp3XmlPullParser.nextTag();
            if (iNextTag == 2) {
                return XmlPullParser.TagEvent.START_ELEMENT;
            }
            if (iNextTag == 3) {
                return XmlPullParser.TagEvent.END_ELEMENT;
            }
            throw new AssertionError();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            throw new XmlPullParserException(e2);
        }
    }

    @Override // org.jivesoftware.smack.xml.XmlPullParser
    public boolean supportsRoundtrip() {
        return this.xpp3XmlPullParser.getFeature(Xpp3XmlPullParserFactory.FEATURE_XML_ROUNDTRIP);
    }

    private static XmlPullParser.Event xpp3EventIntegerToEvent(int i) {
        switch (i) {
            case 0:
                return XmlPullParser.Event.START_DOCUMENT;
            case 1:
                return XmlPullParser.Event.END_DOCUMENT;
            case 2:
                return XmlPullParser.Event.START_ELEMENT;
            case 3:
                return XmlPullParser.Event.END_ELEMENT;
            case 4:
                return XmlPullParser.Event.TEXT_CHARACTERS;
            case 5:
                return XmlPullParser.Event.OTHER;
            case 6:
                return XmlPullParser.Event.ENTITY_REFERENCE;
            case 7:
                return XmlPullParser.Event.IGNORABLE_WHITESPACE;
            case 8:
                return XmlPullParser.Event.PROCESSING_INSTRUCTION;
            case 9:
                return XmlPullParser.Event.COMMENT;
            case 10:
                return XmlPullParser.Event.OTHER;
            default:
                throw new IllegalArgumentException("Unknown XPP3 event integer: " + i);
        }
    }

    private static String nullValueToDefaultPrefix(String str) {
        return str != null ? str : "";
    }
}
