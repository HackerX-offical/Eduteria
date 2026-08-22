package org.jivesoftware.smackx.mam.provider;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mam.element.MamPrefsIQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: loaded from: classes10.dex */
public class MamPrefsIQProvider extends IQProvider<MamPrefsIQ> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MamPrefsIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        xmlPullParser.getAttributeValue("", "type");
        String attributeValue = xmlPullParser.getAttributeValue("", CookieSpecs.DEFAULT);
        List<Jid> listIterateJids = null;
        MamPrefsIQ.DefaultBehavior defaultBehaviorValueOf = attributeValue != null ? MamPrefsIQ.DefaultBehavior.valueOf(attributeValue) : null;
        List<Jid> listIterateJids2 = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("always")) {
                    listIterateJids = iterateJids(xmlPullParser);
                } else if (name.equals("never")) {
                    listIterateJids2 = iterateJids(xmlPullParser);
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new MamPrefsIQ(listIterateJids, listIterateJids2, defaultBehaviorValueOf);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.mam.provider.MamPrefsIQProvider$1, reason: invalid class name */
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

    private static List<Jid> iterateJids(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("jid")) {
                    xmlPullParser.next();
                    arrayList.add(JidCreate.from(xmlPullParser.getText()));
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return arrayList;
            }
        }
    }
}
