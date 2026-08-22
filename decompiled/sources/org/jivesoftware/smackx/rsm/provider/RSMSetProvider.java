package org.jivesoftware.smackx.rsm.provider;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.rsm.packet.RSMSet;

/* JADX INFO: loaded from: classes10.dex */
public class RSMSetProvider extends ExtensionElementProvider<RSMSet> {
    public static final RSMSetProvider INSTANCE = new RSMSetProvider();

    /* JADX INFO: renamed from: org.jivesoftware.smackx.rsm.provider.RSMSetProvider$1, reason: invalid class name */
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

    @Override // org.jivesoftware.smack.provider.Provider
    public RSMSet parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String strNextText = null;
        String strNextText2 = null;
        String strNextText3 = null;
        String strNextText4 = null;
        int integerFromNextText = -1;
        int integerFromNextText2 = -1;
        int integerFromNextText3 = -1;
        int integerAttribute = -1;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "before":
                        strNextText2 = xmlPullParser.nextText();
                        continue;
                        break;
                    case "max":
                        integerFromNextText3 = ParserUtils.getIntegerFromNextText(xmlPullParser);
                        continue;
                        break;
                    case "last":
                        strNextText3 = xmlPullParser.nextText();
                        continue;
                        break;
                    case "after":
                        strNextText = xmlPullParser.nextText();
                        continue;
                        break;
                    case "count":
                        integerFromNextText = ParserUtils.getIntegerFromNextText(xmlPullParser);
                        continue;
                        break;
                    case "first":
                        integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, FirebaseAnalytics.Param.INDEX, -1);
                        strNextText4 = xmlPullParser.nextText();
                        continue;
                        break;
                    case "index":
                        integerFromNextText2 = ParserUtils.getIntegerFromNextText(xmlPullParser);
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new RSMSet(strNextText, strNextText2, integerFromNextText, integerFromNextText2, strNextText3, integerFromNextText3, strNextText4, integerAttribute);
            }
        }
    }
}
