package org.jivesoftware.smackx.stanza_content_encryption.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.stanza_content_encryption.element.AffixElement;
import org.jivesoftware.smackx.stanza_content_encryption.element.ContentElement;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class ContentElementProvider extends ExtensionElementProvider<ContentElement> {
    @Override // org.jivesoftware.smack.provider.Provider
    public ContentElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        ContentElement.Builder builder = ContentElement.builder();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "payload":
                        parsePayload(xmlPullParser, xmlEnvironment, builder);
                        break;
                    case "to":
                        parseToAffix(xmlPullParser, builder);
                        break;
                    case "from":
                        parseFromAffix(xmlPullParser, builder);
                        break;
                    case "rpad":
                        parseRPadAffix(xmlPullParser, builder);
                        break;
                    case "time":
                        parseTimestampAffix(xmlPullParser, builder);
                        break;
                    default:
                        parseCustomAffix(xmlPullParser, xmlEnvironment, builder);
                        break;
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }

    private static void parseCustomAffix(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, ContentElement.Builder builder) throws XmlPullParserException, IOException, SmackParsingException {
        builder.addFurtherAffixElement((AffixElement) PacketParserUtils.parseExtensionElement(xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlPullParser, xmlEnvironment));
    }

    private static void parsePayload(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment, ContentElement.Builder builder) throws XmlPullParserException, IOException, SmackParsingException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                builder.addPayloadItem(PacketParserUtils.parseExtensionElement(xmlPullParser.getName(), xmlPullParser.getNamespace(), xmlPullParser, xmlEnvironment));
            }
            if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseRPadAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws XmlPullParserException, IOException {
        builder.setRandomPadding(xmlPullParser.nextText());
    }

    private static void parseTimestampAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws SmackParsingException.SmackTextParseException {
        builder.setTimestamp(ParserUtils.getDateFromXep82String(xmlPullParser.getAttributeValue("", "stamp")));
    }

    private static void parseFromAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws XmppStringprepException {
        builder.setFrom(JidCreate.from(xmlPullParser.getAttributeValue("", "jid")));
    }

    private static void parseToAffix(XmlPullParser xmlPullParser, ContentElement.Builder builder) throws XmppStringprepException {
        builder.addTo(JidCreate.from(xmlPullParser.getAttributeValue("", "jid")));
    }
}
