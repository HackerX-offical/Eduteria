package org.jivesoftware.smackx.mam.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mam.element.MamFinIQ;
import org.jivesoftware.smackx.rsm.packet.RSMSet;
import org.jivesoftware.smackx.rsm.provider.RSMSetProvider;

/* JADX INFO: loaded from: classes10.dex */
public class MamFinIQProvider extends IQProvider<MamFinIQ> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MamFinIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String attributeValue = xmlPullParser.getAttributeValue("", "queryid");
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, "complete", false);
        boolean booleanAttribute2 = ParserUtils.getBooleanAttribute(xmlPullParser, "stable", true);
        RSMSet rSMSet = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                if (xmlPullParser.getName().equals("set")) {
                    rSMSet = (RSMSet) RSMSetProvider.INSTANCE.parse(xmlPullParser);
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new MamFinIQ(attributeValue, rSMSet, booleanAttribute, booleanAttribute2);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.mam.provider.MamFinIQProvider$1, reason: invalid class name */
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
