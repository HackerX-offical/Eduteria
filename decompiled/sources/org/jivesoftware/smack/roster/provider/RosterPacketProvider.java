package org.jivesoftware.smack.roster.provider;

import com.appnew.android.Utils.Const;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.roster.packet.RosterVer;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: loaded from: classes10.dex */
public class RosterPacketProvider extends IQProvider<RosterPacket> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final RosterPacketProvider INSTANCE = new RosterPacketProvider();

    @Override // org.jivesoftware.smack.provider.IQProvider
    public RosterPacket parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        RosterPacket rosterPacket = new RosterPacket();
        rosterPacket.setVersion(xmlPullParser.getAttributeValue("", RosterVer.ELEMENT));
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("item")) {
                    rosterPacket.addRosterItem(parseItem(xmlPullParser));
                }
            } else if (i2 != 2) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                name2.hashCode();
                if (name2.equals("query") && xmlPullParser.getDepth() == i) {
                    return rosterPacket;
                }
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.roster.provider.RosterPacketProvider$1, reason: invalid class name */
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

    public static RosterPacket.Item parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextText;
        ParserUtils.assertAtStartTag(xmlPullParser, "item");
        int depth = xmlPullParser.getDepth();
        RosterPacket.Item item = new RosterPacket.Item(JidCreate.bareFrom(xmlPullParser.getAttributeValue("", "jid")), xmlPullParser.getAttributeValue("", "name"));
        item.setSubscriptionPending("subscribe".equals(xmlPullParser.getAttributeValue("", "ask")));
        item.setItemType(RosterPacket.ItemType.fromString(xmlPullParser.getAttributeValue("", Const.SUBSCRIPTION)));
        item.setApproved(ParserUtils.getBooleanAttribute(xmlPullParser, "approved", false));
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("group") && (strNextText = xmlPullParser.nextText()) != null && strNextText.trim().length() > 0) {
                    item.addGroupName(strNextText);
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return item;
            }
        }
    }
}
