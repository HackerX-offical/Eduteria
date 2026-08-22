package org.jivesoftware.smackx.delay.provider;

import java.io.IOException;
import java.util.Date;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractDelayInformationProvider extends ExtensionElementProvider<DelayInformation> {
    protected abstract Date parseDate(String str) throws SmackParsingException.SmackTextParseException;

    @Override // org.jivesoftware.smack.provider.Provider
    public final DelayInformation parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws SmackParsingException.SmackTextParseException, XmlPullParserException, IOException {
        String str;
        String attributeValue = xmlPullParser.getAttributeValue("", "stamp");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "from");
        XmlPullParser.Event next = xmlPullParser.next();
        int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[next.ordinal()];
        if (i2 == 1) {
            String text = xmlPullParser.getText();
            xmlPullParser.next();
            str = text;
        } else {
            if (i2 != 2) {
                throw new IOException("Unexpected event: " + next);
            }
            str = null;
        }
        return new DelayInformation(parseDate(attributeValue), attributeValue2, str);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.delay.provider.AbstractDelayInformationProvider$1, reason: invalid class name */
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
