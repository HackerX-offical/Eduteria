package org.jivesoftware.smackx.iqversion.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iqversion.packet.Version;

/* JADX INFO: loaded from: classes10.dex */
public class VersionProvider extends IQProvider<Version> {

    /* JADX INFO: renamed from: org.jivesoftware.smackx.iqversion.provider.VersionProvider$1, reason: invalid class name */
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

    @Override // org.jivesoftware.smack.provider.IQProvider
    public Version parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String strNextText = null;
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "os":
                        strNextText3 = xmlPullParser.nextText();
                        break;
                    case "name":
                        strNextText = xmlPullParser.nextText();
                        break;
                    case "version":
                        strNextText2 = xmlPullParser.nextText();
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i && xmlPullParser.getName().equals("query")) {
                if (strNextText == null && strNextText2 == null && strNextText3 == null) {
                    return new Version();
                }
                return new Version(strNextText, strNextText2, strNextText3);
            }
        }
    }
}
