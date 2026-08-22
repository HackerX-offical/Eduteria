package org.jivesoftware.smackx.hoxt.provider;

import java.io.IOException;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;
import org.jivesoftware.smackx.shim.provider.HeadersProvider;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractHttpOverXmppProvider<H extends AbstractHttpOverXmpp> extends IQProvider<H> {
    private static final String ATTRIBUTE_SID = "sid";
    private static final String ATTRIBUTE_STREAM_ID = "streamId";
    static final String ATTRIBUTE_VERSION = "version";
    private static final String ELEMENT_BASE_64 = "base64";
    private static final String ELEMENT_CHUNKED_BASE_64 = "chunkedBase64";
    private static final String ELEMENT_DATA = "data";
    static final String ELEMENT_IBB = "ibb";
    static final String ELEMENT_JINGLE = "jingle";
    static final String ELEMENT_SIPUB = "sipub";
    private static final String ELEMENT_TEXT = "text";
    private static final String ELEMENT_XML = "xml";

    /* JADX WARN: Multi-variable type inference failed */
    protected HeadersExtension parseHeaders(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, SmackParsingException {
        if (xmlPullParser.next() != XmlPullParser.Event.START_ELEMENT || !xmlPullParser.getName().equals(HeadersExtension.ELEMENT)) {
            return null;
        }
        HeadersExtension headersExtension = (HeadersExtension) HeadersProvider.INSTANCE.parse(xmlPullParser);
        xmlPullParser.next();
        return headersExtension;
    }

    protected AbstractHttpOverXmpp.Data parseData(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        NamedElement chunkedBase64 = null;
        if (xmlPullParser.getEventType() != XmlPullParser.Event.START_ELEMENT) {
            return null;
        }
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "base64":
                        chunkedBase64 = parseBase64(xmlPullParser);
                        break;
                    case "jingle":
                        throw new UnsupportedOperationException("jingle is not supported yet");
                    case "ibb":
                        chunkedBase64 = parseIbb(xmlPullParser);
                        break;
                    case "xml":
                        chunkedBase64 = parseXml(xmlPullParser);
                        break;
                    case "text":
                        chunkedBase64 = parseText(xmlPullParser);
                        break;
                    case "sipub":
                        throw new UnsupportedOperationException("sipub is not supported yet");
                    case "chunkedBase64":
                        chunkedBase64 = parseChunkedBase64(xmlPullParser);
                        break;
                    default:
                        throw new IllegalArgumentException("unsupported child tag: " + xmlPullParser.getName());
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("data")) {
                z = true;
            }
        }
        return new AbstractHttpOverXmpp.Data(chunkedBase64);
    }

    private static AbstractHttpOverXmpp.Text parseText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String text = null;
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.END_ELEMENT) {
                if (!xmlPullParser.getName().equals("text")) {
                    throw new IllegalArgumentException("unexpected end tag of: " + xmlPullParser.getName());
                }
                z = true;
            } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                text = xmlPullParser.getText();
            } else {
                throw new IllegalArgumentException("unexpected eventType: " + next);
            }
        }
        return new AbstractHttpOverXmpp.Text(text);
    }

    private static AbstractHttpOverXmpp.Xml parseXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (true) {
            boolean z2 = true;
            while (!z) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("xml")) {
                    z = true;
                } else if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (!z2) {
                        sb.append(Typography.greater);
                    }
                    sb.append(Typography.less);
                    sb.append(xmlPullParser.getName());
                    appendXmlAttributes(xmlPullParser, sb);
                    z2 = false;
                } else if (next == XmlPullParser.Event.END_ELEMENT) {
                    if (z2) {
                        sb.append("</");
                        sb.append(xmlPullParser.getName());
                        sb.append(Typography.greater);
                    }
                } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                    if (!z2) {
                        sb.append(Typography.greater);
                        z2 = true;
                    }
                    sb.append(StringUtils.escapeForXmlText(xmlPullParser.getText()));
                } else {
                    throw new IllegalArgumentException("unexpected eventType: " + next);
                }
            }
            return new AbstractHttpOverXmpp.Xml(sb.toString());
            sb.append("/>");
        }
    }

    private static void appendXmlAttributes(XmlPullParser xmlPullParser, StringBuilder sb) {
        int attributeCount = xmlPullParser.getAttributeCount();
        if (attributeCount > 0) {
            for (int i = 0; i < attributeCount; i++) {
                sb.append(' ');
                sb.append(xmlPullParser.getAttributeName(i));
                sb.append("=\"");
                sb.append(StringUtils.escapeForXml(xmlPullParser.getAttributeValue(i)));
                sb.append('\"');
            }
        }
    }

    private static AbstractHttpOverXmpp.Base64 parseBase64(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String text = null;
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.END_ELEMENT) {
                if (!xmlPullParser.getName().equals("base64")) {
                    throw new IllegalArgumentException("unexpected end tag of: " + xmlPullParser.getName());
                }
                z = true;
            } else if (next == XmlPullParser.Event.TEXT_CHARACTERS) {
                text = xmlPullParser.getText();
            } else {
                throw new IllegalArgumentException("unexpected eventType: " + next);
            }
        }
        return new AbstractHttpOverXmpp.Base64(text);
    }

    private static AbstractHttpOverXmpp.ChunkedBase64 parseChunkedBase64(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        AbstractHttpOverXmpp.ChunkedBase64 chunkedBase64 = new AbstractHttpOverXmpp.ChunkedBase64(xmlPullParser.getAttributeValue("", "streamId"));
        XmlPullParser.Event next = xmlPullParser.next();
        if (next == XmlPullParser.Event.END_ELEMENT) {
            if (xmlPullParser.getName().equals("chunkedBase64")) {
                return chunkedBase64;
            }
            throw new IllegalArgumentException("unexpected end tag: " + xmlPullParser.getName());
        }
        throw new IllegalArgumentException("unexpected event type: " + next);
    }

    private static AbstractHttpOverXmpp.Ibb parseIbb(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        AbstractHttpOverXmpp.Ibb ibb = new AbstractHttpOverXmpp.Ibb(xmlPullParser.getAttributeValue("", "sid"));
        XmlPullParser.Event next = xmlPullParser.next();
        if (next == XmlPullParser.Event.END_ELEMENT) {
            if (xmlPullParser.getName().equals("ibb")) {
                return ibb;
            }
            throw new IllegalArgumentException("unexpected end tag: " + xmlPullParser.getName());
        }
        throw new IllegalArgumentException("unexpected event type: " + next);
    }
}
