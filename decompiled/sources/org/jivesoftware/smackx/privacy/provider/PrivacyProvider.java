package org.jivesoftware.smackx.privacy.provider;

import com.appnew.android.Utils.Const;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.privacy.packet.Privacy;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;

/* JADX INFO: loaded from: classes10.dex */
public class PrivacyProvider extends IQProvider<Privacy> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public Privacy parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Privacy privacy = new Privacy();
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("active")) {
                    String attributeValue = xmlPullParser.getAttributeValue("", "name");
                    if (attributeValue == null) {
                        privacy.setDeclineActiveList(true);
                    } else {
                        privacy.setActiveName(attributeValue);
                    }
                } else if (xmlPullParser.getName().equals(CookieSpecs.DEFAULT)) {
                    String attributeValue2 = xmlPullParser.getAttributeValue("", "name");
                    if (attributeValue2 == null) {
                        privacy.setDeclineDefaultList(true);
                    } else {
                        privacy.setDefaultName(attributeValue2);
                    }
                } else if (xmlPullParser.getName().equals("list")) {
                    parseList(xmlPullParser, privacy);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        return privacy;
    }

    private static void parseList(XmlPullParser xmlPullParser, Privacy privacy) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("item")) {
                    arrayList.add(parseItem(xmlPullParser));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("list")) {
                z = true;
            }
        }
        privacy.setPrivacyList(attributeValue, arrayList);
    }

    private static PrivacyItem parseItem(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z;
        PrivacyItem privacyItem;
        String attributeValue = xmlPullParser.getAttributeValue("", "action");
        UInt32 uInt32Attribute = ParserUtils.getUInt32Attribute(xmlPullParser, Const.ORDER);
        String attributeValue2 = xmlPullParser.getAttributeValue("", "type");
        attributeValue.hashCode();
        if (attributeValue.equals("deny")) {
            z = false;
        } else {
            if (!attributeValue.equals("allow")) {
                throw new IOException("Unknown action value '" + attributeValue + "'");
            }
            z = true;
        }
        if (attributeValue2 != null) {
            privacyItem = new PrivacyItem(PrivacyItem.Type.valueOf(attributeValue2), xmlPullParser.getAttributeValue("", "value"), z, uInt32Attribute);
        } else {
            privacyItem = new PrivacyItem(z, uInt32Attribute);
        }
        parseItemChildElements(xmlPullParser, privacyItem);
        return privacyItem;
    }

    private static void parseItemChildElements(XmlPullParser xmlPullParser, PrivacyItem privacyItem) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "presence-in":
                        privacyItem.setFilterPresenceIn(true);
                        break;
                    case "iq":
                        privacyItem.setFilterIQ(true);
                        break;
                    case "presence-out":
                        privacyItem.setFilterPresenceOut(true);
                        break;
                    case "message":
                        privacyItem.setFilterMessage(true);
                        break;
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.privacy.provider.PrivacyProvider$1, reason: invalid class name */
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
}
