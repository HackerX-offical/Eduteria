package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public final class PublicKeysListElementProvider extends ExtensionElementProvider<PublicKeysListElement> {
    public static final PublicKeysListElementProvider TEST_INSTANCE = new PublicKeysListElementProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public PublicKeysListElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws SmackParsingException.SmackTextParseException, XmlPullParserException, IOException {
        PublicKeysListElement.Builder builder = PublicKeysListElement.builder();
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i2 == 1) {
                if (PublicKeysListElement.PubkeyMetadataElement.ELEMENT.equals(xmlPullParser.getName())) {
                    builder.addMetadata(new PublicKeysListElement.PubkeyMetadataElement(new OpenPgpV4Fingerprint(xmlPullParser.getAttributeValue(null, PublicKeysListElement.PubkeyMetadataElement.ATTR_V4_FINGERPRINT)), ParserUtils.getDateFromXep82String(xmlPullParser.getAttributeValue(null, "date"))));
                }
            } else if (i2 == 2 && xmlPullParser.getName().equals(PublicKeysListElement.ELEMENT)) {
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.ox.provider.PublicKeysListElementProvider$1, reason: invalid class name */
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
}
