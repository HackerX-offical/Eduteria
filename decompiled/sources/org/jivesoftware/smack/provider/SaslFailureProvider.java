package org.jivesoftware.smack.provider;

import java.io.IOException;
import java.util.Map;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class SaslFailureProvider extends NonzaProvider<SaslNonza.SASLFailure> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SaslFailureProvider INSTANCE = new SaslFailureProvider();

    private SaslFailureProvider() {
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.provider.SaslFailureProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;

        static {
            int[] iArr = new int[XmlPullParser.TagEvent.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = iArr;
            try {
                iArr[XmlPullParser.TagEvent.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[XmlPullParser.TagEvent.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public SaslNonza.SASLFailure parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Map<String, String> descriptiveTexts = null;
        String name = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i2 == 1) {
                if (xmlPullParser.getName().equals("text")) {
                    descriptiveTexts = PacketParserUtils.parseDescriptiveTexts(xmlPullParser, descriptiveTexts);
                } else {
                    name = xmlPullParser.getName();
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new SaslNonza.SASLFailure(name, descriptiveTexts);
            }
        }
    }
}
