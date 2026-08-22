package org.jivesoftware.smackx.mam.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.forward.provider.ForwardedProvider;
import org.jivesoftware.smackx.mam.element.MamElements;

/* JADX INFO: loaded from: classes10.dex */
public class MamResultProvider extends ExtensionElementProvider<MamElements.MamResultExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MamElements.MamResultExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String attributeValue = xmlPullParser.getAttributeValue("", "queryid");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        Forwarded<Message> forwardedMessage = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals(Forwarded.ELEMENT)) {
                    forwardedMessage = ForwardedProvider.parseForwardedMessage(xmlPullParser, xmlEnvironment);
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return new MamElements.MamResultExtension(attributeValue, attributeValue2, forwardedMessage);
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.mam.provider.MamResultProvider$1, reason: invalid class name */
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
