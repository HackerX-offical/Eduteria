package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityJid;

/* JADX INFO: loaded from: classes10.dex */
public class MUCUserProvider extends ExtensionElementProvider<MUCUser> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MUCUser parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        MUCUser mUCUser = new MUCUser();
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "invite":
                        mUCUser.setInvite(parseInvite(xmlPullParser));
                        break;
                    case "status":
                        mUCUser.addStatusCode(MUCUser.Status.create(xmlPullParser.getAttributeValue("", "code")));
                        break;
                    case "item":
                        mUCUser.setItem(MUCParserUtils.parseItem(xmlPullParser));
                        break;
                    case "password":
                        mUCUser.setPassword(xmlPullParser.nextText());
                        break;
                    case "decline":
                        mUCUser.setDecline(parseDecline(xmlPullParser));
                        break;
                    case "destroy":
                        mUCUser.setDestroy(MUCParserUtils.parseDestroy(xmlPullParser));
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return mUCUser;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.muc.provider.MUCUserProvider$1, reason: invalid class name */
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

    private static MUCUser.Invite parseInvite(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser, "to");
        EntityJid entityJidAttribute = ParserUtils.getEntityJidAttribute(xmlPullParser, "from");
        String strNextText = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("reason")) {
                    strNextText = xmlPullParser.nextText();
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(MUCUser.Invite.ELEMENT)) {
                return new MUCUser.Invite(strNextText, entityJidAttribute, bareJidAttribute);
            }
        }
    }

    private static MUCUser.Decline parseDecline(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        EntityBareJid bareJidAttribute = ParserUtils.getBareJidAttribute(xmlPullParser, "to");
        EntityBareJid bareJidAttribute2 = ParserUtils.getBareJidAttribute(xmlPullParser, "from");
        String strNextText = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("reason")) {
                    strNextText = xmlPullParser.nextText();
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(MUCUser.Decline.ELEMENT)) {
                return new MUCUser.Decline(strNextText, bareJidAttribute2, bareJidAttribute);
            }
        }
    }
}
