package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.muc.MUCRole;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

/* JADX INFO: loaded from: classes10.dex */
public class MUCParserUtils {
    public static MUCItem parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        MUCAffiliation mUCAffiliationFromString = MUCAffiliation.fromString(xmlPullParser.getAttributeValue("", "affiliation"));
        Resourcepart resourcepartAttribute = ParserUtils.getResourcepartAttribute(xmlPullParser, "nick");
        MUCRole mUCRoleFromString = MUCRole.fromString(xmlPullParser.getAttributeValue("", "role"));
        Jid jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
        Jid jidAttribute2 = null;
        String strNextText = null;
        Resourcepart resourcepartFrom = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("reason")) {
                    strNextText = xmlPullParser.nextText();
                } else if (name.equals("actor")) {
                    jidAttribute2 = ParserUtils.getJidAttribute(xmlPullParser);
                    String attributeValue = xmlPullParser.getAttributeValue("", "nick");
                    if (attributeValue != null) {
                        resourcepartFrom = Resourcepart.from(attributeValue);
                    }
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return new MUCItem(mUCAffiliationFromString, mUCRoleFromString, jidAttribute2, strNextText, jidAttribute, resourcepartAttribute, resourcepartFrom);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.muc.provider.MUCParserUtils$1, reason: invalid class name */
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

    public static Destroy parseDestroy(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser);
        String strNextText = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("reason")) {
                    strNextText = xmlPullParser.nextText();
                }
            } else if (i == 2 && depth == xmlPullParser.getDepth()) {
                return new Destroy(bareJidAttribute, strNextText);
            }
        }
    }
}
