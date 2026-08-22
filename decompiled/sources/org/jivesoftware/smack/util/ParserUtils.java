package org.jivesoftware.smack.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class ParserUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String JID = "jid";

    public static void assertAtEndTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
    }

    public static void assertAtStartTag(XmlPullParser xmlPullParser) throws XmlPullParserException {
    }

    public static void assertAtStartTag(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        assertAtStartTag(xmlPullParser);
    }

    public static void forwardToStartElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        while (eventType != XmlPullParser.Event.START_ELEMENT) {
            if (eventType == XmlPullParser.Event.END_DOCUMENT) {
                throw new IllegalArgumentException("Document contains no start tag");
            }
            eventType = xmlPullParser.next();
        }
    }

    public static void forwardToEndTagOfDepth(XmlPullParser xmlPullParser, int i) throws XmlPullParserException, IOException {
        XmlPullParser.Event eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return;
            } else {
                eventType = xmlPullParser.next();
            }
        }
    }

    public static Jid getJidAttribute(XmlPullParser xmlPullParser) throws XmppStringprepException {
        return getJidAttribute(xmlPullParser, "jid");
    }

    public static Jid getJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return JidCreate.from(attributeValue);
    }

    public static EntityBareJid getBareJidAttribute(XmlPullParser xmlPullParser) throws XmppStringprepException {
        return getBareJidAttribute(xmlPullParser, "jid");
    }

    public static EntityBareJid getBareJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return JidCreate.entityBareFrom(attributeValue);
    }

    public static EntityFullJid getFullJidAttribute(XmlPullParser xmlPullParser) throws XmppStringprepException {
        return getFullJidAttribute(xmlPullParser, "jid");
    }

    public static EntityFullJid getFullJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return JidCreate.entityFullFrom(attributeValue);
    }

    public static EntityJid getEntityJidAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        Jid jidFrom = JidCreate.from(attributeValue);
        if (!jidFrom.hasLocalpart()) {
            return null;
        }
        EntityFullJid entityFullJidAsEntityFullJidIfPossible = jidFrom.asEntityFullJidIfPossible();
        return entityFullJidAsEntityFullJidIfPossible != null ? entityFullJidAsEntityFullJidIfPossible : jidFrom.asEntityBareJidIfPossible();
    }

    public static Resourcepart getResourcepartAttribute(XmlPullParser xmlPullParser, String str) throws XmppStringprepException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Resourcepart.from(attributeValue);
    }

    public static boolean parseXmlBoolean(String str) {
        str.hashCode();
        switch (str) {
            case "0":
            case "false":
                return false;
            case "1":
            case "true":
                return true;
            default:
                throw new IllegalArgumentException(str + " is not a valid boolean string");
        }
    }

    public static Boolean getBooleanAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Boolean.valueOf(parseXmlBoolean(attributeValue.toLowerCase(Locale.US)));
    }

    public static boolean getBooleanAttribute(XmlPullParser xmlPullParser, String str, boolean z) {
        Boolean booleanAttribute = getBooleanAttribute(xmlPullParser, str);
        return booleanAttribute == null ? z : booleanAttribute.booleanValue();
    }

    public static Byte getByteAttributeFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return Byte.valueOf(xmlPullParser.nextText());
    }

    public static int getIntegerAttributeOrThrow(XmlPullParser xmlPullParser, String str, String str2) throws IOException {
        Integer integerAttribute = getIntegerAttribute(xmlPullParser, str);
        if (integerAttribute == null) {
            throw new IOException(str2);
        }
        return integerAttribute.intValue();
    }

    public static Integer getIntegerAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Integer.valueOf(attributeValue);
    }

    public static int getIntegerAttribute(XmlPullParser xmlPullParser, String str, int i) {
        Integer integerAttribute = getIntegerAttribute(xmlPullParser, str);
        return integerAttribute == null ? i : integerAttribute.intValue();
    }

    public static UInt16 getUInt16Attribute(XmlPullParser xmlPullParser, String str) {
        Integer integerAttribute = getIntegerAttribute(xmlPullParser, str);
        if (integerAttribute == null) {
            return null;
        }
        return UInt16.from(integerAttribute.intValue());
    }

    public static UInt16 getRequiredUInt16Attribute(XmlPullParser xmlPullParser, String str) throws SmackParsingException.RequiredAttributeMissingException {
        UInt16 uInt16Attribute = getUInt16Attribute(xmlPullParser, str);
        if (uInt16Attribute != null) {
            return uInt16Attribute;
        }
        throw new SmackParsingException.RequiredAttributeMissingException(str);
    }

    public static int getIntegerFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return Integer.valueOf(xmlPullParser.nextText()).intValue();
    }

    public static Long getLongAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Long.valueOf(attributeValue);
    }

    public static long getLongAttribute(XmlPullParser xmlPullParser, String str, long j) {
        Long longAttribute = getLongAttribute(xmlPullParser, str);
        return longAttribute == null ? j : longAttribute.longValue();
    }

    public static UInt32 getUInt32Attribute(XmlPullParser xmlPullParser, String str) {
        Long longAttribute = getLongAttribute(xmlPullParser, str);
        if (longAttribute == null) {
            return null;
        }
        return UInt32.from(longAttribute.longValue());
    }

    public static double getDoubleFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return Double.valueOf(xmlPullParser.nextText()).doubleValue();
    }

    public static Double getDoubleAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Double.valueOf(attributeValue);
    }

    public static double getDoubleAttribute(XmlPullParser xmlPullParser, String str, long j) {
        Double doubleAttribute = getDoubleAttribute(xmlPullParser, str);
        return doubleAttribute == null ? j : doubleAttribute.doubleValue();
    }

    public static Short getShortAttribute(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (attributeValue == null) {
            return null;
        }
        return Short.valueOf(attributeValue);
    }

    public static short getShortAttribute(XmlPullParser xmlPullParser, String str, short s) {
        Short shortAttribute = getShortAttribute(xmlPullParser, str);
        return shortAttribute == null ? s : shortAttribute.shortValue();
    }

    public static Date getDateFromOptionalXep82String(String str) throws SmackParsingException.SmackTextParseException {
        if (str == null) {
            return null;
        }
        return getDateFromXep82String(str);
    }

    public static Date getDateFromXep82String(String str) throws SmackParsingException.SmackTextParseException {
        try {
            return XmppDateTime.parseXEP0082Date(str);
        } catch (ParseException e2) {
            throw new SmackParsingException.SmackTextParseException(e2);
        }
    }

    public static Date getDateFromString(String str) throws SmackParsingException.SmackTextParseException {
        try {
            return XmppDateTime.parseDate(str);
        } catch (ParseException e2) {
            throw new SmackParsingException.SmackTextParseException(e2);
        }
    }

    public static Date getDateFromNextText(XmlPullParser xmlPullParser) throws SmackParsingException.SmackTextParseException, XmlPullParserException, IOException {
        return getDateFromString(xmlPullParser.nextText());
    }

    public static URI getUriFromNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException.SmackUriSyntaxParsingException {
        try {
            return new URI(xmlPullParser.nextText());
        } catch (URISyntaxException e2) {
            throw new SmackParsingException.SmackUriSyntaxParsingException(e2);
        }
    }

    public static String getRequiredAttribute(XmlPullParser xmlPullParser, String str) throws IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", str);
        if (StringUtils.isNullOrEmpty(attributeValue)) {
            throw new IOException("Attribute " + str + " is null or empty (" + attributeValue + ')');
        }
        return attributeValue;
    }

    public static String getRequiredNextText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextText = xmlPullParser.nextText();
        if (StringUtils.isNullOrEmpty(strNextText)) {
            throw new IOException("Next text is null or empty (" + strNextText + ')');
        }
        return strNextText;
    }

    public static String getXmlLang(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) {
        String xmlLang = getXmlLang(xmlPullParser);
        return xmlLang != null ? xmlLang : xmlEnvironment.getEffectiveLanguage();
    }

    public static String getXmlLang(XmlPullParser xmlPullParser) {
        return xmlPullParser.getAttributeValue("http://www.w3.org/XML/1998/namespace", "lang");
    }

    @Deprecated
    public static QName getQName(XmlPullParser xmlPullParser) {
        return xmlPullParser.getQName();
    }
}
