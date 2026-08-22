package org.jivesoftware.smack.sm.provider;

import com.clevertap.android.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StanzaErrorTextElement;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public class ParseStreamManagement {
    public static StreamManagement.Enabled enabled(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, "resume", false);
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "location");
        int integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, Constants.PRIORITY_MAX, -1);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.Enabled(attributeValue, booleanAttribute, attributeValue2, integerAttribute);
    }

    public static StreamManagement.Failed failed(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        ArrayList arrayList = new ArrayList(4);
        StanzaError.Condition conditionFromString = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(xmlPullParser.getNamespace())) {
                    if (name.equals("text")) {
                        arrayList.add(new StanzaErrorTextElement(xmlPullParser.nextText(), ParserUtils.getXmlLang(xmlPullParser)));
                    } else {
                        conditionFromString = StanzaError.Condition.fromString(name);
                    }
                }
            } else if (i == 2 && StreamManagement.Failed.ELEMENT.equals(xmlPullParser.getName())) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return new StreamManagement.Failed(conditionFromString, arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.sm.provider.ParseStreamManagement$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr;
            try {
                iArr[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static StreamManagement.Resumed resumed(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long jLongValue = ParserUtils.getLongAttribute(xmlPullParser, "h").longValue();
        String attributeValue = xmlPullParser.getAttributeValue("", "previd");
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.Resumed(jLongValue, attributeValue);
    }

    public static StreamManagement.AckAnswer ackAnswer(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long jLongValue = ParserUtils.getLongAttribute(xmlPullParser, "h").longValue();
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new StreamManagement.AckAnswer(jLongValue);
    }

    public static StreamManagement.AckRequest ackRequest(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return StreamManagement.AckRequest.INSTANCE;
    }
}
