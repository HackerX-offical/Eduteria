package org.jivesoftware.smackx.spoiler.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.spoiler.element.SpoilerElement;

/* JADX INFO: loaded from: classes10.dex */
public class SpoilerProvider extends ExtensionElementProvider<SpoilerElement> {
    public static SpoilerProvider INSTANCE = new SpoilerProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public SpoilerElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String xmlLang = ParserUtils.getXmlLang(xmlPullParser);
        String text = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                text = xmlPullParser.getText();
            } else if (i2 == 2) {
                return new SpoilerElement(xmlLang, text);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.spoiler.provider.SpoilerProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr;
            try {
                iArr[XmlPullParser.Event.TEXT_CHARACTERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
